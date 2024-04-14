package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.GraficasM;

@Repository
public class GraficasRepository {

    @Autowired
    private GraficasCRUDRepository graficasCRUDRepository;

    public List<GraficasM> findAll() {
        return (List<GraficasM>) graficasCRUDRepository.findAll();
    }
    
}