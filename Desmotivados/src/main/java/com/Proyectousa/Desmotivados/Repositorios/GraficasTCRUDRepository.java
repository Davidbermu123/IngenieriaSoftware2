package com.Proyectousa.Desmotivados.Repositorios;

import com.Proyectousa.Desmotivados.Entidades.MisionesEntidades;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GraficasTCRUDRepository extends CrudRepository<MisionesEntidades, Long> {
    @Query("SELECT m FROM MisionesEntidades m WHERE m.estado = true AND m.fechaFin BETWEEN ?1 AND ?2")
    List<MisionesEntidades> obtenerMisionesCompletadasPorRangoDeFechas(Date inicio, Date fin);
}