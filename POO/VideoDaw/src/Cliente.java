import java.time.LocalDate;

public class Cliente {
public String dni;
private String nombre;
private int numsocio;
private static int contadorC = 0;
public String direccion;
private LocalDate fechaNacimiento;
private LocalDate fechaBaja;

//array
static Pelicula[] peliculasAlquiladas;

//constructor
public Cliente(String dni, String nombre, int numsocio, String direccion, LocalDate fechaNacimiento){
    if (validarDni(dni) && nombre != null) {
        int edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
        if (edad >= 18) {
                this.nombre = nombre;
                this.numsocio = contadorC++;
                this.direccion = direccion; 
                this.fechaNacimiento = fechaNacimiento;  
        }
        
            if (edad < 18) {
                System.out.println("El cliente es menor de edad");
                System.out.println("Verificando diferencia de meses...");
                int edad2 = (LocalDate.now().getMonthValue() - fechaNacimiento.getMonthValue());
            } 
            
    } else
        System.out.println("Formato del DNI 0000000X");
   
}


//metodos
public void mostrarPeliculasAlquiladas(){
   for (int i = 0; i < peliculasAlquiladas.length; i++) {
       if (peliculasAlquiladas != null) {
        System.out.println(peliculasAlquiladas[i]);
        
       }
   }
}

public String mostrarInfoCliente(){
    String info = String.format("Cliente - NumSocio= %s DNI= %s Nombre= %s direccion= %s fechaNacimientoo= %s",
     this.numsocio, this.dni, this.nombre, this.direccion, this.fechaNacimiento);
    return info;
}

public void mostrarPeliculasRegistradasDisponibles(){
    for (int i = 0; i < peliculasAlquiladas.length; i++) {
        if (Pelicula.isAlquilado = false) {
            System.out.println(peliculasAlquiladas[i]);
     }   
    }
 }



 public static boolean validarDni(String dni){
    return dni.matches("//d{7}[A-Z]$");
}
}
