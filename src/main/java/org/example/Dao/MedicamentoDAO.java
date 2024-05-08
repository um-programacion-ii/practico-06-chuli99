package org.example.Dao;
import org.example.Entidades.Medicamento;
import java.util.HashMap;
import java.util.Map;

public class MedicamentoDAO {
    private Map<String, Medicamento> medicamentos;

    public MedicamentoDAO() {
        medicamentos = new HashMap<>();
    }

    public void crearMedicamento(Medicamento medicamento) {
        medicamentos.put(medicamento.getNombre(), medicamento);
    }

    public Medicamento obtenerMedicamento(String nombre) {
        return medicamentos.get(nombre);
    }
}