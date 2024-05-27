package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Proyectousa.Desmotivados.Entidades.TareasEntidades;
import com.Proyectousa.Desmotivados.Entidades.User;


public interface tareasCRUDrepositorio extends CrudRepository<TareasEntidades,Long>{
    List<TareasEntidades> findByUsername_Username(String username);
    List<TareasEntidades> findByUsernameAndCompletado(User usuario, boolean completado);
}