package com.Proyectousa.Desmotivados.Controladores;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Modelos.GraficasModelo;

@RestController
@RequestMapping("/tareas")
public class GraficasControlador {

    @Autowired
    private GraficasModelo graficasModelo; // Cambiar de GraficasModelos a GraficasModelo

    @GetMapping("/grafica-prioridades")
    public Map<String, Long> obtenerCantidadTareasPorPrioridad() {
        return graficasModelo.obtenerCantidadTareasPorPrioridad();
    }
}
