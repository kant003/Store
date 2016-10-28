package com.cebem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cebem.model.Client;

public class ClientManagement {
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

	// Method for adding clients to the DB
	public static int addDB(Client c) throws ClassNotFoundException {
		Connection con = null;
		try {
			con = getConnectionDB();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			// We create the sentence
			String sql = "INSERT INTO Client VALUES (?, ?, ?, ?, ?, ?)";

			// We create the PreparedStatement
			PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			// We insert the data received from the Client into the prepared
			// statement
			// pstm.setInt(1, c.getId()); Id is set to auto_increment in the DB
			pstm.setString(1, c.getName());
			pstm.setString(2, c.getSurname());
			pstm.setLong(3, c.getTelephone());
			pstm.setString(4, c.getEmail());
			pstm.setString(5, c.getAddress());
			pstm.setString(6, c.getPassword());

			// We execute the sentence
			int filas = pstm.executeUpdate();
			System.out.println("Filas afectadas: " + filas);

			ResultSet rs = pstm.getGeneratedKeys();
			if (rs != null && rs.next()) {
				long llave = rs.getLong(1);
				return (int) llave;
			}

			con = closeConnectionDB(con);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
	
}
