package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Proyectousa.Desmotivados.Entidades.Aprender_entidades;

@Repository
public class Aprender_repositorios {

    @Autowired
    private Aprender_CRUDrepositorios crud;

    public List<Aprender_entidades> getAllAprender_entidad(){
        return ((List<Aprender_entidades>) crud.findAll());
    }

}
