package com.Proyectousa.Desmotivados.Repositorios;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.TareasEntidades;

@Repository
public interface GraficasmCRUDRepository extends CrudRepository<TareasEntidades, Long> {
    @Query("SELECT m FROM TareasEntidades m WHERE m.completado = true AND m.fechaFinal BETWEEN ?1 AND ?2")
    List<TareasEntidades> obtenerMisionesCompletadasPorRangoDeFechas(Date inicio, Date fin);
}