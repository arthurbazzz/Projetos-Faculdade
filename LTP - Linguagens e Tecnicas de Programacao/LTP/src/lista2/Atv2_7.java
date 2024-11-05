package lista2;

import java.util.Scanner;

public class Atv2_7 {

	public static void main(String[] args) {
		//Declaracao de variaveis
		
		float salarioFunc;
		float bonusSalarial = 0, descontoVt = 0;
		byte tempoCasa;
		
		Scanner input = new Scanner (System.in);
		
		//Entrada de dados
		
		System.out.print("Digite o tempo de casa do funcionario: ");
		tempoCasa = input.nextByte();
		
		System.out.print("Digite o salario do funcionario: ");
		salarioFunc = input.nextFloat();
		
		//Calculo

		if (tempoCasa > 0 && tempoCasa <=5 && salarioFunc <=300) {
			bonusSalarial = 50;
			descontoVt = (float) (salarioFunc * 0.05);
		} 
		else if (tempoCasa > 0 && tempoCasa <=5 && salarioFunc >= 300) {
			bonusSalarial = 80;
			descontoVt = (float) (salarioFunc * 0.06);
		} 
		else if (tempoCasa >= 6 && tempoCasa <= 10 && salarioFunc <= 500) {
			bonusSalarial = (float) (salarioFunc*0.15);
			descontoVt = 70;
		} 
		else if (tempoCasa >= 6 && tempoCasa <= 10 && salarioFunc >= 500 && salarioFunc <= 2000) {
			bonusSalarial = (float) (salarioFunc*0.13);
			descontoVt = 90;
		}
		else if (tempoCasa >= 6 && tempoCasa <= 10 && salarioFunc >= 2000) {
			bonusSalarial = (float) (salarioFunc*0.12);
			descontoVt = (float) (salarioFunc * 0.08);
		} 
		else if (tempoCasa > 10 && salarioFunc >= 2000) {
			bonusSalarial = 300;
			descontoVt = (float) (salarioFunc * 0.04);
		}
		else {
			System.out.println("Valor invalido");
		}
		
		//Saida de dados
		
		System.out.println("\nEmpresa ABC - Calculo Salarial");
		System.out.println("Salario do funcionario: R$"+salarioFunc);
		System.out.println("Bonus salarial: R$"+bonusSalarial);
		System.out.println("Desconto Vale Transporte: R$"+descontoVt);
	}

}
