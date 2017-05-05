package extras;

/**
 * Class that represent a database connection
 * 
 * 
 * Provides a connection with a statement to execute 
 * queries on database.
 * 
 * 
 * @author Theodoros Charalambous 
 * 
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	
	private Connection conn;
	private Statement statement;
	private static final String HOST="localhost";
	private static final String USER="root";
	private static final String PASSWORD="";
	private static final String DATABASE="arkalam";


	
	/**
	 * Constructor that establishes a connection and initialize
	 * a statement.
	 * 
	 * 
	 */
	
	public DatabaseConnection(){		
		try {			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://"+HOST+"/"+DATABASE,USER,PASSWORD);
			statement = conn.createStatement();			
			if (conn == null){
				System.out.println("Problem with connection");
			}				
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Getter for statement
	 * 
	 * @return
	 */
	
	
	
	/**
	 * Method that close the connection with database.
	 * 
	 * 
	 */
	

	public void CloseConnection(){
		try {
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
