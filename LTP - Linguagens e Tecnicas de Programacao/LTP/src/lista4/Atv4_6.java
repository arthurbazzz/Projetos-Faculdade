package lista4;

import java.util.Scanner;

public class Atv4_6 {

    public static void main(String[] args) {
        // Declaracao de variaveis
        String nomePassageiro;
        byte tipoVoo,vooMenor = 0, qtdPassagens = 0;
        byte qtdVoo1 = 0, qtdVoo2 = 0, qtdVoo3 = 0;
        float calculoValor = 0, menorValor = 999999999, contValor1 = 0, contValor2 = 0, contValor3 = 0;
        boolean loop = true;

        Scanner input = new Scanner(System.in);

        System.out.println("Companhia Area Azul \nPara selecionar seu voo escolhe nas seguintes opções");
        System.out.println("1 - Voo 1 || 2 - Voo 2 || 3 - Voo 3");
        while (loop == true) {
            // Entrada de dados
            System.out.print("\nDigite o nome do passageiro: ");
            nomePassageiro = input.nextLine();

            System.out.print("Numero do Voo: ");
            tipoVoo = input.nextByte();
            
            if (tipoVoo == 1 || tipoVoo == 2 || tipoVoo == 3) {

                if (qtdVoo1 == 100 && tipoVoo == 1) {
                        System.out.println("Voo 1 sem assentos.");
                } else if (qtdVoo2 == 100 && tipoVoo == 2) {
                        System.out.println("Voo 1 sem assentos.");
                } else if (qtdVoo3 == 100 && tipoVoo == 3){
                    System.out.println("Voo 1 sem assentos.");
                } else {
                
                System.out.print("Quantidade de passagens compradas: ");
                qtdPassagens = input.nextByte();

                // Calculo e logica
                if (tipoVoo == 1) {
                    qtdVoo1 = (byte) (qtdVoo1 + qtdPassagens);
                    if (qtdVoo1 < 50) {
                        calculoValor = 100 * qtdPassagens;
                    } else if (qtdVoo1 <= 69) {
                        calculoValor = (float) ((100 * 0.3) * qtdPassagens);
                    } else {
                        calculoValor = (float) ((100 * 0.6) * qtdPassagens);
                    }    
                    contValor1 =+ calculoValor;
                    if ( menorValor > calculoValor ){
                        menorValor = calculoValor;
                        vooMenor = 1;
                    }

                } else if (tipoVoo == 2) {
                    qtdVoo2 = (byte) (qtdVoo2 + qtdPassagens);
                    if (qtdVoo2 < 50) {
                        calculoValor = 150 * qtdPassagens;
                    } else if (qtdPassagens <= 69) {
                        calculoValor = (float) ((150 * 0.3) * qtdPassagens);
                    } else{
                        calculoValor = (float) ((150 * 0.6) * qtdPassagens);
                    } 
                    contValor2 =+ calculoValor;
                    if ( menorValor > calculoValor ){
                        menorValor = calculoValor;
                        vooMenor = 2;
                    }
                } else {
                    qtdVoo3 = (byte) (qtdVoo3 + qtdPassagens);
                    if (qtdVoo1 < 50) {
                        calculoValor = 200 * qtdPassagens;
                    } else if (qtdVoo3 <= 69) {
                        calculoValor = (float) ((200 * 0.3) * qtdPassagens);
                    } else {
                        calculoValor = (float) ((200 * 0.6) * qtdPassagens);
                    }
                    contValor3 =+ calculoValor;
                    if ( menorValor > calculoValor ){
                        menorValor = calculoValor;
                        vooMenor = 3;
                    }
                }
                    System.out.println("Valor da passagem: " + calculoValor);
                }

            } else {
                System.out.println("Numero invalido para o Voo");
            }


            System.out.print("\nDeseja inserir outro passageiro? (s/n) ");
            char resp = Character.toUpperCase(input.next().charAt(0));

            if (resp == 'N') {
                loop = false;
            }

            input.nextLine();
        }

        input.close();

        // Saida de dados
        if (contValor1 > contValor2 && contValor1 > contValor3) {
            System.out.println("\nO voo que mais arrecadou foi o primeiro! \nValor arrecadado: " + contValor1);
        } else if (contValor2 > contValor3) {
            System.out.println("\nO voo que mais arrecadou foi o segundo! \nValor arrecadado: " + contValor2);
        } else {
            System.out.println("\nO voo que mais arrecadou foi o terceiro! \nValor arrecadado: " + contValor3);
        }

        System.out.println("Media de arrecadacao dos 3 voos: "+((contValor1+contValor2+contValor3)/3));

        System.out.println("Valor da passagem mais barata: "+menorValor+"\nNumero do voo: "+vooMenor);
    }
}
