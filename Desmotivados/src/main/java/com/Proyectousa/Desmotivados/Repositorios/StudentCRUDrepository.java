package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.Proyectousa.Desmotivados.Entidades.Student_Santiago;

public interface StudentCRUDrepository extends CrudRepository<Student_Santiago, Long>{
    List<Student_Santiago> findAllByName(String name);

}
