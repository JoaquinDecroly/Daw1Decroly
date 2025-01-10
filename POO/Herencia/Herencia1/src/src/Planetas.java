

public class Planetas extends Astros {

    // Atributos

    private double distanciaAlSol;

    private String orbitaAlSol;

    private boolean tieneSatelites;


    // Constructor

    public Planetas(double radioEcuatorial, double rotacionSobreSuEje, double masa, double temperaturaMedia, double gravedad, double distanciaAlSol, String orbitaAlSol, boolean tieneSatelites) {

        super(radioEcuatorial, rotacionSobreSuEje, masa, temperaturaMedia, gravedad);

        this.distanciaAlSol = distanciaAlSol;

        this.orbitaAlSol = orbitaAlSol;

        this.tieneSatelites = tieneSatelites;

    }


    // Getters

    public double getDistanciaAlSol() {

        return distanciaAlSol;

    }


    public String getOrbitaAlSol() {

        return orbitaAlSol;

    }


    public boolean isTieneSatelites() {

        return tieneSatelites;

    }


    

    public void muestra() {

        System.out.println("Planeta: ");

        System.out.println("Radio Ecuatorial: " + getRadioEcuatorial());

        System.out.println("Rotación sobre su eje: " + getRotacionSobreSuEje());

        System.out.println("Masa: " + getMasa());

        System.out.println("Temperatura Media: " + getTemperaturaMedia());

        System.out.println("Gravedad: " + getGravedad());

        System.out.println("Distancia al Sol: " + distanciaAlSol);

        System.out.println("Órbita al Sol: " + orbitaAlSol);

        System.out.println("Tiene Satélites: " + tieneSatelites);

    }

}