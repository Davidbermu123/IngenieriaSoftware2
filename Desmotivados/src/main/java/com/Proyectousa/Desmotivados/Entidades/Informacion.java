package com.Proyectousa.Desmotivados.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Informacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductLo; 
    private String titulo;
    private int precio;
    private String descripcion;
    
    public Long getIdProductLo() {
        return idProductLo;
    }
    public void setIdProductLo(Long idProductLo) {
        this.idProductLo = idProductLo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
