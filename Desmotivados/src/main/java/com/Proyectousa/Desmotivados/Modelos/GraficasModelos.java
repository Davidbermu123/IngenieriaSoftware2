package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Proyectousa.Desmotivados.Entidades.Graficas;
import com.Proyectousa.Desmotivados.Repositorios.GraficasCRUDRepository;

@Service
public class GraficasModelos {

    @Autowired
    private GraficasCRUDRepository graficasCRUDRepository;

    public List<Graficas> findAll() {
        return (List<Graficas>) graficasCRUDRepository.findAll();
    }

    public List<Graficas> findByTitulo(String titulo) {
        return graficasCRUDRepository.findByTitulo(titulo);
    }
}