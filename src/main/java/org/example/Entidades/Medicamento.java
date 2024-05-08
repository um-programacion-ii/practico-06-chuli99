package org.example.Entidades;

public class Medicamento {
    private String nombre;
    private Integer cantidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Medicamento(String nombre, Integer cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
}
