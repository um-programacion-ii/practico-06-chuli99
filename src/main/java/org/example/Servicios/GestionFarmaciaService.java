package org.example.Servicios;

import org.example.Dao.CompraDAO;
import org.example.Dao.PedidoDAO;
import org.example.Dao.MedicamentoDAO;
import org.example.Entidades.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestionFarmaciaService {
    private CompraDAO compraDao = new CompraDAO();
    private PedidoDAO pedidoDao = new PedidoDAO();
    private MedicamentoDAO medicamentoDao = new MedicamentoDAO();

    public Compra iniciarCompra(Paciente paciente, List<Medicamento> medicamentos) {
        Compra compra = new Compra(compraDao.getNextId(), paciente, true, medicamentos);
        compraDao.guardarCompra(compra);
        return compra;
    }

    public Compra finalizarCompra(Compra compra) {
        compra.setEstado(false);
        compraDao.actualizarCompra(compra);
        return compra;
    }

    public Pedido iniciarPedido(List<Medicamento> medicamentos) {
        Pedido pedido = new Pedido(pedidoDao.getNextId(), medicamentos, true);
        pedidoDao.guardarPedido(pedido);
        return pedido;
    }

    public Pedido finalizarPedido(Pedido pedido) {
        pedido.setEstado(false);
        pedidoDao.actualizarPedido(pedido);
        return pedido;
    }

    public boolean solicitarMedicamento(Medicamento medicamento) {
        Optional<Medicamento> medicamentoEnStock = Optional.ofNullable(medicamentoDao.obtenerMedicamento(medicamento.getNombre()));
        if (medicamentoEnStock.isPresent()) {
            return true;
        } else {
            iniciarPedido((List<Medicamento>) medicamento);
            return false;
        }
    }
}