package com.cebem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TimeZone;

import com.cebem.model.Product;

public class ProductManagement extends DBManagement {
	
	public boolean updateProduct(int id, Product product){
		String query = "UPDATE product SET name=?, ref=?, price=?, idProvider=? WHERE Id=?;";

		PreparedStatement ps;
		try {
			ps= (PreparedStatement)con.prepareStatement(query);

			ps.setString(1 , product.getName());
			ps.setInt(2, product.getRef());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4, product.getIdProvider());
			ps.setInt(5, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public void selectSingleDB(int id) {

		ArrayList<Product> arrayProducts = new ArrayList<Product>();

		for (Product p : arrayProducts) {

			if (p.equals(id)) {

				System.out.println(p); // Esto deberia ir en la interfaz
				// guiProduct

			}
		}

	}
}
