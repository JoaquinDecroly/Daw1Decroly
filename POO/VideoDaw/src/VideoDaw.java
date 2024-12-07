import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VideoDaw {
private String cif;
private String direccion;
private LocalDate fechaAlta = LocalDate.now();

//array
static Pelicula[] peliculasRegistradas = new Pelicula[100];
static Cliente[] clientesRegistrados = new Cliente[100];

//constructor
VideoDaw(String CIF, String direccion, DateTimeFormatter formatter) {
    if (validarCif(cif) && direccion != null) {   
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = LocalDate.now();  
    }
    
}

//getters y setters
public String getCif() {
    return cif;
}

public String getDireccion() {
    return direccion;
}

public LocalDate getFechaAlta() {
    return fechaAlta;
}

public Pelicula[] getPeliculasRegistradas() {
    return peliculasRegistradas;
}

public Cliente[] getClientesRegistrados() {
    return clientesRegistrados;
}

//metodos
public String mostrarInfoVideoClub(){
    String info = String.format("VideoClub - Cif= %s  Direccion= %s  FechaAlta= %s ",
         this.cif, this.direccion, this.fechaAlta);
         return info;
}

public static void mostrarPeliculasRegistradas(){
    for (int i = 0; i < peliculasRegistradas.length; i++) {
        if (peliculasRegistradas != null) {
            System.out.println(i++ +"" + peliculasRegistradas[i]);
        }
    }
}
public static void bajaCliente(){
    for (int i = 0; i < clientesRegistrados.length; i++) {
        if (clientesRegistrados != null) {
            System.out.println(i++ + "" + clientesRegistrados[i]); 
        }
    }
}

public void mostrarClientesRegistrados(){
    for (int i = 0; i < clientesRegistrados.length; i++) {
        if (clientesRegistrados != null) {
            System.out.println(i++ + "" + clientesRegistrados[i]); 
        }
    }
}

public static void alquilarPelicula(Pelicula p, Cliente c){
    for (int i = 0; i < VideoDaw.peliculasRegistradas.length; i++) {
        if (!VideoDaw.peliculasRegistradas[i].getIsAlquilado()) { 
            System.out.println(i++ + "" + VideoDaw.peliculasRegistradas[i]);
        }
    }
    if (p != null && p.getIsAlquilado() == false) {
        p.isAlquilado = true;
        System.out.println("La película ha sido alquilada con éxito.");
    } else {
        System.out.println("La película no está disponible.");
    }
} 
    }

public static void devolverPelicula(Pelicula p, Cliente c){
    for (int i = 0; i < VideoDaw.peliculasRegistradas.length; i++) {
        if (VideoDaw.peliculasRegistradas[i] != null) {
        if (Pelicula.isAlquilado = true) {
            System.out.println(i++ + "" + VideoDaw.peliculasRegistradas[i]);
        }
    }
    }
}

public void peliculasRegistradasAlquiladas(Pelicula p) {
    for (int i = 0; i < VideoDaw.peliculasRegistradas.length; i++) {
        if (VideoDaw.peliculasRegistradas[i].isAlquilado == true) {
            
        }
    }
    
}
public static boolean validarCif(String cif){
    return cif.matches("[A-H, J, N, P-S, U-W]{8}");
}

