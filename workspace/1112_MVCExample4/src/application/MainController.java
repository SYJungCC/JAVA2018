package application;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class MainController {

	@FXML private Button _btnAccept;
	@FXML private Button _btnReject;
	@FXML private TextArea _txtOutput;
	@FXML private Button _btnClear;
	@FXML private TextField _txtInput;
	@FXML private Button _btnSubmit;
	@FXML private Label _lblError;

	@FXML public void onAcceptClicked(ActionEvent e)
	{
		_txtOutput.appendText("Accept button was clicked\n");
	}

	@FXML public void onRejectClicked(ActionEvent e)
	{
		_txtOutput.appendText("Reject button was clicked\n");
	}
	@FXML public void onClearClicekd(ActionEvent e){

		_txtOutput.clear();
	}

	@FXML public void onSubmitClicekd(ActionEvent e){

		try {
			_lblError.setText("");

			int userValue = Integer.parseInt(_txtInput.getText());

			userValue++; //increment the value one unit;

			_txtOutput.setText(String.valueOf(userValue));
		}
		catch(NumberFormatException ex) {
			_lblError.setText("You must enter an integer value");
		}

	}
}
