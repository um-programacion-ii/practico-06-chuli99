package org.example.Dao;

import org.example.Entidades.Compra;

import java.util.HashMap;
import java.util.Map;

public class CompraDAO {
    private Map<Integer, Compra> compras = new HashMap<>();

    public void guardarCompra(Compra compra) {
        compras.put(compra.getId(), compra);
    }

    public Compra obtenerCompra(int id) {
        return compras.get(id);
    }

    public void actualizarCompra(Compra compra) {
        compras.put(compra.getId(), compra);
    }

    public void eliminarCompra(int id) {
        compras.remove(id);
    }

    public int getNextId() {
        return compras.size() + 1;
    }
}