package servlets;

import java.sql.DriverManager;

public class Connection {
	 public Connection get_connection(){
	        Connection connection=null;
	        try{
	            Class.forName("com.mysql.jdbc.Driver");
	            connection= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","");
	        }catch (Exception e) {
	            System.out.println(e);
	        }
	        return connection;
	    }
}
