package com.cebem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TimeZone;

import com.cebem.controller.DBManagement;
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

	public void getSingleProduct(int id) {

		ArrayList<Product> arrayProducts = new ArrayList<Product>();

		for (Product p : arrayProducts) {

			if (p.equals(id)) {

			while (rs.next()) {
				/*
				 * Retrieve one client details and store it in client object
				 */

				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setRef(rs.getInt(3));
				p.setPrice(rs.getDouble(4));
				p.setIdprovider(rs.getInt(5));
				Product.add(p);
				System.out.println(p); // Esto deberia ir en la interfaz
				// guiProduct

			}
		}
		return p;
	}

	public static ArrayList<Product> getProducts() {
		ArrayList<Product> products = new ArrayList<Product>();

		String query = "SELECT * FROM Product";
		ResultSet rs = null;
		try {

			Statement statement = con.createStatement();
			rs = statement.executeQuery(query);

			while (rs.next()) {
				Product p = new Product();
				/*
				 * Retrieve one client details and store it in client object
				 */
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setRef(rs.getInt(3));
				p.setPrice(rs.getDouble(4));
				p.setIdprovider(rs.getInt(5));
				Product.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return products;
	}
	public void UpdateProductoDB(int id){

		
		String name;
		int ref;
		double price;
		int idProvider;
	 id_actualizar=getSingleProduct(id);
	String sSQL = "UPDATE producto " +
            "SET name = ?," +
            "ref = ?," +
            "price= ?," +
           "idProvider = ?" +
            "WHERE id = "+id;
String  mensaje = "Los datos se han Modoficado de Manera Satisfactoria...";

try
{
    PreparedStatement pst = con.prepareStatement(sSQL);// con esta sentencia se insertan los datos en la base de datos
//    pst.setString(1, Id);
    pst.setString(1, name);
    pst.setInt(2,ref);
    pst.setDouble(3, price);
    pst.setInt(4, idProvider);
    int n = pst.executeUpdate();//valida si se guardaron los datos; si pst>0 entonces se guardaron
    
}



if(n > 0)
{
JOptionPane.showMessageDialog(null, mensaje);
CargarTabla("");//l momento de agregar un nuevo registro, actualiza la tabla
}
}
catch (SQLException ex)
{
JOptionPane.showMessageDialog(null, ex);
}

}
}
