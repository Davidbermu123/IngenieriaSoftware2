package com.Proyectousa.Desmotivados.Modelos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyectousa.Desmotivados.Entidades.pouEntidades;
import com.Proyectousa.Desmotivados.Repositorios.pouRepository;

@Service

public class pouService {
    @Autowired
    private pouRepository pouRepository;
    
    public List<pouEntidades> getAllpouEntidades(){
        return pouRepository.getAllpouEntidades();
    }
}
