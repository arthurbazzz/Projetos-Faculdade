package Atividade_1;
import java.util.*;

public class Atv2 {

	public static void main(String[] args) {
		//Declaração de variaveis
		String nomeFunc;
		float salario;
		float novoSalario;
		Scanner input = new Scanner (System.in);
		
		//Entrada de dados
		System.out.print("Digite o nome do funcionário: ");
		nomeFunc = input.nextLine();
		
		System.out.print("Digite o salário do(a) "+nomeFunc+": ");
		salario = input.nextFloat();
		
		//Calculo
		novoSalario =  salario + (float) (salario * 0.15);
		
		//Saida de dados
		System.out.println("Funcionario - "+nomeFunc);
		System.out.println("Antigo salário: "+salario);
		System.out.println("Novo salário: "+novoSalario);
	}

}
