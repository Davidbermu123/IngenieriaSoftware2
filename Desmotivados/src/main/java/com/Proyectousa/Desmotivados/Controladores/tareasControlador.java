package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.TareasEntidades;
import com.Proyectousa.Desmotivados.Modelos.tareasModelos;


@RestController
@RequestMapping("/Corganizador")

public class tareasControlador {

    @Autowired
    private tareasModelos tareasService;

    @GetMapping("/prueba")
    public String saludo(){
        return "Holis"; 
    }

    @GetMapping("/tareas")
    public List<TareasEntidades> getAllTr(){
        return tareasService.getAllTareas();
    }

    @PostMapping("/mistareas")
    public TareasEntidades guardarTareas(@RequestBody TareasEntidades g){
        return tareasService.save(g);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTarea(@PathVariable Long id){
        tareasService.delete(id);
        return ResponseEntity.ok("Elemento eliminado correctamente");
    }

    @PostMapping("/modificarTarea")
    public ResponseEntity<String> modificarTarea(@RequestBody TareasEntidades g) {
        try {
            tareasService.modificarTarea(g);
            return new ResponseEntity<>("Tarea modificada correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al modificar la tarea: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
