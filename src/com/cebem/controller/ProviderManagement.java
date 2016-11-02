package com.cebem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TimeZone;

import com.cebem.model.Product;
import com.cebem.model.Provider;

public class ProviderManagement extends DBManagement {

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
