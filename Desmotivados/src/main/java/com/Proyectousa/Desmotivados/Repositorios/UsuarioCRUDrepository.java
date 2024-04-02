package com.Proyectousa.Desmotivados.Repositorios;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.Proyectousa.Desmotivados.Entidades.Usuario;

public interface UsuarioCRUDrepository extends CrudRepository<Usuario,Long>{

    Usuario findByAlias(String alias);

    @Modifying
    @Query("UPDATE Usuario u SET u.nombre = :nombre, u.apellido = :apellido, u.universidad = :universidad, u.carrera = :carrera, u.semestre = :semestre, u.nmascota = :nmascota, u.password = :password WHERE u.alias = :aliasBusqueda")
    void updateUsuarioByAlias(@Param("aliasBusqueda") String aliasBusqueda, 
                            @Param("nombre") String nombre, 
                            @Param("apellido") String apellido, 
                            @Param("universidad") String universidad, 
                            @Param("carrera") String carrera, 
                            @Param("semestre") Integer semestre, 
                            @Param("nmascota") String nmascota);
}
