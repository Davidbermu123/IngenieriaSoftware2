package com.Proyectousa.Desmotivados.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.Proyectousa.Desmotivados.Entidades.MisionesEntidades;
import com.Proyectousa.Desmotivados.Modelos.GraficasmModelo;

@RestController
@RequestMapping("/misiones")
public class GraficasmController {

    @Autowired
    private GraficasmModelo graficasmModelo;

    @GetMapping("/misiones-completadas-semanal")
public Map<Date, Integer> obtenerMisionesCompletadasSemanal() {
    LocalDate fechaActual = LocalDate.now();
    LocalDate inicioSemanaActual = fechaActual.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    LocalDate finSemanaActual = fechaActual.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

    Instant inicioSemanaInstant = inicioSemanaActual.atStartOfDay(ZoneId.systemDefault()).toInstant();
    Instant finSemanaInstant = finSemanaActual.atStartOfDay(ZoneId.systemDefault()).toInstant();

    List<MisionesEntidades> misionesCompletadas = graficasmModelo.obtenerMisionesCompletadasPorRangoDeFechas(
            Date.from(inicioSemanaInstant),
            Date.from(finSemanaInstant)
    );

    Map<Date, Integer> misionesPorFecha = new HashMap<>();
    for (MisionesEntidades mision : misionesCompletadas) {
        if (mision.isEstado()) { // Verificar si la misión tiene estado 1
            Date fechaFin = mision.getFechaFin();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaFin);
            int hora = calendar.get(Calendar.HOUR_OF_DAY);
            misionesPorFecha.put(fechaFin, hora);
        }
    }
    return misionesPorFecha;
}

}
