package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
/* 
    @GetMapping("/modificarTarea/{id}")
    public ResponseEntity<Tareas> obtenerTarea(@PathVariable Long id) {
        Tareas tarea = tareasService.obtenerTareaPorId(id);
        if (tarea != null) {
            return new ResponseEntity<>(tarea, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/actualizarTarea/{id}")
    public ResponseEntity<Tareas> actualizarTarea(@PathVariable Long id, @RequestBody Tareas tarea) {
        Tareas tareaExistente = tareasService.obtenerTareaPorId(id);
        if (tareaExistente != null) {
            tareaExistente.setTitulo(tarea.getTitulo());
            tareaExistente.setDescripcion(tarea.getDescripcion());
            tareaExistente.setFechaInicio(tarea.getFechaInicio());
            tareaExistente.setFechaFinal(tarea.getFechaFinal());
            tareaExistente.setPrioridad(tarea.getPrioridad());
            Tareas tareaActualizada = tareasService.actualizarTarea(tareaExistente);
            return new ResponseEntity<>(tareaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    */
}