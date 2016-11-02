package com.cebem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TimeZone;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cebem.model.Client;

public class ClientManagement {

	static Connection con = null;
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
<<<<<<< HEAD
			System.err.println("Conexiï¿½n establecida");
=======
			//System.err.println("Conexión establecida");
>>>>>>> 5f23a9ef1dd9fc06be032f832980d80f91d201b5
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
<<<<<<< HEAD
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

=======
>>>>>>> 5f23a9ef1dd9fc06be032f832980d80f91d201b5
			// We create the sentence
			String sql = "INSERT INTO Client VALUES (?, ?, ?, ?, ?, ?, ?)";

			// We create the PreparedStatement
			PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); // Para
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
<<<<<<< HEAD

		return 1;
=======
		
			int totalInserciones = pstm.executeUpdate();
		return totalInserciones;
>>>>>>> 5f23a9ef1dd9fc06be032f832980d80f91d201b5
	}
	// Method for closing the connection to the DB
	public static Connection closeConnectionDB(Connection con) throws SQLException {
		con.close();
		return con;
	}

	// Method for adding clients to the DB
	public static int addDB(Client c) throws ClassNotFoundException {
		

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
			//System.out.println("Filas afectadas: " + filas);

			ResultSet rs = pstm.getGeneratedKeys();
			if (rs != null && rs.next()) {
				long llave = rs.getLong(1);
				return (int) llave;
			}


		
		}  catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}


	public Client selectSingleDB(int id) throws SQLException{
		Client c = new Client();
		ArrayList<Client> arrayClients = new ArrayList<Client>();
		try {
		String query = "SELECT * FROM Client WHERE id = ?";
		PreparedStatement pstm = con.prepareStatement(query);
		ResultSet rs = pstm.executeQuery();
		
		
			while(rs.next()){
				
			    /*Retrieve one client details 
			    and store it in client object*/
			    c.setId(rs.getInt(1));
			    c.setName(rs.getString(2));
			    c.setSurname(rs.getString(3));
			    c.setTelephone(rs.getLong(4));
			    c.setEmail(rs.getString(5));
			    c.setAddress(rs.getString(6));
			    c.setPassword(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException();
		}
<<<<<<< HEAD
	}


	// Method for getting the clients from the DB
	public static ArrayList<Client> getClients(){
		ArrayList<Client> clients = new ArrayList<Client>();

		Connection con = null;
		String query = "SELECT * FROM Client";
        ResultSet rs = null;
		try {
			con = getConnectionDB();

			Statement statement = con.createStatement();
			rs = statement.executeQuery(query);
=======
		return c;

	}


	
	// Method for getting the clients from the DB
	public static ArrayList<Client> getClients(){
		ArrayList<Client> clients = new ArrayList<Client>();
	
		String query = "SELECT * FROM Client";
        ResultSet rs = null;
		try {
			
			Statement statement = con.createStatement();
			rs = statement.executeQuery(query);
			
>>>>>>> 5f23a9ef1dd9fc06be032f832980d80f91d201b5

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

		}
<<<<<<< HEAD

		return clients;
	}

=======
		return clients;
	}




	
>>>>>>> 5f23a9ef1dd9fc06be032f832980d80f91d201b5
	// Method for deleting a client
	public static void deleteClient(int id){
	    
	    PreparedStatement st = null;
		try {
			
			st = con.prepareStatement("DELETE FROM Client WHERE id = ?");
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}
<<<<<<< HEAD
=======

>>>>>>> 5f23a9ef1dd9fc06be032f832980d80f91d201b5
}
