/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author ERLIN
 */
public class CategoriaDao {
    public static void setup() {
        String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS CATEGORIAS"
                + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " NOMBRE TEXT,"
                + " ESTADO TEXT,"
                + " LIDERCORREO TEXT,"
                + " DURACIONMESES TEXT,"
                + " AREA TEXT,"
                + " PAIS TEXT);";
        try {
            Statement comando = Conexion.getConexion().createStatement();
            int resultado = comando.executeUpdate(sqlCrearTabla);
            comando.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }
    public static ArrayList<Categoria> obtenerTodos(){
        String sqlObtenerTodo = "SELECT * FROM CATEGORIAS;";
        ArrayList<Categoria> categorias = new ArrayList<>();
        try{
            Statement comando = Conexion.getConexion().createStatement();
            ResultSet categoriasRows = comando.executeQuery(sqlObtenerTodo);
            while (categoriasRows.next()){
                Categoria newcategoria_create = new Categoria();
                newcategoria_create.setId(categoriasRows.getInt("ID"));
                newcategoria_create.setNombre(categoriasRows.getString("NOMBRE"));
                newcategoria_create.setEstado(categoriasRows.getString("ESTADO"));
                newcategoria_create.setLiderCorreo(categoriasRows.getString("LIDERCORREO"));
                newcategoria_create.setDuracionMeses(categoriasRows.getString("DURACIONMESES"));
                newcategoria_create.setArea(categoriasRows.getString("AREA"));
                newcategoria_create.setPais(categoriasRows.getString("PAIS"));
                categorias.add(newcategoria_create);
            }
            comando.close();
            return categorias;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return null;
        }
    }
    public static Categoria agregarNuevo (Categoria newCategoria) {
        String sqlInsertCategoria = "INSERT INTO CATEGORIAS (NOMBRE, ESTADO, LIDERCORREO, DURACIONMESES, AREA, PAIS) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement comando = Conexion.getConexion().prepareStatement(sqlInsertCategoria);
            comando.setString(1, newCategoria.getNombre());
            comando.setString(2, newCategoria.getEstado());
            comando.setString(3, newCategoria.getLiderCorreo());
            comando.setString(4, newCategoria.getDuracionMeses());
            comando.setString(5, newCategoria.getArea());
            comando.setString(6, newCategoria.getPais());
            int registroAgregado = comando.executeUpdate();
            comando.close();
            return newCategoria;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return null;
        }
    }
    
    public static Categoria actualizar(Categoria updCategoria) {
        String sqlUpdateCategoria = "UPDATE CATEGORIAS set NOMBRE=? , ESTADO=? , LIDERCORREO=? , DURACIONMESES=? , AREA=? , PAIS=? where ID=?;";
        try {
            PreparedStatement comando = Conexion.getConexion().prepareStatement(sqlUpdateCategoria);
            comando.setString(1, updCategoria.getNombre());
            comando.setString(2, updCategoria.getEstado());
            comando.setString(3, updCategoria.getLiderCorreo());
            comando.setString(4, updCategoria.getDuracionMeses());
            comando.setString(5, updCategoria.getArea());
            comando.setString(6, updCategoria.getPais());
            comando.setInt(7, updCategoria.getId());
            int registroActualizado = comando.executeUpdate();
            comando.close();
            return updCategoria;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return null;
        }
        
    }
    
    public static int eliminarCategoria (int codEliminar) {
        String sqlEliminarCategoria = "DELETE FROM CATEGORIAS WHERE ID=?;";
        try {
            PreparedStatement comando = Conexion.getConexion().prepareStatement(sqlEliminarCategoria);
            comando.setInt(1, codEliminar);
            int registrosEliminados = comando.executeUpdate();
            comando.close();
            return registrosEliminados;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return 0;
        }
    
    }
    
}
