package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection 
{
	private static Connection conX;  
	private static String url =  "jdbc:mysql://localhost:3306/logininformation?autoReconnect=true&useSSL=false";
	private static String user = "root";//Username of database  
	private static String passWord ="root";//Password of database  
	
	public static Connection connect() throws SQLException
	{  
		try
		{  
			Class.forName("com.mysql.jdbc.Driver").newInstance();  
		}
		catch(ClassNotFoundException cnfe)
		{  
			System.err.println("Error: "+cnfe.getMessage());  
		}
		catch(InstantiationException ie)
		{  
			System.err.println("Error: "+ie.getMessage());  
		}
		catch(IllegalAccessException iae)
		{  
			System.err.println("Error: "+iae.getMessage());  
		}  
		conX = DriverManager.getConnection(url,user,passWord);  
		return conX;  
	}  
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{  
		if(conX !=null && !conX.isClosed())  
			return conX;  
		connect();  
		return conX;  
	}  
}