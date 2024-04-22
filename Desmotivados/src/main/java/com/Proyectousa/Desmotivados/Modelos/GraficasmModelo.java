package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyectousa.Desmotivados.Entidades.MisionesEntidades;
import com.Proyectousa.Desmotivados.Repositorios.GraficasmCRUDRepository;

@Service
public class GraficasmModelo {

    @Autowired
    private GraficasmCRUDRepository misionesRepository;

    public List<MisionesEntidades> obtenerMisionesEnProgreso() {
        return misionesRepository.findByEstadoAndFechaFinIsNull(true);
    }
}

