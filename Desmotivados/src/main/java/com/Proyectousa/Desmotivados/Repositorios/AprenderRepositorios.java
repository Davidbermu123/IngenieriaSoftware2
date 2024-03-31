package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Proyectousa.Desmotivados.Entidades.AprenderEntidades;

@Repository
public class AprenderRepositorios {

    @Autowired
    private AprenderCRUDRepositorios crud;

    public List<AprenderEntidades> getAllAprender_entidad(){
        return ((List<AprenderEntidades>) crud.findAll());
    }

}
