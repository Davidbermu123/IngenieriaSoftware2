package com.Proyectousa.Desmotivados.Repositorios;

import org.springframework.data.repository.CrudRepository;

import com.Proyectousa.Desmotivados.Entidades.User;

public interface Usuario_CRUDrepositorios extends  CrudRepository<User,Long>{

    User findByUsername(String username);
}
