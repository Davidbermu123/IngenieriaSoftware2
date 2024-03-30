package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Proyectousa.Desmotivados.Entidades.Usuario;
import com.Proyectousa.Desmotivados.Repositorios.Usuario_repositorios;

@Service
public class Usuario_modelos {
    
    @Autowired
    private Usuario_repositorios usuarioRepository;

    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.getAllUsuarios();
    }    

    public Usuario save(Usuario k){
        return usuarioRepository.guardaraUsuario(k);
    }

}