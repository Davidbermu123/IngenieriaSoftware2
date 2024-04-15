package com.Proyectousa.Desmotivados.Repositorios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.PouEntidad;
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

    public PouEntidad findByIdItem(Long idItem){
        return PouCrudRepositorio.findByIdItem(idItem);
    }

}

