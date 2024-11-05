package Atividade_1;
import java.util.*;
public class Atv4 {

	public static void main(String[] args) {
		//Declaracao de variaveis
		int km;
		byte horas;
		int velocidade;
		Scanner input = new Scanner(System.in);
				
		//Entrada de dados
		System.out.print("Digite os KM: ");
		km = input.nextInt();
		
		System.out.print("Digite as horas: ");
		horas = input.nextByte();
		
		
		//Calculo
		velocidade = km/horas;
		
		//Saida de dados
		System.out.println("Velocidade do veiculo: "+velocidade+" km/h");
	}

}
