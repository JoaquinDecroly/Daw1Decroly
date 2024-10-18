import java.util.Scanner;
//Escanner
//for de 100 numeros reales, entre 0.0 y 1.0 double | math.random()

//pedir R
//comparar R >= random.length
//salida
public class Rrandom {
    public static void main(String[] args) { 
        double[] nums = new double[100];
        
            for(int i = 0; i < nums.length; i++){
                nums[i] = Math.random();
            }
            double R = 0;
            Scanner entrada = new Scanner(System.in);
            System.out.print("Introduce un valor real R (entre 0.0 y 1.0): ");
            R = entrada.nextDouble();
    
            int contador = 0;
            for (double numero : nums) {
                if (numero >= R) {
                    contador++;
                }
            }
    
            System.out.println("Cantidad de valores iguales o superiores a R: " + contador);
    


           
    }
}

   
























//Escanner
//for de 100 numeros reales, entre 0.0 y 1.0 double | math.random()

//pedir R
//comparar R >= random.length
//salida