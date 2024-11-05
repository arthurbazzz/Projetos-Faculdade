package lista5;
import java.util.Scanner;

public class Atv5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float mediaAluno[] = new float[30];
		float notas, somaNotas = 0, mediaNotas =0;
		Scanner input = new Scanner (System.in);
		
		//Entrada de dados
			for (int i =0; i < 2; i++) {
				for (int j = 0; j < 5; j++) {
					System.out.print("Digite a nota "+(j+1)+" do aluno "+(i+1)+" °: ");
					notas = input.nextFloat();
					
					somaNotas += notas;
				}
				mediaAluno[i] = somaNotas/5;
				mediaNotas =+ somaNotas;
				somaNotas = 0;
				System.out.println();
			}
			
		// Saida de dados
			System.out.println("\nnúmero do aluno              média do aluno");
			for (int i =0; i < 2; i++) {
				System.out.println("        "+(i + 1)+"                         "+mediaAluno[i]);
				
			}
			System.out.println("\nMédia geral da turma: "+(mediaNotas/2));
	}
	

}
