
public abstract class Contacto {

public String name;
public String telf;


//getters y setters
    public Contacto(String name, String telf) {
        this.name = name;
        this.telf = telf;
    }


    @Override
    public String toString() {
        return "Contacto [name=" + name + ", telf=" + telf + "]";
    }

}

