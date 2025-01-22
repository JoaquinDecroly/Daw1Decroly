public class Coche {
String color;
String marca;

public Coche(String color, String marca) {
    this.color = color;
    this.marca = marca;
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
    return "Coche [color=" + color + ", marca=" + marca + "]";
}


}
