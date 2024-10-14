package com.decroly.daw;
		import java.util.Scanner;

public class Billetes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		 Scanner reader = new Scanner(System.in);
         
         int cantidad; 
         

         do {
             System.out.println("Buenos días, inserte el dinero (Solo se admiten billetes de 5)");
             cantidad = reader.nextInt();

             if (cantidad % 5 != 0) {
                 System.out.println("Solo se admiten billetes de 5");
             } continue;

     } while (cantidad % 5 != 0);


     int billete500 = cantidad / 500; 
     cantidad %= 500;
 

     int billete200 = cantidad / 200; 
     cantidad %= 200;

     int billete100 = cantidad / 100; 
     cantidad %= 100;

     int billete50  = cantidad / 50; 
     cantidad %= 50;

     int billete20  = cantidad / 20; 
     cantidad %= 20;   

     int billete10  = cantidad / 10; 
     cantidad %= 10;

     int billete5  = cantidad / 5; 
     cantidad %= 5;

     if (billete500  > 0) {
         System.out.println("Billetes de 500: " + billete500);
         }

     if (billete200   > 0) { 
         System.out.println("Billetes de 200: " + billete200);
         }

     if (billete100   > 0) {
         System.out.println("Billetes de 100: " + billete100);
     }
     if (billete50 > 0 ) {
         System.out.println("Billetes de 50: " + billete50);
     }
     if  (billete20 > 0 ) {  
         System.out.println("Billetes de 20: " + billete20);
     }
     if (billete10 > 0){
         System.out.println("Billetes de 10: " + billete10);
     }
     if  (billete5 > 0){ 
         System.out.println("Billetes de  5: " + billete5);


     }   
 }
}

