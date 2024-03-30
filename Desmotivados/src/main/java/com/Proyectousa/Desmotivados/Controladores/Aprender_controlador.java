package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.Aprender_entidades;
import com.Proyectousa.Desmotivados.Modelos.Aprender_modelos;

@RestController
@RequestMapping("/aprender") 
public class Aprender_controlador {
    @Autowired
    private Aprender_modelos servicio;


    @GetMapping("/retornar")
    public List<Aprender_entidades> getAllAprender_entidad(){
        return servicio.listarTodas();
    }
}