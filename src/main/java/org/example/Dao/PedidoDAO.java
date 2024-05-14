package org.example.Dao;

import org.example.Entidades.Pedido;

import java.util.HashMap;
import java.util.Map;

public class PedidoDAO {
    private Map<Integer, Pedido> pedidos = new HashMap<>();

    public void guardarPedido(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
    }

    public Pedido obtenerPedido(int id) {
        return pedidos.get(id);
    }

    public void actualizarPedido(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
    }

    public void eliminarPedido(int id) {
        pedidos.remove(id);
    }

    public int getNextId() {
        return pedidos.size() + 1;
    }
}