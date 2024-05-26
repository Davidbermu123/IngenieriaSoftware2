package com.Proyectousa.Desmotivados.Controladores;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
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
    private Usuario_modelos servicioUsuario;
    
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

    @PostMapping("/ponerDefault")
    public void ponerDefault() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            User usuario = servicioUsuario.findByUsername(username);

            System.out.println("Entro al controlador");

            PouEntidad item1 = new PouEntidad();
            item1.setDescripcionItem("Descripción del ítem 1");
            item1.setEquipadoItem(true);
            item1.setImagenItem("/imgs/pou/Fondo1.png");
            item1.setTipoItem("Fondo");
            item1.setUsername(usuario);
            PouModelo.save(item1);

            PouEntidad item2 = new PouEntidad();
            item2.setDescripcionItem("Descripción del ítem 2");
            item2.setEquipadoItem(true);
            item2.setImagenItem("/imgs/pou/Ropa11.png");
            item2.setTipoItem("Ropa");
            item2.setUsername(usuario);
            PouModelo.save(item2);

            PouEntidad item3 = new PouEntidad();
            item3.setDescripcionItem("Descripción del ítem 3");
            item3.setEquipadoItem(true);
            item3.setImagenItem("/imgs/pou/Mueble8.png");
            item3.setTipoItem("Mueble");
            item3.setUsername(usuario);
            PouModelo.save(item3);

            PouEntidad item4 = new PouEntidad();
            item4.setDescripcionItem("Descripción del ítem 4");
            item4.setEquipadoItem(true);
            item4.setImagenItem("/imgs/pou/MuebleB10.png");
            item4.setTipoItem("MuebleB");
            item4.setUsername(usuario);
            PouModelo.save(item4);
        }else{
            System.out.println("Fallo autenticacion default");
        }
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
