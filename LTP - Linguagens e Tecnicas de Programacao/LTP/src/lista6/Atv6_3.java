package lista6;

import java.util.Scanner;

public class Atv6_3 {
    public static void main(String[] args) {
    //Declaracao de variaveis
    float [] valorProdutos = new float [3];
    float [] armazem = new float [3];
    float [] armazemCusto = new float [3];
    float [][] custoProdutos = new float [3][3];
    float [][] qtdProdutos = new float [3][3];

    float totalGasto = 0;

    Scanner input = new Scanner(System.in);

    //Entrada de dados

    for (int cont = 0; cont < 3; cont++){
        System.out.print("Digite o valor do "+(cont+1)+" produto: ");
        valorProdutos[cont] = input.nextFloat();
    }

    for (int i = 0; i < 3; i++){
        System.out.println("\nQuantidade de produtos do Armazem "+(i+1));
        for (int j = 0; j < 3; j++){
            System.out.print("Produto "+(j+1)+": ");
            qtdProdutos[i][j] = input.nextFloat();
            armazem[i] =+ qtdProdutos[i][j];            

            //Calculo do valor de cada produto
            custoProdutos[i][j] = qtdProdutos[i][j] * valorProdutos[j];
            armazemCusto[i] = armazemCusto[i] + custoProdutos[i][j];
            totalGasto = totalGasto+custoProdutos[i][j];
        }
    }

    //Saida de dados

    System.out.println("\n                      Quantidade de Produtos");
    System.out.println("                 Produto 1   Produto 2   Produto 3");
    for (int i  = 0; i < 3; i ++){
        System.out.print("Armazem "+(i + 1)+":        ");
        for (int j = 0; j < 3; j++){
            System.out.print(qtdProdutos[i][j]+ "      ");
        }
        System.out.println();
    }

    System.out.println();
    if (armazem[0] > armazem[1] && armazem[0] > armazem [2]){
        System.out.println("O Armazem com maior número de produtos armazenados é o 1.");
    } else if (armazem[1] > armazem[2]){
        System.out.println("O Armazem com maior número de produtos armazenados é o 2.");
    } else {
        System.out.println("O Armazem com maior número de produtos armazenados é o 3.");
    }
    
    System.out.println("\n                      Custo dos Produtos");
    System.out.println("                 Produto 1   Produto 2   Produto 3");
    for (int i  = 0; i < 3; i ++){
        System.out.print("Armazem "+(i + 1)+":        ");
        for (int j = 0; j < 3; j++){
            System.out.print(custoProdutos[i][j]+ "      ");
        }
        System.out.println();
    }
    System.out.print("Total(R$):        ");
    for (int i = 0; i < 3; i++){
        System.out.print(armazemCusto[i]+"      ");
    }
    System.out.print("\nPreço Unidade(R$)  ");
    for (int i = 0; i < 3; i++){
        System.out.print(+valorProdutos[i]+"      ");
    }
    
    System.out.println("\nCusto total de todos os Armazens: R$"+totalGasto);

    }
}
