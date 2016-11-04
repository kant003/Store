package com.cebem.model;

/*
 * 
 * Clase que definel el modelo de Proveedor (Provider)
 * 
 * */

public class Provider {
	
	// ATRIBUTOS
	int id; // Id del proveedor
	String name; // Nombre del proveedor
	String address; // Dirección del proveedor
	String email; // Email del proveedor
	long phone; // Teléfono del proveedor

	// CONSTRUCTOR
	public Provider(int id, String name, String address, String email, long phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone= phone;
	}

	// GETTERS & SETTERS
	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Provider() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return super.toString();
	}
}
