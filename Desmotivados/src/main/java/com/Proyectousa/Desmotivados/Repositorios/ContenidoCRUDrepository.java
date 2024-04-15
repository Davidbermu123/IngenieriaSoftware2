package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Proyectousa.Desmotivados.Entidades.Contenido;

public interface ContenidoCRUDrepository extends CrudRepository<Contenido, Long>{

    List<Contenido> findByAreaEstudioAndInteres(String area_estudio, String interes);
    List<Contenido> findByCategoriaAndInteresIn(String categoria, List<String> interes);
}
