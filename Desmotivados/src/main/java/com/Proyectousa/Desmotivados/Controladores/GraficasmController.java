package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Proyectousa.Desmotivados.Entidades.MisionesEntidades;
import com.Proyectousa.Desmotivados.Repositorios.GraficasmCRUDRepository;

@RestController
@RequestMapping("/misiones")
public class GraficasmController {

    @Autowired
    private GraficasmCRUDRepository misionesService;

    @GetMapping("/progreso-en-progreso")
    public List<MisionesEntidades> obtenerProgresoMisionesEnProgreso() {
        return misionesService.obtenerMisionesEnProgreso();
    }
}
