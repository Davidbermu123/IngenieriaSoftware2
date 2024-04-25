package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.TareasEntidades;


@Repository
public interface GraficasCRUDRepositorio extends CrudRepository<TareasEntidades, Long> {
    List<TareasEntidades> findByTitulo(String titulo);
}
