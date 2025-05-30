package com.decroly.practicaexamen1;

import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = -1284537229497662166L;
    
    private int id;
    private static int contador = 0;
    private String nombre;
    private String apellido;
    private String telefono;
    private Estudio estudio;

    public Cliente(String nombre, String apellido, String telefono, Estudio estudio) {
        this.id = contador++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.estudio = estudio;
    }

    public Cliente(int id, String nombre, String apellido, String telefono, Estudio estudio) {
        this.id = contador++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.estudio = estudio;
    }
    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    @Override
    public String toString() {
        return id + "\t" +
                nombre + "\t" +
                apellido + "\t" +
                telefono + "\t" +
                estudio;
    }
}
