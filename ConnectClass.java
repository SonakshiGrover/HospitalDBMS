package application;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectClass 
{

	        public static Connection c;
		    
		    public ConnectClass() throws ClassNotFoundException,SQLException
		    {
		    	// jdbc connection
		    	  final String dbClassName = "com.mysql.jdbc.Driver";

		    	  final String CONNECTION = "jdbc:mysql://127.0.0.1/hospital_new";

		    	  
		    	  System.out.println(dbClassName);
		    	  Class.forName(dbClassName);

		    	    Properties p = new Properties();
		    	    p.put("user","root");
		    	    p.put("password","password");

		    	    c = DriverManager.getConnection(CONNECTION,p);

		    	    System.out.println("It works !");
		    	    System.out.println("value of Connection c = "+ c.isClosed());

 	
		    	
		    	
		    	
		    }   

	}

	

