

package com.cebem.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.cebem.model.Provider;

public class ProviderManagement extends DBManagement {

<<<<<<< HEAD
	public boolean updateProvider(int id, Provider provider){
		String query = "UPDATE product SET name=?, address=?, email=? WHERE Id=?;";

		PreparedStatement ps;
		try {
			ps= (PreparedStatement)con.prepareStatement(query);

			ps.setString(1 , provider.getName());
			ps.setString(2, provider.getAddress());
			ps.setString(3, provider.getEmail());
			ps.setInt(4, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void selectSingleDB(int id) {
=======
	// Method for adding providers to the DB
	public static int addProvider(Provider p) throws ClassNotFoundException {
>>>>>>> 73147bbac153d03fa67e7d40f20773971a1f4241

		try {
			// We create the sentence
			String sql = "INSERT INTO Provider VALUES (?, ?, ?, ?, ?)";

			// We create the PreparedStatement
			PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			// We insert the data received from the provider into the prepared
			// statement
			// pstm.setInt(1, c.getId()); Id is set to auto_increment in the DB
			pstm.setInt(1, p.getId());
			pstm.setString(2, p.getName());
			pstm.setString(3, p.getAddress());
			pstm.setString(4, p.getEmail());
			pstm.setLong(5, p.getPhone());

			// Execute the sentence
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

	public Provider getSingleProvider(int id) throws SQLException {
		Provider p = null;
		
			String query = "SELECT * FROM Provider WHERE id = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				p = new Provider();
				/*
				 * Retrieve one client details and store it in provider object
				 */
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setAddress(rs.getString(3));
				p.setEmail(rs.getString(4));
				p.setPhone(rs.getLong(5));

			}
		
		return p;
	}

	// Method for getting the providers from the DB
	public static ArrayList<Provider> getProvider() {
		ArrayList<Provider> providers = new ArrayList<Provider>();

		String query = "SELECT * FROM Provider";
		ResultSet rs = null;
		try {

			Statement statement = con.createStatement();
			rs = statement.executeQuery(query);

			while (rs.next()) {
				Provider p = new Provider();
				/*
				 * Retrieve one providers details and store it in provider
				 * object
				 */
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setAddress(rs.getString(3));
				p.setEmail(rs.getString(4));
				p.setPhone(rs.getLong(5));
				// add each client to the list
				providers.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return providers;
	}

	
	// Method for deleting a provider
	public static void deleteProvider(int id) {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement("DELETE FROM Provider WHERE id = ?");
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Provider> findProviderDB(String param) {
		// The array for return the providers
		ArrayList<Provider> arrPro = new ArrayList<Provider>();
		PreparedStatement pstm = null;
		ResultSet result = null;

		try {
			String query = "SELECT Provider.id,name,Address,email" + " FROM Provider WHERE Provider.name like '%"
					+ param + "%' Or Provider.email like '%" + param + "%' Or Provider.address like '%" + param + "%' Or Provider.phone like" + param+"%';";

			pstm = con.prepareStatement(query);
			result = pstm.executeQuery();

			// saving the results on arrPro
			while (result.next()) {
				Provider p = new Provider();
				p.setId(result.getInt(1));
				p.setName(result.getString(2));
				p.setAddress(result.getString(3));
				p.setEmail(result.getString(4));
				p.setPhone(result.getLong(5));

				arrPro.add(p);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return arrPro;
	}
public void Actualizar(int id){
		
		
		
	
	String name = null; // Nombre del proveedor
	String address = null; // Direccion del proveedor
	String email = null; // Email del proveedor
	long phone = 0; // Telefono del proveedor


int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos actuales?");

if(confirmar == JOptionPane.YES_OPTION){



try {


	getSingleProvider(id);
String Ssql = "UPDATE contacto SET name=?, address=?, email=?,phone=? "
          + "WHERE id_contacto=?";

PreparedStatement prest = con.prepareStatement(Ssql);

prest.setString(1, name);
prest.setString(2, address);
prest.setString(3, email);
prest.setLong(4,phone);


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