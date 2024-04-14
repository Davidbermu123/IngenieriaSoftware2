package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.GraficasM;


@Repository
public interface GraficasCRUDRepository extends CrudRepository<GraficasM, Long> {
    List<GraficasM> findByTitulo(String titulo);
}
