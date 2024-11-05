package lista2;

import java.util.Scanner;

public class Atv2_5 {

	public static void main(String[] args) {
		//Declaracao de variaveis
		
		float lado1, lado2, lado3;
		float calc;
		
		Scanner input = new Scanner(System.in);
		
		//Entrada de dados
		
		System.out.print("Digite o primeiro lado: ");
		lado1 = input.nextFloat();
		
		System.out.print("Digite o segundo lado: ");
		lado2 = input.nextFloat();
		
		System.out.print("Digite o terceiro lado: ");
		lado3 = input.nextFloat();
		
		// Calculos e saida de dados
		
		if (lado1+lado2 <= lado3 || lado1+ lado3 <= lado2 || lado2+lado3 <= lado1) {
			System.out.println("Não é um triangulo!");
		} else if (lado1 == lado2 && lado1 == lado3) {
			System.out.println("Triangulo Equilatero");
		} else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
			System.out.println("Triangulo Isoceles");
		} else {
			System.out.println("Triangulo Escaleno");
		}
		
	}

}
