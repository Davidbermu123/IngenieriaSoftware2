package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyectousa.Desmotivados.Entidades.Tareas;
import com.Proyectousa.Desmotivados.Repositorios.Tareas_Repository;



@Service
public class TareaModelos {
 
    @Autowired
    private Tareas_Repository tareasRepository ;

    public List<Tareas> getAlltareas(){
        return tareasRepository.getAlltareas();
    }

    public Tareas save(Tareas g){
        return tareasRepository.guardarTareas(g);   
    
    }
}