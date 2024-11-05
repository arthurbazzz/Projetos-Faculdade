package lista2;
import java.util.*;

public class Atv3 {

	public static void main(String[] args) {
		//Declaracao de variaveis
		String nomeAluno;
		float nota1, nota2, nota3;
		float mediaNotas;
		
		Scanner input = new Scanner(System.in);
		
		//Entrada de dados
			System.out.print("Digite o nome do aluno: ");
			nomeAluno = input.nextLine();
			
			System.out.print("Digite a primeira nota: ");
			nota1 = input.nextFloat();
			
			System.out.print("Digite a segunda nota: ");
			nota2 = input.nextFloat();
			
			System.out.print("Digite a terceira nota: ");
			nota3 = input.nextFloat();
			
		//Calculo
			mediaNotas = (nota1+nota2+nota3) / 3;
			System.out.println(mediaNotas);
			
		//Lógica e Saida de dados
			if (mediaNotas >= 7 ) {
				System.out.println(nomeAluno+" foi aprovado!");
			} else if (mediaNotas >= 4.1 && mediaNotas <= 7) {
				System.out.println(nomeAluno+" esta de recuperação!");
			} else {
				System.out.println(nomeAluno+" foi reprovado!");
			}
		

	}

}
