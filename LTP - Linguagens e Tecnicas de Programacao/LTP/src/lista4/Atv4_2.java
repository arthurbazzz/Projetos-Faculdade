package lista4;
import java.util.Scanner;

public class Atv4_2 {

	public static void main(String[] args) {
		// Declaracao de variaveis
		int voto, votoA = 0, votoB = 0, votoC = 0, votoNulo = 0, votoBranco = 0;
		Scanner input = new Scanner(System.in);
		
		// Entrada de dados
		System.out.print("Votação eleitoral XYZ\n1 - Candidato A\n2 - Candidato B"
				+ "\n3 - Candidato C\n4 - Candidato Nulo\n5 - Candidato Branco");
		
		for (int i = 0 ; i < 5; i++) {
			System.out.print("\nDigite seu voto: ");
			voto = input.nextInt();
			
			if (voto < 1 || voto > 5) {
				System.out.println("Valor invalido!");
				System.out.print("Digite outro valor: ");
				voto = input.nextInt();
			}
			
			switch (voto) {
				case 1 : votoA ++;
					break;
				case 2 : votoB ++;
					break;
				case 3 : votoC ++;
					break;
				case 4 : votoNulo ++;
					break;
				case 5 : votoBranco ++;
					break;
				default : System.out.print("erro");
					break;
			}
			
			System.out.println(votoA+" "+votoB+" "+votoC+" "+votoNulo+" "+votoBranco+" ");
		}
		// Saida de dados
		if (votoA > votoB && votoA > votoC) {
			System.out.println("Candidato A ganhou a eleição");
		} else if (votoB > votoC) {
			System.out.println("Candidato B ganhou a eleição");
		} else {
			System.out.println("Candidato C ganhou a eleição");
		}
		
		System.out.println("Quantidade de votos nulos: "+votoNulo);
		System.out.println("Quantidade de votos branco: "+votoBranco);
	}

}
