package lista8;
import java.util.Scanner;
 
public class Atv8_2 {
 
	public static void main(String[] args) {
		// Declaracao de variaveis
		String[] nomeEmpregado = new String [100];
		float[] salarioEmpregado = new float [100];
        int [] numeroPecasFabricadas = new int [100];
		int codEmpregado = 0, contEmpregados = 0;
		float somaSalarios, mediaSalarios;
		Scanner input = new Scanner (System.in);
		
		//Entrada de dados
		
		System.out.println("Programa para calculo de salário\nPara encerrar a inserção de dados digite 'parar'. ");
		
		for (int i = 0; i < nomeEmpregado.length; i++) {
			
			System.out.print("Digite o nome do "+(i + 1)+" ° empregado: ");
			nomeEmpregado[i] = input.nextLine();
			
			if (nomeEmpregado[i].equals("parar")) {
				System.out.println("\nInserção de dados encerrada.");
				break;
			}
			
			do {
				System.out.print("Digite o código do empregado: ");
				codEmpregado = input.nextInt();
				
				if (codEmpregado <= 0) {
					System.out.println("Digite um valor maior que 0");
				}
			} while (codEmpregado < 0);
 
			do {
				System.out.print("Digite a quantidade de peças fabricadas pelo "+ (i + 1) + "° empregado: ");
				numeroPecasFabricadas[i] = input.nextInt();
				
				if (numeroPecasFabricadas[i] <= 0) {
					System.out.println("Digite um valor maior que 0");
				}
			} while (numeroPecasFabricadas[i] <= 0);
 
			
			contEmpregados++;
			input.nextLine();
		}
		
		//Calculo
		
		for (int i = 0; i < contEmpregados; i++) {
			salarioEmpregado[i] = calcularSalario(numeroPecasFabricadas[i]);
			
			mediaSalarios =+ salarioEmpregado[i] / contEmpregados;
			somaSalarios =+ salarioEmpregado[i];
		}
		
		//Saida de dados
		System.out.println("Nome                        Salario");
		System.out.println("--------------------------  -------");
		for (int i = 0; i < contEmpregados; i++) {
			System.out.print(nomeEmpregado[i]);
            for (int espaco = 0; espaco < (28 - nomeEmpregado[i].length()); espaco++){
                System.out.print(" ");
            }
            System.out.print(salarioEmpregado[i]);
            System.out.println();
		}
	}
	
	public static float calcularSalario (int numeroPecas) {
		float calculoSalario = 0;
		
		if (numeroPecas >= 1 || numeroPecas <= 200) {
			calculoSalario = numeroPecas * 2;
		} else if (numeroPecas <= 400) {
			calculoSalario = (float) (numeroPecas * 2.30);
		} else {
			calculoSalario = (float) (numeroPecas * 2.50);
		}
		
		return calculoSalario;
	}
}