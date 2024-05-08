package org.example.Dao;
import org.example.Entidades.Turno;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TurnoDAO {

    private Map<Integer, Turno> turnos = new HashMap<>(); // Simulamos una base de datos con un Map
    private static int contadorId = 1; // Contador para generar IDs únicos

    public void guardarTurno(Turno turno) {
        turno.setId(contadorId++); // Asignamos un ID único al turno
        turnos.put(turno.getId(), turno);
    }

    public Turno buscarTurno(int id) {
        return turnos.get(id);
    }

    public List<Turno> listarTurnos() {
        return turnos.values().stream().collect(Collectors.toList());
    }

    public void actualizarTurno(Turno turno) {
        turnos.put(turno.getId(), turno);
    }

    public void eliminarTurno(int id) {
        turnos.remove(id);
    }

}