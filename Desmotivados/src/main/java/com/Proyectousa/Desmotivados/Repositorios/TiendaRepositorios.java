package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Proyectousa.Desmotivados.Entidades.TiendaEntidades;

@Repository
public class TiendaRepositorios {

    @Autowired
    private TiendaCRUDRepositorios crud;

    public List<TiendaEntidades> getAllTienda(){
        return (List<TiendaEntidades>) crud.findAll();
    }

    public TiendaEntidades guardarTienda(TiendaEntidades t){
        return crud.save(t);
    }

    public void eliminarTienda(Long id){
        crud.deleteById(id);
    }
}
