package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Proyectousa.Desmotivados.Entidades.TareasEntidades;

@Repository
public class tareasRepositorio {

    @Autowired
    private tareasCRUDrepositorio tareasCRUDRepository;

    public List<TareasEntidades> getAllTareas(){
        return (List<TareasEntidades>) tareasCRUDRepository.findAll();
    }

    public TareasEntidades guardarTareas(TareasEntidades g){
        return tareasCRUDRepository.save(g);
    }

    public void eliminarTareas(Long id){
        tareasCRUDRepository.deleteById(id);
    }
    
}