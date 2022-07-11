/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

/**
 *
 * @author ERLIN
 */
public class Categoria {
    
    public Categoria(){
        
    }
    
    public Categoria(int id, String nombre, String estado,String lidercorreo,String duracionmeses,String area,String pais){
        this.id = id;
        this.nombre = nombre;
        this.estado= estado;
        this.lidercorreo = lidercorreo;
        this.duracionmeses = duracionmeses;
        this.area = area;
        this.pais  = pais;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getLiderCorreo() {
        return lidercorreo;
    }

    public void setLiderCorreo(String lidercorreo) {
        this.lidercorreo = lidercorreo;
    }
    
    public String getDuracionMeses() {
        return duracionmeses;
    }

    public void setDuracionMeses(String duracionmeses) {
        this.duracionmeses = duracionmeses;
    }
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }    
    
    public String printString(){
        return String.valueOf(id) + '\t' + nombre + '\t' + estado + '\t' + lidercorreo + '\t' + duracionmeses + '\t' + area + '\t' + pais ;
    }
    
    private int id;
    private String nombre;
    private String estado;
    private String lidercorreo;
    private String duracionmeses;
    private String area;
    private String pais;
    
}
