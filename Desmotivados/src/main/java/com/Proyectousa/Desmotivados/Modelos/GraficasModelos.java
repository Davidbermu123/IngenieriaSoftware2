package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Proyectousa.Desmotivados.Entidades.GraficasM;
import com.Proyectousa.Desmotivados.Entidades.GraficasT;
import com.Proyectousa.Desmotivados.Repositorios.GraficasCRUDRepository;
import com.Proyectousa.Desmotivados.Repositorios.GraficasTCRUDRepository;

@Service
public class GraficasModelos {

    @Autowired
    private GraficasCRUDRepository graficasCRUDRepository;

    @Autowired
    private GraficasTCRUDRepository graficasTCRUDRepository;

    public List<GraficasM> findByTitulo(String titulo) {
        return graficasCRUDRepository.findByTitulo(titulo);
    }

    public List<GraficasT> findAllTareas() {
        return (List<GraficasT>) graficasTCRUDRepository.findAll();
    }

    public List<GraficasT> findAllTareasIDs() {
        return graficasTCRUDRepository.findAll();
    }
}