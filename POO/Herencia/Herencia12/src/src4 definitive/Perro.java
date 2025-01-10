import java.time.LocalDate;

public class Perro extends Mascotas {
public String raza;
public boolean pulgas;

    public Perro(String nombre, int edad, String estado, LocalDate fechaNacimiento, LocalDate fechaMuerte, String raza, boolean pulgas  ) {
        super(nombre, edad, estado, fechaNacimiento, fechaMuerte);
        this.raza = raza;
        this.pulgas = pulgas;
    }

    
    @Override
    public void cumpleaños(LocalDate fechaNacimiento) {
        if (fechaNacimiento == LocalDate.now()) {
            System.out.println("Felicidades!!!" +nombre);
            LocalDate.from(fechaNacimiento).plusYears(1);
        }
    }

    @Override
    public void morir() {
        System.out.println("RIP" +nombre);
        fechaMuerte = LocalDate.now();
    }

    @Override
    public String hablar() {

return "Hola soy" + nombre ;


}

    @Override
    public String toString() {
        return "Perro [nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + ", pulgas=" + pulgas + ", estado="
                + estado + ", fechaNacimiento=" + fechaNacimiento + ", fechaMuerte=" + fechaMuerte + ", hablar()="
                + hablar() + "]";
    }
}
