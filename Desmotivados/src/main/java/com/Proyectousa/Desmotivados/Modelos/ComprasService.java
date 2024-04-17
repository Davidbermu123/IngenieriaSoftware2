package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Proyectousa.Desmotivados.Entidades.Compras;
import com.Proyectousa.Desmotivados.Repositorios.ComprasCRUDRepository;


@Service
public class ComprasService {

    @Autowired
    private ComprasCRUDRepository comprasCRUDRepository;

    public List<String> getAllTitulos() {
        List<Compras> compras = (List<Compras>) comprasCRUDRepository.findAll();
        return compras.stream().map(Compras::getTitulo).collect(Collectors.toList());
    }

    public List<String> getTitulosComprados() {
        List<Compras> compras = comprasCRUDRepository.findByEtiqueta("comprado");
        return compras.stream().map(Compras::getTitulo).collect(Collectors.toList());
    }
    public Compras getDetallesProducto(String titulo) {
        return comprasCRUDRepository.findByTitulo(titulo);
    }
}