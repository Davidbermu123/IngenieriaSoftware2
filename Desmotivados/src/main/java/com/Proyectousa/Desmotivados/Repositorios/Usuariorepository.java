package com.Proyectousa.Desmotivados.Repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Proyectousa.Desmotivados.Entidades.Usuario;

@Repository
public class Usuariorepository {

    @Autowired
    private UsuarioCRUDrepository usuarioCRUDrepository;

    public Usuario findByAlias(String alias){
        return usuarioCRUDrepository.findByAlias(alias);
    }

    @Transactional
    public void actualizarUsuarioPorAlias(String aliasBusqueda, String nombre, String apellido, String universidad, String carrera, Integer semestre, String nmascota) {
        usuarioCRUDrepository.updateUsuarioByAlias(aliasBusqueda, nombre, apellido, universidad, carrera, semestre, nmascota);
    }

    public Usuario saveUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        return usuarioCRUDrepository.save(usuario);
    }

}
