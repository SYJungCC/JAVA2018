package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import application.Data.Game;
import application.Data.Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Lab5Controller {
	public Connection connection; //connection object
	Data data; //data object that makes db data easier to handle
	boolean gameSelected = false; //if player slects a game in the dropdown is turned on
	boolean playerSelected = false; //if user selects a player in the dropdown is turned ON

	@FXML private ComboBox<String> _gm_list;
	@FXML private ComboBox<String> _pl_list;
	@FXML private TextField _pl_txt1;
	@FXML private TextField _pl_txt2;
	@FXML private TextField _pl_txt3;
	@FXML private TextField _pl_txt4;
	@FXML private TextField _pl_txt5;
	@FXML private TextField _pl_txt6;
	@FXML private TextField _gm_txt1;
	@FXML private Button _btn_new;
	@FXML private Button _pl_insert;
	@FXML private Button _gm_insert;
	@FXML private Button _pl_delete;
	@FXML private Button _gm_delete;
	@FXML private ListView<String> _gm_scorelist;

	@FXML public void initialize() {
		//button handlerss
		_btn_new.setOnAction(new ClearHandler());
		_pl_insert.setOnAction(new InsertPlayerHandler());
		_gm_insert.setOnAction(new InsertGameHandler());
		_pl_delete.setOnAction(new DeletePlayerHandler());
		_gm_delete.setOnAction(new DeleteGameHandler());


		//connect to db
		try{
			Class.forName("oracle.jdbc.OracleDriver");

			//LOCAL Centennial College CONNECTION CCwSecure only
			//connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD", "COMP214_F18_008_9_10_59","password");

			//REMOTE CONNECTION only
			connection = DriverManager.getConnection("jdbc:oracle:thin:@199.212.26.208:1521:SQLD", "COMP214_F18_008_9_10_59","password");


			System.out.println("Successfull connection");
		}
		catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		}


		//prepare data
		if (connection != null)
			data = new Data(connection);

		//fill the dropdown lists with the appropriate entries
		_pl_list.setItems(FXCollections.observableArrayList(data.playersToStrArray()));
		_gm_list.setItems(FXCollections.observableArrayList(data.gamesToStrArray()));


		//when a game is selected display game infoand update score if a player is also selected
		_gm_list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
        {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				Game g = null;

				try {
					g = data.findGame(_gm_list.getSelectionModel().getSelectedItem().toString());
				} catch (NullPointerException e) {}

				if (g != null) {
					_gm_txt1.setText(g.title);
					if (_gm_list.getSelectionModel().getSelectedItem() != null) {
						gameSelected = true;
						_gm_insert.setText("Update");
					}
					populateScore();
				}
			}
        });


		//if player slected update the player info and update score if a game is also selected
		_pl_list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
        {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				Player p = null;

				try {
				p = data.findPlayer(_pl_list.getSelectionModel().getSelectedItem().toString());
				} catch (NullPointerException e) {}

				if (p != null) {
					_pl_txt1.setText(p.firstName);
					_pl_txt2.setText(p.lastName);
					_pl_txt3.setText(p.address);
					_pl_txt4.setText(p.postalCode);
					_pl_txt5.setText(p.province);
					_pl_txt6.setText(p.phoneNum);

					if (_pl_list.getSelectionModel().getSelectedItem() != null)
						playerSelected = true;
						_pl_insert.setText("Update");
					populateScore();
				}
			}
        });

	}


	///generic function that populates the score by finding Game and Player and generating a list of scores
	private void populateScore() {
		if (gameSelected && playerSelected && data != null) {

			_gm_scorelist.getItems().clear();

			Game g = data.findGame(_gm_list.getSelectionModel().getSelectedItem().toString());
			Player p = data.findPlayer(_pl_list.getSelectionModel().getSelectedItem().toString());

			List<String> scores = data.findScore(g, p);

			for(String s : scores) {
				_gm_scorelist.getItems().add(s);
			}
		}
	}



	//clear all the input text fields and dropdowns and reload the values from db
	private class ClearHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			clearGameList();
			clearPlayerList();

			_pl_txt1.clear();
			_pl_txt2.clear();
			_pl_txt3.clear();
			_pl_txt4.clear();
			_pl_txt5.clear();
			_pl_txt6.clear();
			_gm_txt1.clear();

			playerSelected = false;
			gameSelected = false;
			_gm_insert.setText("Create");
			_pl_insert.setText("Create");
		}
	}


	//clear game list and reload game data
	private void clearGameList() {
		String [] list = {};

		_gm_list.setItems(FXCollections.observableArrayList(list));

		if (data != null) {
			data.reload();
			_gm_list.setItems(FXCollections.observableArrayList(data.gamesToStrArray()));
		}
	}

	//clear player list and reload player data
	private void clearPlayerList() {
		String [] list = {};

		_pl_list.setItems(FXCollections.observableArrayList(list));

		if (data != null) {
			data.reload();
			_pl_list.setItems(FXCollections.observableArrayList(data.playersToStrArray()));
		}
	}

	//clear player info fields
	private void clearPlayer() {
		_pl_txt1.clear();
		_pl_txt2.clear();
		_pl_txt3.clear();
		_pl_txt4.clear();
		_pl_txt5.clear();
		_pl_txt6.clear();
	}

	//create/update game handler
	private class InsertGameHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			if (gameSelected) { //if the game is selected UPDATE mode only
				Game g = data.findGame(_gm_list.getSelectionModel().getSelectedItem().toString());

				data.updateGame(Integer.parseInt(g.id), _gm_txt1.getText());

			} else { //else insert mode
				// insert
				data.addGame(Math.abs(_gm_txt1.getText().hashCode()) / 1000, _gm_txt1.getText());
				_gm_txt1.clear();
			}
			clearGameList();
		}
	}


	//delete game handler
	private class DeleteGameHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			if (gameSelected) {
				// delete
				data.deleteGame(_gm_txt1.getText());
				_gm_txt1.clear();
				clearGameList();
				gameSelected = false;
				_gm_insert.setText("Create");
			}
		}
	}


	//insert/update player handler
	private class InsertPlayerHandler implements EventHandler<ActionEvent>  {

		@Override
		public void handle(ActionEvent e) {
			if (playerSelected) { //if player is selected from dropdown UPDATE mode
				Player p = data.findPlayer(_pl_list.getSelectionModel().getSelectedItem().toString());

				//data.addPlayer(Math.abs((_pl_txt1 + "" + _pl_txt2).hashCode()) / 1000, _pl_txt1.getText(), _pl_txt2.getText(), _pl_txt3.getText(), _pl_txt4.getText(), _pl_txt5.getText(), _pl_txt6.getText());
				data.updatePlayer(Integer.parseInt(p.id), _pl_txt1.getText(), _pl_txt2.getText(), _pl_txt3.getText(), _pl_txt4.getText(), _pl_txt5.getText(), _pl_txt6.getText());
			} else { //else INSERT mode
				// insert
				data.addPlayer(Math.abs((_pl_txt1 + "" + _pl_txt2).hashCode()) / 1000, _pl_txt1.getText(), _pl_txt2.getText(), _pl_txt3.getText(), _pl_txt4.getText(), _pl_txt5.getText(), _pl_txt6.getText());
			}


			//make sure all values are reset after update/insert
			clearPlayer();
			clearPlayerList();
		}
	}


	//delete player handler
	private class DeletePlayerHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			if (playerSelected) {
				// delete
				Player p = data.findPlayer(_pl_list.getSelectionModel().getSelectedItem().toString());
				data.deletePlayer(p);
				playerSelected = false;
				_pl_insert.setText("Create");
				clearPlayer();
				clearPlayerList();
			}
		}

	}

}
