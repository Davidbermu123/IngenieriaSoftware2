package com.Proyectousa.Desmotivados.Repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Proyectousa.Desmotivados.Entidades.Usuario;

@Repository
public class Usuariorepository {

    @Autowired
    private UsuarioCRUDrepository usuarioCRUDrepository;

    public Usuario findByAlias(String alias){
        return usuarioCRUDrepository.findByAlias(alias);
    }

}
