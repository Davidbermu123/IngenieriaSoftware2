package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.AprenderEntidades;
import com.Proyectousa.Desmotivados.Modelos.AprenderModelos;

@RestController
@RequestMapping("/aprender") 
public class AprenderControlador {
    @Autowired
    private AprenderModelos servicio;


    @GetMapping("/retornar")
    public List<AprenderEntidades> getAllAprender_entidad(){
        return servicio.listarTodas();
    }
}