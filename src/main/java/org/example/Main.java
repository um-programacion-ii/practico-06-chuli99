package org.example;

import org.example.Dao.*;
import org.example.Entidades.*;
import org.example.Servicios.GestionFarmaciaService;
import org.example.Servicios.AtencionMedicoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Crear instancias de las clases DAO
        MedicoDAO medicoDao = new MedicoDAO();
        TurnoDAO turnoDao = new TurnoDAO();
        MedicamentoDAO medicamentoDao = new MedicamentoDAO();
        PedidoDAO pedidoDao = new PedidoDAO();
        CompraDAO compraDao = new CompraDAO();

        //Crear una instancia del servicio
        GestionFarmaciaService gestionFarmaciaService = new GestionFarmaciaService();
        AtencionMedicoService atencionMedicoService = new AtencionMedicoService(medicoDao, turnoDao);

        //Crear un paciente
        Paciente paciente = new Paciente("Julian","Garcia", new ObraSocial("OSEP"));

        //Crear medicamentos
        Medicamento medicamento1 = new Medicamento("Ibuprofeno", 200);
        Medicamento medicamento2 = new Medicamento("Paracetamol", 500);

        //Agregar los medicamentos a una lista
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos.add(medicamento1);
        medicamentos.add(medicamento2);

        //Iniciar una compra
        Compra compra = gestionFarmaciaService.iniciarCompra(paciente, medicamentos);
        System.out.println("Compra iniciada: " + compra);

        //Finalizar la compra
        Compra compraFinalizada = gestionFarmaciaService.finalizarCompra(compra);
        System.out.println("Compra finalizada: " + compraFinalizada);

        //Iniciar un pedido
        Pedido pedido = gestionFarmaciaService.iniciarPedido(medicamentos);
        System.out.println("Pedido iniciado: " + pedido);

        //Finalizar el pedido
        Pedido pedidoFinalizado = gestionFarmaciaService.finalizarPedido(pedido);
        System.out.println("Pedido finalizado: " + pedidoFinalizado);

        //Solicitar un medicamento
        boolean resultado = gestionFarmaciaService.solicitarMedicamento(medicamento1);
        System.out.println("Medicamento solicitado: " + resultado);

        //Crear una especialidad
        Especialidad especialidad = new Especialidad("Cardiología");

        //Crear una obra social
        ObraSocial obraSocial = new ObraSocial("OSDE");

        //Crear un médico
        Medico medico1 = new Medico("Dr. Juan", especialidad, Arrays.asList(obraSocial), true);
        Medico medico2 = new Medico("Dr. Pedro", especialidad, Arrays.asList(obraSocial), true);

        //Listar médicos particulares
        List<Medico> medicosParticulares = atencionMedicoService.listarMedicosParticulares();
        System.out.println("Médicos particulares: " + medicosParticulares);

        //Listar médicos por especialidad y obra social
        List<Medico> medicosPorEspecialidadYObraSocial = atencionMedicoService.listarMedicosPorEspecialidadYObraSocial(especialidad, obraSocial);
        System.out.println("Médicos por especialidad y obra social: " + medicosPorEspecialidadYObraSocial);

        //Crear un paciente
        Paciente paciente2 = new Paciente("Juan", "Perez", new ObraSocial("OSDE"));

        //Iniciar un turno
        Turno turno = atencionMedicoService.iniciarTurno(paciente2, medico1);
        System.out.println("Turno iniciado: " + turno);

        //Finalizar un turno
        Receta receta = atencionMedicoService.finalizarTurno(turno);
        System.out.println("Turno finalizado: " + receta);



    }
}