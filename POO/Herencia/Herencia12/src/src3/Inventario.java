import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Inventario {
static int contM = 0;
static Mascotas[] mascotas;
static Scanner scanner = new Scanner(System.in);
public static void main(String[] args) {
    String option;

        do {
            System.out.println("Bienvenido al veterinario");
            System.out.println("--------------");
            System.out.println("1. Mostrar lista de animales (tipo y nombre)");
            System.out.println("2. Mostrar datos de animal concreto");
            System.out.println("3. Mostrar datos de todos los animales");
            System.out.println("4. Insertar animal en el inventario");
            System.out.println("5. Eliminar animal del inventario");
            System.out.println("6. Vaciar el inventario");
            System.out.println("0. Salir");
           option = scanner.nextLine();

           switch (option) {
            case "0":
            System.out.println("Adiós...");
                break;
            case "1":
                   
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;

               default:
                  
           }
    
    
        } while (!option.equals("0"));
}

//metodos
    public int calcularEdad(LocalDate fechaNacimiento) {
            return LocalDate.now().getYear() - fechaNacimiento.getYear();
        }
    
        public void agregarMascota(Mascotas mascota) {
            if (contM < mascotas.length) {
                mascotas[contM] = mascota;
                contM++;
            } else {
                System.out.println("No hay espacio para agregar mas mascotas");
            }
        }
    
        public void eliminarMascota(Mascotas mascota){
            int index = -1;
            for (int i = 0; i < contM; i++) {
                if (mascotas[i].equals(mascota)) {
                    index = i;
                    break;
                }
            }
            
            
            if (index == -1) {
                System.out.println("No se encontró la mascota a eliminar");
                return;
            }
    
           
        }
    
        public void recolocarArrayyMacotas(Mascotas mascota){
            int index = -1;
            //desplazar elementos a la izq.
            for (int i = index; i < contM; i++) {
                mascotas[i] = mascotas[i + 1];
            }
            //último elemento es null
            mascotas[contM -1] = null;
            contM--;
        }
        public void vaciarInventarioMascotas() {
            for (int i = 0; i < mascotas.length; i++) {
                mascotas[i] = null;
                contM++;
                
            }
        }
        public void mostrarInventarioMacotas(){
            for (int i = 0; i < mascotas.length; i++) {
                String info = "";
                info = String.format("Macota" + i++ + "{ , Nombre= %s, Tipo= %s, estado= %s, fechaNacimiento= %s, edad= %s,");
            }
        }
         private void mostrarListaAnimales() {
            for (int i = 0; i < contM; i++) {
                System.out.println("Nombre: " + mascotas[i].getNombre() + ", Tipo: " + mascotas[i].getTipo());
            }
        }
    
        private  void mostrarDatosAnimalConcreto(Scanner scanner) {
            System.out.println("Introduce el nombre del animal:");
            String nombre = scanner.nextLine();
            for (int i = 0; i < contM; i++) {
                if (mascotas[i].getNombre().equals(nombre)) {
                    System.out.println(mascotas[i]);
                    return;
                }
            }
            System.out.println("No se encontró el animal con ese nombre.");
        }
    
        private  void mostrarDatosTodosLosAnimales() {
            for (int i = 0; i < contM; i++) {
                System.out.println(mascotas[i]);
            }
        }
    
        private  int insertarAnimal(Scanner scanner) {
            if (contM >= mascotas.length) {
                System.out.println("No hay espacio para agregar más mascotas.");
                return contM;
            }
    
            System.out.println("Introduce el nombre del animal:");
            String nombre = scanner.nextLine();
    
            System.out.println("Introduce la fecha de nacimiento (dd/MM/yyyy):");
            LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    
            System.out.println("Introduce la fecha de muerte (dd/MM/yyyy) o presiona Enter si no aplica:");
            String fechaMuerteInput = scanner.nextLine();
            LocalDate fechaMuerte;
            if (fechaMuerteInput.isEmpty()) {
                fechaMuerte = null;
            } else {
                fechaMuerte = LocalDate.parse(fechaMuerteInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
    
            System.out.println("Elige el tipo de animal a añadir: ");
            System.out.println("1. Loro");
            System.out.println("2. Canario");
            System.out.println("3. Perro");
            System.out.println("4. Gato");
            String tipoInput = scanner.nextLine();
    
            Tipo tipo;
            if (tipoInput.equals("1")) {
                tipo = Tipo.LORO;
            } else if (tipoInput.equals("2")) {
                tipo = Tipo.CANARIO;
            } else if (tipoInput.equals("3")) {
                tipo = Tipo.PERRO;
            } else if (tipoInput.equals("4")) {
                tipo = Tipo.GATO;
            } else {
                System.out.println("Tipo de animal no válido.");
                return contM;
            }
    
            System.out.println("Introduce el color del animal:");
            String colorInput = scanner.nextLine();
            Color color;
            if (colorInput.equalsIgnoreCase("blanco")) {
                color = Color.BLANCO;
            } else if (colorInput.equalsIgnoreCase("negro")) {
                color = Color.NEGRO;
            } else if (colorInput.equalsIgnoreCase("marron")) {
                color = Color.GRIS;
            } else if (colorInput.equalsIgnoreCase("gris")) {
                color = Color.DESCONOCIDO;
            } else {
                color = Color.OTRO;
            }
    
            int edad = calcularEdad(fechaNacimiento);
        Mascotas mascota = null;

        switch (tipo) {
            case LORO:
                mascota = new Loro(nombre, edad, Estado estado, fechaNacimiento, fechaMuerte, color, true, true);
                break;
            case CANARIO:
                mascota = new Canario(nombre, edad, Estado estado, fechaNacimiento, fechaMuerte, color, true, true);
                break;
            case PERRO:
                mascota = new Perro(nombre, edad, Estado estado, fechaNacimiento, fechaMuerte, color);
                break;
            case GATO:
                mascota = new Gato(Color color, edad, colorInput, fechaMuerte, fechaMuerte, colorInput, false);               
                break;
        }

        mascotas[contM] = mascota;
        contM++;
        System.out.println("Animal agregado con éxito.");
        return contM;
    }
}
