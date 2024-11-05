package lista4;

import java.util.Scanner;

public class Atv4_1 {
    public static void main(String[] args) {
        String nome;
        byte numeroDepen;
        int contFunc = 0;
        float salario, novoSalario, somaSalario = 0;
        float mediaSalario;

        Scanner input = new Scanner(System.in);

        //Entrada de dados
        for (int i = 0; i < 3; i++){
            System.out.print("Digite o nome do "+(i+1)+" funcionário: ");
            nome = input.nextLine();

            System.out.print("Digite o salário: ");
            salario = Float.parseFloat(input.nextLine());

            System.out.print("Digite o número de dependentes: ");
            numeroDepen = Byte.parseByte(input.nextLine());

            if (salario < 1000){
                novoSalario = (float) (salario+(salario * 0.30) + (numeroDepen*50));
                System.out.println("Novo salario do "+nome+" R$: "+novoSalario);
            } else if (salario >= 1000 && salario <= 2000){
                novoSalario = (float) (salario+(salario * 0.20) + (numeroDepen*50));
                System.out.println("Novo salario do "+nome+" R$: "+novoSalario);
            } else {        
                novoSalario = (float) (salario+(salario * 0.10) + (numeroDepen*50));
                System.out.println("Novo salario do "+nome+" R$: "+novoSalario);
            }

            somaSalario =+ novoSalario;

            if (novoSalario > 1700){
                contFunc++;
            }
            System.out.println();
        }
            mediaSalario = somaSalario/3;

        //Saida de dados
            System.out.println("\nSoma dos novos salarios: "+somaSalario);
            System.out.println("Media dos novos salarios: "+mediaSalario);
            System.out.println("Numero de funcionarios que recebem salário acima de R$1700: "
            +contFunc);
        
    }
}
