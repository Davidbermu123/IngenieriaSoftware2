package com.Proyectousa.Desmotivados.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Proyectousa.Desmotivados.Entidades.TareasEntidades;
import com.Proyectousa.Desmotivados.Entidades.User;

@Repository
public class tareasRepositorio {

    @Autowired
    private tareasCRUDrepositorio tareasCRUDRepository;

    public List<TareasEntidades> getAllTareas(){
        return (List<TareasEntidades>) tareasCRUDRepository.findAll();
    }

    public TareasEntidades guardarTareas(TareasEntidades g){
        return tareasCRUDRepository.save(g);
    }

    public void eliminarTareas(Long id){
        tareasCRUDRepository.deleteById(id);
    }

    public List<TareasEntidades> getTareasByUsername(String username) {
        return tareasCRUDRepository.findByUsername_Username(username);
    }

    public Optional<TareasEntidades> getTareaById(Long id) {
        return tareasCRUDRepository.findById(id);
    }
    public List<TareasEntidades> obtenerTareasPorUsuarioYcompletado(User usuario, boolean completado) {
        return tareasCRUDRepository.findByUsernameAndCompletado(usuario, completado);
    }
}