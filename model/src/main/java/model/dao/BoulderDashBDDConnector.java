package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <h1>The BoulderDashBDDConnector Class.</h1>
 *
 */
public class BoulderDashBDDConnector {

	
	  private static Connection connect;
	   
	  
	  private BoulderDashBDDConnector(){
	    
	  }
	   
	  
	  /**
	   * method that return the instance or create it if it's missing
	   * 
	   *
	   * @return connect
	   *			connection with the database
	   */
	  public static Connection getInstance(){
		  if(connect == null){
			  try {
				  //String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
				  String JDBC_DRIVER = "com.mysql.jdbc.Driver";
					
				//Register JDBC driver
	            try {
					Class.forName(JDBC_DRIVER);
				} catch (ClassNotFoundException e) {
					
					// Print the exception and the state of the execution stack 
					e.printStackTrace();
				} 
	            
				//URL 
				  String url = "jdbc:mysql://localhost/boulderdash?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				  //UserName
				  String user = "xavier";
				  //Password
				  String passwd = "xavier";
			      connect = DriverManager.getConnection(url, user, passwd);
			    } catch (SQLException e) {
			    	// Print the exception and the state of the execution stack
			    	e.printStackTrace();
			    }
		    System.out.println("INSTANTIATION OF THE SQL CONNEXION ! ");
		  }
		  else{
		    System.out.println(" SQL CONNEXION EFFECTIVE ! ");
		  }
		  return connect;   
		}
}