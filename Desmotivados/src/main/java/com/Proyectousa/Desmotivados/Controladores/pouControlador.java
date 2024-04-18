package com.Proyectousa.Desmotivados.Controladores;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.PouEntidad;
import com.Proyectousa.Desmotivados.Entidades.User;
import com.Proyectousa.Desmotivados.Modelos.PouModelo;
import com.Proyectousa.Desmotivados.Modelos.Usuario_modelos;

@RestController
@RequestMapping("/requestPou")
public class pouControlador {
    @Autowired
    private PouModelo PouModelo;
    @Autowired
    private Usuario_modelos usuarioService;

    @Autowired
    private Usuario_modelos usuariomodelos;

    @GetMapping("/pou")
    public String mostrarPaginaEspecifica() {
        return "index.html"; // Devuelve el nombre de la vista
    }
    
    @GetMapping("/getPou")
    public List<PouEntidad> getAllPouEntidad(){
        return PouModelo.getAllPouEntidad();
    }

    @PostMapping("/guardarElementoPou")
    public PouEntidad guardarElPouEntidad(@RequestBody PouEntidad e){
        return PouModelo.save(e);
    }

    @GetMapping("/getPouItems")
    public List<PouEntidad> cargarItems(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
        String username = authentication.getName();

        User usuario = usuarioService.findByUsername(username);
            List<PouEntidad> itemsPou = PouModelo.findByUsernames(usuario);
            return  itemsPou;
        }else{
            return null;
        }
    }

    @PutMapping("/cambiarEquiado")
    public void actualizarMision(@RequestParam Long idItem, @RequestParam Long idItem2) {
        PouEntidad pou = PouModelo.findById(idItem);
        PouEntidad pou2 = PouModelo.findById(idItem2);
        
        pou.setEquipadoItem(false);
        pou2.setEquipadoItem(true);

        PouModelo.save(pou);
        PouModelo.save(pou2);
    }

    @GetMapping("/itemsEquipados")
    public List<PouEntidad> itemsPou(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
        String username = authentication.getName();

        User usuario = usuarioService.findByUsername(username);
            List<PouEntidad> itemsPou = PouModelo.findByUsernameAndEntidad(usuario, true);
            return  itemsPou;
        }else{
            return null;
        }
    }

    @PutMapping("/actualizarEquipado")
    public void actualizarEquipado(@RequestParam Long idItem, @RequestParam boolean equipadoItem){
        System.out.println("------------------------------------");
        PouEntidad pouentidadeq = PouModelo.findByIdItem(idItem);

        if(pouentidadeq != null){
            System.out.println("Holap3");
            pouentidadeq.setEquipadoItem(equipadoItem);
            PouModelo.save(pouentidadeq);
        }

    }

}
