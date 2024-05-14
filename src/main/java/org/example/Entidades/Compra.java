package org.example.Entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compra {
    private int id;
    private Paciente paciente;
    private boolean estado;
    private List<Medicamento> medicamentos;
}