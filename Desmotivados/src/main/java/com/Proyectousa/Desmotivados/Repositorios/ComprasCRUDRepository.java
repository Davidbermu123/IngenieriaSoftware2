package com.Proyectousa.Desmotivados.Repositorios;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.Proyectousa.Desmotivados.Entidades.Compras;

public interface ComprasCRUDRepository extends CrudRepository<Compras, Long>{
    List<Compras> findByEtiqueta(String etiqueta);
    Compras findByTitulo(String titulo);
}
