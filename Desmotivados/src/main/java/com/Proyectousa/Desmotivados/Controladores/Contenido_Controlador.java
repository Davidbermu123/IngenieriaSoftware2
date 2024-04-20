package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/findContenido")
    public List<Contenido> findContenidosByAreaEstudioAndInteres( 
        @RequestParam("area_estudio") String area_estudio,
        @RequestParam("interes") String interes){
            return contenidoService.findByAreaEstudioAndInteres(area_estudio, interes);
        }

    @PostMapping("/postContenido")
    public Contenido saveContenido(Contenido contenido) {
        return contenidoService.saveContenido(contenido);
    }

    @DeleteMapping("/deleteContenido/{id}")
    public void deleteContenido(@PathVariable Long id){
        contenidoService.deleteContenido(id);
    }


    @GetMapping("/mostrarContenido")
    public Optional<Contenido> findContenidoId(Long id){
        return contenidoService.mostrarContenido(id);
    }

    @PutMapping("/editarContenido")
    public void updateContenido(Long idContenido, String tituloContenido, String detalleContenido, String areaEstudio, String interes, String categoria, String link){
        contenidoService.actualizarContenido(idContenido, tituloContenido, detalleContenido, areaEstudio, interes, categoria, link);
    }    
}
