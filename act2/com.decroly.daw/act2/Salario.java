package act2;

import java.util.Scanner;

public class Salario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//CalcularSalario (nombre, salario bruto y neto + tasas)
		
				//35 horas = tarifa normal
				//>35 horas = 1.5 la tarifa normal
				
				//<500 € = libre de impuestos
				//>500 <= 900€ = 25% impuestos
				//>900€ = 45% impuestos
		
//		Si el número de horas trabajadas es menor o igual a 35:
//			Salario Bruto = Horas Trabajadas x Tarifa Normal
//			Si el número de horas trabajadas es mayor a 35:
//			Salario Bruto = (35 x Tarifa Normal) + ((Horas Trabajadas - 35) x Tarifa Normal x 1.5)
//			Impuestos
//
//			Si el Salario Bruto es menor o igual a 500 euros:
//			Impuestos = 0
//			Si el Salario Bruto es mayor a 500 euros pero menor o igual a 900 euros:
//			Impuestos = (Salario Bruto - 500) x 0.25
//			Si el Salario Bruto es mayor a 900 euros:
//			Impuestos = (400 x 0.25) + (Salario Bruto - 900) x 0.45
//			Salario Neto
//
//			Salario Neto = Salario Bruto - Impuestos
		
			double impuestos, tasas;
			int horas, pagoxhora;
			String nombre;
			
			double salarioBruto = 0;
			double salarioNeto = 0;
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("¿Nombre?");
			nombre = entrada.nextLine();
			
			System.out.println("¿Horas trabajadas?");
				horas = entrada.nextInt();
			System.out.println("¿Pago por horas trabajadas?");
				pagoxhora = entrada.nextInt();
			
			if (horas > 35) {
				salarioNeto = salarioBruto;
				salarioBruto = horas * pagoxhora;
					;
			} else{
				salarioBruto = (horas * pagoxhora) + ((horas - horas) * pagoxhora * 1.5);
			{
				if (salarioBruto <= 500 ) {
					salarioBruto = salarioNeto;
					impuestos = 0;
						System.out.println("Tu salario bruto es: " +salarioBruto);
						System.out.println("Tu salario neto es: " +salarioNeto);
						System.out.println("Los impuestos añadidos al salario bruto son: " +impuestos);
				} else if(salarioBruto > 500 && salarioBruto <= 900) {
						impuestos = (salarioBruto) * 0.25;
						salarioNeto = salarioBruto + impuestos;
							System.out.println("Tu salario bruto es: " +salarioBruto);
							System.out.println(" Tu salario neto(con impuestos)es: " +salarioNeto);
							System.out.println("Los impuestos añadidos al salario bruto son: " +impuestos);
				}else {
					impuestos = (salarioBruto) * 0.45;
					salarioNeto = salarioBruto + impuestos;
						System.out.println("Tu salario bruto es: " +salarioBruto);
						System.out.println("Tu salario neto(con impuestos) es: " +salarioNeto);
						System.out.println("Los impuestos añadidos al salario bruto son: " +impuestos);
				}
			}
			}
	}
}

