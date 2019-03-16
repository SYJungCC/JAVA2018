package application;

/**
 * Seo Young Jung
 * 300981742 COMP-228
 */

import java.sql.Connection;
import java.util.ArrayList;

import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.fxml.FXML;


public class MainController {

	private Db _dbController;	//for db Connection
	private ArrayList<String> _dbData;	//for getting Db data

	@FXML private TextField _txtCity;	//For searching
	@FXML private TextArea _textArea;	//For showing


	//Data data; //data object that makes db data easier to handle
	@FXML public void initialize() {
		_dbController = new Db();
		_dbData = new ArrayList<String>();
		_dbController.Connect();

	}

	//button Click
	@FXML public void onDisplayClicked(ActionEvent e)
	{
		//_textArea.clear();
		_dbData = _dbController.FindData("Students", "City", _txtCity.getText());

		for(int i = 0 ; i < _dbData.size() ; ++i)
		{
			_textArea.appendText(_dbData.get(i));
		}

	}

	/**

ALTER TABLE Game DISABLE constraint GAME_PK_ID cascade;
	 **/
}
