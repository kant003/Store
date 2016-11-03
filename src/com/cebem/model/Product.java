package com.cebem.model;

public class Product {

	int id;
	String name;
	int ref;
	double price;
	int idProvider;
	int stock;

	public Product(int id, String name, int ref, double price, int idProvider, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.ref = ref;
		this.price = price;
		this.idProvider = idProvider;
		this.stock = stock;
	}

	public Product() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(int idProvider) {
		this.idProvider = idProvider;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
