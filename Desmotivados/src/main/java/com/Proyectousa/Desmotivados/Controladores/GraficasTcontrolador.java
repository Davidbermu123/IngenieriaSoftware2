package com.Proyectousa.Desmotivados.Controladores;

import com.Proyectousa.Desmotivados.Entidades.Tareas;
import com.Proyectousa.Desmotivados.Modelos.GraficasTModelo;
import com.Proyectousa.Desmotivados.Repositorios.TareasRepository;

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
    private TareasRepository tareasRepository;

    @GetMapping("/tareas")
    public List<Tareas> obtenerTodasLasTareas() {
        return tareasRepository.findTareas();
    }

    @GetMapping("/tareas-completadas-semanal")
public Map<Date, Integer> obtenerTareasCompletadasSemanal() {
    LocalDate fechaActual = LocalDate.now();
    LocalDate inicioSemanaActual = fechaActual.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    LocalDate finSemanaActual = fechaActual.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

    Instant inicioSemanaInstant = inicioSemanaActual.atStartOfDay(ZoneId.systemDefault()).toInstant();
    Instant finSemanaInstant = finSemanaActual.atStartOfDay(ZoneId.systemDefault()).toInstant();

    List<Tareas> tareasCompletadas = tareasRepository.findTareas(); // Obtener todas las tareas
    Map<Date, Integer> tareasPorFecha = new HashMap<>();
    for (Tareas tarea : tareasCompletadas) {
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
