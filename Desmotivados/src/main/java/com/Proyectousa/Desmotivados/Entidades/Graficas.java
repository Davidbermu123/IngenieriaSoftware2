package com.Proyectousa.Desmotivados.Entidades;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Graficas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarea;
    private String titulo;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    private int tareasDiarias;
    private float puntajeGanado;


    public Long getIdTarea() {
        return idTarea;
    }
    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }
    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }
    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
    public int getTareasDiarias() {
        return tareasDiarias;
    }
    public void setTareasDiarias(int tareasDiarias) {
        this.tareasDiarias = tareasDiarias;
    }
    public float getPuntajeGanado() {
        return puntajeGanado;
    }
    public void setPuntajeGanado(float puntajeGanado) {
        this.puntajeGanado = puntajeGanado;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}