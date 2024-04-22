package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.MisionesEntidades;

@Repository
public interface GraficasmCRUDRepository extends CrudRepository<MisionesEntidades, Long> {
    @Query("SELECT m FROM MisionesEntidades m WHERE m.estado = true AND m.fechaFin IS NULL")
    List<MisionesEntidades> obtenerMisionesEnProgreso();
}

