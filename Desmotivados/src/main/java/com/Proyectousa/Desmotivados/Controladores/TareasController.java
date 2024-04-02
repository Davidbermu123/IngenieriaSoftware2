package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.Tareas;
import com.Proyectousa.Desmotivados.Modelos.ModificadorModelo;

@RestController
@RequestMapping("/Modificador")
public class TareasController {

    @Autowired
    private ModificadorModelo tareasService;

    @GetMapping("/todasTareas")
    public List<Tareas> getAllTareas() {
        return tareasService.findTodo();
    }
    
    @PostMapping("/modificarTarea")
    public ResponseEntity<String> modificarTarea(@RequestBody Tareas tarea) {
        try {
            tareasService.modificarTarea(tarea);
            return new ResponseEntity<>("Tarea modificada correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al modificar la tarea: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}