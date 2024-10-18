import java.util.Scanner;

public class Nalturas {
public static void main(String[] args) {
    //N
    //array
    //media, maximo, minimo
double[] nums = new double[2];
Scanner entrada = new Scanner(System.in);

for (int i = 0; i < nums.length; i++) {
    System.out.println("Introduzca una altura N en metros: ");
    nums[i] = entrada.nextDouble();
    
}
double N = 0.0;
double suma = 1;
    int i = 0;
suma += nums[i];
double media = suma/2;
    double min = 0;
    double max = 0;
min = Math.min(min, nums[i]);
max = Math.max(max, nums[i]);

System.out.println("Media: " +media);
System.out.println("Minimo: " +min);
System.out.println("Maximo: " +max);


}
}
