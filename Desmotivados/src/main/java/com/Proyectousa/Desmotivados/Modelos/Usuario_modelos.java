package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyectousa.Desmotivados.Entidades.Role;
import com.Proyectousa.Desmotivados.Entidades.User;
import com.Proyectousa.Desmotivados.Repositorios.Usuario_repositorios;

@Service
public class Usuario_modelos {
    
    @Autowired
    private Usuario_repositorios usuarioRepository;

    public List<User> getAllUsuarios(){
        return usuarioRepository.getAllUsuarios();
    }    

    public User save(User k){
        return usuarioRepository.guardaraUsuario(k);
    }
    
    public User findByUsername(String alias){
        return usuarioRepository.findByUsername(alias);
    }
    public Role obtenerRolPorUsuario(String username) {
        User usuario = usuarioRepository.findByUsername(username);
        return usuario.getRole();
    }
}