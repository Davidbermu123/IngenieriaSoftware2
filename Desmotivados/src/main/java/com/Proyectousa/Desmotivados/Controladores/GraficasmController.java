package com.Proyectousa.Desmotivados.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.TareasEntidades;
import com.Proyectousa.Desmotivados.Entidades.User;
import com.Proyectousa.Desmotivados.Modelos.Usuario_modelos;
import com.Proyectousa.Desmotivados.Modelos.tareasModelos;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/graficos")
public class GraficasmController {

    @Autowired
    private Usuario_modelos usuariomodelos;

    @Autowired
    private tareasModelos TareasModelos;

    @GetMapping("/tareas-completadas-semanal")
    public Map<LocalDate, Integer> obtenerTareasCompletadasSemanal(@RequestParam("username") String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            User usuario = usuariomodelos.findByUsername(username);
            if (usuario != null) {
                LocalDate fechaActual = LocalDate.now();
                LocalDate inicioSemanaActual = fechaActual.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
                LocalDate finSemanaActual = fechaActual.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

                Instant inicioSemanaInstant = inicioSemanaActual.atStartOfDay(ZoneId.systemDefault()).toInstant();
                Instant finSemanaInstant = finSemanaActual.atStartOfDay(ZoneId.systemDefault()).toInstant();

                List<TareasEntidades> tareasCompletadas = TareasModelos.obtenerTareasPorUsuarioYcompletados(usuario, true);
                Map<LocalDate, Integer> tareasPorFecha = new HashMap<>();
                for (TareasEntidades tarea : tareasCompletadas) {
                    LocalDate fechaFin = tarea.getFechaFinal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    int hora = tarea.getFechaFinal().toInstant().atZone(ZoneId.systemDefault()).toLocalTime().getHour();
                    tareasPorFecha.put(fechaFin, hora);
                }

                return tareasPorFecha;
            } else {
                return Collections.emptyMap(); // Usuario no encontrado
            }
        } else {
            return Collections.emptyMap(); // Usuario no autenticado
        }
    }
}