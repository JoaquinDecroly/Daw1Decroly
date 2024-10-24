import java.util.Scanner;

public class Notas {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        // matriz para almacenar las notas de 4 alumnos y 5 asignaturas
        double[][] notas = new double[4][5]; 
        
        // entrada de datos
        for (int i = 0; i < notas.length; i++) {//itera alumnos
            for (int j = 0; j < notas[i].length; j++) {//itera asignaturas
                System.out.println("Introduce la nota del Alumno " + (i + 1) + " para la Asignatura " + (j + 1) + ": ");
                notas[i][j] = entrada.nextDouble();
            }
        }
        
        // mostrar resultados
        for (int i = 0; i < notas.length; i++) {//itera alumnos x2
            double[] notasAlumno = notas[i];
            System.out.println("Alumno " + (i + 1) + ":");
            System.out.println("Nota mínima: " + encontrarMinimo(notasAlumno));
            System.out.println("Nota máxima: " + encontrarMaximo(notasAlumno));
            System.out.println("Media: " + calcularMedia(notasAlumno));
            System.out.println(); 
        }
        
        
    }

    public static double encontrarMinimo(double[] notas) {
        double min = notas[0];
        for (double nota : notas) {//for:each1 nota minima
            if (nota < min) {
                min = nota;
            }
        }
        return min;
    }

    public static double encontrarMaximo(double[] notas) {//for:each2 nota maxima
        double max = notas[0];
        for (double nota : notas) {
            if (nota > max) {
                max = nota;
            }
        }
        return max;
    }

    public static double calcularMedia(double[] notas) {//for:each nota media
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }
}