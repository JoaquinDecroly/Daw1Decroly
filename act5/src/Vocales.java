import java.util.Scanner;

public class Vocales {
public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce un texto: ");
        String texto = entrada.nextLine();

        int contadorA = 0;
        int contadorE = 0;
        int contadorI = 0;
        int contadorO = 0;
        int contadorU = 0;

        texto = texto.toLowerCase();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i); 
            switch (c) {
                case 'a':
                    contadorA++;
                    break;
                case 'e':
                    contadorE++;
                    break;
                case 'i':
                    contadorI++;
                    break;
                case 'o':
                    contadorO++;
                    break;
                case 'u':
                    contadorU++;
                    break;
                default:
                    break;
            }
        }

        System.out.println("Nº de A's: " + contadorA);
        System.out.println("Nº de E's: " + contadorE);
        System.out.println("Nº de I's: " + contadorI);
        System.out.println("Nº de O's: " + contadorO);
        System.out.println("Nº de U's: " + contadorU);
}
}
