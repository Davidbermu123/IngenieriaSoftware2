package com.Proyectousa.Desmotivados.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyectousa.Desmotivados.Entidades.User;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username); 
}
