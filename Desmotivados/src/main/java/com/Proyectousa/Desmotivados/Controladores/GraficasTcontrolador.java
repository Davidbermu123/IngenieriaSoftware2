package com.Proyectousa.Desmotivados.Controladores;

import com.Proyectousa.Desmotivados.Entidades.User;
import com.Proyectousa.Desmotivados.Modelos.Usuario_modelos;
import com.Proyectousa.Desmotivados.Modelos.MisionesModelos;
import com.Proyectousa.Desmotivados.Entidades.MisionesEntidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private Usuario_modelos usuariomodelos;

    @Autowired
    private MisionesModelos misionesService;


    @GetMapping("/misiones-completadas-semanal")
    public Map<Date, Integer> obtenerMisionesCompletadasSemanal(@RequestParam("username") String username) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.isAuthenticated()) {
        User usuario = usuariomodelos.findByUsername(username);
        if (usuario != null) {
            LocalDate fechaActual = LocalDate.now();
            LocalDate inicioSemanaActual = fechaActual.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            LocalDate finSemanaActual = fechaActual.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

            Instant inicioSemanaInstant = inicioSemanaActual.atStartOfDay(ZoneId.systemDefault()).toInstant();
            Instant finSemanaInstant = finSemanaActual.atStartOfDay(ZoneId.systemDefault()).toInstant();

            List<MisionesEntidades> misionesCompletadas = misionesService.obtenerMisionesPorUsuarioYEstado(usuario, true); // Obtener las misiones completadas por el usuario
            Map<Date, Integer> misionesPorFecha = new HashMap<>();
            for (MisionesEntidades misiones : misionesCompletadas) {
                Date fechaFin = misiones.getFechaFin();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fechaFin);
                int hora = calendar.get(Calendar.HOUR_OF_DAY);
                misionesPorFecha.put(fechaFin, hora);
            }
            return misionesPorFecha;
        } else {
            return Collections.emptyMap(); // Usuario no encontrado
        }
    } else {
        return Collections.emptyMap(); // Usuario no autenticado
    }
}
}