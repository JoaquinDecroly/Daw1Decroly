public abstract class Astros {

    // Atributos

    private double radioEcuatorial;

    private double rotacionSobreSuEje;

    private double masa;

    private double temperaturaMedia;

    private double gravedad;


    // Constructor

    public Astros(double radioEcuatorial, double rotacionSobreSuEje, double masa, double temperaturaMedia, double gravedad) {

        this.radioEcuatorial = radioEcuatorial;

        this.rotacionSobreSuEje = rotacionSobreSuEje;

        this.masa = masa;

        this.temperaturaMedia = temperaturaMedia;

        this.gravedad = gravedad;

    }


    // Getters

    public double getRadioEcuatorial() {

        return radioEcuatorial;

    }


    public double getRotacionSobreSuEje() {

        return rotacionSobreSuEje;

    }


    public double getMasa() {

        return masa;

    }


    public double getTemperaturaMedia() {

        return temperaturaMedia;

    }


    public double getGravedad() {

        return gravedad;

    }


    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Astros{");
        sb.append("radioEcuatorial=").append(radioEcuatorial);
        sb.append(", rotacionSobreSuEje=").append(rotacionSobreSuEje);
        sb.append(", masa=").append(masa);
        sb.append(", temperaturaMedia=").append(temperaturaMedia);
        sb.append(", gravedad=").append(gravedad);
        sb.append('}');
        return sb.toString();
    }

}