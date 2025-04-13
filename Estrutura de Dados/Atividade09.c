/*
    Atividade 09
    Nome: Arthur Bazilio de Moraes
*/

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

//VALIDANDO NUMERO INTEIRO(POSITIVO OU NULO)
int validarNumeroInteiro() {
    int numero;
    do {
        printf("\nDigite um numero inteiro: ");
        scanf("%d", &numero);
        if (numero < 0) {
            printf("Numero invalido. Tente novamente.\n");
        }
    } while (numero < 0);
    return numero;
}

//VALIDANDO UM NUMERO REAL(POSITIVO)
float validarNumeroReal() {
    float numero;
    do {
        printf("\nDigite um numero real: ");
        scanf("%f", &numero);
        if (numero <= 0) {
            printf("Numero invalido. Tente novamente.\n");
        }
    } while (numero <= 0);
    return numero;
}

//CALCULO DO SALARIO DO EMPREGADO
void calcularSalarioLiquido(int dias, float valorDiario, float *salarioLiquido) {
    float bruto = dias * valorDiario;
    *salarioLiquido = bruto * 0.92;
    printf("\nSalario liquido: R$ %.2f\n", *salarioLiquido);
}

//CALCULO DEPOIS DO REAJUSTE
float calcularNovoSalario(float *salarios, int tamanho) {
    float soma = 0.0;
    for (int i = 0; i < tamanho; i++) {
        float aumento = 0;
        if (salarios[i] <= 1500) {
            aumento = salarios[i] * 0.15;
        } else if (salarios[i] <= 3000) {
            aumento = salarios[i] * 0.10;
        } else if (salarios[i] <= 5000) {
            aumento = salarios[i] * 0.05;
        }
        float novoSalario = salarios[i] + aumento;
        printf("Funcionario %d - Salario original: R$%.2f, Novo salario: R$%.2f\n", i + 1, salarios[i], novoSalario);
        soma += novoSalario;
    }
    return soma / tamanho;
}

//MENU DE OPÇÕES
void exibirMenu() {
    char resposta;
    int dias = 0;
    float valor = 0.0, salarioLiquido = 0.0;
    int numeroDeFuncionarios = 0;

    do {
        printf("\n===================== MENU DE OPCOES =====================\n");
        printf("[A] Resultado do exercicio 4\n");
        printf("[B] Resultado do exercicio 5\n");
        printf("[C] Finalizar\n");
        printf("Selecione a opcao: ");
        scanf(" %c", &resposta);
        resposta = toupper(resposta);

        switch (resposta) {
            case 'A':
                dias = validarNumeroInteiro();
                valor = validarNumeroReal();
                calcularSalarioLiquido(dias, valor, &salarioLiquido);
                break;

            case 'B':
                do {
                    printf("Digite o numero de funcionarios: ");
                    scanf("%d", &numeroDeFuncionarios);
                    if (numeroDeFuncionarios <= 0) {
                        printf("Valor invalido. Deve ser maior que zero.\n");
                    }
                } while (numeroDeFuncionarios <= 0);

                float *salarios = (float *)malloc(numeroDeFuncionarios * sizeof(float));

                for (int i = 0; i < numeroDeFuncionarios; i++) {
                    printf("Digite o salario do funcionario %d: ", i + 1);
                    salarios[i] = validarNumeroReal();
                }

                float media = calcularNovoSalario(salarios, numeroDeFuncionarios);
                printf("Media dos novos salarios: R$ %.2f\n", media);

                free(salarios);
                break;

            case 'C':
                printf("Programa encerrado.\n");
                break;

            default:
                printf("Opcao invalida. Tente novamente.\n");
        }
    } while (resposta != 'C');
}

int main() {
    exibirMenu();
    return 0;
}
