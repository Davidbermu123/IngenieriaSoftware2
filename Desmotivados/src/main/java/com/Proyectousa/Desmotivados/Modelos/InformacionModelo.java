package com.Proyectousa.Desmotivados.Modelos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyectousa.Desmotivados.Entidades.Informacion;
import com.Proyectousa.Desmotivados.Repositorios.InformacionCRUDRepository;

@Service
public class InformacionModelo {

    @Autowired
    private InformacionCRUDRepository informacionCRUDRepository;

    public List<String> getAllTitulos() {
        List<Informacion> informaciones = (List<Informacion>) informacionCRUDRepository.findAll();
        List<String> titulos = new ArrayList<>();
        for (Informacion informacion : informaciones) {
            titulos.add(informacion.getTitulo());
        }
        return titulos;
    }

    public Informacion getInformacionByTitulo(String titulo) {
        return informacionCRUDRepository.findByTitulo(titulo);
    }
}
