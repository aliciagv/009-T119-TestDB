/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cice.test;

import com.cice.dbmanager.Manager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cice
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        String insert=" INSERT INTO test(nombre,apellido) values ('Alicia','Gutiérrez')";
        Manager manager= new Manager();
        manager.setPort("3306");
        manager.setPass("rali");
        manager.setUrl("jdbc:mysql://"+manager.getHost()+":"+manager.getPort()+ "/"+manager.getDatabase()+"?useSSL=false");
        
        manager.executeUpdate(insert);
        
        String  select ="Select * from test";
        ResultSet busqueda=manager.executeSelect(select);
        try {
            while (busqueda.next()){
                System.out.println(busqueda.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
