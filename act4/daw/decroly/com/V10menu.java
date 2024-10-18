
import java.util.Scanner;

public class V10menu {
public static void main(String[] args) {
    //array 10 enteros
    ////////////////////////
    //scanner + menú
    //a = array
    //b = valorV y posicionP
    //c = salir/break;
    Scanner entrada = new Scanner(System.in);
    int[] nums = new int[10]; 
    char opcion;

    do {
        System.out.println("Menú:");
        System.out.println("a. Mostrar valores");
        System.out.println("b. Introducir valor");
        System.out.println("c. Salir");
        System.out.print("Elige una opción: ");
        opcion = entrada.next().charAt(0); 

    switch(opcion) {
         case 'a':
            System.out.println("Valores en el array:");
            for (int i = 0; i < nums.length; i++) {
            System.out.println("Posición " + i + ": " + nums[i]);
            }
            
            break;

        case 'b':
            System.out.print("Introduce un valor: ");
            int V = entrada.nextInt();
            System.out.print("Introduce una posición (0-9): ");
            int P = entrada.nextInt();

            if (P >= 0 && P < nums.length) {
            nums[P] = V; 
            System.out.println("Valor " + V + " introducido en la posición " + P);
            } else {
            System.out.println("Posición no válida. Debe estar entre 0 y 10.");
            }
            
            break;

        case 'c':
            System.out.println("Saliendo del programa...");
            
            break;

        default:
            System.out.println("Opción no válida. Por favor, elige 'a', 'b' o 'c'.");
            }
        } while (opcion != 'c'); 

    }
}
