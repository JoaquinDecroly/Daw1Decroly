import java.util.Scanner;
public class PIN { 
public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    
    int V = 0;
    int I = 0;
    int N = 0;

    
    System.out.println("Introduce un valor inicial: ");
    V = entrada.nextInt();

    System.out.println("Introduce un intervalo(separación de numeros): ");
    I = entrada.nextInt();

    System.out.println("Introduce los numeros totales a crear: ");
    N = entrada.nextInt();

    int[] nums = new int[N];


for (int i = 0; i < nums.length; i++) {
    nums[i] = V + ( I * i );
    }


System.out.println("Esta es la secuencia aritmética: ");
for (int i = 0; i < nums.length; i++) { 
System.out.println(nums[i]);

}
}
}
