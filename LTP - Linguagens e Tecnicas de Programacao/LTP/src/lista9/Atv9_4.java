package lista9;

import java.util.Scanner;

public class Atv9_4 {
    public static void main(String[] args) {
        // Declaracao de variaveis
        String placaCarro, dataMulta;
        byte qtdCaracteres;
        float valorMulta = 0, valorTotalMultas = 0, valorMenorMulta = 99999999, mediaMultas;
        int cont = 0;
        boolean letra = true, valido = true;

        Scanner input = new Scanner(System.in);


        //Entrada de dados
        do {
            do{
                System.out.print("Digite o número da placa: ");
                placaCarro = input.nextLine();

                if(placaCarro.equalsIgnoreCase("fim")){
                    break;
                }
    
                qtdCaracteres = (byte) placaCarro.length();


                if (qtdCaracteres != 7 || ! letra) {
                    System.out.println("A placa do carro deve conter 7 digitos.");
                }
  
            } while (qtdCaracteres != 7 || ! letra);

            do {
                System.out.print("Digite o valor da multa: ");
                valorMulta = input.nextFloat();
                input.nextLine();
                
                if (valorMulta <= 0){
                    System.out.println("O valor da multa deve ser maior que R$00.00");
                } else {
                    valorTotalMultas += valorMulta;
                    if(valorMulta < valorMenorMulta){
                        valorMenorMulta = valorMulta;
                    }
                }   
            } while (valorMulta <= 0);

            do {
                System.out.print("Digite a data da multa:");
                dataMulta = input.nextLine();

                valido = dataEhValida(dataMulta);

                if (!valido){
                    System.out.println("Data invalida.");
                }
            } while (! valido);

            cont++;
            
        } while(! placaCarro.equalsIgnoreCase("fim"));

        if(cont > 0){
            mediaMultas = valorTotalMultas/cont;
            System.out.println("\nValor total das multas: "+valorTotalMultas);
            System.out.println("Valor da menor multa: "+valorMenorMulta);
            System.out.println("Média das multas:" +(mediaMultas));
        } else {
            System.out.println("Não ocorreu multas.");
        }

    }

    public static boolean dataEhValida (String dataMulta){

        boolean passou = true;
        int qtdCaracteresDias = dataMulta.length();
        int dia = 1, mes = 1, ano = 2024;
        try {
            dia = Integer.parseInt(dataMulta.substring(0, 1));
            mes = Integer.parseInt(dataMulta.substring(3, 4));
            ano = Integer.parseInt(dataMulta.substring(6, 9));
        } catch (NumberFormatException e){
            passou = false;
        }

        if (qtdCaracteresDias != 10 || (dia <= 0 || dia > 31) || (mes <= 0 || mes > 12) || (ano > 2024) || dataMulta.charAt(2) != '/' || dataMulta.charAt(5) != '/'){
            passou = false;
        } else if ((mes == 4 ||  mes == 6 ||  mes == 9 ||  mes == 11) && dia == 31){ //4,6,9,11
            passou = false;
        } else if (mes == 2) {
            if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
                if (dia < 1 || dia > 29) {
                    passou = false;
                }
            } else {
                if (dia < 1 || dia > 28) {
                    passou = false;
                }
            }
        } else {
            passou = true;
        }
        return passou;
    }
}
