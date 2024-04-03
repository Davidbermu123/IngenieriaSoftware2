package com.Proyectousa.Desmotivados.Controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.AprenderEntidades;
import com.Proyectousa.Desmotivados.Modelos.AprenderModelos;

@RestController
@RequestMapping("/aprender") 
public class AprenderControlador {
    @Autowired
    private AprenderModelos servicio;


    @GetMapping("/retornar")
    public List<AprenderEntidades> getAllAprender_entidad(){
        return servicio.listarTodas();
    }

    @PostMapping("/guardar")
    public AprenderEntidades guardarAprender(@RequestBody AprenderEntidades entidad){
        return servicio.save(entidad);
    }

    @DeleteMapping("/eliminaraprender/{id}")
    public ResponseEntity<String> eliminarTarea(@PathVariable Long id){
        servicio.delete(id);
        return ResponseEntity.ok("Elemento eliminado correctamente");
    }

    @GetMapping("/verificarExistencia/{id}")
    public ResponseEntity<Map<String, Boolean>> verificarExistencia(@PathVariable Long id) {
        boolean existe = servicio.existe(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("existe", existe);
        return ResponseEntity.ok(response);
    }
    
}