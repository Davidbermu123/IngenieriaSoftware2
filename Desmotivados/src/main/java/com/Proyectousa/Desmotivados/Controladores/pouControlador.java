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

    @PutMapping("/cambiarEquipado")
    public void actualizarItemEquipado(@RequestParam Long idItem, @RequestParam Long idItem2) {

        PouEntidad itemEquipado = PouModelo.findByIdItem(idItem);
        PouEntidad itemAEquipar = PouModelo.findByIdItem(idItem2);
        
        itemEquipado.setEquipadoItem(false);
        itemAEquipar.setEquipadoItem(true);

        PouModelo.save(itemEquipado);
        PouModelo.save(itemAEquipar);
    }

    @GetMapping("/itemsEquipados")
    public List<PouEntidad> itemsPouEquipados(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            User usuario = usuarioService.findByUsername(username);

            List<PouEntidad> itemsPou = PouModelo.findByUsernameAndEquipadoItem(usuario, true);
            return  itemsPou;

        }else{
            return null;
        }
    }

}
