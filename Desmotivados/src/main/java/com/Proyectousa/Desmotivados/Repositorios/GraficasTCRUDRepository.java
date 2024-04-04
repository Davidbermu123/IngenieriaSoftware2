package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.GraficasT;

@Repository
public interface GraficasTCRUDRepository extends CrudRepository<GraficasT, Long> {
    List<GraficasT> findAll();
}