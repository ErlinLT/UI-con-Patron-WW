/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author ERLIN
 * 
 * 
 */
public class Conexion {
    private static Connection conexion_new = null;
    public static Connection getConexion(){
        try {
            if(conexion_new == null) {
                Class.forName("org.sqlite.JDBC");
                conexion_new = DriverManager.getConnection("jdbc:sqlite:cateogrias.db");
            }
            return conexion_new;
        } catch(Exception ex) {
            System.err.println("Error Conecction: " + ex.getMessage());
            System.exit(1);
            return null;
        }
    }  
}
