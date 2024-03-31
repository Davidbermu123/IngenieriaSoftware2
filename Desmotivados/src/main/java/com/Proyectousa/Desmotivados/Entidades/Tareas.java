package com.Proyectousa.Desmotivados.Entidades;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tareas{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     
    
    private Long idTarea;
    private String titulo;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFinal;
    private String prioridad;

    public Long getIdTarea() {
        return idTarea;
    }
    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFinal() {
        return fechaFinal;
    }
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    public String getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }


}
