package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;
import java.util.Optional;

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

    public void modificarTarea(TareasEntidades g) {
        tareasRepositorio.guardarTareas(g);
    }
    public List<TareasEntidades> getTareasByUsername(String username) {
        return tareasRepositorio.getTareasByUsername(username);
    }

    public Optional<TareasEntidades> getTareaById(Long id) {
        return tareasRepositorio.getTareaById(id);
    }

}
