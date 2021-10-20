package servlets;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	 public Connection get_connection(){
	        Connection connection=null;
	        try{
	            Class.forName("com.mysql.jdbc.Driver");
	            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","");
	        }catch (Exception e) {
	            System.out.println(e);
	        }
	        return connection;
	    }
}
