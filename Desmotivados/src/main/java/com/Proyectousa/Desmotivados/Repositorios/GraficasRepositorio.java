package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.TareasEntidades;

@Repository
public class GraficasRepositorio {

    @Autowired
    private GraficasCRUDRepositorio graficasCRUDRepository;

    public List<TareasEntidades> findAll() {
        return (List<TareasEntidades>) graficasCRUDRepository.findAll();
    }
    
}