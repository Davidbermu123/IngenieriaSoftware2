package com.Proyectousa.Desmotivados.Controladores;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Proyectousa.Desmotivados.Entidades.pouEntidades;
import com.Proyectousa.Desmotivados.Modelos.pouService;

@RestController
@RequestMapping("/requestPou")

public class pouControlador {
    @Autowired
    private pouService pouService;

    @GetMapping("/pou")
    public String mostrarPaginaEspecifica() {
        return "index.html"; // Devuelve el nombre de la vista
    }
    
    @GetMapping("/getPou")
    public List<pouEntidades> getAllpouEntidades(){
        return pouService.getAllpouEntidades();
    }
}
