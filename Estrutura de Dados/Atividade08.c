#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// DEFININDO A STRUCT
typedef struct {
    char nome[100];
    float salario;
} Funcionario;

// VALIDA A QUANTIDADE DE FUNCIONÁRIOS
int quantidadeDeFuncionarios(){
    int qtd;
    do {
        printf("==================QUANTIDADE DE FUNCIONÁRIOS====================");
        printf("\nDigite a quantidade de funcionarios: ");
        scanf("%d", &qtd);
        printf("================================================================\n");
    } while(qtd <= 0);
    return qtd;
}

// APLICA AUMENTO CONFORME TABELA
float aplicarAumento(float salario){
    float novoSalario;

    if (salario <= 5000.0)
        novoSalario = salario * 1.10;
    else if (salario <= 10000.0)
        novoSalario = salario * 1.05;
    else
        novoSalario = salario;

    return novoSalario;
}

// PROCESSA OS FUNCIONÁRIOS
void processarFuncionarios(int qtd){
    Funcionario *funcionarios = (Funcionario *) malloc(qtd * sizeof(Funcionario));
    float somaSalarios = 0.0;

    printf("\n\n==================INCLUSÃO DE FUNCIONÁRIOS======================");

    for (int i = 0; i < qtd; i++){
        printf("\nFuncionário %d", i + 1);

        printf("\nDigite o nome do funcionário: ");
        scanf(" %[^\n]", funcionarios[i].nome);

        do {
            printf("Digite o valor do salário: R$ ");
            scanf("%f", &funcionarios[i].salario);
        } while (funcionarios[i].salario <= 0);

        funcionarios[i].salario = aplicarAumento(funcionarios[i].salario);
        funcionarios[i].salario *= 0.92; 
        somaSalarios += funcionarios[i].salario;
    }

    // EXIBE OS DADOS ATUALIZADOS
    printf("\n\n==================SALÁRIOS ATUALIZADOS==========================");
    for (int i = 0; i < qtd; i++){
        printf("\n%s: R$ %.2f", funcionarios[i].nome, funcionarios[i].salario);
    }

    // MÉDIA SALARIAL
    float media = somaSalarios / qtd;
    printf("\n\nMédia salarial da empresa: R$ %.2f", media);
    printf("\n===============================================================\n");

    free(funcionarios);
}

int main() {
    processarFuncionarios(quantidadeDeFuncionarios());
    return 0;
}