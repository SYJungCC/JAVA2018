package application;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneDemo extends Application{


	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane and set its properties
		FlowPane pane = new FlowPane(Orientation.VERTICAL); //default horizental
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setHgap(5);
		pane.setVgap(15);

		//button controls
		Button btnOk = new Button("OK");
		Button btnCancel = new Button("Cancel");

		//Place nodes in the pane
		pane.getChildren().addAll(btnOk,btnCancel);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 300, 100);
		primaryStage.setTitle("ShowFlowPane"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}
	public static void main(String[] args) {
		launch(args);
		}

}
