package revisao;

import java.util.Scanner;

public class Atv4_6 {
    public static void main(String[] args) {
        //Declaracao de variaveis
        byte tipoVoo,
        qtdPassagens = 0,
        qtdPassagensVoo1 = 0,
        qtdPassagensVoo2 = 0,
        qtdPassagensVoo3 = 0;
        float valorPassagem;
        Scanner input = new Scanner (System.in);

        do {
            do {
                System.out.print("Digite o número do voo: ");
                tipoVoo = input.nextByte();
                if (tipoVoo <= 0 || tipoVoo > 3){
                    System.out.println("Valor invalido");
                }
            } while (tipoVoo < 0 || tipoVoo > 3);
            
            do {
                System.out.print("Digite a quantidade de passagens que deseja comprar: ");
                qtdPassagens = input.nextByte();

                if (qtdPassagens <= 0 || qtdPassagens > 100){
                    System.out.println("Valor invalido");
                }
            } while (qtdPassagens <= 0 || qtdPassagens > 100);

            if (tipoVoo == 1){     
                do{             
                    qtdPassagensVoo1 += qtdPassagens;
                    if(qtdPassagensVoo1 > 100){
                        System.out.println("Valor invalido");
                        System.out.print("Quantidade de bancos excedidos: "+(qtdPassagens));
                        System.out.println("\nDigite uma quantidade valida: ") ;
                        qtdPassagensVoo1 -=qtdPassagens;

                        qtdPassagens = input.nextByte();
                    }
                } while (qtdPassagensVoo1 <= 0 || qtdPassagensVoo1 > 100);

            } else if (tipoVoo == 2){

            } else {

            }

        } while ((qtdPassagensVoo1 >= 0 || qtdPassagensVoo1 <=100) 
            &&   (qtdPassagensVoo2 >= 0 || qtdPassagensVoo2 <=100)  
            &&   (qtdPassagensVoo3 >= 0 || qtdPassagensVoo3 <=100));
    }

}
