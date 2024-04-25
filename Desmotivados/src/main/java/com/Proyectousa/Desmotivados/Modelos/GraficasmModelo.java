package com.Proyectousa.Desmotivados.Modelos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import com.Proyectousa.Desmotivados.Entidades.MisionesEntidades;
import com.Proyectousa.Desmotivados.Repositorios.GraficasmCRUDRepository;

@Service
public class GraficasmModelo {

    @Autowired
    private GraficasmCRUDRepository graficasmCRUDRepository;

    public List<MisionesEntidades> obtenerMisionesCompletadasPorRangoDeFechas(Date inicio, Date fin) {
        return graficasmCRUDRepository.obtenerMisionesCompletadasPorRangoDeFechas(inicio, fin);
    }
}

