package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import com.Proyectousa.Desmotivados.Entidades.User;
import com.Proyectousa.Desmotivados.Modelos.Usuario_modelos;

@RestController
@RequestMapping("/cregistro")
public class Usuario_controlador {
    @Autowired
private Usuario_modelos usuarioService;
    @GetMapping("/usuario")
    public List<User> getAllUs(){
        return usuarioService.getAllUsuarios();
    }

    @PostMapping("/guardarUs")
    public User guardarUsuario(@RequestBody User k){
        return usuarioService.save(k);
    }
    @GetMapping("/findbyalias")
    public User findByUsername(@RequestParam("username") String username){
        return usuarioService.findByUsername(username);
    }
    @GetMapping("/rol")
    public String obtenerRolPorUsuario() {
        // Obtener el nombre de usuario del objeto Authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        
        // Buscar el usuario en el servicio Usuario_modelos
        User usuario = usuarioService.findByUsername(username);

        // Verificar si el usuario existe y devolver su rol
        if (usuario != null) {
            return usuario.getRole().toString();
        } else {
            return "Usuario no encontrado";
        }
    }
}

