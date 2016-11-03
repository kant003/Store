package com.cebem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TimeZone;

import com.cebem.model.Product;
import com.cebem.model.Provider;

public class ProviderManagement extends DBManagement {

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

		ArrayList<Provider> arrayProviders = new ArrayList<Provider>();

		for (Provider pv : arrayProviders) {

			if (pv.equals(id)) {

				System.out.println(pv); // Esto deberia ir en la interfaz
				// guiProvider

			}
		}

	}
}
