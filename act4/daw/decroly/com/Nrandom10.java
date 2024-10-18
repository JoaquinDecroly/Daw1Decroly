import java.util.Scanner;

public class Nrandom10 {
public static void main(String[] args) {
    //array 100
    //random (math absolute * 10) +1
    //N == random
    int[] nums = new int[100];

    for(int i = 0; i < nums.length; i++){
        nums[i] = (int)(Math.random() * 10) + 1;
       
    } 
    Scanner entrada = new Scanner(System.in);
    System.out.println("Introduce un valor de N conprendido entre 0 y 10 ambos incluidos: ");
    double N = entrada.nextDouble();
    if(N >= 0.0 && N <= 10.0){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == N ){ 
                System.out.println("El valor" +N+ "se encuentra en las posiciones: " +i);
            }
        }
            
            
        }
    }
}
