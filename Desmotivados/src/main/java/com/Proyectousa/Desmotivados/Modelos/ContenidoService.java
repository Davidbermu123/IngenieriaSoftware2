package com.Proyectousa.Desmotivados.Modelos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyectousa.Desmotivados.Entidades.Contenido;
import com.Proyectousa.Desmotivados.Repositorios.Contenidorepository;

@Service
public class ContenidoService {

    @Autowired
    private Contenidorepository contenidorepository;

    public List<Contenido> findByAreaEstudioAndInteres(String area_estudio, String interes){
        return contenidorepository.findByAreaEstudioAndInteres(area_estudio, interes);
    }

    public Contenido saveContenido(Contenido contenido){
        return contenidorepository.saveContenido(contenido);
    }

    public void deleteContenido(Long id){
        contenidorepository.deleteContenido(id);
    }

    public Optional<Contenido> mostrarContenido(Long id){
        return contenidorepository.findContenidoId(id);
    }

    public Contenido findContenidoPorId(Long idContenido) {
        return contenidorepository.findContenidoId(idContenido).orElse(null);
    }
    
    public void actualizarContenido(Long idContenido, String tituloContenido, String detalleContenido, String areaEstudio, String interes, String categoria, String link) {
        // Obtener el contenido a actualizarse
        Contenido contenido = findContenidoPorId(idContenido);
        
        // Verificar si se encontró el contenido
        if (contenido != null) {
            // Actualizar los campos permitidos
            contenido.setTituloContenido(tituloContenido);
            contenido.setDetalleContenido(detalleContenido);
            contenido.setAreaEstudio(areaEstudio);
            contenido.setInteres(interes);
            contenido.setCategoria(categoria);
            contenido.setLink(link);
            
            // Guardar los cambios en la base de datos
            contenidorepository.saveContenido(contenido);
        } else {
            // Manejar el caso en que no se encuentre el usuario
            throw new RuntimeException("El contenido con ese id no existe: " + idContenido);
        }
    }
}
