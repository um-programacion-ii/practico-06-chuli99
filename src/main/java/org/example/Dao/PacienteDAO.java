package org.example.Dao;
import org.example.Entidades.Paciente;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
public class PacienteDAO {
    private Map<String,Paciente> pacientes = new HashMap<>();

    public void crearPaciente(Paciente paciente){
        if (pacientes.containsKey(paciente.getNombre())){
            throw new IllegalArgumentException("El paciente ya existe.");
        }
        pacientes.put(paciente.getNombre(),paciente);
    }
    public Paciente obtenerPaciente(String nombre){
        return pacientes.get(nombre);
    }

    public void actualizarPaciente(Paciente paciente){
        if (!pacientes.containsKey(paciente.getNombre())){
            throw new IllegalArgumentException("El paciente no existe.");
        }
        pacientes.put(paciente.getNombre(),paciente);
    }

    public void eliminarPaciente(String nombre){
        pacientes.remove(nombre);
    }

    public List<Paciente> listarPacientes(){
        return pacientes.values().stream().collect(Collectors.toList());
    }
}
