package com.Proyectousa.Desmotivados.Entidades;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PouEntidad {
  
    /* 
    @OneToOne
    @JoinColumn(name = "usuario")
    private long username;
    private String nombreMascota;
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;

    private Boolean equipadoItem;
    private String imagenItem;
    private String descripcionItem;
    private String tipoItem;

    /* 
    public long getUsername() {
        return username;
    }
    public void setUsername(long username) {
        this.username = username;
    }
    public String getNombreMascota() {
        return nombreMascota;
    }
    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }
    */

    public Long getIdItem() {
        return idItem;
    }
    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }
    public Boolean getEquipadoItem() {
        return equipadoItem;
    }
    public void setEquipadoItem(Boolean equipadoItem) {
        this.equipadoItem = equipadoItem;
    }
    public String getImagenItem() {
        return imagenItem;
    }
    public void setImagenItem(String imagenItem) {
        this.imagenItem = imagenItem;
    }
    public String getDescripcionItem() {
        return descripcionItem;
    }
    public void setDescripcionItem(String descripcionItem) {
        this.descripcionItem = descripcionItem;
    }
    public String getTipoItem() {
        return tipoItem;
    }
    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }
}
