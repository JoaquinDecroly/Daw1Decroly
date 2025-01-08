import java.util.Scanner;

public class App {
    public static void main(String[] args)  {
        String option = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----Bienvenido a tu observatorio Decroly-----");
        do {
            System.out.println("Elegir una opcion");
            System.out.println("-----------");
            System.out.println("0. Salir");
            System.out.println("1. Astros");
            System.out.println("2. Satelites");
            System.out.println("3. Planetas");
            option = scanner.nextLine();

               switch (option) {
                case "0":
                    System.out.println("Fue un placer ayudarle. Hasta más ver...");
                    break;

                case "1":
                String astro = "";
                System.out.println("Astros");
                System.out.println("1. Sol");
                System.out.println("2. Luna");
                System.out.println("3. Marte");
                System.out.println("4. Jupiter");
                System.out.println("5. Saturno");
                System.out.println("6. Urano");
                System.out.println("7. Neptuno");
                System.out.println("8. Mercurio");
                System.out.println("9. Venus");
                astro = scanner.nextLine();

                if (astro.equals("1")) {
                    
                    
                }
                break;

                case "2":
                String satelite = "";
                System.out.println("Satelites");
                System.out.println("1. Luna");
                System.out.println("2. Marte");
                System.out.println("3. Júpiter");
                System.out.println("4. Saturno");
                System.out.println("5. Urano");
                System.out.println("6. Neptuno");
                break;

                case "3":
                String planeta = "";
                System.out.println("Planetas");
                System.out.println("1. Mercurio");
                System.out.println("2. Venus");
                System.out.println("3. Tierra");
                System.out.println("4. Marte");
                System.out.println("5. Júpiter");
                System.out.println("6. Saturno");
                System.out.println("7. Urano");
                System.out.println("8. Neptuno");
                break;

                default:
                System.out.println("Opcion invalida");
                    break;
               }

            
        } while (!option.equals("0"));

        // Satelites s1 = new Satelites(30000000, 10000000, "Saturno", 10000000, 999999, 36000000, -34,0);
        // System.out.println(s1);

        // Planetas p1 = new Planetas(500000000, 360000, 9999999, 54, 35, 5000000, true, false);
        // System.out.println(p1);

        // Astros a1 = new Astros(500000000, 333333, 777777777, 94, 54);
        // System.out.println(a1);
    }
}
