package com.cebem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cebem.model.Client;

public class ClientManagement {

	
	
	public int addDB(Client c){
		// Setting parameters for the connection
        Connection connection = null;
        String user = "";
        String password = ""; 
        String url = "jdbc:mysql://localhost:3306/";

		try{
            // Code for loading the Driver from Mysql
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Setting the connection
            connection = DriverManager.getConnection(url, user, password);
            System.err.println("Connection established");
                            
           //We create the sentence
           String sql = "INSERT INTO Client VALUES (?, ?, ?, ?, ?, ?, ?)";
                                                    
           //We create the PreparedStatement
           PreparedStatement pstm = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS); //Para devolver la ID
                
           //We insert the data recieved from the Client into the prepared statement
           pstm.setInt(1, c.getId());
           
           pstm.setString(2, c.getName());
            
           pstm.setString(3, c.getSurname());
            
           pstm.setLong(4, c.getTelephone());

           pstm.setString(5, c.getEmail());
     
           pstm.setString(6, c.getAddress());
  
           pstm.setString(7, c.getPassword());
            
      
            
           //We execute the sentence
           int filas = pstm.executeUpdate();
           System.out.println("Filas afectadas: " +filas);
           
           ResultSet rs = pstm.getGeneratedKeys();
           if (rs != null && rs.next()) {
           long llave = rs.getLong(1);
           return (int)llave;
           }
           
           
            connection.close();
        }catch(ClassNotFoundException cnf){
            cnf.printStackTrace();
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
		
		return 0;
	}
	
}
