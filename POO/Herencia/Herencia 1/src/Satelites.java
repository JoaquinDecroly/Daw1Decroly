public class Satelites extends Astros {
    private double distanciaPlaneta;
    private double orbita;
    private String planetaPerteneciente;

    public Satelites(double distanciaPlaneta, double orbita, String planetaPerteneciente, double radio, double rotacion, double masa, double temp, double gravedad) {
        super(radio, rotacion, masa, temp, gravedad);
        this.distanciaPlaneta = distanciaPlaneta;
        this.orbita = orbita;
        this.planetaPerteneciente = planetaPerteneciente;
    }

    public double getDistanciaPlaneta() {
        return distanciaPlaneta;
    }

    public void setDistanciaPlaneta(long distanciaPlaneta) {
        this.distanciaPlaneta = distanciaPlaneta;
    }

    public double getOrbita() {
        return orbita;
    }

    public String getPlanetaPerteneciente() {
        return planetaPerteneciente;
    }

   @Override
public String toString() {
    return String.format("Satelites{%s, distanciaPlaneta=%.2f, orbita=%.2f, planetaPerteneciente='%s'}",
            super.toString(), distanciaPlaneta, orbita, planetaPerteneciente);
}



}
