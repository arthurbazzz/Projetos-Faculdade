package revisao;

import java.util.*;
public class Atividade_Prova {
    public static void main(String[] args) {
        //Declaracao de variaveis
        int codEmpregado, cont = 0, qtdFaltas;
        float salarioEmpregado, gastoTotal = 0, maiorSalario = 0;

        Scanner leia = new Scanner (System.in);

        //Entrada de dados
        do{
            System.out.print("Digite o codigo do empregado: ");
                codEmpregado = leia.nextInt();

                //Flag
                if (codEmpregado == 999){
                    break;
                } 

            do {
                System.out.print("Digite o salario do empregado: ");
                    salarioEmpregado = leia.nextFloat();

                    if (salarioEmpregado < 1200){
                        System.out.println("Informe um valor de 1200 ou maior para o salario.");
                    }
            } while(salarioEmpregado < 1200);

            System.out.print("Digite a quantidade de faltas do empregado: ");
                qtdFaltas = leia.nextInt();

                if (qtdFaltas >=1 && qtdFaltas <= 3 ){
                    salarioEmpregado -= 50 * qtdFaltas;
                } else if (qtdFaltas <= 8){
                    salarioEmpregado -= 70 * qtdFaltas;
                } else {
                    salarioEmpregado -= 100 * qtdFaltas;
                }

                if (salarioEmpregado < 1000){
                    salarioEmpregado = 1000;
                }

                if (maiorSalario < salarioEmpregado){
                    maiorSalario = salarioEmpregado;
                }
                
                gastoTotal += salarioEmpregado;
                cont++;

        }   while (codEmpregado != 999);
        
        //Saida de dados

        System.out.println("Gasto total da empresa: "+gastoTotal);
        System.out.println("Media dos gastos da empresa: "+(gastoTotal/cont));
        System.out.println("Maior Salário: "+maiorSalario);
    }
}
