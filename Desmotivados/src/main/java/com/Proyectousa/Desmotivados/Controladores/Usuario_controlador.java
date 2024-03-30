package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Proyectousa.Desmotivados.Entidades.Usuario;
import com.Proyectousa.Desmotivados.Modelos.Usuario_modelos;

@RestController
@RequestMapping("/cregistro")
public class Usuario_controlador {
    @Autowired
private Usuario_modelos usuarioService;
    @GetMapping("/usuario")
    public List<Usuario> getAllUs(){
        return usuarioService.getAllUsuarios();
    }

    @PostMapping("/guardarUs")
    public Usuario guardarUsuario(@RequestBody Usuario k){
        return usuarioService.save(k);
    }

    
}
