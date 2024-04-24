package com.Proyectousa.Desmotivados.Modelos;

import com.Proyectousa.Desmotivados.Entidades.MisionesEntidades;
import com.Proyectousa.Desmotivados.Repositorios.GraficasTCRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GraficasTModelo {

    @Autowired
    private GraficasTCRUDRepository graficasTCRUDRepository;

    public List<MisionesEntidades> obtenerMisionesCompletadasPorRangoDeFechas(Date inicio, Date fin) {
        return graficasTCRUDRepository.obtenerMisionesCompletadasPorRangoDeFechas(inicio, fin);
    }
}
