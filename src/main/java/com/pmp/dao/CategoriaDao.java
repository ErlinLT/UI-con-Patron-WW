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
 * @author obetancourth
 */
public class CategoriaDao {
    public static void setup() {
        String sqlCrearTabla = "CREATE TABLE CATEGORIASZZ"
                + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " NOMBRE TEXT,"
                + " ESTADO TEXT);"
                + " LIDERCORREO TEXT);"
                + " DURACIONMESES TEXT);"
                + " AREA TEXT);"
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
                Categoria categoria = new Categoria();
                categoria.setId(categoriasRows.getInt("ID"));
                categoria.setNombre(categoriasRows.getString("NOMBRE"));
                categoria.setEstado(categoriasRows.getString("ESTADO"));
                categoria.setLiderCorreo(categoriasRows.getString("LIDERCORREO"));
                categoria.setDuracionMeses(categoriasRows.getString("DURACIONMESES"));
                categoria.setArea(categoriasRows.getString("AREA"));
                categoria.setPais(categoriasRows.getString("PAIS"));
                categorias.add(categoria);
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
        String sqlInsertCategoria = "INSERT INTO CATEGORIAS (NOMBRE, ESTADO, LIDERCORREO, DURACIONMESES, AREA, PAIS) VALUES (?, ?, ?, ?, ?, ?); ";
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
