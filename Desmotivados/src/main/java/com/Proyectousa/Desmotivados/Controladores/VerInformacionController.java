package com.Proyectousa.Desmotivados.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.Proyectousa.Desmotivados.Entidades.Informacion;
import com.Proyectousa.Desmotivados.Modelos.InformacionModelo;

@RestController
@RequestMapping("/Informacion")
public class VerInformacionController {

    @Autowired
    private InformacionModelo informacionService;

    @GetMapping("/todasInformaciones")
    public ResponseEntity<List<String>> getAllTitulos() {
        List<String> titulos = informacionService.getAllTitulos();
        if (!titulos.isEmpty()) {
            return ResponseEntity.ok().body(titulos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/detalleProducto")
    public ResponseEntity<Informacion> getDetalleProducto(@RequestParam String titulo) {
        Informacion producto = informacionService.getInformacionByTitulo(titulo);
        if (producto != null) {
            return ResponseEntity.ok().body(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
