import org.example.Servicios.GestionTurnoService;
import org.example.Dao.MedicoDAO;
import org.example.Entidades.Especialidad;
import org.example.Entidades.Medico;
import org.example.Entidades.ObraSocial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GestionTurnoServiceTest {
    private GestionTurnoService gestionTurnoService;
    private MedicoDAO medicoDao;

    @BeforeEach
    public void setUp() {
        medicoDao = Mockito.mock(MedicoDAO.class);
        gestionTurnoService = new GestionTurnoService(medicoDao);
    }

    @Test
    public void testListarMedicosPorEspecialidad() {
        Especialidad especialidad = new Especialidad("Cardiología");
        ObraSocial obraSocial = new ObraSocial("OSDE");
        Medico medico1 = new Medico("Dr. Juan", especialidad, Arrays.asList(obraSocial), false);
        Medico medico2 = new Medico("Dr. Pedro", especialidad, Arrays.asList(obraSocial), false);

        when(medicoDao.listarMedicosPorEspecialidad(especialidad)).thenReturn(Arrays.asList(medico1, medico2));

        List<Medico> result = gestionTurnoService.listarMedicosPorEspecialidad(especialidad, obraSocial);

        assertEquals(2, result.size());
        assertEquals(medico1, result.get(0));
        assertEquals(medico2, result.get(1));
    }

    @Test
    public void testListarMedicos() {
        Especialidad especialidad = new Especialidad("Cardiología");
        ObraSocial obraSocial = new ObraSocial("OSDE");
        Medico medico1 = new Medico("Dr. Juan", especialidad, Arrays.asList(obraSocial), false);
        Medico medico2 = new Medico("Dr. Pedro", especialidad, Arrays.asList(obraSocial), false);

        when(medicoDao.listarMedicos()).thenReturn(Arrays.asList(medico1, medico2));

        List<Medico> result = gestionTurnoService.listarMedicos();

        assertEquals(2, result.size());
        assertEquals(medico1, result.get(0));
        assertEquals(medico2, result.get(1));
    }

    @Test
    public void testIniciarTurno() {
        Especialidad especialidad = new Especialidad("Cardiología");
        ObraSocial obraSocial = new ObraSocial("OSDE");
        Medico medico = new Medico("Dr. Juan", especialidad, Arrays.asList(obraSocial), false);

        assertEquals(1, gestionTurnoService.iniciarTurno(null, medico).getId());
    }

    @Test
    public void testFinalizarTurno() {
        Especialidad especialidad = new Especialidad("Cardiología");
        ObraSocial obraSocial = new ObraSocial("OSDE");
        Medico medico = new Medico("Dr. Juan", especialidad, Arrays.asList(obraSocial), false);

        assertEquals(null, gestionTurnoService.finalizarTurno(null));
    }

}