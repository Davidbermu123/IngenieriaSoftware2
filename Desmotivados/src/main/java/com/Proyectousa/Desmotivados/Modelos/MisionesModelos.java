package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyectousa.Desmotivados.Entidades.Contenido;
import com.Proyectousa.Desmotivados.Entidades.MisionesEntidades;
import com.Proyectousa.Desmotivados.Entidades.User;
import com.Proyectousa.Desmotivados.Repositorios.MisionesRepositorio;

@Service
public class MisionesModelos {
    
    @Autowired
    private MisionesRepositorio repositorio;

    public List<MisionesEntidades> listarTodas() {
        return repositorio.getAllMisionesEntidades();
    }

    public MisionesEntidades guardar(MisionesEntidades m){
        return repositorio.save(m);
    }

    public boolean existeMisionParaUsuarioYContenido(User usuario, Contenido contenido) {
        return repositorio.existeMisionParaUsuarioYContenido(usuario, contenido);
    }

    public List<MisionesEntidades> obtenerMisionesPorUsuarioYEstado(User usuario, boolean estado) {
        return repositorio.obtenerMisionesPorUsuarioYEstado(usuario, estado);
    }

    public MisionesEntidades findById(Long idMision){
        return repositorio.findById(idMision);
    }
}
