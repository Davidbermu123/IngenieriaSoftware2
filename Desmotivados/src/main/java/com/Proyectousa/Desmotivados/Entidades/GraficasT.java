package com.Proyectousa.Desmotivados.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GraficasT {
    private Long GraficasT;
    private int prioridadBaja;
    private int prioridadMedia;
    private int prioridadAlta;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getGraficasT() {
        return GraficasT;
    }
    public void setGraficasT(Long graficasT) {
        GraficasT = graficasT;
    }
     
    public int getPrioridadBaja() {
        return prioridadBaja;
    }
    public void setPrioridadBaja(int prioridadBaja) {
        this.prioridadBaja = prioridadBaja;
    }
    public int getPrioridadMedia() {
        return prioridadMedia;
    }
    public void setPrioridadMedia(int prioridadMedia) {
        this.prioridadMedia = prioridadMedia;
    }
    public int getPrioridadAlta() {
        return prioridadAlta;
    }
    public void setPrioridadAlta(int prioridadAlta) {
        this.prioridadAlta = prioridadAlta;
    }
    
}