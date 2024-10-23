import java.util.Scanner;

public class NxM {
public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    //leer N y M matriz
    System.out.println("Introduce el numero de filas: ");
    int N = entrada.nextInt();
    System.out.println("Introduce el numero de columnas: ");
    int M = entrada.nextInt();

    //Matriz
    int[][] matriz = new int[N][M];

    //Valores
    int i = 0;
    int j = 0;
    System.out.println("Introduce el valor de la posicion [" + i + "][" + j + "]");
    for (i = 0; i < N; i++) {
        for (j = 0; j < M; j++) {
            System.out.println("Valor en posicion  [" + i + "][" + j + "]");

            matriz[i][j] = entrada.nextInt();
        }
    }

    
    //contadores
    int mayores0 = 0;
    int iguales0 = 0;
    int menores0 = 0;

for (i = 0; i < N; i++) {
    for (j = 0; j < M; j++) {
        if (matriz[i][j] > 0) {
            mayores0++;
        } else if (matriz[i][j] == 0) {
            iguales0++;
        } else {
            menores0++;
        }
    }
     //Salida
    System.out.println("Cantidad de valores mayores que cero: " + mayores0);
    System.out.println("Cantidad de valores menores que cero: " + menores0);
    System.out.println("Cantidad de valores iguales a cero: " + iguales0);
}        
    }
            
}

