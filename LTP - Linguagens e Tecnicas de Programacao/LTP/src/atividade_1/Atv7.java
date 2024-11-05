package Atividade_1;
import java.util.Scanner;

public class Atv7 {

	public static void main(String[] args) {
		//Declaracao de variaveis
		
		float valorDepositado;
		float cheque1, cheque2;
		float valorFinal;
		float calc, calc2; //variaveis para calculo
		
		Scanner input = new Scanner (System.in);
		
		//Entrada de dados;
		
		System.out.print("Digite o valor depositado: ");
		valorDepositado = input.nextFloat();
		
		System.out.print("Digite o valor do 1 cheque: ");
		cheque1 = input.nextFloat();
		
		System.out.print("Digite o valor do 2 cheque: ");
		cheque2 = input.nextFloat();
		
		//Calculo
		calc =  (float) (cheque1 * (0.02 / 100));
		calc2 = (float) (cheque2 * (0.02 / 100));
		
		valorFinal = valorDepositado - (cheque1 + cheque2) - (calc + calc2);
		
		//Saida Final
		System.out.println("Valor final: "+valorFinal);
	}

}
