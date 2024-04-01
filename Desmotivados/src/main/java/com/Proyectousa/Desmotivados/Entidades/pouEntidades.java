package com.Proyectousa.Desmotivados.Entidades;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class pouEntidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_item;
    private String tipo;
    private String nombre;
    private String imagen;
    private Boolean comprado;
    private Boolean equipado;

    public Boolean getComprado() {
        return comprado;
    }

    public void setComprado(Boolean comprado) {
        this.comprado = comprado;
    }

    public Boolean getEquipado() {
        return equipado;
    }

    public void setEquipado(Boolean equipado) {
        this.equipado = equipado;
    }

    public Long getid_item() {
        return id_item;
    }

    public void setid_item(Long id_item) {
        this.id_item = id_item;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
