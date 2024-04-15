package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.TiendaEntidades;
import com.Proyectousa.Desmotivados.Modelos.TiendaModelos;

@RestController
@RequestMapping("/tienda")
public class TiendaControladores {

    @Autowired
    private TiendaModelos servicio;

    @GetMapping("/retornaritems")
    public List<TiendaEntidades> getAllTiendaEntidades(){
        return servicio.getAllTienda();
    }
}
