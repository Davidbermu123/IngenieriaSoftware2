package com.Proyectousa.Desmotivados.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PouN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpou;
    private String name;

    public Long getIdpou() {
        return idpou;
    }
    public void setIdpou(Long idpou) {
        this.idpou = idpou;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
