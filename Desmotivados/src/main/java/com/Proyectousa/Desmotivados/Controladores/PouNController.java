package com.Proyectousa.Desmotivados.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.PouN;
import com.Proyectousa.Desmotivados.Repositorios.PouNCRUDRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/PouN")
public class PouNController {

    @Autowired
    private PouNCRUDRepository pouNRepository;

    @GetMapping("/nombre")
    public List<String> getNombres() {
        List<PouN> mascotas = (List<PouN>) pouNRepository.findAll();
        return mascotas.stream().map(PouN::getName).collect(Collectors.toList());
    }
}

