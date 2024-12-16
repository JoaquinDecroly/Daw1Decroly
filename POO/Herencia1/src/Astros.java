public class Astros {
private double radio;
private double rotacion;
private double masa;
private double temp;
private double gravedad;

//constructor
public Astros(double radio, double rotacion, double masa, double temp, double gravedad) {
    this.radio = radio;
    this.rotacion = rotacion;
    this.masa = masa;
    this.temp = temp;
    this.gravedad = gravedad;
}

//getters
public double getRadio() {
    return radio;
}

public void setRadio(double radio) {
    this.radio = radio;
}

public double getRotacion() {
    return rotacion;
}

public void setRotacion(double rotacion) {
    this.rotacion = rotacion;
}

public double getMasa() {
    return masa;
}

public void setMasa(double masa) {
    this.masa = masa;
}

public double getTemp() {
    return temp;
}

public void setTemp(double temp) {
    this.temp = temp;
}

public double getGravedad() {
    return gravedad;
}

public void setGravedad(double gravedad) {
    this.gravedad = gravedad;
}

//metodos

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Astros{");
        sb.append("radio=").append(radio);
        sb.append(", rotacion=").append(rotacion);
        sb.append(", masa=").append(masa);
        sb.append(", temp=").append(temp);
        sb.append(", gravedad=").append(gravedad);
        sb.append('}');
        return sb.toString();
    }









}
