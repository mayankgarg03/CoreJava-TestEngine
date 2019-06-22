package com.xyz.testengine.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public interface CommonDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		          Class.forName("org.postgresql.Driver");
		          ResourceBundle rb = ResourceBundle.getBundle("config");
		          String dbUrl= rb.getString("url");
		          String username = rb.getString("username");
		          String password = rb.getString("password");
		          Connection con = DriverManager.getConnection(dbUrl,username,password);
		          return con;
	}

}
