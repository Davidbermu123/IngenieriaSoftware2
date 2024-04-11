package com.Proyectousa.Desmotivados.Controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Proyectousa.Desmotivados.Entidades.User;
import com.Proyectousa.Desmotivados.Modelos.Usuario_modelos;

@RestController
@RequestMapping("/cregistro")
public class Usuario_controlador {
    @Autowired
private Usuario_modelos usuarioService;
    @GetMapping("/findbyalias")
    public User findByUsername(@RequestParam("username") String username){
        return usuarioService.findByUsername(username);
    }

    @PutMapping("/updateUsuario")
    public void actualizarUsuarioPorUsername(String usernameBusqueda, String nombre, String apellido, String universidad, String carrera, Integer semestre, String nmascota){
        usuarioService.actualizarUsuarioPorUsername(usernameBusqueda, nombre, apellido, universidad, carrera, semestre, nmascota);
    }
}
