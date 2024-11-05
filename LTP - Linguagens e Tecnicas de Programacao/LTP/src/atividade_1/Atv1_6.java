package Atividade_1;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Atv1_6 {
    public static void main(String[] args) {
        //Declaracao de variaveis
        byte idadeUsuario, mesUsuario, diaUsuario;
        int anoUsuario;
        Scanner input = new Scanner (System.in);

        //Metodo que pega ano, mes, dia atual
        GregorianCalendar calendar = new GregorianCalendar();
        int anoAtual = calendar.get(GregorianCalendar.YEAR);
        int mesAtual = calendar.get(GregorianCalendar.MONTH);
        int diaAtual = calendar.get(GregorianCalendar.DAY_OF_MONTH);

        System.out.println(diaAtual+"/"+mesAtual+"/"+anoAtual);
        
        //Entrada de dados
        System.out.print("Digite o dia do seu aniversário: ");
        diaUsuario = input.nextByte();

        System.out.print("Digite o mes do seu aniversário: ");
        mesUsuario = input.nextByte();

        System.out.print("Digite o ano do seu aniversário: ");
        anoUsuario = input.nextInt();

        //Calculo
        idadeUsuario = (byte) (anoAtual - anoUsuario);
            //Caso o mes atual seja menor que o mês do aniversario ou seja igual e o dia atual seja menor que o dia do aniversario
            if (mesAtual < mesUsuario || mesAtual == mesUsuario && diaAtual < diaUsuario){
                idadeUsuario--;
            }

        //Saida de ddos
        System.out.println("Idade do usuario: "+idadeUsuario+" anos");
        } 
    }

