package com.cebem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TimeZone;

import com.cebem.model.Product;

public class ProductManagement extends DBManagement {

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
