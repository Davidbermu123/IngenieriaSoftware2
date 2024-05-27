package com.Proyectousa.Desmotivados.Controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Proyectousa.Desmotivados.Entidades.PouEntidad;
import com.Proyectousa.Desmotivados.Entidades.TiendaEntidades;
import com.Proyectousa.Desmotivados.Entidades.User;
import com.Proyectousa.Desmotivados.Modelos.PouModelo;
import com.Proyectousa.Desmotivados.Modelos.TiendaModelos;
import com.Proyectousa.Desmotivados.Modelos.Usuario_modelos;

@RestController
@RequestMapping("/tienda")
public class TiendaControladores {

    @Autowired
    private TiendaModelos servicio;
    @Autowired
    private PouModelo servicioPou;
    @Autowired
    private Usuario_modelos servicioUsuario;

    @GetMapping("/retornaritems")
    public List<TiendaEntidades> getAllTiendaEntidades(){
        return servicio.getAllTienda();
    }

    @PostMapping("/guardar")
    public TiendaEntidades guardarArticulo(@RequestBody TiendaEntidades t){
        return servicio.save(t);
    }

    @GetMapping("/existentes")
    public List<PouEntidad> getItemsComprados(){
        return servicioPou.getAllPouEntidad();
    }

    @GetMapping("/monedas")
    public int monedas(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            User usuario = servicioUsuario.findByUsername(username);
            return usuario.getMonedas();
        }
        return -1;
    }

    @PostMapping("/comprar")
    public String guardarElPouEntidad(@RequestParam String descripcion, @RequestParam String imagen, @RequestParam String tipo, @RequestParam int precio){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            User usuario = servicioUsuario.findByUsername(username);

            int monedas = usuario.getMonedas();

            if((monedas - precio) < 0){
                return "insuficiente";
            }else{
                PouEntidad item = new PouEntidad();

                item.setDescripcionItem(descripcion);
                item.setEquipadoItem(false);
                item.setImagenItem(imagen);
                item.setTipoItem(tipo);
                item.setUsername(usuario);
                monedas -= precio;
                usuario.setMonedas(monedas);
                servicioPou.save(item);
                return "guardado";
            }
        }else{
            return "Usuario no encontrado";
        }
    }

    @DeleteMapping("/eliminarTienda/{id}")
    public ResponseEntity<String> eliminarTienda(@PathVariable Long id){
        servicio.delete(id);
        return ResponseEntity.ok("Elemento eliminado correctamente");
    }

    @PutMapping("/editar") // Modified to accept idTienda as a path variable
    public void updateTienda(Long idTienda, // Use @PathVariable to map idTienda from URL
                            String imagenTiendaItem,
                            String descripcionTiendaItem,
                            String tipoTiendaItem,
                            Integer precio) {
        servicio.actualizarTienda(idTienda, imagenTiendaItem, descripcionTiendaItem, tipoTiendaItem, precio);
    }

    @GetMapping("/mostrar")
    public Optional<TiendaEntidades> mostrarTienda(Long id){
        return servicio.mostrarTienda(id);
    }
}
