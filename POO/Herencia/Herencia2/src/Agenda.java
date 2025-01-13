public class Agenda {
public String nombre;
public int numTelf;

public Agenda(String nombre, int numTelf) {
    this.nombre = nombre;
    this.numTelf = numTelf;
}

public String getNombre() {
    return nombre;
}


public int getNumTelf() {
    return numTelf;
}

@Override
public String toString() {
    return "Agenda [nombre=" + nombre + ", numTelf=" + numTelf + "]";
}






}
