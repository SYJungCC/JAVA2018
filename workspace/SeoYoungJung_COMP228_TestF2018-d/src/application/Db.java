package application;

/**
 * Seo Young Jung
 * 300981742 COMP-228
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Db {

	private Connection _connection; //connection object
	private ArrayList<String> _dbData = new ArrayList<String>();

	void Connect()
	{
		//connect to db
		try{
			Class.forName("oracle.jdbc.OracleDriver");

			_connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD", "COMP214_F18_008_9_10_59","password");

			System.out.println("Successfull connection");

		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	ArrayList<String> FindData(String table, String whereid, String content)
	{
		try {
			ResultSet rs = genericSelect(table,whereid,content);
			String text;
			while(rs.next())
			{
				if(rs.getObject(2).toString().length() > 4)
				{
					 text = rs.getObject(1)
							+ "\t\t" + rs.getObject(2)
							+ "\t" + rs.getObject(3)
							+ "\t\t" + rs.getObject(4)
							+ "\t\t" + rs.getObject(5)
							+ "\t\t" + rs.getObject(6)
							+ "\t\t" + rs.getObject(7) +"\n";

				}
				else
				{
					 text = rs.getObject(1)
							+ "\t\t" + rs.getObject(2)
							+ "\t\t" + rs.getObject(3)
							+ "\t\t" + rs.getObject(4)
							+ "\t\t" + rs.getObject(5)
							+ "\t\t" + rs.getObject(6)
							+ "\t\t" + rs.getObject(7) +"\n";

				}

				System.out.println(text);
				_dbData.add(text);

			}
			return _dbData;
		}
		catch (SQLException e) {
			System.out.println("FindData Fail : " + e);
		}
		return null;
	}

	private ResultSet genericSelect(String table, String whereid, String content)throws SQLException
	{

		return _connection.createStatement().executeQuery("select * from "+table+" where "+ whereid + "= '" + content + "'");
	}
}
