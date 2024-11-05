package lista5;

import java.util.Scanner;

public class Atv5_4 {

	public static void main(String[] args) {
		//Declaracao de variaveis
		char [] gabaritoProva = new char[10];
		char [] gabaritoAluno = new char[10];
        int [] freqMax = new int[10];

		int matriculaAluno;
		int cont = 0, contAprovados = 0, acertos = 0, notaMaiorFreq = 0;
		
		Scanner input = new Scanner (System.in);
		
		//Entrada de dados
		System.out.println("Gabarito da Prova");
		for (int i = 0; i < 10; i++) {
			do {
			System.out.print("Digite a respota da "+(i+1)+" ° questão: ");
			gabaritoProva[i] = Character.toUpperCase(input.next().charAt(0));
			
			if (gabaritoProva[i] != 'A' && gabaritoProva[i] != 'B' && gabaritoProva[i] != 'C' && gabaritoProva[i] != 'D' && gabaritoProva[i] != 'E') {
				System.out.println("\nAlternativa inválida.\n");
			}
			
			} while (gabaritoProva[i] != 'A' && gabaritoProva[i] != 'B' && gabaritoProva[i] != 'C' && gabaritoProva[i] != 'D' && gabaritoProva[i] != 'E');	
		}
		
		System.out.println("\nGabarito da Prova - Aluno");
		System.out.println("Para parar a inserção de dados digite 999 na matricula");
		while (cont >= 0) {
			System.out.print("\nDigite a matricula do "+(cont + 1)+" ° aluno: ");
			matriculaAluno = input.nextInt();
			
			if (matriculaAluno == 999){
				break;
			}
			
			for (int i = 0; i < 10; i++) {
				do {
				System.out.print("Digite a respota da "+(i+1)+" ° questão: ");
				gabaritoAluno[i] = Character.toUpperCase(input.next().charAt(0));
				
				if (gabaritoAluno[i] != 'A' && gabaritoAluno[i] != 'B' && gabaritoAluno[i] != 'C' && gabaritoAluno[i] != 'D' && gabaritoAluno[i] != 'E') {
					System.out.println("\nAlternativa inválida.\n");
				}
				
				if(gabaritoProva[i] == gabaritoAluno[i]){
					acertos++;
				}
				
				} while (gabaritoAluno[i] != 'A' && gabaritoAluno[i] != 'B' && gabaritoAluno[i] != 'C' && gabaritoAluno[i] != 'D' && gabaritoAluno[i] != 'E');	
			}
			
			for (int i = 0 ; i < 10; i ++) {
				if (acertos > 6) {
					contAprovados++;
				}
				if (i == acertos) {
	                freqMax[i] = freqMax[i]+ 1;
				}
			}
			
			System.out.println("Quantidade de acertos do aluno "+(cont+1)+" °: "+acertos);
			
			acertos = 0;
			cont++;
		}
		
		//Calculos
		
		//Saida de dados
		
		
		for (int i = 0; i < freqMax.length; i++) {
			if (notaMaiorFreq < freqMax[i]){
				notaMaiorFreq = freqMax[i];
			}
		}
		
			System.out.println("Nota com maior frequencia: "+notaMaiorFreq);
	}

}
