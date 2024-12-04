
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VideoDaw {
private String cif;
private String direccion;
private LocalDate fechaAlta = LocalDate.now();

//array
Pelicula[] peliculasRegistradas;
Cliente[] clientesRegistrados;

//constructor
public VideoDaw(String cif, String direccion, DateTimeFormatter formatter) {
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

public void mostrarPeliculasRegistradas(){
    for (int i = 0; i < peliculasRegistradas.length; i++) {
        if (peliculasRegistradas != null) {
            System.out.println(i++ +"" +peliculasRegistradas[i]);
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

public void alquilarPelicula(Pelicula p, Cliente c){
        for (int i = 0; i < peliculasRegistradas.length; i++) {
            if (peliculasRegistradas[i] != null) {
            if (Pelicula.isAlquilado = false) {
                System.out.println(peliculasRegistradas[i]);
            }
        }
    }
            
}

public void devolverPelicula(Pelicula p, Cliente c){
    for (int i = 0; i < peliculasRegistradas.length; i++) {
        if (peliculasRegistradas[i] != null) {
        if (Pelicula.isAlquilado = true) {
            System.out.println(peliculasRegistradas[i]);
        }
    }
    }
}

public void peliculasRegistradasAlquiladas(Pelicula p) {
    for (int i = 0; i < peliculasRegistradas.length; i++) {
        if (peliculasRegistradas[i].isAlquilado == true) {
        
        }
    }
    
}
public  boolean validarCif(String cif){
    return cif.matches("[A-H, J, N, P-S, U-W]{8}");
}
            
}   


