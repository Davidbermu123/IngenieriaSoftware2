package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Proyectousa.Desmotivados.Entidades.Graficas;
import com.Proyectousa.Desmotivados.Modelos.GraficasModelos;

@RestController
@RequestMapping("/tareas")
public class GraficasController {

    @Autowired
    private GraficasModelos graficasModelos;

    @GetMapping("/grafica/{titulo}")
    public List<Graficas> obtenerDatosParaGraficaPorTitulo(@PathVariable String titulo) {
        return graficasModelos.findByTitulo(titulo);
    }
}