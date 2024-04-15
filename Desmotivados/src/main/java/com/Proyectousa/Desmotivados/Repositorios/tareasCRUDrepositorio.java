package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Proyectousa.Desmotivados.Entidades.TareasEntidades;

public interface tareasCRUDrepositorio extends CrudRepository<TareasEntidades,Long>{
    List<TareasEntidades> findByUsername_Username(String username);

}
