package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyectousa.Desmotivados.Entidades.TiendaEntidades;
import com.Proyectousa.Desmotivados.Repositorios.TiendaRepositorios;

@Service
public class TiendaModelos {

    @Autowired
    private TiendaRepositorios repositorio;

    public List<TiendaEntidades> getAllTienda(){
        return repositorio.getAllTienda();
    }

    public void delete(Long id){
        repositorio.eliminarTienda(id);
    }
}
