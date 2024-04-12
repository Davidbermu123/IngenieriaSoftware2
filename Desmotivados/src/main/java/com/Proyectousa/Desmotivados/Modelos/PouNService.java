package com.Proyectousa.Desmotivados.Modelos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyectousa.Desmotivados.Entidades.PouN;
import com.Proyectousa.Desmotivados.Repositorios.PouNCRUDRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PouNService {

    @Autowired
    private PouNCRUDRepository pouNRepository;

    public List<String> getNombres() {
        List<PouN> mascotas = (List<PouN>) pouNRepository.findAll();
        return mascotas.stream().map(PouN::getName).collect(Collectors.toList());
    }
}