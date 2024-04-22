package com.Proyectousa.Desmotivados.Modelos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Proyectousa.Desmotivados.Entidades.Tareas;
import com.Proyectousa.Desmotivados.Repositorios.GraficasCRUDRepositorio;

@Service
public class GraficasModelo {

    @Autowired
    private GraficasCRUDRepositorio graficasCRUDRepository;

    public Map<String, Long> obtenerCantidadTareasPorPrioridad() {
        List<Tareas> tareas = (List<Tareas>) graficasCRUDRepository.findAll();
        Map<String, Long> cantidadPorPrioridad = new HashMap<>();

        // Contar tareas por prioridad
        for (Tareas tarea : tareas) {
            String prioridad = tarea.getPrioridad();
            if (prioridad != null) {
                // Filtrar por prioridad y contar
                switch (prioridad.toLowerCase()) {
                    case "alta":
                    case "altaa": // Por si hay un typo
                        cantidadPorPrioridad.put("alta", cantidadPorPrioridad.getOrDefault("alta", 0L) + 1);
                        break;
                    case "media":
                        cantidadPorPrioridad.put("media", cantidadPorPrioridad.getOrDefault("media", 0L) + 1);
                        break;
                    case "baja":
                        cantidadPorPrioridad.put("baja", cantidadPorPrioridad.getOrDefault("baja", 0L) + 1);
                        break;
                    default:
                        // Si hay una prioridad diferente, ignorarla
                        break;
                }
            }
        }

        return cantidadPorPrioridad;
    }
}
