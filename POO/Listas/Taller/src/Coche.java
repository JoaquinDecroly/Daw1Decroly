public class Coche {
    private String color;
    private String marca;
    private String matricula;

    public Coche(String color, String marca, String matricula) {
        this.color = color;
        this.marca = marca;
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "color='" + color + '\'' +
                ", marca='" + marca + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}