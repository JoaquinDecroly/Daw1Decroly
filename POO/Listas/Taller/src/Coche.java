public class Coche {
String color;
String marca;
String matrícula;

public Coche(String color, String marca, String matrícula) {
    this.color = color;
    this.marca = marca;
    this.matrícula = matrícula;
}


public Coche(String color, String marca) {
    this.color = color;
    this.marca = marca;
}


public String getMatrícula() {
    return matrícula;
}

public String getColor() {
    return color;
}

public void setColor(String color) {
    this.color = color;
}

public String getMarca() {
    return marca;
}

@Override
public String toString() {
    return "Coche [" + matrícula + "]";
}


public String toString1(){
    return "Coche [" + matrícula + marca + color + "]";
}

public String toString2(){
    return "Coche [" + marca + color + "]";
}





}
