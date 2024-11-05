package Atividade_1;
import java.util.*;

public class Atv1 {

	public static void main(String[] args) {
		//Declaracao da variavel
		String nomeAluno;
		byte nota1;
		byte nota2;
		byte nota3;
		Scanner input = new Scanner(System.in);		
		
		System.out.print("Digite o nome do aluno: ");
		nomeAluno = input.nextLine();
		
		System.out.println(nomeAluno);
		
		System.out.print("Digite a nota da primeira avaliação: ");
		nota1 = input.nextByte();
		
		System.out.println(nota1);
		
		System.out.print("Digite a nota da segundo avaliação: ");
		nota2 = input.nextByte();
		
		System.out.println(nota2);
		
		System.out.print("Digite a nota da terceira avaliação: ");
		nota3 = input.nextByte();
		
		System.out.println(nota3);
	}

}
