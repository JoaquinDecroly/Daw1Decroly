import java.util.Scanner;

public class NxM {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Leer N y M para la matriz
        System.out.print("Introduce el número de filas: ");
        int N = entrada.nextInt();
        System.out.print("Introduce el número de columnas: ");
        int M = entrada.nextInt();

        // Crear la matriz
        int[][] matriz = new int[N][M];

        // Introducir los valores en la matriz
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print("Introduce el valor en la posición [" + i + "][" + j + "]: ");
                matriz[i][j] = entrada.nextInt();
            }
        }

        // Contadores
        int mayores0 = 0;
        int iguales0 = 0;
        int menores0 = 0;

        // Contar los valores
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matriz[i][j] > 0) {
                    mayores0++;
                } else if (matriz[i][j] == 0) {
                    iguales0++;
                } else {
                    menores0++;
                }
            }
        }

        // Salida de resultados
        System.out.println("Cantidad de valores mayores que cero: " + mayores0);
        System.out.println("Cantidad de valores menores que cero: " + menores0);
        System.out.println("Cantidad de valores iguales a cero: " + iguales0);

       
    }
}

