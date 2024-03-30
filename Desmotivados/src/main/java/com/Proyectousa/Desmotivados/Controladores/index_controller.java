package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.Student_Santiago;
import com.Proyectousa.Desmotivados.Modelos.StudentService;

@RestController
@RequestMapping("/inicio")
public class index_controller {

    private StudentService studentService;

    public index_controller(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @GetMapping("/hi")
    public String saludar(){
        return "Hola";
    }

    @GetMapping("/students")
    public List<Student_Santiago> findByNombre(@RequestParam("name") String name) {
        return studentService.findAllStudentsByName(name);
    }

}
