package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyectousa.Desmotivados.Entidades.TiendaEntidades;
import com.Proyectousa.Desmotivados.Repositorios.TiendaRepositorios;

@Service
public class TiendaModelos {

    @Autowired
    private TiendaRepositorios repositorio;

    public Optional<TiendaEntidades> mostrarTienda(Long Id){
        return repositorio.findByIdTienda(Id);
    }

    public List<TiendaEntidades> getAllTienda(){
        return repositorio.getAllTienda();
    }

    public TiendaEntidades save(TiendaEntidades t){
        return repositorio.guardarTienda(t);
    }

    public TiendaEntidades findTiendaPorId(Long idTienda) {
        return repositorio.findByIdTienda(idTienda).orElse(null);
    }
    
    public void actualizarTienda(Long idTienda, String imagenTiendaItem, String descripcionTiendaItem, String tipoTiendaItem, Integer precio) {
        // Obtener el contenido a actualizarse
        TiendaEntidades tienda = findTiendaPorId(idTienda);
        
        // Verificar si se encontró el contenido
        if (tienda != null) {
            // Actualizar los campos permitidos
            tienda.setImagenTiendaItem(imagenTiendaItem);
            tienda.setDescripcionTiendaItem(descripcionTiendaItem);
            tienda.setTipoTiendaItem(tipoTiendaItem);
            tienda.setPrecio(precio);
            
            // Guardar los cambios en la base de datos
            repositorio.guardarTienda(tienda);
        } else {
            // Manejar el caso en que no se encuentre el usuario
            throw new RuntimeException("El contenido con ese id no existe: " + idTienda);
        }
    }
}
