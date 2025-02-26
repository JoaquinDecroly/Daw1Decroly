
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class VideoDaw {
String cif;
String direccion;
LocalDate fechaAlta;



List<Articulo> articulos = new ArrayList<>();
List<Cliente> clientes = new ArrayList<>();

   
    public String mostrarInfoVideoclub() {
        StringBuilder sb = new StringBuilder();
        sb.append("VideoDaw{");
        sb.append("cif=").append(cif);
        sb.append(", direccion=").append(direccion);
        sb.append(", fechaAlta=").append(fechaAlta);
        sb.append(", articulos=").append(articulos);
        sb.append(", clientes=").append(clientes);
        sb.append('}');
        return sb.toString();
    }

    
    public String mostrarArticulosRegistrados() {
        StringBuilder sb = new StringBuilder();
        sb.append("VideoDaw{");
        sb.append("articulos=").append(articulos);
        sb.append('}');
        return sb.toString();
    }

 
    public String mostrarClientesRegistrados() {
        StringBuilder sb = new StringBuilder();
        sb.append("VideoDaw{");
        sb.append("clientes=").append(clientes);
        sb.append('}');
        return sb.toString();
    }

    void alquilarPeliculaOvideojuego(Pelicula pelicula, Videojuego videojuego) {

        System.out.println("""
                           1. Pelicula\n\r
                           2.Videojuego""");
                String option = Scanner.nextLine();
            switch (option) {
                case "1":
                    
                    break;
                case "2":
                Iterator<Pelicula> iterator = peliculas.iterator();

                while (iterator.hasNext()) {
                    Pelicula p = iterator.next();
                    if (p != null) { 
                        agregarPelicula(Pelicula pelicula);
                    }
                }
}
                break;
                default:
                    throw new AssertionError();
            }





   
}
}
