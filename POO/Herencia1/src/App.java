public class App {
    public static void main(String[] args) throws Exception {
        Satelites s1 = new Satelites(30000000, 10000000, "Saturno", 10000000, 999999, 36000000, -34,0);
        System.out.println(s1);

        Planetas p1 = new Planetas(500000000, 360000, 9999999, 54, 35, 5000000, true, false);
        System.out.println(p1);

        Astros a1 = new Astros(500000000, 333333, 777777777, 94, 54);
        System.out.println(a1);
    }
}
