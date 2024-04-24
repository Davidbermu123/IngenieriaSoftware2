package com.Proyectousa.Desmotivados.Repositorios;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.Tareas;


@Repository
public class TareasRepository {

    @Autowired
    private TareasCRUDRepository tareasCRUDRepository;

    public List<Tareas> findTareas() {
        return (List<Tareas>) tareasCRUDRepository.findAll();
    }
    
    public Tareas encontrarTareaPorId(Long id) {
        Optional<Tareas> optionalTarea = tareasCRUDRepository.findById(id);
        return optionalTarea.orElse(null); // Devuelve la tarea si está presente, de lo contrario, devuelve null
    }

    public Tareas guardarTarea(Tareas tarea) {
        return tareasCRUDRepository.save(tarea);
    }
}