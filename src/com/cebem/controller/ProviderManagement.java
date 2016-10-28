package com.cebem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ProviderManagement{
	// Method for connecting to the DB
	public static Connection getConnectionDB() throws SQLException {
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Madrid");
		TimeZone.setDefault(timeZone);
		String sURL = "jdbc:mysql://10.100.13.110/store_development?useSSL=false&serverTimezone=Europe/Madrid";
		String user = "Store";// User
		String pass = "Ad123";// Pass
		String sDriver = "com.mysql.cj.jdbc.Driver";// mysql-connector-java-6.0.4
													// is needed
		Connection con = null;

		try {
			// Method for loading the DB driver
			Class.forName(sDriver).newInstance();
			// The connection is established
			con = DriverManager.getConnection(sURL, user, pass);
			System.err.println("Conexión establecida");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException mte) {
			mte.printStackTrace();
			throw new SQLException(mte.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}

		return con;
	}

	// Method for closing the connection to the DB
	public static Connection closeConnectionDB(Connection con) throws SQLException {
		con.close();
		return con;
	}
}
