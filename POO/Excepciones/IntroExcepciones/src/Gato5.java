

public class Gato5 {
String nombre;
int edad;


public String getNombre() {
    return nombre;
}
public int getEdad() {
    return edad;
}

public void setEdad(int edad) {
    this.edad = edad;
}

public Gato5(String nombre, int edad) {
    this.nombre = nombre;
    this.edad = edad;
}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gato5{");
        sb.append("nombre=").append(nombre);
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }


}
