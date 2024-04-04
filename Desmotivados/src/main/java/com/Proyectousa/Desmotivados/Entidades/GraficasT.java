package com.Proyectousa.Desmotivados.Entidades;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GraficasT {
    private Long GraficasT;
    private Date fechaMIN;
    private Date FechaMAX;
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
     
    public Date getFechaMIN() {
        return fechaMIN;
    }
    public void setFechaMIN(Date fechaMIN) {
        this.fechaMIN = fechaMIN;
    }
    public Date getFechaMAX() {
        return FechaMAX;
    }
    public void setFechaMAX(Date fechaMAX) {
        FechaMAX = fechaMAX;
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