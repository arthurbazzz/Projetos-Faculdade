package lista4;

import java.util.Scanner;

public class Atv4_4 {
    public static void main(String[] args) {
        // Declaracao de variaveis
        int codOperario = 1;
        int contPecas = 0, contClassB = 0, qtdPecas = 0, qtdPecasB = 0;
        int funcMaiorPecas = 999999999, codOperarioMaior = 0;
        float salarioOperario = 0, gastoSalarial = 0;
        char classe = ' ';

        Scanner input = new Scanner(System.in);

        // Entrada de dados
        System.out.println("Calculo Salarial\nPara terminar a entrada de dados digite 0 no codigo de operario");

        while (codOperario != 0) {
            System.out.print("\nDigite o seu codigo de operario: ");
            codOperario = input.nextInt();

            if(codOperario == 0){
                break;
            }

            System.out.print("Digite sua classe: ");
            classe = Character.toUpperCase(input.next().charAt(0));

            // Verifica se foi digitado o valor correto da classe
            if (classe != 'A' && classe != 'B' && classe != 'C') {
                System.out.print("\nClasse invalida.\nDigite uma classe válida: ");
                classe = Character.toUpperCase(input.next().charAt(0));
            }

            // Calculos
            if (classe == 'A' || classe == 'B' || classe == 'C') {
                System.out.print("Digite a quantidade de peças que você fabricou: ");
                contPecas = input.nextInt();
                if (contPecas  <= 0) {
                    System.out.print("\nValor informado invalido, número de peças deve ser maior que 0.\nDigite quantidade de pecas: ");
                    contPecas = input.nextInt();
                } 
                
                if (contPecas > 0) {
                    switch (classe) {
                        case 'A':
                            if (contPecas <= 30) {
                                salarioOperario = 500 + (2 * contPecas);
                            } else if (contPecas > 30 && contPecas <= 40) {
                                salarioOperario = (float) (500 + (2.30 * contPecas));
                            } else {
                                salarioOperario = (float) (500 + (2.80 * contPecas));
                            }
                            break;
                        case 'B':
                            salarioOperario = 1200;
                            contClassB++;
                            qtdPecasB =+ contPecas;
                            break;
                        case 'C':
                            if (contPecas <= 50) {
                                salarioOperario = (40 * contPecas);
                            } else {
                                salarioOperario = (45 * contPecas);
                            }
                        default:
                            break;
                    }
                }

                //Funcionario que fabricou a menor quantidade de pecas
                if (funcMaiorPecas > contPecas){
                    funcMaiorPecas = contPecas;
                    codOperarioMaior = codOperario;
                }

            } else {
                System.out.println("Classe invalida.");
            }
            System.out.println("\nCodigo do operario: "+codOperario+"\nSalario: "+salarioOperario);
            
            qtdPecas += contPecas;
            gastoSalarial += salarioOperario;
        }
        // Saida de dados
        System.out.println("\nNumero total de peças fabricadas: "+qtdPecas);
        System.out.println("Codigo do operario que fabricou o menor numero de pecas: "+codOperarioMaior);
        if (contClassB > 0 && qtdPecas > 0){
            System.out.println("Media de quantidade de pecas fabricadas por empregados da classe B: "+ ((float) (qtdPecasB / contClassB)));
        } else {
            System.out.println("Não ocorreu a entrada de nenhum operario da Classe B");
        }
        System.out.println("Total de gasto da emprega com pagamento dos salários: " + gastoSalarial);
    }

}
