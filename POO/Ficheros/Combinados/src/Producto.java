import java.io.Serializable;

public class Producto implements Serializable {
   private static final long serialVersionUID = 6594629875724918237L;

    private String referencia;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private String tipo;
    private double precio;
    private int descuento; 
    private int IVA; 
    private boolean aplicarDto;    

//constructor general
    public Producto(String referencia, String nombre, String descripcion, String tipo, int cantidad, double precio,
			int descuento, int iVA, boolean aplicarDto) {
                this.referencia = referencia;
                this.nombre = nombre;
                this.descripcion = descripcion;
                this.cantidad = cantidad;
                this.tipo = tipo;
            this.precio = calcularPrecioFinal();
            this.descuento = calcularDescuento();
            IVA = calcularIVA();
            this.aplicarDto = aplicarDto;
	}
//constructor unicode
    public Producto(String referencia, String nombre, String descripcion, String tipo){
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;  
    }

//constructor binario
 public Producto(int cantidad, double precio, int descuento, int iVA, boolean aplicarDto) {
    this.precio = calcularPrecioFinal();
    this.descuento = calcularDescuento();
    IVA = calcularIVA();
    this.aplicarDto = aplicarDto;
    }

    // Getters
	public String getReferencia() {
        return referencia;
    }

    public String getNombre() {
        return nombre;
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

 public boolean isAplicarDto() {
        return aplicarDto;
    }
    // Setters
    
   

    public void setIVA(int iVA) {
        IVA = iVA;
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
    private int calcularDescuento() {
        if (aplicarDto) {
            return (int)(precio * (descuento / 100.0));
        }
        return 0;
    }

    // Método para calcular el IVA aplicado
    private int calcularIVA() {
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

