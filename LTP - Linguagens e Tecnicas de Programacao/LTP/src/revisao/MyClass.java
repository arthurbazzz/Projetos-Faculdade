package revisao;

import java.util.Scanner;

public class MyClass {
    public static void main(String args[]) {
    float apm = 0, totalApm = 0, pontos = 0, cont= 0, media = 0, mediaPontos= 0;
    boolean loop = true;
    
    Scanner input = new Scanner (System.in);
    
    while (loop = true){
        System.out.print("Digite o apm: ");
        apm = input.nextFloat();
        
        if (apm == 0){
            break;
        }
        
        System.out.print("Digite os pontos: ");
        pontos = input.nextFloat();
        
        cont++;

        
        media += apm;
        mediaPontos += pontos;
        
        System.out.println();
    }
    System.out.println();

        System.out.println("Média de APM: "+(media/cont));
        System.out.println("Média de pontos: "+(mediaPontos/cont));
    }
}