package lista9;

import java.util.Scanner;

public class Atv9_2 {
    public static void main(String[] args) {
        //Declaracao de variaveis
        String codigoEntrada;
        int qtdCaracteres;
        long codigo = 0;
        boolean loop;

        Scanner input = new Scanner (System.in);

        //Entrada de dados
        do{
            do{
                System.out.print("Digite o codigo: ");
                codigoEntrada = input.nextLine();
                
                qtdCaracteres = codigoEntrada.length();
                System.out.println(qtdCaracteres);

                if (qtdCaracteres != 11){
                    System.out.println("O código deve conter 11 numeros.");
                }

            } while(qtdCaracteres != 11);

            try{
                codigo = Long.parseLong(codigoEntrada);
                loop = true;
            } catch(NumberFormatException E) {
                System.out.println("O código deve conter apenas numeros");
                loop = false;
            }
        } while ( ! loop);

        calcularDigitosVerificadores(codigoEntrada);

    }

    public static void calcularDigitosVerificadores(String codigoEntrada){
        char codigoVerificador1, codigoVerificador2;
        int soma = 0, multiplicacao = 1;

        String verificador;
        String verificadorCod = codigoEntrada.substring(9);

        for (byte i=0;i<9;i++){
            soma = soma + Character.digit(codigoEntrada.charAt(i), 10);
            multiplicacao = multiplicacao * Character.digit(codigoEntrada.charAt(i), 10);   
        }

        soma = soma / 10;
        codigoVerificador1 = String.valueOf(soma).charAt(0);

        codigoVerificador2 = String.valueOf(soma).charAt(String.valueOf(soma).length()-1);

        verificador = String.valueOf(codigoVerificador1) + String. valueOf(codigoVerificador2);

        if (verificadorCod.equals(verificador)){
            System.out.println("Código correto");
        }else {
            System.out.println("Código incorreto");
        }
    }
}
