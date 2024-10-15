import java.util.Scanner;

public class N10media {
public static void main(String[] args) {
    double[] numeros = new double[20];
    Scanner scanner = new Scanner(System.in);

    // Pedir veinte números reales por teclado y almacenarlos en el array
    for (int i = 0; i < 20; i++) {
      System.out.print("Introduce el número " + (i + 1) + ": ");
      numeros[i] = scanner.nextDouble();
    }

    // Calcular la suma de los valores
    double suma = 0;
    for (int i = 0; i < 20; i++) {
      suma += numeros[i];
    }

    // Calcular la media
    double media = suma / 20;

    // Mostrar la media
    System.out.println("La media de los valores es: " + media);
  }
}

