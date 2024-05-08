package org.example.Dao;
import org.example.Entidades.Receta;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class RecetaDAO {
    private Map<Integer, Receta> recetas = new HashMap<>();

    public void guardarReceta(Integer idTurno, Receta receta) {
        recetas.put(idTurno, receta);
    }

    public Receta obtenerReceta(Integer idTurno) {
        return recetas.get(idTurno);
    }

    public void actualizarReceta(Integer idTurno, Receta receta) {
        recetas.put(idTurno, receta);
    }

    public void eliminarReceta(Integer idTurno) {
        recetas.remove(idTurno);
    }

    public List<Receta> listarRecetas() {
        return new ArrayList<>(recetas.values());
    }
}