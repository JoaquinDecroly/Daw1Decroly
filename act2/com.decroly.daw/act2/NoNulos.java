package act2;
import java.util.Scanner;

public class NoNulos {
    public static void main(String[] args) {
        boolean negativo = false;
        Scanner entrada = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            System.out.println("Introduzca un numero no nulo:" + i + "/10");
            int j = entrada.nextInt();

            if (j < 0) {
                negativo = true;
            }
        }

        if (negativo) {
            System.out.println("Hay números negativos");
        } else {
            System.out.println("Hay números positivos");
        }
    }
}
	



 
		
		
		
			



	
	

	
