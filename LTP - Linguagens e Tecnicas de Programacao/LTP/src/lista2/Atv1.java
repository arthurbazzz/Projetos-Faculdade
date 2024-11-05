package lista2;
import java.util.*;

public class Atv1 {

	public static void main(String[] args) {
		//Declaracao de variaveis		
		byte idade;
		Scanner input = new Scanner(System.in);
		
		//Entrada de dados;		
		System.out.print("Digite sua idade: ");
		idade = input.nextByte();
		
		//Logica e Saida de dados		
		if(idade >= 18) {
			System.out.println("Você é maior de idade!");
		} else {
			System.out.println("Você é menor de idade!");
		}
		
	}

}
