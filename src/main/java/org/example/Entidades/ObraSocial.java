package org.example.Entidades;

public class ObraSocial {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ObraSocial(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ObraSocial{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
