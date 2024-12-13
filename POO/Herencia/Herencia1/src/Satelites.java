public class Satelites extends Astros {
    private long distanciaPlaneta;
    private double orbita;
    private String planetaPerteneciente;

    public Satelites(long distanciaPlaneta, double orbita, String planetaPerteneciente, double radio, double rotacion, double masa, double temp, double gravedad) {
        super(radio, rotacion, masa, temp, gravedad);
        this.distanciaPlaneta = distanciaPlaneta;
        this.orbita = orbita;
        this.planetaPerteneciente = planetaPerteneciente;
    }

    public long getDistanciaPlaneta() {
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
        StringBuilder sb = new StringBuilder();
        sb.append("Satelites{");
        sb.append(super.toString());
        sb.append("distanciaPlaneta=").append(distanciaPlaneta);
        sb.append(", orbita=").append(orbita);
        sb.append(", planetaPerteneciente=").append(planetaPerteneciente);
        sb.append('}');
        return sb.toString();
    }



}
