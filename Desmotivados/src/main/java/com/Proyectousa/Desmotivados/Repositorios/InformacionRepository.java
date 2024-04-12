package com.Proyectousa.Desmotivados.Repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.Informacion;

@Repository
public class InformacionRepository {

    @Autowired
    private InformacionCRUDRepository informacionCRUDRepository;

    public Informacion findByTitulo(String titulo) {
        return informacionCRUDRepository.findByTitulo(titulo);
    }

}