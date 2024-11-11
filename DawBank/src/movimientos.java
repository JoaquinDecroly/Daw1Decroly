public class movimientos {


    // atributos
    private double ingreso;
    private double gasto;
    private int cantidadMovimientos;
    private String fecha;

    // constructor
    public movimientos(double ingreso, double gasto, double saldo, int cantidadMovimientos, String fecha) {
        this.ingreso = ingreso;
        this.gasto = gasto;
        this.cantidadMovimientos = cantidadMovimientos;
        cantidadMovimientos = 0;
        cantidadMovimientos++;
        
        this.fecha = fecha;
    }

    // métodos getter y setter
    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }

    public double getGasto() {
        return gasto;
    }

    public void setGasto(double gasto) {
        this.gasto = gasto;
    }


    public int getCantidadMovimientos() {
        return cantidadMovimientos;
    }

    public String getFecha() {
        return fecha;
    }

}



