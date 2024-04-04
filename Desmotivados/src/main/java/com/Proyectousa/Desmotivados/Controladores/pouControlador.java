package com.Proyectousa.Desmotivados.Controladores;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.PouEntidad;
import com.Proyectousa.Desmotivados.Modelos.PouModelo;

@RestController
@RequestMapping("/requestPou")

public class PouControlador {
    @Autowired
    private PouModelo PouModelo;

    @GetMapping("/pou")
    public String mostrarPaginaEspecifica() {
        return "index.html"; // Devuelve el nombre de la vista
    }
    
    @GetMapping("/getPou")
    public List<PouEntidad> getAllPouEntidad(){
        return PouModelo.getAllPouEntidad();
    }

    @PostMapping("/guardarElementoPou")
    public PouEntidad guardarElPouEntidad(@RequestBody PouEntidad e){
        return PouModelo.save(e);
    }

    @GetMapping("/verificarExistencia/{id}")
    public ResponseEntity<Map<String, Boolean>> verificarExistencia(@PathVariable Long id) {
        boolean existe = PouModelo.existeIdPou(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("existe", existe);
        return ResponseEntity.ok(response);
    }
}
