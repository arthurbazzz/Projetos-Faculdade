package lista2;
import java.util.*;
public class Atv2 {

	public static void main(String[] args) {
		//Declaracao de variaveis
		String nomeFuncionario;
		float salario;
		float salarioAumento;
		Scanner input = new Scanner(System.in);
		
		//Entrada de dados
		System.out.print("Digite o nome do funcionário: ");
		nomeFuncionario = input.nextLine(); 
		
		System.out.print("Digite o salario do funcionario: ");
		salario = input.nextFloat();
		
		//Lógica
		if(salario < 1000) {
			salarioAumento =  salario + (float) (salario * 0.15);
			System.out.println("Novo salario: "+salarioAumento);
		} else {
			salarioAumento = salario + (float) (salario * 0.10);
			System.out.println("Novo salario: "+salarioAumento);
		}

	}

}
