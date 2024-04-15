package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Proyectousa.Desmotivados.Entidades.Contenido;
import com.Proyectousa.Desmotivados.Entidades.MisionesEntidades;
import com.Proyectousa.Desmotivados.Entidades.User;


@Repository
public class MisionesRepositorio {
    
    @Autowired
    private MisionesCRUDRepositorios crud;

    public List<MisionesEntidades> getAllMisionesEntidades(){
        return ((List<MisionesEntidades>) crud.findAll());
    }

    public MisionesEntidades save(MisionesEntidades m){
        return crud.save(m);
    }

    public boolean existeMisionParaUsuarioYContenido(User usuario, Contenido contenido) {
        return crud.existsByUsernameAndContenido(usuario, contenido);
    }

    public List<MisionesEntidades> obtenerMisionesPorUsuarioYEstado(User usuario, boolean estado) {
        return crud.findByUsernameAndEstado(usuario, estado);
    }

    public MisionesEntidades findById(Long idMision){
        return crud.findByIdMision(idMision);
    }
}
