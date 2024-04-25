package com.Proyectousa.Desmotivados.PublicoControlador;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
     String nombre;

     String apellido;

     String username;

     String universidad;

     String carrera;

     Integer semestre;

     String nmascota;

     String password;
     
     String intereses;

     Integer monedas;
}
