package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.MisionesEntidades;


@Repository
public class MisionesRepositorio {
    
    @Autowired
    private MisionesCRUDRepositorios crud;

    public List<MisionesEntidades> getAllMisionesEntidades(){
        return ((List<MisionesEntidades>) crud.findAll());
    }

}
