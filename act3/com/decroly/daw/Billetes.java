package com.decroly.daw;
		import java.util.Scanner;

public class Billetes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        Scanner entrada = new Scanner(System.in);

		        System.out.println("Introduce una cantidad de euros (múltiplo de 5€):");
		        int cantidad = entrada.nextInt();

		        int billete500 = cantidad / 500;
		        cantidad %= 500;

		        int billete200 = cantidad / 200;
		        cantidad %= 200;

		        int billete100 = cantidad / 100;
		        cantidad %= 100;

		        int billete50 = cantidad / 50;
		        cantidad %= 50;

		        int billete20 = cantidad / 20;
		        cantidad %= 20;

		        int billete10 = cantidad / 10;
		        cantidad %= 10;

		        int billete5 = cantidad / 5;

		        System.out.println("Billetes necesarios:");
		        if (billete500 > 0) {
		            System.out.println(billete500 + " billete(s) de 500€");
		        }
		        if (billete200 > 0) {
		            System.out.println(billete200 + " billete(s) de 200€");
		        }
		        if (billete100 > 0) {
		            System.out.println(billete100 + " billete(s) de 100€");
		        }
		        if (billete50 > 0) {
		            System.out.println(billete50 + " billete(s) de 50€");
		        }
		        if (billete20 > 0) {
		            System.out.println(billete20 + " billete(s) de 20€");
		        }
		        if (billete10 > 0) {
		            System.out.println(billete10 + " billete(s) de 10€");
		        }
		        if (billete5 > 0) {
		            System.out.println(billete5 + " billete(s) de 5€");
		        }
		    }
		}


	}

}
