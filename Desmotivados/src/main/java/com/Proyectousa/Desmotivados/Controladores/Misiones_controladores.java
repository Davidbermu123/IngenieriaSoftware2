package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.MisionesEntidades;
import com.Proyectousa.Desmotivados.Modelos.MisionesModelos;

@RestController
@RequestMapping("/misiones") 
public class Misiones_controladores {
    @Autowired
    private MisionesModelos servicio;

    @GetMapping("/retornarmisiones")
    public List<MisionesEntidades> getAllAprender_entidad(){
        return servicio.listarTodas();
    }
}
