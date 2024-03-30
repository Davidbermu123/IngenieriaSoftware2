package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyectousa.Desmotivados.Entidades.Student_Santiago;
import com.Proyectousa.Desmotivados.Repositorios.StudentRepository_Santiago;

@Service
public class StudentService {

    @Autowired
    private StudentRepository_Santiago studentRepository_Santiago;

    public List<Student_Santiago> getAllStudents(){
        return studentRepository_Santiago.getAllStudents();
    }

    public List<Student_Santiago> findAllStudentsByName(String name) {
        return studentRepository_Santiago.findAllStudentsByName(name);
    }
}
