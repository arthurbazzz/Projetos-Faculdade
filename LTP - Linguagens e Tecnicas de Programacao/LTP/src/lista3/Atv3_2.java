package lista3;

import java.util.Scanner;

public class Atv3_2 {
    public static void main(String[] args) {
        //Declaracao de variaveis
        int valor, fatorial, i;
        Scanner input = new Scanner(System.in);

        //Entrada de dados
        System.out.print("Digite o valor do fatorial: ");
        valor = input.nextInt();

        //Calculo
        fatorial = valor;
        for (i = 1; i < valor; i++){
            fatorial *= i;
            System.out.println(valor+ " x "+ i+ " = "+fatorial);
        }
        System.out.println("\n"+fatorial);
    }
}
