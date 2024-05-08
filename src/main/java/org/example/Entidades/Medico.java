package org.example.Entidades;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medico {
    private String nombre;
    private Especialidad especialidad;
    private List<ObraSocial> obraSociales;
    private Boolean particular;

}
