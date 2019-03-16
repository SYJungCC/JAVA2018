package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {

	@FXML  Button _btnNew;
	@FXML  Button _btnSave;
	@FXML  Button _btnUpdate;
	@FXML  Button _btnDelete;

	@FXML TextField _txtID;
	@FXML TextField _txtFirstName;
	@FXML TextField _txtLastName;


	@FXML private void initialize()
	{

		try (JdbcRowSet _rowSet = RowSetProvider.newFactory().createJdbcRowSet())
		{
			Class.forName("oracle.jdbc.OracleDriver");
			// specify JdbcRowSet properties

			_rowSet.setUrl("jdbc:oracle:thin:@199.212.26.208:1521:SQLD");
			_rowSet.setUsername("COMP214_F18_008_9_10_59");
			_rowSet.setPassword("password");
			_rowSet.setCommand("SELECT ID, FIRSTNAME, LASTNAME FROM Person"); // set query
			_rowSet.execute(); // execute query
			_rowSet.first();
			_txtID.setText(String.valueOf(_rowSet.getString("ID")));
			_txtFirstName.setText(_rowSet.getString(2));
			_txtLastName.setText(_rowSet.getString(3));
			_rowSet.close();
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();



		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@FXML void OnNewClicked()
	{

		try (JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet())
		{
			Class.forName("oracle.jdbc.OracleDriver");
			rowSet.setUrl("jdbc:oracle:thin:@199.212.26.208:1521:SQLD");
			rowSet.setUsername("COMP214_F18_008_9_10_59");
			rowSet.setPassword("password");
			rowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
			rowSet.setCommand("SELECT ID, FIRSTNAME, LASTNAME FROM Person"); // set query
			rowSet.execute(); // execute query


			rowSet.moveToInsertRow();
			rowSet.updateInt(1, Integer.parseInt(_txtID.getText().trim()));
			rowSet.updateString(2, _txtFirstName.getText());
			rowSet.updateString(3, _txtLastName.getText());
		    rowSet.insertRow();
			System.out.print("Row is added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

