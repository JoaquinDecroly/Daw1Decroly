package act2;

import java.util.Scanner;

public class HorasMinSeg {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int hora = pedirHora(entrada, "Introduce la hora (0-23):", 0, 23);
        int min = pedirHora(entrada, "Introduce los minutos (0-59):", 0, 59);
        int seg = pedirHora(entrada, "Introduce los segundos (0-59):", 0, 59);

        // Sumar un segundo
        seg++;

        // Ajustar valores
        if (seg >= 60) {
            min++;
            seg = 0;
        }
        if (min >= 60) {
            hora++;
            min = 0;
        }
        if (hora >= 24) {
            hora = 0;
        }

        System.out.println("La hora es --> " + hora + ":" + min + ":" + seg);
    }

    private static int pedirHora(Scanner entrada, String mensaje, int minimo, int maximo) {
        while (true) {
            System.out.println(mensaje);
            int valor = entrada.nextInt();
            if (valor >= minimo && valor <= maximo) {
                return valor;
            } else {
                System.out.println("Valor inválido. Intente de nuevo.");
            }
        }
    }
}



