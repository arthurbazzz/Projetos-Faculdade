package lista6;

import java.util.Scanner;

public class Atv6_1 {
    public static void main(String[] args) {
        // Declaracao de variaveis
        String[][] passagens = new String[20][6];
        String nomePassageiro;
        byte linha = 0, coluna = 0;

        Scanner input = new Scanner(System.in);
        //Entrada de dados
        
        do {
            System.out.print("Digite seu nome: ");
            nomePassageiro = input.nextLine();

            if (nomePassageiro.equals("parar")){
                break;
            }
            do{
                System.out.println("Digite a fileira: ");
                linha = input.nextByte();

                if (linha < 1 || linha > 20){
                    System.out.println("Digite um número entre 1 e 20.");
                }
            } while (linha < 1 || linha > 20);

            do {
                System.out.println("Digite a cadeira: ");
                coluna = input.nextByte();

                if (coluna < 1 || coluna > 7){
                    System.out.println("Digite um número entre 1 e 6.");
                }                
            } while (coluna < 1 || coluna > 7);

            passagens[linha - 1][coluna - 1] = nomePassageiro;

            input.nextLine();
            
        } while (! nomePassageiro.equals("parar"));
    


        // Saida de dados
        for (int i = 0; i < 20; i++){
            System.out.print(i+1);
            for (int j = 0; j < 6; j++){
                if (passagens[i][j] == null){
                    System.out.print(" * ");
                } else {
                    System.out.print(passagens[i][j]+" ");

                }
            }   
            System.out.println();
        }
    }
}