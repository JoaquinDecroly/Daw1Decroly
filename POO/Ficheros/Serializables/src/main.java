import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String option = ""; 

        Libro libros;

        System.out.print("\n========MENU PRINCIPAL BIBLIO======== ");

        do {
            System.out.println("1. Crear libro y registrarlo en la Biblioteca");
            System.out.println("2. Mostrar libros existentes");
            System.out.println("3. Eliminar libro mediante ISBN");
            System.out.println("4. Guardar Libros en fichero");
            System.out.println("5. Guardar y Salir");
            option = sc.nextLine(); 
            switch(option) {
                case "1":
                Libro.generateAndValidateISBN();
                escribirLibro();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    try {
                        System.out.println("Guardando....");
                        Thread.sleep(2000); 
                        System.out.println("Guardado");
                        Thread.sleep(2000); 
                        System.out.println("Saliendo");
                    } catch (InterruptedException e) {
                        System.out.println("El hilo fue interrumpido");
                    }
                    break;
            }
        } while (!option.equals("5")); 

        sc.close(); 
    }
}
