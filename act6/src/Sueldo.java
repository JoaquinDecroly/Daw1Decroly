import java.util.Scanner;

public class Sueldo {
public static void main(String[] args) {

    Scanner entrada = new Scanner(System.in);
    //N
    System.out.println("Introduce personas totales: ");
    int N = entrada.nextInt();
    
    int S = 2; 
    //matriz
    double[][] personas = new double[N][S]; 
    for (int i = 0; i < personas.length; i++) {//introducir datoos
        for (int j = 0; j < personas[i].length; j++) {
            System.out.print("Introduce el género de la persona " + (i + 1) + " (0 para varón y 1 para mujer): ");
            personas[i][0] = entrada.nextInt();
            System.out.print("Introduce el sueldo de la persona " + (i + 1) + ": ");
            personas[i][1] = entrada.nextDouble();
        }
        
    }
    //variables a usar
    double sueldoMedioVarones = 0;
    double sueldoMedioMujeres = 0;
    int contadorVarones = 0;
    int contadorMujeres = 0;

    for (int i = 0; i < N; i++) {//for  para recorrer la matriz

        if (personas[i][0] == 0) {
            sueldoMedioVarones += personas[i][1];
            contadorVarones++;
        } else {
            sueldoMedioMujeres += personas[i][1];
            contadorMujeres++;
        }
}

        if (contadorVarones > 0) {
            sueldoMedioVarones /= contadorVarones;
            System.out.println("Sueldo medio varones: " + sueldoMedioVarones);
        } else {
            System.out.println("No hay varones registrados.");
        }

        if (contadorMujeres > 0) {
            sueldoMedioMujeres /= contadorMujeres;
            System.out.println("Sueldo medio mujeres: " + sueldoMedioMujeres);
        } else {
            System.out.println("No hay mujeres registradas.");
        }    
    }
}
