public class Producto {
    private String referencia;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private String tipo;
    private double precio;
    private int descuento; 
    private int IVA; 
    private boolean aplicarDto;

    public Producto(String referencia, String nombre, String descripcion, String tipo) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.referencia = referencia;
        this.tipo = tipo;
    }

    public Producto(String referencia, String nombre, String descripcion, String tipo, int cantidad, double precio,
            int descuento, int iVA, boolean aplicarDto) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.precio = precio;
        this.descuento = descuento;
        IVA = iVA;
        this.aplicarDto = aplicarDto;
    }

    Producto(int cantidad, double precio, int descuento, int iVA, boolean aplicarDto) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        IVA = iVA;
        this.aplicarDto = aplicarDto;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("referencia=").append(referencia);
        sb.append(", nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", tipo=").append(tipo);
        sb.append(", precio=").append(precio);
        sb.append(", descuento=").append(descuento);
        sb.append(", IVA=").append(IVA);
        sb.append(", aplicarDto=").append(aplicarDto);
        sb.append('}');
        return sb.toString();
    }

    



}
