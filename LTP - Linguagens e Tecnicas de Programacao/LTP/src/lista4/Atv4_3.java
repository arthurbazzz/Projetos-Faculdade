package lista4;
import java.util.Scanner;

public class Atv4_3 {

	public static void main(String[] args) {
		//Declaracao de variaveis
		char sexo;
		float altura = 0, menorAltura = 999999, maiorAltura = 0;
		int numeroM = 0, numeroF = 0, cont = 0;
		float mediaAltura, mediaGeral;
		boolean loop = true;
		
		Scanner input = new Scanner (System.in);
		
		//Entrada de dados
		while (loop != false) {
			System.out.print("Digite o sexo do "+(cont+1)+"° atleta: ");
			sexo = (Character.toUpperCase(input.next().charAt(0)));
			
			if (sexo == 'M' || sexo == 'F') {
				//Verifica se o sexo é M ou F
				if (sexo == 'M') {
					numeroM++;
				} else {
					numeroF++;
				}	
				
				System.out.print("Digite Altura do "+(cont+1)+"° atleta: ");
				altura = input.nextFloat();
				
				if(altura > 0 && altura <= 2.5) {
					//Verifica a altura maior e menor
					if (maiorAltura < altura) {
						maiorAltura = altura;
					}
					
					if (menorAltura > altura) {
						menorAltura = altura;
					}	
					
				} else {
					System.out.println("Valor invalido\nDigite outro valor: ");
					altura = input.nextFloat();
				}

			} else {
				System.out.print("Valor informado está errado\nUtilize M ou F: ");
				sexo =  (Character.toUpperCase(input.next().charAt(0)));
			}
			
			System.out.println(numeroM+" "+numeroF+" ");
			

			


			
			cont ++;
		}

		

	}

}
