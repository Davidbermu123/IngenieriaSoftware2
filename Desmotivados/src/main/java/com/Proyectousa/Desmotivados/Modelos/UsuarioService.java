package com.Proyectousa.Desmotivados.Modelos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyectousa.Desmotivados.Entidades.Usuario;
import com.Proyectousa.Desmotivados.Repositorios.Usuariorepository;

@Service
public class UsuarioService {

    @Autowired
    private Usuariorepository usuariorepository;

    public Usuario findByAlias(String alias){
        return usuariorepository.findByAlias(alias);
    }

}
