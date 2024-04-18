package com.Proyectousa.Desmotivados.Repositorios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.PouEntidad;
import com.Proyectousa.Desmotivados.Entidades.User;

import java.util.List;

@Repository
public class PouRepositorio {
    @Autowired
    private PouCrudRepositorio PouCrudRepositorio;
    public List<PouEntidad> getAllPouEntidad(){
        return ((List<PouEntidad>)PouCrudRepositorio.findAll());
    }

    public PouEntidad guardarElementoPou (PouEntidad e){
        return PouCrudRepositorio.save(e);
    }

    public boolean existeIdPou(Long id) {
        return PouCrudRepositorio.existsById(id);
    }

    public List<PouEntidad> findByUsername(User usuario){
        return PouCrudRepositorio.findByUsername(usuario);
    }

    public PouEntidad findById(Long id){
        return PouCrudRepositorio.findByIdItem(id);
    }

    public List<PouEntidad> findByUsernameAndEntidad(User username, boolean equipadoItem){
        return PouCrudRepositorio.findByUsernameAndEquipadoItem(username, equipadoItem);
    }
}

