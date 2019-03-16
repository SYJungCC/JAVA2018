package application;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class MainController {
	@FXML private ComboBox<String> gm_list;
	@FXML private ComboBox<String> pl_list;
	@FXML private TextField pl_txt1;
	@FXML private TextField pl_txt2;
	@FXML private TextField pl_txt3;
	@FXML private TextField pl_txt4;
	@FXML private TextField pl_txt5;
	@FXML private TextField pl_txt6;
	@FXML private TextField gm_txt1;
	@FXML private Button btn_new;
	@FXML private Button pl_insert;
	@FXML private Button gm_insert;


	@FXML public void initialize() {

		gm_list.setItems(FXCollections.observableArrayList("Python", "C#", "Java"));
	//	_txtArea.appendText(String.format("%-14s\t",metaData.getColumnName(i)));
	}
}
