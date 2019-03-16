package application;
/**
 * 300981742 SeoYoung Jung
 * COMP228 Lab4
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

	//TextField
	@FXML private TextField _txtName;
	@FXML private TextField _txtAddress;
	@FXML private TextField _txtProvience;
	@FXML private TextField _txtCity;
	@FXML private TextField _txtPostalCode;
	@FXML private TextField _txtPhoneNumber;
	@FXML private TextField _txtEmail;

	//Display Button & TextArea for displaying
	@FXML private Button _btnDisplay;
	@FXML private TextArea _txtOutput;

	//Radio Button
	@FXML private RadioButton _rBtnComputer;
	@FXML private RadioButton _rBtnBusiness;

	//Check Box
	@FXML private CheckBox _cbxCouncil;
	@FXML private CheckBox _cbxVolunteer;

	//Combo Box  & List View
	@FXML private ComboBox<String>  _cmbMajor;
	@FXML private ListView<String> _lstViewMajor;
	@FXML private Label _lblError;

	//for combo Box
	private String[] _computerList = {"Python", "C#", "Java"};
	private String[] _businessList = {"Accounting", "Math", "Business Theory"};

	/**
	 * Radio button (Computer & Business)
	 */
	@FXML public void radioButtonChanged()
	{
		_cmbMajor.getItems().clear();

		if(_rBtnComputer.isSelected())
		{
			ObservableList<String> majorOList = FXCollections.observableArrayList(_computerList);
			_cmbMajor.setItems(majorOList);
		}
		if(_rBtnBusiness.isSelected())
		{
			ObservableList<String> majorOList = FXCollections.observableArrayList(_businessList);
			_cmbMajor.setItems(majorOList);
		}
	}

	/**
	 * Display All
	 * @param e
	 */
	@FXML public void onDisplayClicked(ActionEvent e)
	{
		String str = "Name : " + _txtName.getText() + ", "
					+ "Address : "  +_txtAddress.getText()+ ", "
					+ "Provience : "  + _txtProvience.getText()+ ", "
					+ "City : "  +_txtCity.getText()+", "
					+ "PostalCode : "  +_txtPostalCode.getText()+ ", "
					+ "Phone : "  +_txtPhoneNumber.getText()+ ", "
					+ "Email : " +_txtEmail.getText()+ ".\n"
					+ "Concile : " + (_cbxCouncil.isSelected() ? "Yes" : "No")+ ","
					+ "Volunteer : " + (_cbxVolunteer.isSelected() ? "Yes" : "No") + ".\n"
					+ "Courses : \n";

		for(int i = 0; i < _lstViewMajor.getItems().size(); ++i )
		{
			if(i != 0) str += ", ";
			str +=_lstViewMajor.getItems().get(i);
		}
		str+="\n";

		_txtOutput.appendText(str);
	}


	/**
	 * When user click the Combo box, it checks the list box items.
	 * If they item is already added, it shouldn't be add.
	 */
    @FXML private void onSelectCmb(){

    	String course = _cmbMajor.getSelectionModel().getSelectedItem();
    	_lblError.setText("");
    	if(course != null)
    	{

    		if(!_lstViewMajor.getItems().contains(course))
    		{
    			_lstViewMajor.getItems().add(course);
    		}
    		else
    		{
    			_lblError.setText("£ª£ª You arleady added this course");
    		}
    	}
    }



}
