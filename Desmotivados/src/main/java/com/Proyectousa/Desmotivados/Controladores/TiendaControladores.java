package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.TiendaEntidades;
import com.Proyectousa.Desmotivados.Modelos.TiendaModelos;


@RestController
@RequestMapping("/tienda")
public class TiendaControladores {

    @Autowired
    private TiendaModelos servicio;

    @GetMapping("/mostrar")
    public Optional<TiendaEntidades> mostrarTienda(Long id){
        return servicio.mostrarTienda(id);
    }
    
    @GetMapping("/retornaritems")
    public List<TiendaEntidades> getAllTiendaEntidades(){
        return servicio.getAllTienda();
    }

    @PostMapping("/guardar")
    public TiendaEntidades guardarArticulo(@RequestBody TiendaEntidades t){
        return servicio.save(t);
    }

    @PutMapping("/editar") // Modified to accept idTienda as a path variable
    public void updateTienda(Long idTienda, // Use @PathVariable to map idTienda from URL
                            String imagenTiendaItem,
                            String descripcionTiendaItem,
                            String tipoTiendaItem,
                            Integer precio) {
        servicio.actualizarTienda(idTienda, imagenTiendaItem, descripcionTiendaItem, tipoTiendaItem, precio);
    }

}
