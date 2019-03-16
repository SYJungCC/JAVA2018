package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

	@FXML Button _btnShow;
    @FXML TextArea _txtArea;
    @FXML Button _btnClose;
    @FXML Button _btnOpenWindow;



	@FXML private void onClickedShow()
	{

		//this loads the driver in memory
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD", "COMP214_F18_008_9_10_59","password");
			//Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "username","password");
			System.out.println("Successfull connection");

			Statement retrieveStatement = connection.createStatement();
			ResultSet resultSet = retrieveStatement.executeQuery("select * from Person");

			// fetch all rows from the Person table
			// get ResultSet's meta data

			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();

			System.out.printf("Person Table:%n%n");

			// display the names of the columns in the ResultSet
			for (int i = 1; i <= numberOfColumns; i++){

				_txtArea.appendText(String.format("%-14s\t",metaData.getColumnName(i)));


			}
			  _txtArea.appendText("\n");

			// display query results
			while (resultSet.next())
			{
				for (int i = 1; i <= numberOfColumns; i++)
				{
					_txtArea.appendText(String.format("%-14s\t", resultSet.getObject(i)));
				}

			}

		}
			catch(ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				e.printStackTrace();
			}
			catch(SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				e.printStackTrace();
			}

	}




	@FXML public void onClickedClose()
	{
		Alert alert = new Alert(AlertType.CONFIRMATION, "ARE YOU SURE YOU WATN TO CLOSE THE APPLICATION?");
		Optional<ButtonType> result  = alert.showAndWait();

		if(result.isPresent() && result.get() == ButtonType.OK)
		{
			//when OK is clicked goes here
			System.exit(0);
		}
	}

	@FXML public void onClickedSecondWindow()
	{
		try {
			Stage secondaryStage = new Stage();

			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Second.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondaryStage.setScene(scene);
			secondaryStage.setTitle("Second Window");
			secondaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}









}
