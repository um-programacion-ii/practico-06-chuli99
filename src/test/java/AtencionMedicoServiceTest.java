import org.example.Dao.MedicoDAO;
import org.example.Dao.TurnoDAO;
import org.example.Entidades.*;
import org.example.Servicios.AtencionMedicoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AtencionMedicoServiceTest {
    private AtencionMedicoService atencionMedicoService;
    private MedicoDAO medicoDao;
    private TurnoDAO turnoDao;

    @BeforeEach
    public void setUp() {
        medicoDao = Mockito.mock(MedicoDAO.class);
        turnoDao = Mockito.mock(TurnoDAO.class);
        atencionMedicoService = new AtencionMedicoService(medicoDao, turnoDao);
    }

    @Test
    public void testListarMedicosParticulares() {
        Especialidad especialidad = new Especialidad("Cardiología");
        ObraSocial obraSocial = new ObraSocial("OSDE");
        Medico medico1 = new Medico("Dr. Juan", especialidad, Arrays.asList(obraSocial), true);
        Medico medico2 = new Medico("Dr. Pedro", especialidad, Arrays.asList(obraSocial), true);

        when(medicoDao.listarMedicos()).thenReturn(Arrays.asList(medico1, medico2));

        List<Medico> result = atencionMedicoService.listarMedicosParticulares();

        assertEquals(2, result.size());
        assertEquals(medico1, result.get(0));
        assertEquals(medico2, result.get(1));
    }

    @Test
    public void testListarMedicosPorEspecialidadYObraSocial() {
        Especialidad especialidad = new Especialidad("Cardiología");
        ObraSocial obraSocial = new ObraSocial("OSDE");
        Medico medico1 = new Medico("Dr. Juan", especialidad, Arrays.asList(obraSocial), true);
        Medico medico2 = new Medico("Dr. Pedro", especialidad, Arrays.asList(obraSocial), true);

        when(medicoDao.listarMedicosPorEspecialidad(especialidad)).thenReturn(Arrays.asList(medico1, medico2));

        List<Medico> result = atencionMedicoService.listarMedicosPorEspecialidadYObraSocial(especialidad, obraSocial);

        assertEquals(2, result.size());
        assertEquals(medico1, result.get(0));
        assertEquals(medico2, result.get(1));
    }

    @Test
    public void testIniciarTurno() {
        Paciente paciente = new Paciente("Juan", "Perez",new ObraSocial("OSDE"));
        Medico medico = new Medico("Dr. Juan", new Especialidad("Cardiología"), Arrays.asList(new ObraSocial("OSDE")), true);
        Turno turno = new Turno(1, paciente, medico, paciente.getObraSocial(), null, true);

        when(turnoDao.getNextid()).thenReturn(1);

        Turno result = atencionMedicoService.iniciarTurno(paciente, medico);

        assertEquals(turno, result);
    }

    @Test
    public void testFinalizarTurno() {
        Paciente paciente = new Paciente("Juan", "Perez",new ObraSocial("OSDE"));
        Medico medico = new Medico("Dr. Juan", new Especialidad("Cardiología"), Arrays.asList(new ObraSocial("OSDE")), true);
        Turno turno = new Turno(1, paciente, medico, paciente.getObraSocial(), null, true);

        Receta receta = new Receta();
        receta.getMedicamentos().add(new Medicamento("Medicamento 1", 1));
        receta.getMedicamentos().add(new Medicamento("Medicamento 2", 2));

        turno.setReceta(receta);

        Receta result = atencionMedicoService.finalizarTurno(turno);

        assertEquals(receta, result);
    }

    @Test
    public void testGenerarRecetaAleatoria() {
        Receta receta = atencionMedicoService.generarRecetaAleatoria();

        assertEquals(1, receta.getMedicamentos().size());
    }


}