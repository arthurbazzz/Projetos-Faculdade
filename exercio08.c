// Online C compiler to run C program online
#include <stdio.h>
#include <stdlib.h>

int main() {
    int qtdDeUsuarios;
    
    //CAPTAÇÃO DE QUANTIDADES DE USUARIOS
    do{
        printf("Digite o numero de usuarios: ");
        scanf("%d",&qtdDeUsuarios);
        
        if (qtdDeUsuarios <= 0){
            printf("Digite um numero maior que 0.");
        }
    } while (qtdDeUsuarios <= 0);

    //ALOCACAO DA MEMORIA
    int *vetorUsuarios = (int*) calloc (qtdDeUsuarios, sizeof(int));
    int valorInput;
    int somatoriaDosValores = 0;
    
    
    //INCLUSÃO DE USUARIOS
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
    

    //IMPRIMINDO OS VALORES DOS USUARIOS
    printf("\n==================== IMPRESSAO DOS VALORES =======================");
    for (int i = 0; i < qtdDeUsuarios; i++){
        printf("\nValor Usuario [%d] = %d", i, vetorUsuarios[i]);
    }
    
    printf("\nSomatoria dos Valores: %d ", somatoriaDosValores);
    
    
    free(vetorUsuarios);

    return 0;
}