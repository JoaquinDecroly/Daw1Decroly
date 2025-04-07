package com.decroly;

import java.util.Objects;

public class Producto {
    static int id;
    static String ref;
    static String nombre;
    static String desc;
    int tipo;
    static int cantidad;
    static double precio;
    static int descuento;
    int iva;
    static boolean aplicarDto;

    public Producto(int id, String ref, String nombre, String desc, int tipo, int cantidad,
                    double precio, int descuento, int iva, boolean aplicarDto) {
        if (cantidad != 0 && precio != 0 && descuento != 0 && iva != 0) {
            this.ref = ref;
            this.nombre = nombre;
            this.desc = desc;
            this.tipo = tipo;
            this.cantidad = cantidad;
            this.precio = precio;
            this.descuento = descuento;
            this.iva = iva;
            this.aplicarDto = aplicarDto;
        }
    }

    public static int getId() {
        return id;
    }

    public static String getRef() {
        return ref;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getDesc() {
        return desc;
    }

    public int getTipo() {
        return tipo;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public static double getPrecio() {
        return precio;
    }

    public static int getDescuento() {
        return descuento;
    }

    public int getIva() {
        return iva;
    }

    public static boolean isAplicarDto() {
        return aplicarDto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public void setAplicarDto(boolean aplicarDto) {
        this.aplicarDto = aplicarDto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "productos{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", nombre='" + nombre + '\'' +
                ", desc='" + desc + '\'' +
                ", tipo=" + tipo +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", descuento=" + descuento +
                ", iva=" + iva +
                ", aplicarDto=" + aplicarDto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(nombre, producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    public int compareTo(Producto p) {
        return Integer.compare(id, p.getIva());
    }
}

