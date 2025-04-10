#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

void exibirMenu();
void receberValorInteiro(int *valor);
void calcularNovoSalario(float *salario);
float processarSalarios(float **salarios, int tamanho);

void exibirMenu() {
    char resposta;
    do {
        printf("\nA - Calcular novo salario\nB - Finalizar\nEscolha uma opcao: ");
        scanf(" %c", &resposta);
        resposta = toupper(resposta);
        getchar();

        if (resposta == 'A') {
            int tamanho;
            receberValorInteiro(&tamanho);
            float *salarios = (float *)malloc(tamanho * sizeof(float));
            
            if (salarios == NULL) {
                printf("Erro ao alocar memoria!\n");
                return;
            }
            
            float media = processarSalarios(&salarios, tamanho);
            printf("\nMedia dos novos salarios: %.2f\n", media);
            free(salarios);
        }
    } while (resposta != 'B');
    
    printf("\nEncerrando...\n");
}

void receberValorInteiro(int *valor) {
    do {
        printf("\nDigite um numero inteiro positivo (max 50): ");
        scanf("%d", valor);
    } while (*valor <= 0 || *valor > 50);
}

void calcularNovoSalario(float *salario) {
    if (*salario <= 2500)
        *salario *= 1.15; 
    else if (*salario <= 7000)
        *salario *= 1.075;
}

float processarSalarios(float **salarios, int tamanho) {
    float soma = 0;
    for (int i = 0; i < tamanho; i++) {
        printf("Digite o salario do funcionario %d: ", i + 1);
        scanf("%f", (*salarios + i));

        calcularNovoSalario((*salarios + i));
        soma += *(*salarios + i);
    }
    return soma / tamanho;
}

int main() {
    exibirMenu();
    return 0;
}
