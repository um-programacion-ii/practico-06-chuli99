package org.example.Entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turno {
    private Integer id;
    private Paciente paciente;
    private Medico medico;
    private ObraSocial obraSocial;
    private Receta receta;
    private Boolean estado;
}
