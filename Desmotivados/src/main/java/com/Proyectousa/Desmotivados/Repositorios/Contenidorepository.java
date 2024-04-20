package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;
import java.util.Optional;

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

    public Contenido saveContenido(Contenido contenido) {
        if (contenido == null) {
            throw new IllegalArgumentException("El contenido no puede ser nulo");
        }
        return contenidoCRUDrepository.save(contenido);
    }
    
    @SuppressWarnings("null")
    public void deleteContenido(Long id){
        contenidoCRUDrepository.deleteById(id);
    }

    @SuppressWarnings("null")
    public Optional<Contenido> findContenidoId(Long id){
        return contenidoCRUDrepository.findById(id);
    }

    public List<Contenido> findByCategoriaAndInteresIn(String categoria, List<String> interes){
        return contenidoCRUDrepository.findByCategoriaAndInteresIn(categoria, interes);
    }

}
