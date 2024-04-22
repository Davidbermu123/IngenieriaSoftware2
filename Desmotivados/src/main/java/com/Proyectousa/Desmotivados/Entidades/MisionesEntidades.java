package com.Proyectousa.Desmotivados.Entidades;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MisionesEntidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMision;

    private Integer puntaje;
    private Date fechaFin; 
    private boolean estado;
    
    
    public Long getIdMision() {
        return idMision;
    }
    public void setIdMision(Long idMision) {
        this.idMision = idMision;
    }
    public Integer getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
}
