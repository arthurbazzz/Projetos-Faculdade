#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <ctype.h>

void gotoxy(int x, int y) {
    COORD pos = {x, y};
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), pos);
}

void alterarCor(int cor) {
    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), cor);
}

int main() {
    int qtdDeClientes;
    char resposta;

    do {
        do {
            gotoxy(40, 0);
            printf("Agencia Banco FUMEC 001");
            gotoxy(40, 3);
            printf("Digite o numero de clientes dessa agencia: ");
            scanf("%d", &qtdDeClientes);

            if (qtdDeClientes <= 0) {
                alterarCor(4);
                gotoxy(40, 2);
                printf("Digite um numero maior que 0.");
                alterarCor(7);
                gotoxy(83, 3);
                printf("             ");
            }
        } while (qtdDeClientes <= 0);

        system("cls");

        float *valorDoSaldo = (float *)calloc(qtdDeClientes, sizeof(float));
        float saldo, somaSaldos = 0;
        int tipoDeConta;

        for (int i = 0; i < qtdDeClientes; i++) {
            gotoxy(40, 0);
            printf("Agencia Banco FUMEC 001");

            do {
                gotoxy(40, 3);
                printf("Digite o saldo do [%d] cliente: ", (i + 1));
                scanf("%f", &saldo);

                if (saldo < 0) {
                    alterarCor(4);
                    gotoxy(40, 2);
                    printf("Digite um saldo maior ou igual a 0.");
                    alterarCor(7);

                    gotoxy(71, 3);
                    printf("          ");
                }
            } while (saldo < 0);

            do {
                gotoxy(40, 7);
                printf("[1] Poupanca");
                gotoxy(40, 8);
                printf("[2] Plus");
                gotoxy(40, 9);
                printf("[3] Especial");
                gotoxy(40, 10);
                printf("Digite a opcao de conta: ");
                scanf("%d", &tipoDeConta);

                if (tipoDeConta < 1 || tipoDeConta > 3) {
                    gotoxy(40, 5);
                    alterarCor(4);
                    printf("Digite um tipo de conta entre 1 e 3.");
                    alterarCor(7);
                    gotoxy(65, 10);
                    printf("       ");
                }
            } while (tipoDeConta < 1 || tipoDeConta > 3);

            switch (tipoDeConta) {
                case 1:
                    saldo *= 1.015;
                break;

                case 2:
                    saldo *= 1.02;
                break;

                case 3:
                    saldo *= 1.04;
                break;
            };

            valorDoSaldo[i] = saldo;
            somaSaldos += saldo;
            system("cls");
        }

        system("cls");
        gotoxy(40, 0);
        printf("Agencia Banco FUMEC 001");

        gotoxy(40, 3);
        printf("Lista de Clientes:");

        for (int i = 0; i < qtdDeClientes; i++) {
            gotoxy(40, 5 + i);
            printf("[%d] Cliente - Saldo = R$ %.2f", i + 1, valorDoSaldo[i]);
        }

        float mediaSaldos = somaSaldos / qtdDeClientes;
        gotoxy(40, 6 + qtdDeClientes);
        printf("Media dos saldos: R$ %.2f", mediaSaldos);

        free(valorDoSaldo); // Liberando memória alocada
        getchar(); // Limpando buffer do scanf

        do {
            gotoxy(40, 8 + qtdDeClientes);
            printf("Deseja adicionar mais clientes? (S - Sim | N - Nao): ");
            scanf(" %c", &resposta);
            resposta = toupper(resposta); // Convertendo para maiúscula

            if (resposta != 'S' && resposta != 'N') {
                gotoxy(40, 10 + qtdDeClientes);
                alterarCor(4);
                printf("Digite um caracter valido. [%c]", resposta);
                alterarCor(7);
                gotoxy(90,  8 + qtdDeClientes);
                printf("*");
            }
        } while (resposta != 'S' && resposta != 'N');

        // Zerando as variaveis caso o codigo rode novamente

        mediaSaldos = 0;
        somaSaldos = 0;
        qtdDeClientes = 0;

        system("cls");

    } while (resposta != 'N');

    return 0;
}
