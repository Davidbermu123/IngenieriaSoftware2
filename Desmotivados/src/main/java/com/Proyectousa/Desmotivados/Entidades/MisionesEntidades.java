package com.Proyectousa.Desmotivados.Entidades;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MisionesEntidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMision;

    @ManyToOne
    @JoinColumn(name = "idContenido")
    private Contenido contenido; 

    private Integer puntaje;
    private Date fechaFin; 
    private boolean estado;
    
    @ManyToOne
    @JoinColumn(name = "username")
    private User username;

    
    public User getUsername() {
        return username;
    }
    public void setUsername(User username) {
        this.username = username;
    }
    
    public Long getIdMision() {
        return idMision;
    }
    public void setIdMision(Long idMision) {
        this.idMision = idMision;
    }
    public Contenido getContenido() {
        return contenido;
    }
    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
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
