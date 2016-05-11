package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCconnect 
{

	String SQLQuery;
	
	public JDBCconnect(String query)
	{
		SQLQuery=query;
	}
	
	
	public ResultSet execute() throws SQLException,ClassNotFoundException
	{
		//Statement stmt = null;
		Statement stmt = ConnectClass.c.createStatement();
		
		if (stmt==null)
	      System.out.println("yes !!!!");
	    ResultSet rs = stmt.executeQuery(SQLQuery);
	    return rs;
	}
	
	public void executeadd() throws SQLException,ClassNotFoundException
	{
		//Statement stmt = null;
		/*try
		{ Statement stmt = ConnectClass.c.createStatement();
		System.out.println("hola 1");
		  if (stmt==null)
	        System.out.println("yes !!!!");
		  System.out.println("hola2");
	      stmt.executeUpdate(SQLQuery);
	      System.out.println("hola3");
	      ConnectClass.c.commit(); 
	      System.out.println("Inserted record in the table");
		}
		catch(SQLException e)
		{
			System.out.println("error");
		}
	    */
		
		
		 try {

		        PreparedStatement preparedStatement = ConnectClass.c.prepareStatement(SQLQuery);

		        /*preparedStatement.setString(1, user.getUsername());
		        preparedStatement.setString(2, user.getPassword());
		        preparedStatement.setString(3, user.getName());
		        preparedStatement.setString(4, user.getEmail());
		        //System.out.println("101");
		        */
		        
		        preparedStatement.executeUpdate();//--->throws exception here
		        
		        
		        
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		        //System.out.println("102");
		        e.printStackTrace();
		    }
		
		
		
	   	    
	    //return rs;
	}
	
	
	
	
}
