package com.Proyectousa.Desmotivados.Repositorios;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.Proyectousa.Desmotivados.Entidades.User;

public interface Usuario_CRUDrepositorios extends  CrudRepository<User,Long>{

    User findByUsername(String username);

    @Modifying
    @Query("UPDATE User u SET u.nombre = :nombre, u.apellido = :apellido, u.universidad = :universidad, u.carrera = :carrera, u.semestre = :semestre, u.nmascota = :nmascota WHERE u.username = :usernameBusqueda")
    void updateUserByUsername(@Param("usernameBusqueda") String usernameBusqueda,
                              @Param("nombre") String nombre,
                              @Param("apellido") String apellido,
                              @Param("universidad") String universidad,
                              @Param("carrera") String carrera,
                              @Param("semestre") Integer semestre,
                              @Param("nmascota") String nmascota);
    
}
