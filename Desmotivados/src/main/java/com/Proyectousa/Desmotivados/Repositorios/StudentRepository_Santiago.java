package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Proyectousa.Desmotivados.Entidades.Student_Santiago;

@Repository
public class StudentRepository_Santiago {

    @Autowired
    private StudentCRUDrepository studentCRUDrepository;

    public List<Student_Santiago> getAllStudents(){
        return (List<Student_Santiago>)studentCRUDrepository.findAll();
    }

    public List<Student_Santiago> findAllStudentsByName(String name) {
        return studentCRUDrepository.findAllByName(name);
    }

   
    
}
