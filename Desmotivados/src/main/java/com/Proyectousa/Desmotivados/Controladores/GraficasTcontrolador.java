package com.Proyectousa.Desmotivados.Controladores;

import com.Proyectousa.Desmotivados.Entidades.TareasEntidades;
import com.Proyectousa.Desmotivados.Modelos.GraficasTModelo;
import com.Proyectousa.Desmotivados.Modelos.tareasModelos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@RestController
@RequestMapping("/graficos")
public class GraficasTcontrolador {


    @Autowired
    private GraficasTModelo graficasTModelo;

    @Autowired
    private tareasModelos tareasRepository;

    @GetMapping("/tareas")
    public List<TareasEntidades> obtenerTodasLasTareas() {
        return tareasRepository.getAllTareas();
    }

    @GetMapping("/tareas-completadas-semanal")
public Map<Date, Integer> obtenerTareasCompletadasSemanal() {
    LocalDate fechaActual = LocalDate.now();
    LocalDate inicioSemanaActual = fechaActual.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    LocalDate finSemanaActual = fechaActual.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

    Instant inicioSemanaInstant = inicioSemanaActual.atStartOfDay(ZoneId.systemDefault()).toInstant();
    Instant finSemanaInstant = finSemanaActual.atStartOfDay(ZoneId.systemDefault()).toInstant();

    List<TareasEntidades> tareasCompletadas = tareasRepository.getAllTareas(); // Obtener todas las tareas
    Map<Date, Integer> tareasPorFecha = new HashMap<>();
    for (TareasEntidades tarea : tareasCompletadas) {
        if (tarea.isCompletado()) { // Verificar si la tarea está completada
            Date fechaFin = tarea.getFechaFinal();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaFin);
            int hora = calendar.get(Calendar.HOUR_OF_DAY);
            tareasPorFecha.put(fechaFin, hora);
        }
    }
    return tareasPorFecha;
}

}
