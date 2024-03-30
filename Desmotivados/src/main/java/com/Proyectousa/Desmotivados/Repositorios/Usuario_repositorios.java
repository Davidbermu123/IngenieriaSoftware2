package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.Usuario;

@Repository
public class Usuario_repositorios {
     @Autowired
    private Usuario_CRUDrepositorios usuarioCRUDRepository;


    public List<Usuario> getAllUsuarios() {

        return (List<Usuario>) usuarioCRUDRepository.findAll();

    }

    public Usuario guardaraUsuario (Usuario k){
        return usuarioCRUDRepository.save(k);
    }
}
