package application;


import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/* 
 * Data object takes a connection object and provides functions to deal with the data
 * 
 * objects:
 * Game
 * Player
 * PlayerAndGame (used for score and date)
 * 
 * 
 */

public class Data {
	List<Game> games = new ArrayList<Game>();
	List<Player> players= new ArrayList<Player>();
	List<PlayerAndGame> playersandgames = new ArrayList<PlayerAndGame>();
	
	Connection connection;
	
	public Data(Connection con) {
		connection = con;
		
		reload();
		
		//games = new List<Game>();
		
	}
	
	//inner Game object
	public class Game  {
		public String id;
		public String title;
		
		public Game() {
			
		}
		
		public Game(Object o1, Object o2) {
			id = o1.toString();
			title = o2.toString();
		}
	}

	// Player object
	public class Player {
		 String id;
		 String firstName;
		 String lastName;
		 String address;
		 String postalCode;
		 String province;
		 String phoneNum;
		 
		public Player(Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7) {
			id = o1.toString();
			firstName = o2.toString();
			lastName = o3.toString();
			address = o4.toString();
			postalCode = o5.toString();
			province = o6.toString();
			phoneNum = o7.toString();
		}
	}
	
	// Score and Date object
	public class PlayerAndGame {
		 String id;
		 String player_id;
		 String game_id;
		 String playing_date;
		 String score;
		 
		public PlayerAndGame(Object o1, Object o2, Object o3, Object o4, Object o5) {
			id = o1.toString();
			game_id = o2.toString();
			player_id = o3.toString();
			playing_date = o4.toString();
			score = o5.toString();
		}
	}
	
	// this function is called to reload the data whenever the oracle db updates
	public void reload() {
		loadGames();
		loadPlayers();
		loadPlayersAndGames();
	}
	
	//loads games from SQL db
	private void loadGames() {	
		try {
			ResultSet rs = genericSelect("game");
			
			games.clear();
			
			while(rs.next())
			{
				games.add(new Game(rs.getObject(1), rs.getObject(2)));
			}
			
		} catch (SQLException e) {
		}
	}
	
	// loads players from SQL db
	private void loadPlayers() {	
		try {
			ResultSet rs = genericSelect("player");
			
			players.clear();
			
			while(rs.next())
			{
				players.add(new Player(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7)));
			}
			
		} catch (SQLException e) {
		}
	}
	
	//loads score objects from SQL db
	private void loadPlayersAndGames() {	
		try {
			ResultSet rs = genericSelect("playerandgame");
			
			playersandgames.clear();
			
			while(rs.next())
			{
				playersandgames.add(new PlayerAndGame(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5)));
			}
			
		} catch (SQLException e) {
		}
	}
	
	
	//generates an array of game titles (used for dropdown)
	public String [] gamesToStrArray() {
		
		String[] strArr = new String[games.size()];
		int i = 0;
		
		for (Game g : games) {
			strArr[i++] = g.title;
		}
		
		return strArr;
		
	}
	
	//generates and array of player titles (used for dropdown)
	public String [] playersToStrArray() {
		String[] strArr = new String[players.size()];
		int i = 0;
		
		for (Player p : players) {
			strArr[i++] = p.firstName + " " + p.lastName;
		}
		
		return strArr;
	}

	
	// finds a list of scores that matches with Game and Player
	public List<String> findScore(Game g, Player p) {
		List<String> strArray = new ArrayList<String>();
		
		for (PlayerAndGame pg : playersandgames) {
			if (pg.player_id.equals(p.id) && pg.game_id.equals(g.id)) {
				strArray.add(pg.playing_date + "  score: " + pg.score);
			}
		}
			
		return strArray;
	}
	
	// finds a game based on Title (not perfect)
	public Game findGame(String s1) {	
		for (Game g : games) {
			if (g.title.equals(s1))
				return g;
		}
		
		return null;
	}
	
	//finds Player based on First and Last name compounded
	public Player findPlayer(String s1) {
		for (Player p : players) {
			if (s1.equals((p.firstName + " " + p.lastName)))
				return p;
		}
		
		return null;
	}
	
	
	//add game to the DB
	public void addGame(int i1, String s1) {
		try {
			connection.createStatement().executeQuery("insert into game values (" +  i1 + ",'" + s1  +"')");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//update game in db
	public void updateGame(int i1, String s1) {
		try {
			connection.createStatement().executeQuery("update game set game.game_title='" + s1  +"' where game.game_id=" + i1);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//delete game in db
	public void deleteGame(String s1) {
		try {
			connection.createStatement().executeQuery("delete from game where game_title = '" + s1 + "'");
		} catch (SQLException e) {
			System.out.println(e);
		}		
	}
	
	//add player in db
	public void addPlayer(int i1, String s1, String s2, String s3, String s4, String s5, String s6) {
		try {
			connection.createStatement().executeQuery("insert into player values (" + i1 + ",'" + s1 +"','" + s2  + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "')");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//update player in db
	public void updatePlayer(int i1, String s1, String s2, String s3, String s4, String s5, String s6) {
		//UPDATE player SET player.first_name = 'name', player.last_name ='name' , player.address ='add', player.postal_code ='code', player.province ='prov', player.phone_number ='number' where player.player_id = 100; 
		try {
			connection.createStatement().executeQuery("update player set player.first_name='" + s1 +"', player.last_name='" + s2  + "', player.address='" + s3 + "', player.postal_code='" + s4 + "', player.province='" + s5 + "', player.phone_number='" + s6 + "' where player.player_id =" + i1);
		} catch (SQLException e) {
			System.out.println(e);
		}	
	}
	
	
	//delete player in db
	public void deletePlayer(Player p) {
		try {
			connection.createStatement().executeQuery("delete from player where player_id = '" + p.id + "'");
		} catch (SQLException e) {
			System.out.println(e);
		}		
	}
	
	//generic select statement used to pull data from the db
	private ResultSet genericSelect(String table) throws SQLException {
		return connection.createStatement().executeQuery("select * from " + table.toUpperCase());
	}
	
}
