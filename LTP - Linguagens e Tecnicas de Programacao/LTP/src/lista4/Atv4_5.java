package lista4;

import java.util.Scanner;

public class Atv4_5 {

    public static void main(String[] args) {
        // Declaracao de variaveis
        String respostaA, respostaB;
        boolean loop = true;

        Scanner input = new Scanner(System.in);

        System.out.println("Regras Jokenpo");
        System.out.println("Pedra ganha de Tesoura mas perde para Papel\nTesoura ganha de Papel\nPapel ganha de pedra\n");

        // Entrada de dados
        do {
            System.out.println("Digite a jogada do Jogador 1: ");
            respostaA = input.nextLine();

            System.out.println("Digite a jogada do Jogador 2: ");
            respostaB = input.nextLine();

            if ((respostaA.equals("tesoura") || respostaA.equals("papel") || respostaA.equals("pedra")) 
            && (respostaB.equals("tesoura") || respostaB.equals("papel") || respostaB.equals("pedra"))) {    
                if (respostaA.equals(respostaB)) {
                    System.out.println("Empate!");
                } else if (respostaA.equals("pedra")) {
                    if (respostaB.equals("papel")) {
                        System.out.println("Jogador 2 venceu!");
                    } else {
                        System.out.println("Jogador 1 venceu!");
                    }
                } else if (respostaA.equals("papel")) {
                    if (respostaB.equals("pedra")) {
                        System.out.println("Jogador 1 venceu!");
                    } else {
                        System.out.println("Jogador 2 venceu!");
                    }
                } else {
                    if (respostaB.equals("papel")) {
                        System.out.println("Jogador 1 venceu!");
                    } else {
                        System.out.println("Jogador 2 venceu!");
                    }
                }
            } else {
                loop = false;
            }
            System.out.println();
        } while (loop == true);
            input.close();
    }
}
