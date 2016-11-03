package com.cebem.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cebem.model.Product;
import com.cebem.model.Provider;

public class ProviderManagement extends DBManagement {

	public void getSingleProvider(int id) {

		ArrayList<Provider> arrayProviders = new ArrayList<Provider>();

		for (Provider pv : arrayProviders) {

			if (pv.equals(id)) {

				System.out.println(pv); // Esto deberia ir en la interfaz
				// guiProvider

				pv.setId(rs.getInt(1));
				pv.setName(rs.getString(2));
				pv.setAddress(rs.getString(3));
				pv.setEmail(rs.getString(4));

			}
		}
		return pv;
	}

	public static ArrayList<Provider> getProviders() {
		ArrayList<Product> providers = new ArrayList<Product>();

		String query = "SELECT * FROM Provider";
		ResultSet rs = null;
		try {

			Statement statement = con.createStatement();
			rs = statement.executeQuery(query);

			while (rs.next()) {
				Provider pv = new Provider();
				/*
				 * Retrieve one client details and store it in client object
				 */

				pv.setId(rs.getInt(1));
				pv.setName(rs.getString(2));
				pv.setAddress(rs.getString(3));
				pv.setEmail(rs.getString(4));
				Provider.add(pv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return providers;
	}
}
