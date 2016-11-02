package com.cebem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
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

	public int addDB2(Client c) throws SQLException{
		// Setting parameters for the connection
		Connection connection = null;
		String user = "";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/";

		
			// Code for loading the Driver from Mysql
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Setting the connection
			connection = DriverManager.getConnection(url, user, password);
			System.err.println("Connection established");

			// We create the sentence
			String sql = "INSERT INTO Client VALUES (?, ?, ?, ?, ?, ?, ?)";

			// We create the PreparedStatement
			PreparedStatement pstm = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); // Para
			// devolver
			// la
			// ID

			// We insert the data recieved from the Client into the prepared
			// statement
			pstm.setInt(1, c.getId());

			pstm.setString(2, c.getName());

			pstm.setString(3, c.getSurname());

			pstm.setLong(4, c.getTelephone());

			pstm.setString(5, c.getEmail());

			pstm.setString(6, c.getAddress());

			pstm.setString(7, c.getPassword());
		
		return 1;
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


		con.close();
		}  catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public void selectSingleDB(int id) {

		ArrayList<Client> arrayClients = new ArrayList<Client>();

		for (Client e : arrayClients) {

			if (e.equals(id)) {
				
				System.out.println(e); // Esto deberia ir en la interfaz
				// guiclient
			
<<<<<<< HEAD

			}
=======
			while (rs.next()) {
                Client c = new Client();
                /*Retrieve one client details 
                and store it in client object*/
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setSurname(rs.getString(3));
                c.setTelephone(rs.getLong(4));
                c.setEmail(rs.getString(5));
                c.setAddress(rs.getString(6));
                c.setPassword(rs.getString(7));
                //add each client to the list
                clients.add(c);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
>>>>>>> 7f998ded29ba48e2d90147e8eb04995948646987
		}

	}
<<<<<<< HEAD


=======
	
	// Method for deleting a client
	public static void deleteClient(int id){
	    Connection con = null;
	    PreparedStatement st = null;
		try {
			con = getConnectionDB();
			st = con.prepareStatement("DELETE FROM Client WHERE id = ?");
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			con = closeConnectionDB(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
>>>>>>> 7f998ded29ba48e2d90147e8eb04995948646987
}
