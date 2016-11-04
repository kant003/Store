package com.cebem.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cebem.model.Provider;

public class ProviderManagement extends DBManagement {

	// Method for adding providers to the DB
	public static int addProvider(Provider p) throws ClassNotFoundException {

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
		try {
			String query = "SELECT * FROM Provider WHERE id = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				/*
				 * Retrieve one client details and store it in provider object
				 */
				p=new Provider();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setAddress(rs.getString(3));
				p.setEmail(rs.getString(4));
				p.setPhone(rs.getLong(5));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException();
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
		ArrayList<Provider> arrPro = null;
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
}