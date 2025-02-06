import java.util.Scanner;
public class App4 {
    public static void imprimePositivo(int p) throws ExcepcionPositiva {
        if (p < 0) {
            throw new ExcepcionPositiva("El valor debe ser positivo.");
        }
        System.out.println("Valor positivo: " + p);
    }

    public static void imprimeNegativo(int n) throws ExcepcionNegativa {
        if (n >= 0) {
            throw new ExcepcionNegativa("El valor debe ser negativo.");
        }
        System.out.println("Valor negativo: " + n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Ingrese un numero (o 'exit' para salir): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                int number = Integer.parseInt(input);
                imprimePositivo(number);
                imprimeNegativo(number);
            } catch (ExcepcionPositiva e) {
                System.out.println("Error Positivo: " + e.getMessage());
            } catch (ExcepcionNegativa e) {
                System.out.println("Error Negativo: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Entrada no válida. Debe ingresar un número.");
            }
        }
        scanner.close();
    }
}