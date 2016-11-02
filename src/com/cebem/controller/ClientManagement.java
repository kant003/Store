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

public class ClientManagement extends DBManagement {

	// Method for adding clients to the DB
	public static int addClient(Client c) throws ClassNotFoundException {

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
			pstm.executeUpdate();

			ResultSet rs = pstm.getGeneratedKeys();
			if (rs != null && rs.next()) {
				long llave = rs.getLong(1);
				return (int) llave;
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public Client getSingleClient(int id) throws SQLException {
		Client c = new Client();
		try {
			String query = "SELECT * FROM Client WHERE id = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				/*
				 * Retrieve one client details and store it in client object
				 */
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
		return c;
	}

	// Method for getting the clients from the DB
	public static ArrayList<Client> getClients() {
		ArrayList<Client> clients = new ArrayList<Client>();

		String query = "SELECT * FROM Client";
		ResultSet rs = null;
		try {

			Statement statement = con.createStatement();
			rs = statement.executeQuery(query);

			while (rs.next()) {
				Client c = new Client();
				/*
				 * Retrieve one client details and store it in client object
				 */
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setSurname(rs.getString(3));
				c.setTelephone(rs.getLong(4));
				c.setEmail(rs.getString(5));
				c.setAddress(rs.getString(6));
				c.setPassword(rs.getString(7));
				// add each client to the list
				clients.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return clients;
	}

	// Method for deleting a client
	public static void deleteClient(int id) {
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
	
	public ArrayList<Client> findClientsDB(String param){
		//The array for return the clients
		ArrayList<Client> arrCli=null;
		PreparedStatement pstm=null;
		ResultSet result=null;
		
		try{           
			String query = "SELECT Client.id,name,surname,telephone,email,address,password"
                    + " FROM Client WHERE Client.name like '%"+param+"%' Or Client.surname like '%"+param
                    + "%' Or Client.telephone like '%"+param+"%' Or Client.email like '%"+param
                    + "%' Or Client.address like '%"+param+"%';";

           pstm = con.prepareStatement(query);
           result = pstm.executeQuery();
            
           //Recorremos el resultado, guardadno los resultados en el arrCli
           while(result.next()){
               System.out.println(result.getString("Nombre") +"\t"+
               result.getDate("fechaAlta") +"\t" +result.getDouble("Salario") +"\t"+
               result.getDouble("Comision") +"\t" +result.getString("DepNombre") +"\t"+
               result.getString("Localidad"));   
           }
        
        }catch(SQLException sqle){sqle.printStackTrace();}

		return arrCli;
	}
}
