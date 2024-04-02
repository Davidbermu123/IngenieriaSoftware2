package com.Proyectousa.Desmotivados.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.Usuario;
import com.Proyectousa.Desmotivados.Modelos.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class Usuario_controlador {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/findbyalias")
    public Usuario findByAlias(@RequestParam("alias") String alias){
        return usuarioService.findByAlias(alias);
    }

    @PutMapping("/updateUsuario")
    public void actualizarUsuarioPorAlias(String aliasBusqueda, String nombre, String apellido, String universidad, String carrera, Integer semestre, String nmascota){
        usuarioService.actualizarUsuarioPorAlias(aliasBusqueda, nombre, apellido, universidad, carrera, semestre, nmascota);
    }
}
