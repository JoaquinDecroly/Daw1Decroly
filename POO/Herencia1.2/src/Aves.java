import java.time.LocalDate;

public abstract class Aves extends Mascotas {
private boolean vuela;
private boolean pico;

public Aves(String nombre, int edad, String estado, LocalDate fechaNacimiento, boolean vuela, boolean pico) {
    super(nombre, edad, estado, fechaNacimiento);
    this. vuela = vuela;
    this.pico = pico;
}

public boolean isVuela() {
    return vuela;
}

public boolean isPico() {
    return pico;
}

@Override
public void cumpleaños(LocalDate fechaNacimiento) {
    if (LocalDate.now() == fechaNacimiento) {
        System.out.println("Feliz cumpleaños " + this.getNombre());
        
    }    
}

@Override
public String hablar() {
    return "Hola";
}

@Override
public void morir() {
   fechaMuerte = LocalDate.now().minusYears(edad);
}

public boolean volar(Boolean vuela) {
return true;
}


}
