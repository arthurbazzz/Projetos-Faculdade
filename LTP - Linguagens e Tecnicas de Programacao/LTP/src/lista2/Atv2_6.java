package lista2;

import java.util.Scanner;

public class Atv2_6 {

	public static void main(String[] args) {
		//Declaracao de variaveis
		
		float peso, altura;
		float imc;
		float pesoMax, pesoMin;
		
		Scanner input = new Scanner (System.in);
		
		//Entrada de dados
		
		System.out.print("Digite o peso (KG): ");
		peso = input.nextFloat();
		
		System.out.print("Digite a altura (Metros): ");
		altura = input.nextFloat();
		
		//Calculo
		imc = (float) (peso / Math.pow(altura, 2));
		pesoMin = (float) (20 * Math.pow(altura, 2));
		pesoMax = (float) (25 * Math.pow(altura, 2));
		
		//Lógica e saida de dados
		if (imc < 20) {
			System.out.println("\nIMC: "+imc);
			System.out.println("Abaixo do peso!");
			System.out.println("Peso mínimo: "+pesoMin+"\nPeso máximo: "+pesoMax);
		} else if (imc >= 20 && imc <=25) {
			System.out.println("\nIMC: "+imc);
			System.out.println("Peso ideal!");
			System.out.println("Peso mínimo: "+pesoMin+"\nPeso máximo: "+pesoMax);
		} else {
			System.out.println("\nIMC: "+imc);
			System.out.println("Acima do peso!");
			System.out.println("Peso mínimo: "+pesoMin+"\nPeso máximo: "+pesoMax);
		}

	}

}
