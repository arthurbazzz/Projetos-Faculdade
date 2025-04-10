#include <stdio.h>

int main () {

    int contador = 0;
    char string[40] = "Estrutura de dados";

    /*
        fazer um loop que até encontrar \0
        que indica o fim da string
    */

    do{
        contador++;
    } while( string[contador] != '\0' );

    printf("%s tem %d letras.",string,contador);

    return 0;
}
