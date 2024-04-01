package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Proyectousa.Desmotivados.Entidades.TareasEntidades;
import com.Proyectousa.Desmotivados.Repositorios.tareasRepositorio;

@Service
public class tareasModelos {
 
    @Autowired
    private tareasRepositorio tareasRepositorio ;

    public List<TareasEntidades> getAllTareas(){
        return tareasRepositorio.getAllTareas();
    }

    public TareasEntidades save(TareasEntidades g){
        return tareasRepositorio.guardarTareas(g);   
    }

    public void delete(Long id){
        tareasRepositorio.eliminarTareas(id);  
    }

}
