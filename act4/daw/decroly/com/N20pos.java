
import java.util.Scanner;

public class N20pos {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Scanner scanner = new Scanner(System.in);
    
        // Pedir veinte números enteros por teclado y almacenarlos en el array
        for (int i = 0; i < 20; i++) {
          System.out.print("Introduce el número " + (i + 1) + ": ");
          arr[i] = scanner.nextInt();
        }
    
        // Inicializar variables para almacenar la suma de valores positivos y negativos
        int sumaPositivos = 0;
        int sumaNegativos = 0;
    
        // Recorrer el array y sumar los valores positivos y negativos
        for (int i = 0; i < 20; i++) {
          if (arr[i] > 0) {
            sumaPositivos += arr[i];
          } else if (arr[i] < 0) {
            sumaNegativos += arr[i];
          }
        }
    
        // Mostrar la suma de valores positivos y negativos
        System.out.println("La suma de los valores positivos es: " + sumaPositivos);
        System.out.println("La suma de los valores negativos es: " + sumaNegativos);
      }
    }