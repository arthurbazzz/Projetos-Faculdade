/*
    Atividade 07
    Nome: Arthur Bazilio de Moraes
*/

#include <stdio.h>
#include <stdlib.h>

//CAPTAÇÃO DE QUANTIDADES DE USUARIOS
int quantidadeDeUsuarios(){
    int qtd;
    do{
        printf("Digite o numero de usuarios: ");
        scanf("%d",&qtd);
        
        if (qtd<= 0){
            printf("Digite um numero maior que 0.");
        }
    } while (qtd <= 0);
    
    return qtd;
}

//ALOCANDO MEMORIA 
int *alocarMemoria(int espaco){
    int *memoria = (int*) calloc (espaco, sizeof(int));
    return memoria;
}

//INCLUSAO DE VALORES DOS USUARIOS
int inclusaoDosValores(int *vetorUsuarios, int qtdDeUsuarios){
    int valorInput;
    int somatoriaDosValores = 0;
    
    printf("\n==================== INCLUSÃO DOS VALORES =======================");
    for (int i = 0; i < qtdDeUsuarios; i++){
        do{
        printf("\nDigite o valor do [%d] usuario: ", (i + 1));
        scanf("%d",(&valorInput));
        
        } while (valorInput <= 0);
        
        if (i % 2 == 0){
            vetorUsuarios[i] = valorInput * 2 ;
        } else {
            vetorUsuarios[i] = valorInput / 2;
        }
    
        somatoriaDosValores += vetorUsuarios[i];
    }
    
    return somatoriaDosValores;
}

//IMPRESSÃO DOS VALORES DOS USUARIOS
void impressaoDosValores(int *vetorUsuarios, int somatoriaDosValores, int qtdDeUsuarios){
    printf("\n==================== IMPRESSAO DOS VALORES =======================");
    for (int i = 0; i < qtdDeUsuarios; i++){
        printf("\nValor Usuario [%d] = %d", i, vetorUsuarios[i]);
    }
    
    printf("\nSomatoria dos Valores: %d ", somatoriaDosValores);
}

int main() {
    int qtdDeUsuarios = quantidadeDeUsuarios();
    int *vetorUsuarios = alocarMemoria(qtdDeUsuarios);
    
    int somatoriaDosValores = inclusaoDosValores(vetorUsuarios, qtdDeUsuarios);
    impressaoDosValores(vetorUsuarios, somatoriaDosValores,qtdDeUsuarios);
    
    free(vetorUsuarios);

    return 0;
}