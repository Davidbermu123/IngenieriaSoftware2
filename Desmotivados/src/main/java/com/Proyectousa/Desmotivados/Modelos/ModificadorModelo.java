package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Proyectousa.Desmotivados.Entidades.Tareas;
import com.Proyectousa.Desmotivados.Repositorios.TareasRepository;

@Service
public class ModificadorModelo {

    @Autowired
    private TareasRepository tareasRepository;

    public List<Tareas> findTodo(){
        return tareasRepository.findTareas();        
    }


   /* public Tareas obtenerTareaPorId(Long id) {
        Optional<Tareas> tareaOptional = tareasRepository.findById(id);
        return tareaOptional.orElse(null);
    }

    public Tareas actualizarTarea(Tareas tarea) {
        return tareasRepository.save(tarea);
    }
    */
}