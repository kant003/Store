package com.cebem.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import com.cebem.model.Client;



public class ClientManagement extends DBManagement {

<<<<<<< HEAD
	/* method update client in the DB */
	public boolean updateClient(int id, Client client){
		String query = "UPDATE client SET name=?, surname=?, telephone=?, email=?, address=?, password=?WHERE Id=?;";

		PreparedStatement ps;
		try {
			ps= (PreparedStatement)con.prepareStatement(query);

			ps.setString(1 , client.getName());
			ps.setString(2, client.getSurname());
			ps.setLong(3, client.getTelephone());
			ps.setString(4, client.getEmail());
			ps.setString(5, client.getAddress());
			ps.setString(6, client.getPassword());
			ps.setInt(7, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Method for adding clients to the DB
=======

	/**
	 * AÃ±ade un Cliente a la BD
	 * 
	 * @param c Object Client
	 * @return 0
	 * @throws ClassNotFoundException
	 */
>>>>>>> 73147bbac153d03fa67e7d40f20773971a1f4241
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

	/**
	 * Selecciona un Cliente de la BD dada su id
	 * 
	 * @param id Integer
	 * @return c Object Client
	 * @throws SQLException
	 */
	public Client getSingleClient(int id) throws SQLException {
		Client c =null; 
		try {
			String query = "SELECT * FROM Client WHERE id = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				c=new Client();
				// Establecemos los valores para los parÃ¡metros que debemos guardar en un objeto Client
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setSurname(rs.getString(3));
				c.setTelephone(rs.getLong(4));
				c.setEmail(rs.getString(5));
				c.setAddress(rs.getString(6));
				c.setPassword(rs.getString(7));
			}
		} catch (SQLException e) {
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
			
			e.printStackTrace();
		}
	}
/**
 * Este método recoge una cadena, la convierte en una consulta
 * que nos recoge los clientes con algún parámetro coincidente(excluyendo id y password)
 */
	public ArrayList<Client> findClientsDB(String param) {
		ArrayList<Client> arrCli=new ArrayList<Client>();
		PreparedStatement pstm=null;
		ResultSet result=null;

		try{
			//Creamos la consulta
			String query="SELECT Client.id,name,surname,telephone,email,address,password"
					+ " FROM Client WHERE Client.name like '%" + param + "%' Or Client.surname like '%" + param
					+ "%' Or Client.telephone like '%" + param + "%' Or Client.email like '%" + param
					+ "%' Or Client.address like '%" + param + "%';";

			//La ejecutamos y guardamos los resultados en un ResultSet
			pstm=con.prepareStatement(query);
			result=pstm.executeQuery();

			// Recorremos el ResultSet, guardando los resultados en el arrCli
			while (result.next()) {
				Client c = new Client();
				c.setId(result.getInt(1));
				c.setName(result.getString(2));
				c.setSurname(result.getString(3));
				c.setTelephone(result.getLong(4));
				c.setEmail(result.getString(5));
				c.setAddress(result.getString(6));
				c.setPassword(result.getString(7));
				arrCli.add(c);
			}

		}catch (SQLException sqle){sqle.printStackTrace();}

		return arrCli;
	}
	public void Actualizar(int id){
		
		
		
		String name = null; // Nombre del Cliente
		String surname = null; // Apellidos del Cliente
		String email = null; // Email del Cliente
		String address = null; // Direccion del Cliente
		String password = null; // Password del Cliente
		long telephone = 0; // Telefono del Cliente

int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos actuales?");

if(confirmar == JOptionPane.YES_OPTION){



try {


getSingleClient(id);
String Ssql = "UPDATE contacto SET name=?, surname=?, email=?, address=?, password=?, telephone=? "
          + "WHERE id_contacto=?";

PreparedStatement prest = con.prepareStatement(Ssql);

prest.setString(1, name);
prest.setString(2, surname);
prest.setString(3, email);
prest.setString(4, address);
prest.setString(5, password);
prest.setLong(6, telephone);


if(prest.executeUpdate() > 0){

  JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa", 
                                JOptionPane.INFORMATION_MESSAGE);
  
}else{

  JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                + "Inténtelo nuevamente.", "Error en la operación", 
                                JOptionPane.ERROR_MESSAGE);

}

} catch (SQLException e) {

JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                + "Inténtelo nuevamente.\n"
                                + "Error: "+e, "Error en la operación", 
                                JOptionPane.ERROR_MESSAGE);

}
}
 
}






	
}
