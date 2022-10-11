package br.com.comex.sql.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.12:1521/XE","system","dell");
	}		
		
}
