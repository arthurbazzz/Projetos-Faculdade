package lista8;
import java.util.Scanner;

public class Atv8_1 {
    public static void main(String[] args) {
        int x , y , z;
        Scanner input = new Scanner (System.in);
        System.out.println("Write the value of X: ");
        x = input.nextInt();

        System.out.println("Write the value of Y: ");
        y = input.nextInt();

        System.out.println("Write the value of Z: ");
        z = input.nextInt();

        System.out.println("Value in between A and B: "+someIntegers(x, y));
        printDivisorABforC(x, y, z);
    }

    public static int someIntegers (int x, int y){
        int some = 0;
        for ( int i = x + 1; i < y; i++){
            some =+ i;
        }
        return some;
    }

    public static void printDivisorABforC(int x, int y, int z){
        for ( int i = x + 1; i < y; i++){
            if ( i % z == 0){
                System.out.println("Numbers can be divisor for Z: "+ i);
            }
        }
    }
}
