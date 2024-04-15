package com.Proyectousa.Desmotivados.Controladores;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

public class PouControlador {
    @Autowired
    private PouModelo PouModelo;

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

    @PostMapping("/postPou")
    public ResponseEntity<PouEntidad> guardarPouInventario(@RequestBody PouEntidad pou) {

        System.out.println("Arriba de la funcion");
        System.out.println("Esto sirve?: "+ pou.getDescripcionItem());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("Abajo de la funcion: "+authentication);

        if (authentication != null && authentication.isAuthenticated()) {
            // Obtener el nombre de usuario del usuario autenticado
            String username = authentication.getName();
            System.out.println(username);
            // Buscar al usuario por su username
            User usuario = usuariomodelos.findByUsername(username);
            System.out.println(usuario);
            if (usuario != null) {
                // Asociar la pou con el usuario obtenido
                pou.setUsername(usuario);

                // Guardar la pou
                PouEntidad pouGuardado = PouModelo.save(pou);

                System.out.println("CAREMONDAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                return ResponseEntity.ok(pouGuardado);
            } else {
                // Esto podría indicar un problema más grave, como una desincronización entre la autenticación y la base de datos
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            // No debería llegar aquí si el filtro está configurado correctamente
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/verificarExistencia/{id}")
    public ResponseEntity<Map<String, Boolean>> verificarExistencia(@PathVariable Long id) {
        boolean existe = PouModelo.existeIdPou(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("existe", existe);
        return ResponseEntity.ok(response);
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
