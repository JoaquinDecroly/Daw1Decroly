package com.decroly.vetdawexam.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Consulta implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String fecha;
    private double duracion;
    private String observaciones;
    private List<Mascota> mascota;

    public Consulta(String fecha, double duracion, String observaciones, List<Mascota> mascota) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.observaciones = observaciones;
        this.mascota = new LinkedList<>();
    }
    


    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<Mascota> getMascota() {
        return mascota;
    }

    public void setMascota(List<Mascota> mascota) {
        this.mascota = mascota;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", fecha=" + fecha +
                ", duracion=" + duracion +
                ", observaciones='" + observaciones + '\'' +
                ", mascota=" + mascota;
    }
}
