package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Proyectousa.Desmotivados.Entidades.GraficasM;
import com.Proyectousa.Desmotivados.Entidades.GraficasT;
import com.Proyectousa.Desmotivados.Modelos.GraficasModelos;

@RestController
@RequestMapping("/tareas")
public class GraficasController {

    @Autowired
    private GraficasModelos graficasModelos;

    @GetMapping("/grafica/{titulo}")
    public List<GraficasM> obtenerDatosParaGraficaPorTitulo(@PathVariable String titulo) {
        return graficasModelos.findByTitulo(titulo);
    }

    @GetMapping("/grafica-tareas")
    public List<GraficasT> obtenerDatosTareas() {
        return graficasModelos.findAllTareas();
    }

    @GetMapping("/grafica-tareas-ids")
    public List<GraficasT> obtenerIDsDeTareas() {
        return graficasModelos.findAllTareasIDs();
    }
}