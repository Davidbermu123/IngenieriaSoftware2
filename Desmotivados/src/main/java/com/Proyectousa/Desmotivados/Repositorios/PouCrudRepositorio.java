package com.Proyectousa.Desmotivados.Repositorios;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.Proyectousa.Desmotivados.Entidades.PouEntidad;
import com.Proyectousa.Desmotivados.Entidades.User;

public interface PouCrudRepositorio extends CrudRepository<PouEntidad, Long>{
    List<PouEntidad> findByUsername(User usuario);
    List<PouEntidad> findByUsernameAndEquipadoItem(User usuario, boolean equipadoItem);
    PouEntidad findByIdItem(Long id);
}