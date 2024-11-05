package lista2;
import java.util.*;

public class Atv4 {

	public static void main(String[] args) {
		//Declaracao de variaveis
		
		int voto; //opção de voto
		int voto1 = 0, voto2 =0, voto3 = 0, votoNulo = 0; //opções de votos dos candidatos
		int qtd = 0; //quantidade de votos;
		int resp;
		boolean ligado = false;
		
		Scanner input = new Scanner(System.in);
		
		while (ligado != true) {
			System.out.println("Votação Eleitoral");
			System.out.println("1 - Primeiro Candidato");
			System.out.println("2 - Primeiro Candidato");
			System.out.println("3 - Primeiro Candidato");
			System.out.println("0 - Voto nulo");
			System.out.println("Digite o número correspondente ao candidato: ");
			voto = input.nextInt();
			qtd = qtd+1;
			
			switch (voto) {
				case 0 : votoNulo = votoNulo+1;
					break;
				case 1 : voto1 = voto1+1;
					break;
				case 2 : voto2 = voto2+1;
					break;
				case 3 : voto3 = voto3+1;
					break;
			}
			
			System.out.println("Se for realizar mais um voto");
			System.out.println("1 - Sim || 2 - Não");
			resp = input.nextInt();
			
			if (resp == 1) {
				ligado = false;
			} else {
				ligado = true;
			}
		}
		
		System.out.println("Quantidade de votos");
		System.out.println("Candidato 1: "+voto1);
		System.out.println("Candidato 2: "+voto2);
		System.out.println("Candidato 3: "+voto3);
		System.out.println("Voto Nulo: "+votoNulo);
		System.out.println("Quantidade total de votos: "+qtd);
				

	}

}
