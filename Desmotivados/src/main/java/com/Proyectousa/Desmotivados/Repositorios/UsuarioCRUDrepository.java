package com.Proyectousa.Desmotivados.Repositorios;

import org.springframework.data.repository.CrudRepository;


import com.Proyectousa.Desmotivados.Entidades.Usuario;

public interface UsuarioCRUDrepository extends CrudRepository<Usuario,Long>{

    Usuario findByAlias(String alias);
}
