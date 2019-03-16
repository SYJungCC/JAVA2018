package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	public static Connection _connection;

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try{
			//this loads the driver in memory
			Class.forName("oracle.jdbc.OracleDriver");
			//_connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD", "COMP214_F18_008_9_10_59","password");
			_connection = DriverManager.getConnection("jdbc:oracle:thin:@199.212.26.208:1521:SQLD", "COMP214_F18_008_9_10_59","password");

			System.out.println("Successfull connection");

			ResultSet rs = genericSelect("game");

			while(rs.next())
			{
				for(int i = 1 ; i< rs.getMetaData().getColumnCount() + 1 ; i++)
				{
					System.out.println(rs.getObject(i));
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


		launch(args);
	}

	public static ResultSet genericSelect(String table) throws SQLException {
		return _connection.createStatement().executeQuery("select * from " + table.toUpperCase());
	}

}
