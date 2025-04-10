#include <stdio.h>

int main()
{
    char resposta;
    double divisao;
    int contador, qtd, aux;

    printf("---------- Menu de Opcoes ----------");
    printf("\na - Primeira Serie\nb - Segunda Serie\nc - Terceira Serie\nd - Finalizar o programa\n");

    do {
        printf("\nDigite a opcao: ");
        scanf("%c",&resposta);

        contador = 1;
        aux = 1;

        switch (resposta) {
        case 'a' :
            printf("\n---------- Primeira Serie ----------");
                do{
                    printf("\nDigite a quantidade de series: ");
                    scanf("%d",&qtd);
                } while( qtd < 0);

                while (contador <= qtd){
                    divisao = (contador + (contador - 1)) / (double) (contador * contador);
                    printf("%d + %d / %d = %lf\n",contador,(contador - 1),contador,divisao);
                    contador++;
                }
            break;

        case 'b' :
            printf("\n---------- Segunda Serie ----------");
            do{
                printf("\nDigite a quantidade de series: ");
                scanf("%d",&qtd);
            } while( qtd <= 0);

            do{
                divisao = (contador * contador * contador) / (double) (aux);
                printf("%d / %d = %lf\n",contador,aux,divisao);
                contador++;
                aux *= 10;
            } while ( contador <= qtd);
            break;

        case 'c' :
            printf("\n---------- Terceira Serie ----------");
            do{
                printf("\nDigite a quantidade de series: ");
                scanf("%d",&qtd);
            } while( qtd < 0);


            aux = 2;

            for (int i = 0; i < qtd; i++){
                divisao = (i + 1) / (double) (3 * aux);
                printf("%d / 3 X %d = %lf\n",(i + 1),aux,divisao);
                aux += 2;
            }
            break;

        case 'd' :
            printf("O programa vai ser encerrado.");
            break;

        default :
            printf("\n--------------------------\nDigite um caracter valido.\n--------------------------\n");
        }

        getchar(); //limpando o buffer

    }while(resposta != 'd');

    return 0;
}