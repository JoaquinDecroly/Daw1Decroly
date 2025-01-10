

public class Satelites extends Astros {

    // Atributos

    private double distanciaAlPlaneta;

    private String orbitaPlanetaria;

    private String planetaAlQuePertenece;


    // Constructor

    public Satelites(double radioEcuatorial, double rotacionSobreSuEje, double masa, double temperaturaMedia, double gravedad, double distanciaAlPlaneta, String orbitaPlanetaria, String planetaAlQuePertenece) {

        super(radioEcuatorial, rotacionSobreSuEje, masa, temperaturaMedia, gravedad);

        this.distanciaAlPlaneta = distanciaAlPlaneta;

        this.orbitaPlanetaria = orbitaPlanetaria;

        this.planetaAlQuePertenece = planetaAlQuePertenece;

    }


    // Getters

    public double getDistanciaAlPlaneta() {

        return distanciaAlPlaneta;

    }


    public String getOrbitaPlanetaria() {

        return orbitaPlanetaria;

    }


    public String getPlanetaAlQuePertenece() {

        return planetaAlQuePertenece;

    }


    

    public void muestra() {

        System.out.println("Satélite: ");

        System.out.println("Radio Ecuatorial: " + getRadioEcuatorial());

        System.out.println("Rotación sobre su eje: " + getRotacionSobreSuEje());

        System.out.println("Masa: " + getMasa());

        System.out.println("Temperatura Media: " + getTemperaturaMedia());

        System.out.println("Gravedad: " + getGravedad());

        System.out.println("Distancia al Planeta: " + distanciaAlPlaneta);

        System.out.println("Órbita Planetaria: " + orbitaPlanetaria);

        System.out.println("Planeta al que pertenece: " + planetaAlQuePertenece);

    }

}



