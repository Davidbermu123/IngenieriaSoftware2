package com.Proyectousa.Desmotivados.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aprender_entidades {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    
    private String nombre;
    private String descripcion;
    private String urlaprender;
    private String urljuego;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getUrlaprender() {
        return urlaprender;
    }
    public void setUrlaprender(String urlaprender) {
        this.urlaprender = urlaprender;
    }
    public String getUrljuego() {
        return urljuego;
    }
    public void setUrljuego(String urljuego) {
        this.urljuego = urljuego;
    }
    
}
