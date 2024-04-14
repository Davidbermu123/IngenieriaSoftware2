package com.Proyectousa.Desmotivados.Modelos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyectousa.Desmotivados.Entidades.MisionesEntidades;
import com.Proyectousa.Desmotivados.Repositorios.MisionesRepositorio;

@Service
public class MisionesModelos {
    
    @Autowired
    private MisionesRepositorio repositorio;

    public List<MisionesEntidades> listarTodas() {
        List<MisionesEntidades> lista =  repositorio.getAllMisionesEntidades();
        List<MisionesEntidades> filtrada = new ArrayList<>();
        for (MisionesEntidades entidad : lista) {
            //entidad.getcontenido().setAreaEstudio(null);
            //entidad.getcontenido().setInteres(null);
            filtrada.add(entidad);
        }
        return filtrada;
    }
}
