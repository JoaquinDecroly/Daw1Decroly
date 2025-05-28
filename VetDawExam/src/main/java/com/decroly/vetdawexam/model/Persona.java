package com.decroly.vetdawexam.model;

import java.io.Serial;
import java.io.Serializable;

public class Persona implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String email;

    public Persona(String dni, String nombre, String apellido, String telefono, String direccion, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }
    
    public Persona(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'';
    }

//    @Override
//    public String toString() {
//        return "dni='" + dni + '\'' +
//                ", nombre='" + nombre + '\'' +
//                ", apellido='" + apellido + '\'';
//    }
}
