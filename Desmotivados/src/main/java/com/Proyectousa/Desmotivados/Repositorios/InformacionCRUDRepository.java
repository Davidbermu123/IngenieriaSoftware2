package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.Proyectousa.Desmotivados.Entidades.Informacion;


public interface InformacionCRUDRepository extends CrudRepository<Informacion, Long>{
    List<Informacion> findAll();
    Informacion findByTitulo(String titulo);
}