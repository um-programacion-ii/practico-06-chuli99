package org.example.Servicios;

import org.example.Dao.CompraDAO;
import org.example.Dao.MedicamentoDAO;
import org.example.Dao.PedidoDAO;
import org.example.Entidades.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GestionFarmaciaServiceTest {
    private GestionFarmaciaService gestionFarmaciaService;
    private Paciente paciente;
    private Medicamento medicamento;
    private List<Medicamento> medicamentos;

    @BeforeEach
    void setUp() {
        gestionFarmaciaService = new GestionFarmaciaService();
        paciente = new Paciente();
        medicamento = new Medicamento();
        medicamentos = new ArrayList<>();
        medicamentos.add(medicamento);
    }

    @Test
    void iniciarCompra() {
        Compra compra = gestionFarmaciaService.iniciarCompra(paciente, medicamentos);
        assertNotNull(compra);
        assertEquals(paciente, compra.getPaciente());
        assertTrue(compra.isEstado());
        assertEquals(medicamentos, compra.getMedicamentos());
    }

    @Test
    void finalizarCompra() {
        Compra compra = gestionFarmaciaService.iniciarCompra(paciente, medicamentos);
        Compra compraFinalizada = gestionFarmaciaService.finalizarCompra(compra);
        assertNotNull(compraFinalizada);
        assertFalse(compraFinalizada.isEstado());
    }

    @Test
    void iniciarPedido() {
        Pedido pedido = gestionFarmaciaService.iniciarPedido(medicamentos);
        assertNotNull(pedido);
        assertTrue(pedido.isEstado());
        assertEquals(medicamentos, pedido.getMedicamentos());
    }

    @Test
    void finalizarPedido() {
        Pedido pedido = gestionFarmaciaService.iniciarPedido(medicamentos);
        Pedido pedidoFinalizado = gestionFarmaciaService.finalizarPedido(pedido);
        assertNotNull(pedidoFinalizado);
        assertFalse(pedidoFinalizado.isEstado());
    }

    @Test
    void solicitarMedicamento() {
        boolean resultado = gestionFarmaciaService.solicitarMedicamento(medicamento);
        assertTrue(resultado);
    }
}