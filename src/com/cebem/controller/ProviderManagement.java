package com.cebem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProviderManagement{
	
	public static Connection getConnectionDB() throws SQLException{
		String sURL="jdbc:mysql://10.100.13.110/store_development?useSSL=false";
		String user="Store";
		String pass="Ad123";
		String sDriver="com.mysql.jdbc.Driver";
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
