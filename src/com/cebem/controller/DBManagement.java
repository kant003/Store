package com.cebem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class DBManagement {
	static Connection con = null;

	// Method for connecting to the DB
	public static void openConnectionDB(String user, String pass) throws SQLException {
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Madrid");
		TimeZone.setDefault(timeZone);
		String sURL = "jdbc:mysql://10.100.13.197/store_development?useSSL=false&serverTimezone=Europe/Madrid";
		String sDriver = "com.mysql.jdbc.Driver";// mysql-connector-java-6.0.4
													// is needed
		con = null;

		try {
			// Method for loading the DB driver
			Class.forName(sDriver).newInstance();
			// The connection is established
			con = DriverManager.getConnection(sURL, user, pass);
			// System.err.println("Conexi�n establecida");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException mte) {
			mte.printStackTrace();
			throw new SQLException(mte.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
	}

	// Method for closing the connection to the DB
	public static void closeConnectionDB() throws SQLException {
		con.close();
		con = null;
	}
}
