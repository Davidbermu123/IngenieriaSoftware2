package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.Proyectousa.Desmotivados.Entidades.Graficas;

public interface GraficasCRUDRepository extends CrudRepository<Graficas, Long> {
    List<Graficas> findByTitulo(String titulo);
}
