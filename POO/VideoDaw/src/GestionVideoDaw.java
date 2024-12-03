import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

    public class GestionVideoDaw {
        public static void main(String[] args) {
            String opcion = "0";
    
            Scanner sc = new Scanner(System.in);
    do{
            System.out.println("---------Bienvenido a VideoDaw---------");
    
            System.out.println("1. Crear y registrar videoclub");
                      
            System.out.println("2. Registrar Pelicula");
           
            System.out.println("3. Registrar Cliente");
            System.out.println("4. Alquilar Pelicula");
            System.out.println("5. Devolver Pelicula");
            System.out.println("6. Dar de Baja Cliente");
            System.out.println("7. Dar de Baja Pelicula");
            System.out.println("8. Salir");
    
            opcion = sc.nextLine();
    
    
            switch (opcion) {
                case "1":
                System.out.println("CIF= ");
                String CIF = sc.nextLine();
                System.out.println("Dirección= ");
                String direccion = sc.nextLine();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.println("Fecha Alta= " + LocalDate.now().format(formatter));
                
                 VideoDaw v = new VideoDaw(CIF, direccion, formatter);
                    break;                           


                case "2": 
                Pelicula p1 = new Pelicula(null, null, false);
                break;
                case "3":
                Cliente c1 = new Cliente(opcion, opcion, 0, opcion, null);
                break;
                case "4":
                alquilarPelicula ();
                alquilarPelicula(p1, c1);  
                break;
                case "5":
                break;
                case "6":
                break;
                case "7":
                break;
                case "8":
                System.out.println("Saliendo...");
                break;
            
                default:
                    break;
            }
    
           }while(!opcion.equals("8"));
        }
    }

