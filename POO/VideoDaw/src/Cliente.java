
import java.time.LocalDate;
import java.time.Period;

public final class Cliente {
private String dni;
private String nombre;
private int numSocio;
private static int contadorCl = 0;
private String direccion;
private LocalDate fechaNacimiento;
private LocalDate fechaBaja;

//array
private Pelicula [] peliculasAlquiladas;

//constructor
public Cliente(String dni, String nombre, String numSocio, String direccion, LocalDate fechaNacimiento){
if ( validardni(dni) && !nombre.isEmpty() && esMayorDeEdad(fechaNacimiento)){    
this.dni = dni;
    this.nombre = nombre;
    this.numSocio = contadorCl++;
    this.direccion = direccion;
    this.fechaNacimiento = fechaNacimiento;
    this.fechaBaja = null;
    this.peliculasAlquiladas = new Pelicula[0];
}else{
    System.out.println("Error al crear cliente");
}
}

//metodos
public void mostrarInfoClientes(){
    
}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("dni=").append(dni);
        sb.append(", nombre=").append(nombre);
        sb.append(", numSocio=").append(numSocio);
        sb.append(", direccion=").append(direccion);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", fechaBaja=").append(fechaBaja);
        sb.append(", peliculasAlquiladas=").append(peliculasAlquiladas);
        sb.append('}');
        return sb.toString();
    }

    public void mostrarPeliculasAlquiladas(){
        for (Pelicula pelicula : peliculasAlquiladas) {
            System.out.println(pelicula.toString());
            }
    }

    public boolean validardni(String dni){
        return dni.matches("[0-9]{8}[A-Z]$");
    }

     private boolean esMayorDeEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }

   

     
    
}
