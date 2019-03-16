package application;

import java.sql.ResultSet;

public class Data {
	Data array;

	public class Game extends Data {
		public String id;
		public String title;

		public Game(String s1, String s2) {
			id = s1;
			title = s2;
		}
	}

	public class Player extends Data{
		 String id;
		 String firstName;
		 String lastName;
		 String address;
		 String postalCode;
		 String province;
		 String phoneNum;
	}

	public class PlayerAndGame extends Data{
		 String id;
		 String player_id;
		 String game_id;
		 String playing_date;
		 String score;
	}

	public Data getGameArray(ResultSet rs) {
		return new Game("","");
	}
}
