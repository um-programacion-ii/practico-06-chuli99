package org.example.Servicios;

import org.example.Dao.MedicoDAO;
import org.example.Dao.TurnoDAO;
import org.example.Entidades.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GestionTurnoService {
    private MedicoDAO medicoDao = new MedicoDAO();

    private TurnoDAO turnoDao = new TurnoDAO();
    private Random random = new Random();

    public GestionTurnoService(MedicoDAO medicoDao) {
        this.medicoDao = medicoDao;
    }

    public List<Medico> listarMedicos() {
        return medicoDao.listarMedicos();
    }

    public List<Medico> listarMedicosPorEspecialidad(Especialidad especialidad, ObraSocial obraSocial) {
        return medicoDao.listarMedicosPorEspecialidad(especialidad).stream()
                .filter(medico -> medico.getObraSociales().contains(obraSocial))
                .collect(Collectors.toList());
    }

    public Turno iniciarTurno(Paciente paciente, Medico medico) {

        Turno turno = new Turno(turnoDao.getNextid(), paciente, medico, paciente.getObraSocial(), null, true);
        turnoDao.guardarTurno(turno);
        return turno;
    }

    public Receta finalizarTurno(Turno turno) {
        turno.setEstado(false);
        turnoDao.actualizarTurno(turno);
        return turno.getReceta();
    }

    public Receta generarRecetaAleatoria() {
        int cantidadMedicamentos = random.nextInt(5) + 1;
        Receta receta = new Receta();
        for (int i = 0; i < cantidadMedicamentos; i++) {
            Medicamento medicamento = new Medicamento("Medicamento " + (i + 1), random.nextInt(10) + 1);
            receta.getMedicamentos().add(medicamento);
        }
        return receta;
    }
}