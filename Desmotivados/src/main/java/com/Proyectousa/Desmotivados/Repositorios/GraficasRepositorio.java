package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.Tareas;

@Repository
public class GraficasRepositorio {

    @Autowired
    private GraficasCRUDRepositorio graficasCRUDRepository;

    public List<Tareas> findAll() {
        return (List<Tareas>) graficasCRUDRepository.findAll();
    }
    
}