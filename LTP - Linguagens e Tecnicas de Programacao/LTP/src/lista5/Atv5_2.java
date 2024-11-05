package lista5;

import java.util.Scanner;

public class Atv5_2 {
    public static void main(String[] args) {
        //Declaracao de variaveis
        int [] freqMax = new int[11];
        int notas;

        Scanner input = new Scanner(System.in);

        //Entrada de dados
        for (int i = 0 ; i < 20; i++){

            do{
                System.out.print("Digite a nota do "+(i+1)+"° aluno: ");
                notas = input.nextInt();

                if (notas < 0 || notas > 10){
                    System.out.println("\nDigite uma nota maior entre 0 e 10.\n");
                }
            } while( notas < 0 || notas > 10);

            for (int j = 0; j < 11; j++){
                if (notas == j){
                    freqMax[j] = freqMax[j]+ 1;
                }
            }
        }

        //Saida de dados
        System.out.println("\n            Tabela de notas e frequências");
        System.out.println("     Nota                           Frequência absoluta");
        for (int i = 0; i < 11; i++){
            if (i < 10){
                System.out.println("       "+i+"                                      "+freqMax[i]);
            } else {
                System.out.println("       "+i+"                                     "+freqMax[i]);
            }
           
        }
    }
}
