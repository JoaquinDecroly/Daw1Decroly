import java.util.Scanner;

public class PQ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce el valor de P: ");
        int p = scanner.nextInt();
        
        System.out.print("Introduce el valor de Q: ");
        int q = scanner.nextInt();
        
        int longitud = Math.abs(q - p) +1;
        
        int[] array = new int[longitud];
        
        if (p <= q) {
            for (int i = 0; i < longitud; i++) {
                array[i] = p + i;
            }
        } else {
            for (int i = 0; i < longitud; i++) {
                array[i] = p - i;
            }
        }
        
        System.out.print("El array desde P hasta Q es: [");
        for (int i = 0; i < longitud; i++) {
            System.out.print(array[i]);
            if (i < longitud - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
