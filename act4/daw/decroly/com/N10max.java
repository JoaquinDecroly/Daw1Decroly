package daw.decroly.com;
import java.util.Scanner;
public class N10max {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[10];
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce numeros enteros");
		for(int i = 0; i < 10; i++) {		
			
			System.out.println("Numero" + (i + 1) + "/10");
			nums[i] = entrada.nextInt();
		}
		int min = 0;
		int max = 0;
		System.out.println("Numeros introducidos:");
		for (int i = 0; i < 10; i++) {
		    min = Math.min(min, nums[i]);
		    max = Math.max(max, nums[i]);
		    
 
		}
			System.out.println("El máximo del array es: "+ max);
		    System.out.println("El mínimo del array es: " + min);
		
	
	
		
		
		
		
		
		
//10 N
//	Array
//	Max y min array
// mostrar
		
	}

}

