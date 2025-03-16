import java.io.Serializable;

public class Producto implements Serializable {
      private static final long serialVersionUID = 6594629875724918237L;

    private String referencia;
    private String descripcion;
    private String tipo;
    private int cantidad;
    private double precio;
    private int descuento; // Porcentaje de descuento
    private int IVA; // Porcentaje de IVA
    private boolean aplicarDto;

    public Producto(String referencia, String descripcion, String tipo, int cantidad, double precio, int descuento,
                    int iVA, boolean aplicarDto) {
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = calcularPrecioFinal();
        this.descuento = calcularDescuento();
         iVA = calcularIVA();
        this.aplicarDto = aplicarDto;
    }


	// Getters
    public String getReferencia() {
        return referencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDescuento() {
        return descuento;
    }

    public int getIVA() {
        return IVA;
    }

    // Setters
    public boolean isAplicarDto() {
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

    // Método para calcular el descuento aplicado
    public int calcularDescuento() {
        if (aplicarDto) {
            return (int)(precio * (descuento / 100.0));
        }
        return 0;
    }

    // Método para calcular el IVA aplicado
    public int calcularIVA() {
        return (int)(precio * (IVA / 100.0));
    }

    // Método para calcular el precio final
    public final double calcularPrecioFinal() {
        double descuentoAplicado = calcularDescuento();
        double ivaAplicado = calcularIVA();
        return (precio - descuentoAplicado) + ivaAplicado;
    }

    @Override
    public String toString() {
        return "Referencia: " + referencia +
               "\nDescripción: " + descripcion +
               "\nTipo: " + tipo +
               "\nCantidad: " + cantidad +
               "\nPrecio original: " + precio +
               "\nDescuento aplicado: " + calcularDescuento() +
               "\nIVA aplicado: " + calcularIVA() +
               "\nPrecio final: " + calcularPrecioFinal();
    }
}
