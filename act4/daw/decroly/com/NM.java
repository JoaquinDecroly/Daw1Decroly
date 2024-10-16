import java.util.Scanner;

public class NM {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int m = 0;
        int n = 0;

        System.out.println("Introduce N:");
        n = entrada.nextInt();
        System.out.println("Introduce M:");
        m = entrada.nextInt();

        double[] nnumeros = new double[n];

        for (int i = 0; i < n; i++) {
            
            nnumeros[i] = m; 

            System.out.println("Tu array es : " +nnumeros[i]);
        }
       
       
        
        
           
       }

        
    }

    //ARRAY N n.length
    //CONTENIDO M n.length

    //mostrarlo

