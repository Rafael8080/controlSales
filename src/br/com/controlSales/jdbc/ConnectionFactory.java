package br.com.controlSales.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/bdvendas?useTimezone=true&serverTimezone=UTC", "root", "root"); 
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
