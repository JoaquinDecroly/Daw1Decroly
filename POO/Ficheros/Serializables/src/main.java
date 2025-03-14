import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
        String option = ""; 

        System.out.print("\n========MENU PRINCIPAL BIBLIO======== ");
            Libro.cargarLibro();
        do {
            System.out.println("\n1. Crear libro y registrarlo en la Biblioteca");
            System.out.println("2. Mostrar libros existentes");
            System.out.println("3. Eliminar libro mediante ISBN");
            System.out.println("4. Guardar Libros en fichero");
            System.out.println("5. Guardar y Salir");
            option = sc.nextLine(); 
            switch(option) {
                case "1":
                Libro.crearLibro();
                Libro.escribirLibro();
                    break;
                case "2":
                Libro.cargarLibro();
                    break;
                case "3":
                Libro.eliminarLibro();
                Libro.escribirLibro();
                    break;
                case "4":
                Libro.escribirLibro();
                    break;
                case "5":
                    try {
                        System.out.println("Guardando....");
                        Libro.escribirLibro();
                        Thread.sleep(1000); 
                        System.out.println("Guardado");
                        Thread.sleep(500); 
                        System.out.println("Saliendo");
                    } catch (InterruptedException e) {
                        System.out.println("El hilo fue interrumpido");
                    }
                    break;
            }
        } while (!option.equals("5")); 
    }
    }
}
