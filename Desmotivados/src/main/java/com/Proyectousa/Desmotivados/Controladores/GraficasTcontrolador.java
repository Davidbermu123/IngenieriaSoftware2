package com.Proyectousa.Desmotivados.Controladores;

import com.Proyectousa.Desmotivados.Entidades.MisionesEntidades;
import com.Proyectousa.Desmotivados.Entidades.Tareas;
import com.Proyectousa.Desmotivados.Modelos.GraficasTModelo;
import com.Proyectousa.Desmotivados.Repositorios.TareasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/graficos")
public class GraficasTcontrolador {


    @Autowired
    private GraficasTModelo graficasTModelo;

    @Autowired
    private TareasRepository tareasRepository;

    @GetMapping("/tareas")
    public List<Tareas> obtenerTodasLasTareas() {
        return tareasRepository.findTareas();
    }

    @GetMapping("/misiones-completadas/{idTarea}")
public List<MisionesEntidades> obtenerMisionesCompletadasPorTarea(@PathVariable Long idTarea) {
    Optional<Tareas> tareaOptional = Optional.ofNullable(tareasRepository.encontrarTareaPorId(idTarea));
    if (tareaOptional.isPresent()) {
        Tareas tarea = tareaOptional.get();
        Date fechaInicio = tarea.getFechaInicio();
        Date fechaFin = tarea.getFechaFinal();
        return graficasTModelo.obtenerMisionesCompletadasPorRangoDeFechas(fechaInicio, fechaFin);
    } else {
        // Manejar el caso en que la tarea no exista
        return Collections.emptyList();
    }
}
}
