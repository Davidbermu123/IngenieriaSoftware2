package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.Proyectousa.Desmotivados.Entidades.MisionesEntidades;

public interface MisionesCRUDRepositorios extends CrudRepository<MisionesEntidades, Long>{

    //List<MisionesEntidades> findByInteresesNombreIn(@Param("nombresIntereses") List<String> nombresIntereses);

}
