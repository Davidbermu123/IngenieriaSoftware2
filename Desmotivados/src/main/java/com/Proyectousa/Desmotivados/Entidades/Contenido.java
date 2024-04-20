package com.Proyectousa.Desmotivados.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContenido;

    private String tituloContenido;

    private String detalleContenido;

    private String areaEstudio;

    private String interes;

    private String categoria;

    private String link;

    public Long getIdContenido() {
        return idContenido;
    }

    public void setIdContenido(Long idContenido) {
        this.idContenido = idContenido;
    }

    public String getAreaEstudio() {
        return areaEstudio;
    }

    public void setAreaEstudio(String areaEstudio) {
        this.areaEstudio = areaEstudio;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTituloContenido() {
        return tituloContenido;
    }

    public void setTituloContenido(String tituloContenido) {
        this.tituloContenido = tituloContenido;
    }

    public String getDetalleContenido() {
        return detalleContenido;
    }

    public void setDetalleContenido(String detalleContenido) {
        this.detalleContenido = detalleContenido;
    }

    

}
