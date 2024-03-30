package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyectousa.Desmotivados.Entidades.Aprender_entidades;
import com.Proyectousa.Desmotivados.Repositorios.Aprender_repositorios;

@Service
public class Aprender_modelos {
    
    @Autowired
    private Aprender_repositorios repositorio;

    public List<Aprender_entidades> listarTodas() {
        return repositorio.getAllAprender_entidad();
    }
}