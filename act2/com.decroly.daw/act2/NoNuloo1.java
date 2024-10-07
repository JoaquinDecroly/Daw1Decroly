package act2;

import java.util.Scanner;

public class NoNuloo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int countPositive = 0;
	     
        int countNegative = 0;

        Scanner entrada = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            System.out.println("Introduzca un número no nulo: " + i + "/10");
            int j = entrada.nextInt();

            if (j > 0) {
                countPositive++;
            } else if (j < 0) {
                countNegative++;
            }
        }

        System.out.println("Hay " + countPositive + " números positivos y " + countNegative + " números negativos entre 10.");

        entrada.close();
    }

	}

