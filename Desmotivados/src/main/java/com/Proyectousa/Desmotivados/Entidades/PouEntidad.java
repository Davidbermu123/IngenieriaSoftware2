package com.Proyectousa.Desmotivados.Entidades;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PouEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;

    private Boolean equipadoItem;
    private String imagenItem;
    private String descripcionItem;
    private String tipoItem;

    @ManyToOne
    @JoinColumn(name = "username")
    private User username;
   
    public User getUsername() {
        return username;
    }
    public void setUsername(User username) {
        this.username = username;
    }
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
