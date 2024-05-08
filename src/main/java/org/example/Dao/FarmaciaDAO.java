package org.example.Dao;
import org.example.Entidades.Farmacia;
import org.example.Entidades.Medicamento;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FarmaciaDAO {

    // Simulamos el stock de la farmacia con un Map (Medicamento -> Cantidad)
    private Map<Medicamento, Integer> stockFarmacia = new HashMap<>();

    public void actualizarStock(Medicamento medicamento, int cantidad) {
        // Verificamos si el medicamento ya existe en el stock
        if (stockFarmacia.containsKey(medicamento)) {
            // Si existe, actualizamos la cantidad
            int cantidadActual = stockFarmacia.get(medicamento);
            stockFarmacia.put(medicamento, cantidadActual + cantidad);
        } else {
            // Si no existe, lo agregamos al stock
            stockFarmacia.put(medicamento, cantidad);
        }
    }

    public int obtenerCantidadDisponible(Medicamento medicamento) {
        // Devolvemos la cantidad disponible del medicamento en el stock
        return stockFarmacia.getOrDefault(medicamento, 0);
    }

    public void disminuirStock(Medicamento medicamento, int cantidad) {
        int cantidadActual = stockFarmacia.get(medicamento);
        if (cantidadActual >= cantidad) {
            stockFarmacia.put(medicamento, cantidadActual - cantidad);
        } else {
            throw new RuntimeException("No hay suficiente stock del medicamento: " + medicamento.getNombre());
        }
    }

    // Método para obtener la lista de medicamentos en stock (opcional, para mostrar información)
    public List<Medicamento> obtenerMedicamentosEnStock() {
        return stockFarmacia.keySet().stream().toList();
    }
}