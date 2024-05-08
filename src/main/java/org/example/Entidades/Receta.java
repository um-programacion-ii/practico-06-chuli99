package org.example.Entidades;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Receta {
    private List<Medicamento> medicamentos;

    public Receta(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
}
