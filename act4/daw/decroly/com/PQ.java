import java.util.Scanner;

public class PQ {
        public static void main(String[] args) {
            Scanner entrada = new Scanner(System.in);
            int p = 0;
            int q = 0; 
            int i = 0;

            double[] numeros = new double[p];
            for (i = 0; i < p; i++) { 
            System.out.println("Introduce P:");
            numeros[p] = entrada.nextInt();
            for (i = 0; i < p; i++) { 
                System.out.println("Introduce Q:");                
                numeros[q] = entrada.nextInt();
                @SuppressWarnings("unused")
                double PQ = numeros[p] + numeros[q];
                }
            }
            double PQ = 0;
            System.out.println("El array que empieza por P, y termina por Q es: " +PQ);


           
           
            
            
               
           }
    
            
        }
}
