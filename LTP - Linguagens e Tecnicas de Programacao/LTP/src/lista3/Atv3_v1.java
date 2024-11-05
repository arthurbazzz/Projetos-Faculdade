package lista3;
import java.util.*;
public class Atv3_v1 {

	public static void main(String[] args) {
		//Declaracao de variaveis
        int [] notas = new int[10];
        int aprovados = 0, reprovados = 0;
        byte i;
        Scanner input = new Scanner(System.in);

        //Entrada de dados
        for(i = 0; i < 5; i++){
            System.out.print("Digite a nota do "+(i+1)+"° aluno: ");
            notas[i] = input.nextInt();
            if (notas[i] >= 60){
                aprovados = aprovados+1;
                System.out.println("Aluno aprovado!\n");
            } else{
                reprovados = reprovados+1;
                System.out.println("Aluno reprovado!\n");
            }
        }

        //Saida de dados
        System.out.println("\nAlunos aprovados: "+aprovados+"\nAlunos reprovados: "+reprovados);

	}

}
