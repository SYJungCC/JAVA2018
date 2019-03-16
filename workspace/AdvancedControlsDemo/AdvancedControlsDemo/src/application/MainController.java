package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.paint.Paint;

public class MainController {

	@FXML private ComboBox<String>  _cmbColor;
	@FXML private ListView<String> _lstViewColor;
    @FXML private Label _lblDisplay;
	@FXML private void initialize() {


		String[] colorList = {"Yellow", "Red", "Green"};
		ObservableList<String> colorOList = FXCollections.observableArrayList(colorList);
		// initialize the combo box
		_cmbColor.setItems(colorOList);

		// initialize the list view
        _lstViewColor.setItems(colorOList);

        _lstViewColor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
        {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				  int index = _lstViewColor.getSelectionModel().getSelectedIndex();
	              _lblDisplay.setTextFill(Paint.valueOf("Black"));
				  _lblDisplay.setText(colorList[index]);
			}

        });


	}

     @FXML private void onSelectCmb(){

    	 String selectedColor= _cmbColor.getSelectionModel().getSelectedItem();
          _lblDisplay.setTextFill(Paint.valueOf(selectedColor));
          _lblDisplay.setText(selectedColor);
     }

}
