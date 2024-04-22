package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.Tareas;


@Repository
public interface GraficasCRUDRepositorio extends CrudRepository<Tareas, Long> {
    List<Tareas> findByTitulo(String titulo);
}
