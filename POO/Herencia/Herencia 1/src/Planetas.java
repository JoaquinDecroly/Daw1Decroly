public class Planetas extends Astros {

    private long distanciaSol;
    private boolean orbitaSol;
    private boolean tieneSatelites;

//constructor
    public Planetas(double radio, double rotacion, double masa, double temp, double gravedad, long distanciaSol,
        boolean orbitaSol, boolean tieneSatelites) {
        super(radio, rotacion, masa, temp, gravedad);
        this.distanciaSol = distanciaSol;
        this.orbitaSol = orbitaSol;
        this.tieneSatelites = tieneSatelites;
    }


//getters

    public long getDistanciaSol() {
        return distanciaSol;
    }

    public void setDistanciaSol(long distanciaSol) {
        this.distanciaSol = distanciaSol;
    }

    public boolean isOrbitaSol() {
        return orbitaSol;
    }

    public void setOrbitaSol(boolean orbitaSol) {
        this.orbitaSol = orbitaSol;
    }

    public boolean isTieneSatelites() {
        return tieneSatelites;
    }

    public void setTieneSatelites(boolean tieneSatelites) {
        this.tieneSatelites = tieneSatelites;
    }


   @Override
public String toString() {
    return String.format("Planetas [distanciaSol=%d, orbitaSol=%b, tieneSatelites=%b, %s]",
            distanciaSol, orbitaSol, tieneSatelites, super.toString());
}


    


//metodos




    

    
}
