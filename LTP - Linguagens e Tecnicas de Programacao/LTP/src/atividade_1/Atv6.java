package Atividade_1;
import java.util.*;

public class Atv6 {

	public static void main(String[] args) {
		//Declaraçao das variaveis usu = usuario
		byte diaUsu, diaAtual; 
		byte mesUsu, mesAtual;
		int anoUsu, anoAtual;
		int diaF, mesF, anoF;
		
		Scanner input = new Scanner(System.in);
		
		//Entrada de dados
		System.out.print("Digite o dia do seu nascimento: ");
		diaUsu = input.nextByte();
		
		System.out.print("Digite o mês do seu nascimento: ");
		mesUsu = input.nextByte();
		
		System.out.print("Digite o ano do seu nascimento: ");
		anoUsu = input.nextInt();
		
		System.out.print("Digite o dia atual: ");
		diaAtual = input.nextByte();
		
		System.out.print("Digite o mês atual: ");
		mesAtual = input.nextByte();
		
		System.out.print("Digite o ano atual: ");
		anoAtual = input.nextInt();
		
		//Calculo
			diaF = diaUsu-diaAtual;
			mesF = mesUsu-mesAtual;
			anoF = anoAtual-anoUsu-1;

			//If para o ano > e dia e mes
			
		//Saida de dados
		System.out.println("Você tem "+anoF+" anos "+mesF+" meses "+diaF+" dias de vida." );
	}

}
