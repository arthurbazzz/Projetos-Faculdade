package Atividade_1;
import java.util.*;

public class Atv5 {

	public static void main(String[] args) {
		//Declaração das variaveis
		float pe;
		float cm;
		float jarda;
		float milha;
		float polegada;
		Scanner input = new Scanner(System.in);

		//Entrada de dados
		System.out.print("Digite o valor de pés que deseja converter: ");
		pe = input.nextFloat();
		
		//Conversão
		polegada = 12*pe;
		cm = (float) (pe * 30.48);
		jarda = (pe/3);
		milha = pe / 5280;
		// milha = jarda / 1760;

		//Saida de dados
		System.out.println("Valor inserido: "+pe+" pés");
		System.out.println("Polegada: "+polegada);
		System.out.println("CM: "+cm);
		System.out.println("Jarda: "+jarda);
		System.out.println("Milha: "+milha);
	}

}


