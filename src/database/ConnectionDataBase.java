package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {
	// firewall 192.168.20.3
			/*Integration : 10.10.2.2*/
			/* localhost:3306 databaseSql APP 123  ajout*/
		
	private  String URL;//"jdbc:mysql://localhost:3306/hotel"mysql 3306 postgre 5432 // changer ICI pour bdd
	 private String USER; // fonctionne pas	
	 private  String PASSWORD;  // fonctionne pas
	 private  String DRIVER_NAME;
			
			 	public ConnectionDataBase() {
				super();
				try {
					 Class.forName("com.mysql.jdbc.Driver").newInstance();
					 System.out.println("* Driver loaded.");
				 }
				 catch (ClassNotFoundException e) {
					 System.err.println("* ERROR: Driver "  + "not found");
				 }
				 catch (InstantiationException e) {
					 System.err.println("* ERROR: Impossible to create aninstance of " + DRIVER_NAME);
					 System.err.println(e.getMessage());
				 }
				 catch (IllegalAccessException e) {
					 System.err.println("* ERROR: Impossible to create aninstance of " + DRIVER_NAME);
					 System.err.println(e.getMessage());
				 }
			}

				
			 
			 
			public  Connection getConnection() throws SQLException {
				this.URL="jdbc:mysql://localhost:3306/pdsdette?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
				this.USER="root";
				this.PASSWORD="";
				 return DriverManager.getConnection(URL, USER, PASSWORD);
			}
			 
}
