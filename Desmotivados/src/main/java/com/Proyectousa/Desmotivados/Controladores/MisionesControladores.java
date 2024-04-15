package com.Proyectousa.Desmotivados.Controladores;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.Contenido;
import com.Proyectousa.Desmotivados.Entidades.MisionesEntidades;
import com.Proyectousa.Desmotivados.Entidades.User;
import com.Proyectousa.Desmotivados.Modelos.ContenidoService;
import com.Proyectousa.Desmotivados.Modelos.MisionesModelos;
import com.Proyectousa.Desmotivados.Modelos.Usuario_modelos;

@RestController
@RequestMapping("/misiones") 
public class MisionesControladores {
    @Autowired
    private MisionesModelos servicio;
    @Autowired
    private Usuario_modelos usuarioServicio;
    @Autowired
    private ContenidoService contenidoService;

    @GetMapping("/retornarmisiones")
    public List<MisionesEntidades> getAllMisionesEntidades(){
        return servicio.listarTodas();
    }

    @PostMapping("/generarmisiones")
    public boolean generarMision(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
        String username = authentication.getName();

        User usuario = usuarioServicio.findByUsername(username);

        List<String> intereses = Arrays.asList(usuario.getIntereses().split("\\s*,\\s*"));
        List<Contenido> contenidos = contenidoService.findByCategoriaAndInteresIn("Actividades",intereses);
        
        int cantidad = 0;
        for (Contenido contenido : contenidos) {
            // Verificar si ya existe una misión para este contenido y usuario
            if (!servicio.existeMisionParaUsuarioYContenido(usuario, contenido) && cantidad < 5) {
                MisionesEntidades mision = new MisionesEntidades();
                mision.setUsername(usuario);
                mision.setContenido(contenido);
                mision.setPuntaje(100);
                mision.setEstado(false);
                mision.setFechaFin(null);
                servicio.guardar(mision);
                cantidad += 1;
            }
        }
        if(cantidad != 0){
            return true;
        }
        }
        return false;
    }

    @GetMapping("/cargarmisiones")
    public List<MisionesEntidades> cargarMisiones(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
        String username = authentication.getName();

        User usuario = usuarioServicio.findByUsername(username);
            List<MisionesEntidades> misionesUsuario = servicio.obtenerMisionesPorUsuarioYEstado(usuario, false);
            return  misionesUsuario;
        }else{
            return null;
        }
    }

    @PutMapping("/actualizarmision")
    public void actualizarMision(@RequestParam Long idMision, @RequestParam boolean estado) {
        MisionesEntidades mision = servicio.findById(idMision);
        if (mision != null) {
            mision.setEstado(estado);
            if (estado) { // Si el estado es true, establecemos la fecha de finalización.
                mision.setFechaFin(new Date());
            }
            servicio.guardar(mision);
        }
    }
}
