package com.leitordoc.vitals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
	
	private static String createUrl() {
		return "jdbc:postgresql://" + Environments.DB_HOST + ":" + Environments.DB_PORT + "/" + Environments.DB_NAME;
	}
	
	 public Connection connect() {
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(createUrl(), Environments.DB_USER, Environments.DB_PASSWORD);
	            System.out.println("Connected to the PostgreSQL server successfully.");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }

	        return conn;
	    }
}
