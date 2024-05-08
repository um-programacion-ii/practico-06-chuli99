package org.example.Entidades;

public class Medico {
    private String nombre;
    private Especialidad especialidad;
    private ObraSocial obraSocial;
    private Boolean particular;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }

    public Boolean getParticular() {
        return particular;
    }

    public void setParticular(Boolean particular) {
        this.particular = particular;
    }

    public Medico(String nombre, Especialidad especialidad, ObraSocial obraSocial, Boolean particular) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.obraSocial = obraSocial;
        this.particular = particular;
    }
}
