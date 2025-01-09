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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cumpleaños'");
    }

    @Override
    public void morir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'morir'");
    }

    @Override
    public String hablar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hablar'");
    }

   @Override
public String toString() {
    return "Perro [nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + ", pulgas=" + pulgas + ", estado=" + estado
            + ", fechaNacimiento=" + fechaNacimiento + ", fechaMuerte=" + fechaMuerte + "]";
}


@Override
protected char[] getTipo() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getTipo'");
}
}
