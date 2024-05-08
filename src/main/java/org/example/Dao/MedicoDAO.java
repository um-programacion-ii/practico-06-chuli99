package org.example.Dao;
import org.example.Entidades.Medico;
import org.example.Entidades.Especialidad;
import org.example.Entidades.ObraSocial;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MedicoDAO {

    private Map<String, Medico> medicos = new HashMap<>();

    public void crearMedico(Medico medico) {
        medicos.put(medico.getNombre(), medico);
    }

    public Medico obtenerMedico(String nombre) {
        return medicos.get(nombre);
    }

    public void actualizarMedico(Medico medico) {
        medicos.put(medico.getNombre(), medico); // Reemplaza al médico existente
    }

    public void eliminarMedico(String nombre) {
        medicos.remove(nombre);
    }

    public List<Medico> listarMedicos() {
        return medicos.values().stream().collect(Collectors.toList());
    }

    public List<Medico> listarMedicosPorEspecialidad(Especialidad especialidad) {
        return medicos.values().stream()
                .filter(medico -> medico.getEspecialidad().equals(especialidad))
                .collect(Collectors.toList());
    }

    public List<Medico> listarMedicosPorObraSocial(ObraSocial obraSocial) {
        return medicos.values().stream()
                .filter(medico -> medico.getObraSociales().contains(obraSocial))
                .collect(Collectors.toList());
    }

//    public List<Medico> listarMedicosParticulares() {
//        return medicos.values().stream()
//                .filter(Medico::isAtiendeParticular)
//                .collect(Collectors.toList());
//    }
}