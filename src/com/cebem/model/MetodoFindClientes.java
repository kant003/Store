package com.cebem.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MetodoFindClientes {
	public ArrayList<MetodoFindClientes> findClientsDB(String param){
		ArrayList<MetodoFindClientes> arrCli=null;
		 	PreparedStatement pstm=null;
		 		ResultSet result=null;
		
		// Configurar parametros de conexion
		// Connection crea una conexion con una base de datos
		Connection conexion = null;
		String user = "Store";
		String password = "Ad123"; // la contraseña para ejecutar MySQL
		String url = "jdbc.mysql://10.100.13.110/store_development?useSSL=false&serverTimezone=Europe/Madridstore_developement";
		String sDriver = "com.mysql.cj.jdbc.Driver";// mysql-connector-java-6.0.4
		try {
			// Codigo para cargar el Driver de la Base de Datos
		
			// Establecemos la conexión
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexion establecida");

			// Preparamos la consulta
			Statement instruccionSQL = conexion.createStatement();
		
			String query  =("SELECT Client.id,name,surname,telephone,email,address,password"
                   + " FROM Client WHERE Client.name like '%"+param+"%' Or Client.surname like '%"+param
                  + "%' Or Client.telephone like '%"+param+"%' Or Client.email like '%"+param
                 + "%' Or Client.address like '%"+param+"%';");

			pstm = conexion.prepareStatement(query);
			           result = pstm.executeQuery();
			            
			            //Recorremos el resultado, guardadno los resultados en el arrCli
			           while(result.next()){
			               System.out.println(result.getString("Nombre") +"\t"+
			               result.getDate("fechaAlta") +"\t" +result.getDouble("Salario") +"\t"+
			               result.getDouble("Comision") +"\t" +result.getString("DepNombre") +"\t"+
			               result.getString("Localidad"));   
			           }               
		} 
			           catch(SQLException sqle){sqle.printStackTrace();}
		 
		 		return arrCli;
	}
	}

// fin clase