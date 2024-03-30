package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Proyectousa.Desmotivados.Entidades.Tareas;


@Repository
public class Tareas_repositorio {

    @Autowired
    private Tareas_CRUDrepositorio tareasCRUDRepository;

    public List<Tareas> getAlltareas(){
        return (List<Tareas>) tareasCRUDRepository.findAll();
    }

    public Tareas guardarTareas(Tareas g){
        return tareasCRUDRepository.save(g);
    }
}