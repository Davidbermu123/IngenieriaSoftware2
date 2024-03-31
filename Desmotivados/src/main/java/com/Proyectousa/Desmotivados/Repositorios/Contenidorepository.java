package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Proyectousa.Desmotivados.Entidades.Contenido;

@Repository
public class Contenidorepository {

    @Autowired
    private ContenidoCRUDrepository contenidoCRUDrepository;

    public List<Contenido> findByAreaEstudioAndInteres(String area_estudio, String interes){
        return contenidoCRUDrepository.findByAreaEstudioAndInteres(area_estudio, interes);
    }

}
