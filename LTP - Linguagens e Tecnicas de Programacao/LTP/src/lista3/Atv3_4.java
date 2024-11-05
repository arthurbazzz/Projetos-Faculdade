package lista3;

import java.util.Scanner;

public class Atv3_4 {

	public static void main(String[] args) {
		// Declaracao de variaveis
		String nome, nomeNota = null, resp = null;
		float nota1, nota2, nota3;
		float notaFinal = 0, mediaTotal = 0, maiorNota = 0;
		int cont = 0;
		boolean loop = true;

		Scanner input = new Scanner(System.in);

		// Entrada de dados

		System.out.println("Registro de notas alunos LTP");

		while ((loop != false)) {
			System.out.print("\nDigite o nome do " + (cont + 1) + " ° aluno: ");
			nome = input.nextLine();

			// Solucao para o scanner nao pular o nome;
			System.out.print("Digite a 1° nota: ");
			nota1 = Float.parseFloat(input.nextLine());
			System.out.print("Digite a 2° nota: ");
			nota2 = Float.parseFloat(input.nextLine());
			System.out.print("Digite a 3° nota: ");
			nota3 = Float.parseFloat(input.nextLine());
			
			// Calculos
			notaFinal = (nota1 + nota2 + nota3);
			mediaTotal = mediaTotal + notaFinal;

			if(notaFinal >= 60){
				System.out.println(nome+" foi Aprovado!\nNota final: "+notaFinal);
			} else {
				System.out.println(nome+" foi Reprovado\nNota Final: "+notaFinal);
			}

			if (notaFinal > maiorNota) {
				maiorNota = notaFinal;
				nomeNota = nome;
			}

			System.out.print("\nDigite FIM para cancelar a entrada de dados\nPara continuar qualquer use qualquer tecla: ");
			resp = input.nextLine().toUpperCase();

			//Para o loop
			if (resp.equals("FIM")) {
				loop = false;
			}

			cont++;
			
		}

		// Saida de de dados
		System.out.println("\nQuantidade de alunos: " + cont);
		System.out.println("Aluno com maior nota final: " + nomeNota+"\nMaior nota: "+maiorNota);
		System.out.println("Media aritmetica: " + (mediaTotal/cont));
	}

}
