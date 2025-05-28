package com.decroly.vetdawexam.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Mascota implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    
    private String pasaporte;
    private String nombre;
    private String peso;
    private String fechaNacimiento;
    private Tipo tipos;
    private List<Persona> personas;

    public Mascota(String pasaporte, String nombre, String peso, String fechaNacimiento, List<Persona> personas, Tipo tipos) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.peso = peso;
        this.fechaNacimiento = fechaNacimiento;
        this.personas = new LinkedList<>();
        this.tipos = tipos;
    }

    public Mascota(String pasaporte, String nombre, String fechaNacimiento) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Tipo getTipos() {
        return tipos;
    }

    @Override
    public String toString() {
        return "pasaporte='" + pasaporte + '\'' +
                ", nombre='" + nombre + '\'' +
                ", peso='" + peso + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", tipos=" + tipos +
                ", personas=" + personas;
    }
}
