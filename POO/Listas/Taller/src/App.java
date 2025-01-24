import java.util.Scanner;

public class App {
public static void main(String[] args) {
    
    String option = "";
    String option2 = "";
    Scanner scanner = new Scanner(System.in);
    Taller taller = new Taller();
    

    do {
        System.out.println("1) Añadir coche\r\n" + 
                "2) Eliminar Coche\r\n" + 
                "3.) Salir");
                option = scanner.nextLine();
                

       switch (option) {
        case "1":
            Coche coche = new Coche(option, option, option);
            taller.anadeElemento(coche);   
            break;
        case "2":
        System.out.println("Matricula a eliminar: ");
        String matricula = scanner.nextLine();
            System.out.println("\"Esta es su matricula: \" + matricula1\r\n" + //
                                "Es correcto: \r\n" + 
                                "Si\r\n" + 
                                "No");
                    if (option2.equalsIgnoreCase("SI")) {
                        taller.eliminaElemento(matricula);
                    }else if (option2.equalsIgnoreCase("NO")) {
                        do {
                            System.out.println("Matricula a eliminar: ");
                            matricula = scanner.nextLine();
                        } while (!option2.equalsIgnoreCase("SI"));
                    }
        break;
        case "3":
        System.out.println("Gracias por usar el programa...");
        taller.visualizarCoches(coche);
        taller.visualizarMatriculas(matricula);
        taller.visualizaTaller(coche);
} 
    }while (!option.equals("3"));
}
}

