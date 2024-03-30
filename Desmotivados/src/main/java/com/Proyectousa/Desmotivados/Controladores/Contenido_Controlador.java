package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.Contenido;
import com.Proyectousa.Desmotivados.Modelos.ContenidoService;

@RestController
@RequestMapping("/contenido")
public class Contenido_Controlador {

    @Autowired
    private ContenidoService contenidoService;

    public List<Contenido> findContenidosByAreaEstudioAndInteres( 
        @RequestParam("area_estudio") String area_estudio,
        @RequestParam("interes") String interes){
            return contenidoService.findByAreaEstudioAndInteres(area_estudio, interes);
        }
}
