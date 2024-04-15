package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyectousa.Desmotivados.Entidades.Contenido;
import com.Proyectousa.Desmotivados.Repositorios.Contenidorepository;

@Service
public class ContenidoService {

    @Autowired
    private Contenidorepository contenidorepository;

    public List<Contenido> findByAreaEstudioAndInteres(String area_estudio, String interes){
        return contenidorepository.findByAreaEstudioAndInteres(area_estudio, interes);
    }
    
    public List<Contenido> findByCategoriaAndInteresIn(String categoria, List<String> interes){
        return contenidorepository.findByCategoriaAndInteresIn(categoria, interes);
    }
}
