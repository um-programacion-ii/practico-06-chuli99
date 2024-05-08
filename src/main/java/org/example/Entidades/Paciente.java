package org.example.Entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente{
    private String Nombre;
    private String Apellido;
    private ObraSocial obraSocial;
}
