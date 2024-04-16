package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Proyectousa.Desmotivados.Entidades.Role;
import com.Proyectousa.Desmotivados.Entidades.User;

@Repository
public class Usuario_repositorios {
     @Autowired
    private Usuario_CRUDrepositorios usuarioCRUDRepository;


    public List<User> getAllUsuarios() {
        return (List<User>) usuarioCRUDRepository.findAll();
    }

    public User guardaraUsuario (User m){
        return usuarioCRUDRepository.save(m);
    }
    public User findByUsername(String alias){
        return usuarioCRUDRepository.findByUsername(alias);
    }   

    public Role obtenerRolPorUsuario(String username) {
        User usuario = usuarioCRUDRepository.findByUsername(username);
        return usuario.getRole();
    }
}
