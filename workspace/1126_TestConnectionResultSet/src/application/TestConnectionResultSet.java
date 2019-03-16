package application;

import java.sql.*;

import javax.swing.JOptionPane;

public class TestConnectionResultSet {
	public static void main(String[] args)  {
		Connection connection = null;
		Statement retrieveStatement = null;
		ResultSet resultSet = null;
		try{

			//this loads the driver in memory
			Class.forName("oracle.jdbc.OracleDriver");
			//connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD", "COMP214_F18_008_9_10_59","password");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@199.212.26.208:1521:SQLD", "COMP214_F18_008_9_10_59","password");


			System.out.println("Successfull connection");


			retrieveStatement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
			resultSet = retrieveStatement.executeQuery("select ID, FIRSTNAME, LASTNAME from Person");

			// insert a row using ResultSet
			//resultSet.moveToInsertRow(); //create a buffer for the new row
			//resultSet.updateInt(1, 1010); // populate the first field
			//resultSet.updateString(2,"Max"); //populate the second field
			//resultSet.updateString(3, "O'Connor");
			//resultSet.insertRow(); //Insert the contents of the insert row into table

			// update a row using ResultSet
			//resultSet.moveToCurrentRow();
			///resultSet.first();
			///resultSet.updateInt(1, 1011);
			//resultSet.updateString(2, "Ali");
			//resultSet.updateRow();

			// delete a row
			//resultSet.last();
			//resultSet.deleteRow();
			//resultSet.updateRow();



			// fetch all rows from the Person table
			// get ResultSet's meta data

			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();

			System.out.printf("Person Table:%n%n");

			// display the names of the columns in the ResultSet
			for (int i = 1; i <= numberOfColumns; i++){

				System.out.printf("%-14s\t",metaData.getColumnName(i) );
			}
			System.out.println();
			resultSet.beforeFirst();
			// display query results
			while (resultSet.next())
			{
				for (int i = 1; i <= numberOfColumns; i++)
					System.out.printf("%-14s\t", resultSet.getObject(i));
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


		//added
		finally{
			if(connection != null)
			{
				//clost the connection
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		if(retrieveStatement != null)
		{
			try {
				retrieveStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		if(resultSet != null)
		{
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}
}









