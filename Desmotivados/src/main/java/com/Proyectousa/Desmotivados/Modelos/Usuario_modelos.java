package com.Proyectousa.Desmotivados.Modelos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Proyectousa.Desmotivados.Entidades.User;
import com.Proyectousa.Desmotivados.Repositorios.Usuario_repositorios;

@Service
public class Usuario_modelos {
    
    @Autowired
    private Usuario_repositorios usuarioRepository;
     
    public User findByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

    public void actualizarUsuarioPorUsername(String usernameBusqueda, String nombre, String apellido, String universidad, String carrera, Integer semestre, String nmascota) {
        // Obtener el usuario a actualizars
        User usuario = usuarioRepository.findByUsername(usernameBusqueda);
        
        // Verificar si se encontró el usuario
        if (usuario != null) {
            // Actualizar los campos permitidos
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setUniversidad(universidad);
            usuario.setCarrera(carrera);
            usuario.setSemestre(semestre);
            usuario.setNmascota(nmascota);
            
            // Guardar los cambios en la base de datos
            usuarioRepository.guardaraUsuario(usuario);
        } else {
            // Manejar el caso en que no se encuentre el usuario
            throw new RuntimeException("El usuario con el alias proporcionado no existe: " + usernameBusqueda);
        }
    }

}