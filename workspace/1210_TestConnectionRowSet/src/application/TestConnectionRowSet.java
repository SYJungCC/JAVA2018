package application;

import java.sql.*;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JOptionPane;

public class TestConnectionRowSet {
	public static void main(String[] args)  {


		try (JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet())
		{
			Class.forName("oracle.jdbc.OracleDriver");
			// specify JdbcRowSet properties

			rowSet.setUrl("jdbc:oracle:thin:@199.212.26.208:1521:SQLD");
			rowSet.setUsername("COMP214_F18_008_9_10_59");
			rowSet.setPassword("password");
			rowSet.setCommand("SELECT ID, FIRSTNAME, LASTNAME FROM Person"); // set query
			rowSet.execute(); // execute query

			// insert a row using RowSet
			rowSet.moveToInsertRow(); //create a buffer for the new row
			rowSet.updateInt(1, 1099); // populate the first field
			rowSet.updateString(2,"Test"); //populate the second field
			rowSet.updateString(3, "Test");
		    rowSet.insertRow(); //Insert the contents of the insert row into table





			// fetch all rows from the Person table
			// get RowSet's meta data

			ResultSetMetaData metaData = rowSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();

			System.out.printf("Person Table:%n%n");

			// display the names of the columns in the ResultSet
			for (int i = 1; i <= numberOfColumns; i++){

				System.out.printf("%-14s\t",metaData.getColumnName(i) );
			}
			System.out.println();
			rowSet.beforeFirst();
			// display query results
			while (rowSet.next())
			{
				for (int i = 1; i <= numberOfColumns; i++)
					System.out.printf("%-14s\t", rowSet.getObject(i));
				System.out.println();
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
}










