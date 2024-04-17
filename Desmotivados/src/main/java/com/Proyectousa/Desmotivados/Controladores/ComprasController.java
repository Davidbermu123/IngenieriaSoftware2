package com.Proyectousa.Desmotivados.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.Compras;
import com.Proyectousa.Desmotivados.Modelos.ComprasService;
import java.util.List;

@RestController
@RequestMapping("/compras")
public class ComprasController {

    @Autowired
    private ComprasService comprasService;

    @GetMapping("/productosFiltrados")
public ResponseEntity<List<String>> getProductosFiltrados(@RequestParam String tipo) {
    List<String> titulos;
    if (tipo.equalsIgnoreCase("tienda")) {
        titulos = comprasService.getAllTitulos();
    } else if (tipo.equalsIgnoreCase("comprado")) {
        titulos = comprasService.getTitulosComprados();
    } else {
        return ResponseEntity.badRequest().build();
    }
    if (!titulos.isEmpty()) {
        return ResponseEntity.ok().body(titulos);
    } else {
        return ResponseEntity.notFound().build();
    }
}

@GetMapping("/detallesProducto")
public ResponseEntity<Compras> getDetallesProducto(@RequestParam String titulo) {
    Compras producto = comprasService.getDetallesProducto(titulo);
    if (producto != null) {
        return ResponseEntity.ok().body(producto);
    } else {
        return ResponseEntity.notFound().build();
    }
}
}