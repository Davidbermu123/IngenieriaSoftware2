package com.Proyectousa.Desmotivados.Repositorios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.pouEntidades;
import java.util.List;

@Repository
public class pouRepository {
    @Autowired
    private pouCrudRepository pouCrudRepository;
    public List<pouEntidades> getAllpouEntidades(){
        return ((List<pouEntidades>)pouCrudRepository.findAll());
    }
}
