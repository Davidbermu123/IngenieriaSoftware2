package com.Proyectousa.Desmotivados.Repositorios;
import org.springframework.data.repository.CrudRepository;
import com.Proyectousa.Desmotivados.Entidades.PouEntidad;

public interface PouCrudRepositorio extends CrudRepository<PouEntidad, Long>{

    PouEntidad findByIdItem(Long idItem);

}