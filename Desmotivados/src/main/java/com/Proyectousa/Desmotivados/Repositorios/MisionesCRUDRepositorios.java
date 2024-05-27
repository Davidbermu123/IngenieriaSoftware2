package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Proyectousa.Desmotivados.Entidades.Contenido;
import com.Proyectousa.Desmotivados.Entidades.MisionesEntidades;
import com.Proyectousa.Desmotivados.Entidades.User;

public interface MisionesCRUDRepositorios extends CrudRepository<MisionesEntidades, Long>{
    boolean existsByUsernameAndContenido(User usuario, Contenido contenido);
    List<MisionesEntidades> findByUsernameAndEstado(User usuario, boolean estado);
    MisionesEntidades findByIdMision(Long idMision);
    List<MisionesEntidades> findByUsername(User e);
}
