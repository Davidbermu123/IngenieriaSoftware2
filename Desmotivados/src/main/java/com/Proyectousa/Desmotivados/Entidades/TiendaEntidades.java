package com.Proyectousa.Desmotivados.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TiendaEntidades {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)    
    private Long idItemTienda;
    
    String imagenTiendaItem;
    String descripcionTiendaItem;
    String tipoTiendaItem;
    Integer precio;
    
    public Integer getPrecio() {
        return precio;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    public Long getIdItemTienda() {
        return idItemTienda;
    }
    public void setIdItemTienda(Long idItemTienda) {
        this.idItemTienda = idItemTienda;
    }
    public String getImagenTiendaItem() {
        return imagenTiendaItem;
    }
    public void setImagenTiendaItem(String imagenTiendaItem) {
        this.imagenTiendaItem = imagenTiendaItem;
    }
    public String getDescripcionTiendaItem() {
        return descripcionTiendaItem;
    }
    public void setDescripcionTiendaItem(String descripcionTiendaItem) {
        this.descripcionTiendaItem = descripcionTiendaItem;
    }
    public String getTipoTiendaItem() {
        return tipoTiendaItem;
    }
    public void setTipoTiendaItem(String tipoTiendaItem) {
        this.tipoTiendaItem = tipoTiendaItem;
    }
}
