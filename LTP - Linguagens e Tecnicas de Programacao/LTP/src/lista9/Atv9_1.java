package lista9;
import java.util.Scanner;

public class Atv9_1 {
    public static void main(String[] args) {
        String dataHoje, dataAniversario;

        Scanner input = new Scanner (System.in);

        System.out.print("Digite a data de hoje: ");
        dataHoje = input.nextLine();

        System.out.print("Digite a data do seu aniversario: ");
        dataAniversario = input.nextLine();
        
        System.out.println("Sua idade: "+calcularIdade(dataHoje, dataAniversario));
    }

    public static byte calcularIdade(String dataHoje, String dataAniversario){
        byte idade;

        idade = (byte) (Byte.parseByte(dataAniversario.substring(6)) - Byte.parseByte(dataHoje.substring(6)));

        return idade;
    }
}
