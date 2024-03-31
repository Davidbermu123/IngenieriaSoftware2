package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.Tareas;
import com.Proyectousa.Desmotivados.Modelos.TareaModelos;


@RestController
@RequestMapping("/Corganizador")

public class Tareas_Controller {

    @Autowired
    private TareaModelos tareasService;

    @GetMapping("/prueba")
    public String saludo(){
        return "Holis"; 
    }

    @GetMapping("/tareas")
    public List<Tareas> getAllTr(){
        return tareasService.getAlltareas();
    }

    @PostMapping("/mistareas")
    public Tareas guardarTareas(@RequestBody Tareas g){
        return tareasService.save(g);
    }

}