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

    public List<Tareas> findTodo() {
        return tareasRepository.findTareas();        
    }
    
    public void modificarTarea(Tareas tarea) {
        // Aquí puedes agregar cualquier lógica de validación antes de guardar los cambios
        tareasRepository.guardarTarea(tarea);
    }
}
