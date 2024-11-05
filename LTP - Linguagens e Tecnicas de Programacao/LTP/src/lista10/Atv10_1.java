package lista10;
import java.util.Scanner;

public class Atv10_1 {
    public static void main(String[] args) {
        //Declaracao de variaveis
        String nome;
        Scanner input = new Scanner(System.in);

        //Entrada de dados

        System.out.print("Digite o nome: ");
        nome = input.nextLine();
        
        System.out.println("Nome alterado (1): "+alterarPrimeiraLetraMaiscula(nome));
        System.out.println("Nome alterado (2): "+alterarTodasAsPrimeirasLetrasEmMaisculo(nome));
        System.out.println("Nome alterado (3): "+eliminarEspacosNaEsquerda(nome));
        System.out.println("Nome alterado (4): "+eliminarEspacosNaDireita(nome));
        System.out.println("Nome alterado (5): "+eliminarEspacosNaDireita(nome));

    }
    
    public static String alterarPrimeiraLetraMaiscula (String nome){
        nome = Character.toUpperCase(nome.charAt(0))+ nome.substring(1);
        return nome;
    }

    public static String alterarTodasAsPrimeirasLetrasEmMaisculo(String nome){
        nome = alterarPrimeiraLetraMaiscula(nome);

        for (int i = 1; i < nome.length(); i ++){
            if (nome.charAt(i) == ' '){
                nome = nome.substring(0, i+1) + Character.toUpperCase(nome.charAt(i+1)) + nome.substring(i+2);
            }
        }

        return nome;
    }

    public static String eliminarEspacosNaEsquerda (String nome){
        while (nome.charAt(0) == ' '){
            nome = nome.substring(1);
        }
        return nome;
    }

    public static String eliminarEspacosNaDireita (String nome){
        while (nome.charAt(nome.length()) == ' '){
            nome = nome.substring(nome.length()-1);
        }
        return nome;
    }

    public static String eliminarEspacos (String nome){
        nome = nome.trim();
        nome = nome.replaceAll("\\s+", " ");
        
        return nome;
    }
}
