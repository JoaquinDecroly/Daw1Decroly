

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

    public class GestionVideoDaw {
        public static void main(String[] args) {
            String opcion = "0";
            boolean salir = false;
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
                            sc = new Scanner (System.in);
                            System.out.println("CIF= ");
                            String CIF = sc.nextLine();
                                VideoDaw.validarCif(CIF);
                            System.out.println("Dirección= ");
                            String direccion = sc.nextLine();
            
                            DateTimeFormatter formatter13 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            System.out.println("Fecha Alta= " + LocalDate.now().format(formatter13));
                            
                             VideoDaw v1 = new VideoDaw(CIF, direccion, formatter13);
                             
                                break;                           
                                
            
                            case "2": 
                            sc = new Scanner(System.in);
                            System.out.println("Genero= ");
                            do {
                                System.out.println("Seleccione un género:");
                                System.out.println("1. ACCIÓN");
                                Genero accion = Genero.ACCION;
                                System.out.println("2. SCIFI");
                                Genero scifi = Genero.SCIFI;
                                System.out.println("3. COMEDIA");
                                Genero comedia = Genero.COMEDIA;
                                System.out.println("4. DRAMA");
                                Genero drama = Genero.DRAMA;
                                System.out.println("5. TERROR");
                                Genero terror = Genero.TERROR;
                                System.out.println("6. DOCUMENTAL");
                                Genero documental = Genero.DOCUMENTAL;
                                System.out.println("7. BIBLIOGRAFICA");
                                Genero bibliografica = Genero.BIBLIOGRAFICA;
                                System.out.println("8. ANIMACION");
                                Genero animacion = Genero.ANIMACION;
                                System.out.println("9. AVENTURA");
                                Genero aventura = Genero.AVENTURA;
                                System.out.println("10. ROMANCE");
                                Genero romance = Genero.ROMANCE;
                                System.out.println("11. FANTASIA");
                                Genero fantasia = Genero.FANTASIA;
                                System.out.println("12. MUSICAL");
                                Genero musical = Genero.MUSICAL;
                                String g = sc.nextLine();
            
                                
                                
                                switch (g) {
                                    case "1":
                                    sc = new Scanner (System.in);
                                        System.out.println("Ha elegido ACCION");
                                        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        System.out.println("Fecha Registro= " + LocalDate.now().format(formatter1));
                                        Pelicula p1 = new Pelicula(0, accion, formatter1, false);
                                        salir = true;
                                        break;
            
                                        case "2":
                                        System.out.println("Ha elegido SCIFI");    
                                        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        System.out.println("Fecha Registro= " + LocalDate.now().format(formatter2));
                                        Pelicula p2 = new Pelicula(0, scifi, formatter2, false);
                                        salir = true;                            
                                        break;
            
                                        case "3":
                                        System.out.println("Ha elegido COMEDIA");
                                        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        System.out.println("Fecha Registro= " + LocalDate.now().format(formatter3));
                                       Pelicula p3 = new Pelicula(0, comedia, formatter3, false);
                                       salir = true; 
                                       break;
            
                                        case "4":
                                        System.out.println("Ha elegido DRAMA");
                                        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        System.out.println("Fecha Registro= " + LocalDate.now().format(formatter4));
                                        Pelicula p4 = new Pelicula(0, drama, formatter4, false);
                                        salir = true;
                                        break;
            
                                        case "5":
                                        System.out.println("Ha elegido TERROR");
                                        DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        System.out.println("Fecha Registro= " + LocalDate.now().format(formatter5));
                                        Pelicula p5 = new Pelicula(0, terror, formatter5, false);
                                        salir = true;
                                        break;
            
                                        case "6":
                                        System.out.println("Ha elegido DOCUMENTAL");
                                        DateTimeFormatter formatter6 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        System.out.println("Fecha Registro= " + LocalDate.now().format(formatter6));
                                        Pelicula p6 = new Pelicula(0, documental, formatter6, false);                            
                                        salir = true;
                                        break;
            
                                        case "7":
                                        System.out.println("Ha elegido BIBLIOGRAFICA");
                                        DateTimeFormatter formatter7 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        System.out.println("Fecha Registro= " + LocalDate.now().format(formatter7));
                                       Pelicula p7 = new Pelicula(0, bibliografica, formatter7, false);
                                       salir = true; 
                                       break;
            
                                        case "8":
                                        System.out.println("Ha elegido ANIMACION");
                                        DateTimeFormatter formatter8 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        System.out.println("Fecha Registro= " + LocalDate.now().format(formatter8));
                                        Pelicula p8 = new Pelicula(0, animacion, formatter8, false);
                                        salir = true;
                                        break;
            
                                        case "9":
                                        System.out.println("Ha elegido AVENTURA");
                                        DateTimeFormatter formatter9 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        System.out.println("Fecha Registro= " + LocalDate.now().format(formatter9));
                                        Pelicula p9 = new Pelicula(0, aventura, formatter9, false);
                                        salir = true;
                                        break;
            
                                        case "10":
                                        System.out.println("Ha elegido ROMANCE");
                                        DateTimeFormatter formatter10 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        System.out.println("Fecha Registro= " + LocalDate.now().format(formatter10));
                                        Pelicula p10 = new Pelicula(0, romance, formatter10, false);
                                        salir = true;
                                        break;
            
                                        case "11":
                                        System.out.println("Ha elegido FANTASIA");
                                        DateTimeFormatter formatter11 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        System.out.println("Fecha Registro= " + LocalDate.now().format(formatter11));
                                        Pelicula p11 = new Pelicula(0, fantasia, formatter11, false);
                                        salir = true;
                                        break;
            
                                        case "12":
                                        System.out.println("Ha elegido MUSICAL");
                                        DateTimeFormatter formatter12 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        System.out.println("Fecha Registro= " + LocalDate.now().format(formatter12));
                                        Pelicula p12 = new Pelicula(0, musical, formatter12, false);
                                        salir = true;
                                        break;
            
                                        default:
                                        System.out.println("Opción no válida");
                                            break;
                                }
            
            
                            } while (salir = false);
                            
            
                            case "3":
                            sc = new Scanner (System.in);
                            System.out.println("DNI= "); 
                            String Dni = sc.nextLine();
                                Cliente.validarDni(Dni);
                            System.out.println("Nombre= ");
                            String Nombre = sc.nextLine();
                            System.out.println("Direccion= ");
                            String Direccion = sc.nextLine();                
                            System.out.printf("fechaNacimiento (dd/MM/yyy)= ");
                            String fechaNacimiento = sc.nextLine();
                            DateTimeFormatter formatter14 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate fechaNacimiento2 = LocalDate.parse(fechaNacimiento, formatter14); 
                            Cliente c1 = new Cliente(Dni, Nombre, 0, Direccion, fechaNacimiento2);               
                        case "4":
                        sc = new Scanner (System.in);
                        System.out.println("Clientes= ");
                        for (int i = 0; i < VideoDaw.clientesRegistrados.length; i++) {
                            System.out.println(i++ + " " + VideoDaw.clientesRegistrados[i]);
                        }
                        System.out.println("Elija el cliente mediante el número= ");
                        int c = sc.nextInt();                     
                        System.out.println("Pelicula= ");
                        for (int i = 0; i < VideoDaw.peliculasRegistradas.length; i++) {
                            System.out.println(i++ + " " + VideoDaw.peliculasRegistradas[i]);
                        } 
                        System.out.println("Elija la pelicula mediante el número= ");
                        int p = sc .nextInt();

                       VideoDaw.alquilarPelicula(VideoDaw.peliculasRegistradas[p], VideoDaw.clientesRegistrados[c]);
                           
                            break;
                            case "5":
                            sc = new Scanner (System.in);
                            System.out.println("Clientes= ");
                            for (int i = 0; i < VideoDaw.clientesRegistrados.length; i++) {
                                System.out.println(i++ + " " + VideoDaw.clientesRegistrados[i]);
                            }
                            System.out.println("Elija el cliente mediante el número= ");
                             c = sc .nextInt();
                            
                            System.out.println("Pelicula= ");
                            for (int i = 0; i < VideoDaw.peliculasRegistradas.length; i++) {
                                System.out.println(i++ + " " + VideoDaw.peliculasRegistradas[i]);
                            } 
                            System.out.println("Elija la pelicula mediante el número= ");
                            p = sc .nextInt();


                             if (VideoDaw.peliculasRegistradas[p].isAlquilado == true) {
                                System.out.println("La película ha sido devuelta con éxito.");
                                VideoDaw.devolverPelicula(VideoDaw.peliculasRegistradas[p], VideoDaw.clientesRegistrados[c]);
                            } else {
                                System.out.println("La película no fue devuelta");
                                System.out.println("La película no está alquilada");
                            }                         
                            break;
                            case "6":
                                sc = new Scanner (System.in);
                                System.out.println("Clientes= ");
                                for (int i = 0; i < VideoDaw.clientesRegistrados.length; i++) {
                                    System.out.println(i++ + " " + VideoDaw.clientesRegistrados[i]);
                                }
                                System.out.println("Elija el cliente mediante el número= ");
                                c = sc.nextInt();
                                VideoDaw.bajaCliente(VideoDaw.clientesRegistrados[c]);
                                 Cliente cliente = null;
                            break;
                            case "7":
                            sc = new Scanner (System.in);
                            System.out.println("Pelicula= ");
                            for (int i = 0; i < VideoDaw.peliculasRegistradas.length; i++) {
                                System.out.println(i++ + " " + VideoDaw.peliculasRegistradas[i]);
                            } 
                            System.out.println("Elija la pelicula mediante el número= ");
                            p = sc .nextInt();
                            VideoDaw.bajaPelicula(VideoDaw.peliculasRegistradas[p]);
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
