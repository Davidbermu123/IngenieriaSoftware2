package com.Proyectousa.Desmotivados.Modelos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Proyectousa.Desmotivados.Entidades.Usuario;
import com.Proyectousa.Desmotivados.Repositorios.Usuariorepository;

@Service
public class UsuarioService {

    @Autowired
    private Usuariorepository usuariorepository;

    public Usuario findByAlias(String alias){
        return usuariorepository.findByAlias(alias);
    }

    @Transactional
    public void actualizarUsuarioPorAlias(String aliasBusqueda, String nombre, String apellido, String universidad, String carrera, Integer semestre, String nmascota) {
    // Obtener el usuario a actualizar
    Usuario usuario = usuariorepository.findByAlias(aliasBusqueda);
    
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
        usuariorepository.saveUsuario(usuario);
    } else {
        // Manejar el caso en que no se encuentre el usuario
        throw new RuntimeException("El usuario con el alias proporcionado no existe: " + aliasBusqueda);
    }
}


}
