package com.cebem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClientManagement{
	
	public static Connection getConnectionDB() throws SQLException{
		//Creamos la conexión con la base
		String sURL="jdbc:mysql://10.100.13.110/store_development?useSSL=false";
		String user="Store";//Con el usuario
		String pass="Ad123";//Su contraseña
		String sDriver="com.mysql.jdbc.Driver";//Es necesario el conector correspondiente, en este caso el mysql-connector-java-5.1.39
		Connection con=null;
		
		try{
			Class.forName(sDriver).newInstance();
			con=DriverManager.getConnection(sURL,user,pass);
		}catch(InstantiationException | IllegalAccessException | ClassNotFoundException mte){
			mte.printStackTrace();
			throw new SQLException(mte.getMessage());
		}catch(SQLException e){e.printStackTrace();throw new SQLException(e.getMessage());}
			
		return con;
	}

}
