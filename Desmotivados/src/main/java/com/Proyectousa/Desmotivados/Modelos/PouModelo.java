package com.Proyectousa.Desmotivados.Modelos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Proyectousa.Desmotivados.Entidades.PouEntidad;
import com.Proyectousa.Desmotivados.Repositorios.PouRepositorio;

@Service

public class PouModelo {
    @Autowired
    private PouRepositorio PouRepositorio;
    
    public List<PouEntidad> getAllPouEntidad(){
        return PouRepositorio.getAllPouEntidad();
    }

    public PouEntidad save(PouEntidad e){
        return PouRepositorio.guardarElementoPou(e);
    }

    public boolean existeIdPou(Long id) {
        return PouRepositorio.existeIdPou(id);
    }
}

