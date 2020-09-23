/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author ricardo
 */
public class Conectar {
    
    public Connection conectarDB() throws SQLException{
    // La url incluye el esquema a usar, en este caso 'mysql'
            String urlConnection = "jdbc:mysql://localhost:3306/mydb";
            String user = "root";
            String password = "kittenrv2897.";
            
            Connection conection = null;
            try{
            Class.forName("com.mysql.jdbc.Driver");
            conection =(Connection) DriverManager.getConnection(urlConnection, user, password);
            }catch(Exception e){
                System.out.println(e);
       
            }
            return conection;
    }
    
    
    }

