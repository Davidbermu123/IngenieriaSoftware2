package com.Proyectousa.Desmotivados.Repositorios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.User;

import jakarta.transaction.Transactional;

@Repository
public class Usuario_repositorios {
     @Autowired
    private Usuario_CRUDrepositorios usuarioCRUDRepository;

    public User findByUsername(String username){
        return usuarioCRUDRepository.findByUsername(username);
    }

    @Transactional
    public void actualizarUserPorUsername(String usernameBusqueda, 
                                        String nombre, 
                                        String apellido, 
                                        String universidad, 
                                        String carrera, 
                                        Integer semestre, 
                                        String nmascota){
        usuarioCRUDRepository.updateUserByUsername(usernameBusqueda, nombre, apellido, universidad, carrera, semestre, nmascota);
    }
    

    @SuppressWarnings("null")
    public User guardaraUsuario (User m){
        return usuarioCRUDRepository.save(m);
    }

}
