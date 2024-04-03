package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyectousa.Desmotivados.Entidades.AprenderEntidades;
import com.Proyectousa.Desmotivados.Repositorios.AprenderRepositorios;

@Service
public class AprenderModelos {
    
    @Autowired
    private AprenderRepositorios repositorio;

    public List<AprenderEntidades> listarTodas() {
        return repositorio.getAllAprender_entidad();
    }

    public AprenderEntidades save(AprenderEntidades entidad){
        return repositorio.guardarAprenderEntidades(entidad);
    }

    public void delete(Long id){
        repositorio.eliminarAprendizaje(id);
    }

    public boolean existe(Long id) {
        return repositorio.existe(id);
    }
}