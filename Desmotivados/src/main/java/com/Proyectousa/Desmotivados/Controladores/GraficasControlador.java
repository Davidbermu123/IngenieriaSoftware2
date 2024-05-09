package com.Proyectousa.Desmotivados.Controladores;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.User;
import com.Proyectousa.Desmotivados.Modelos.GraficasModelo;
import com.Proyectousa.Desmotivados.Modelos.Usuario_modelos;

@RestController
@RequestMapping("/graficos")
public class GraficasControlador {

    @Autowired
    private GraficasModelo graficasModelo;

    @Autowired
    private Usuario_modelos usuariomodelos;

    @GetMapping("/grafica-prioridades")
    public ResponseEntity<Map<String, Long>> obtenerCantidadTareasPorPrioridad(@RequestParam("username") String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            User usuario = usuariomodelos.findByUsername(username);
            if (usuario != null) {
                Map<String, Long> cantidadPorPrioridad = graficasModelo.obtenerCantidadTareasPorPrioridad(username);
                return ResponseEntity.ok(cantidadPorPrioridad);
            } else {
                return ResponseEntity.notFound().build(); // Usuario no encontrado en la base de datos
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // Usuario no autenticado
        }
    }
}