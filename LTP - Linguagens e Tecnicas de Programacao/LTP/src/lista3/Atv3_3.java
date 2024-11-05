package lista3;
import java.util.Scanner;

public class Atv3_3 {

	public static void main(String[] args) {
		//Declaracao de variaveis
		char resp;
		int malbec = 0, tanat = 0,	carbenet=0;
		boolean rodando = true;
		
		Scanner input = new Scanner (System.in);
		
		//Entrada de dados
		System.out.println("Escolha a opção do vinho: \n"
				+ "- C para Cabernet Savion\n"
				+ "- M para Malbec\n"
				+ "- T para Tanat\n"
				+ "- F para finalizar");
		while (rodando != false) {
			System.out.print("\nDigite a letra respectiva do vinho: ");
			resp = input.next().charAt(0);
			resp = (Character.toUpperCase(resp));
		
			switch (resp) {
			case 'C' : carbenet = carbenet + 1;
			break;
			
			case 'M' : malbec= malbec +1;
			break;
			
			case 'T' : tanat= tanat +1;
			break;
			
			case 'F' : rodando = false;
			break;
			
			default : System.out.println("valor invalido");
			break;
			}
		}
		
		System.out.println("Quantidade total dos vinhos\nCabernet Savion: "+carbenet);
		System.out.println("Malbec: "+malbec);
		System.out.println("Tanat: "+tanat);
	}

}
