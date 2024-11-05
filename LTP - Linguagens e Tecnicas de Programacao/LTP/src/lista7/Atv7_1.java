package lista7;
import java.util.Scanner;

public class Atv7_1 {    
    public static void main(String[] args) {
        //Declaracao de variaveis
        String [] cityNames = new String[20];
        float [] cityDistance = new float[20];
        byte cont = 0;
        boolean loop = true;
        Scanner input = new Scanner (System.in);

        // Entrada de dados
        do{
            System.out.println("Sistema de registo e pesquisa de voos ");
            System.out.println("1 - Registrar uma cidade\n2 - Pesquisar uma cidade\n3 - Encerrar o programa.");
            byte anwser = input.nextByte();

            input.nextLine();

            if (anwser == 1){
                System.out.println("Você selecionou a opção de registrar uma cidade.");
                    for ( int i = 0; i <= cont; i++){
                        do{
                            System.out.print("Digite o nome da "+(cont+1)+"° cidade: ");
                            cityNames[cont] = input.nextLine();
                            
                            if (cityNames[cont].isEmpty()){
                                System.out.println("Você deve escrever um nome para cidade.");
                            }
                        } while (cityNames[cont].isEmpty());
    
                        do{
                            System.out.print("Digite a distância (KM): ");
                            cityDistance[cont] = input.nextFloat();
    
                            if (cityDistance[cont] < 500){
                                System.out.println("O valor deve ser maior ou igual a 500 KM");
                            }
                        } while (cityDistance[cont] < 500);
    
                        System.out.print("Deseja adicionar outra cidade? (s/n):  ");
                        char awnserfor = Character.toUpperCase(input.next().charAt(0));
                        if (awnserfor == 'S'){
                            cont++;
                        } else {
                            break;
                        }

                        input.nextLine();

                        if (cont == 19){
                            break;
                        }
                    }   
            } else if ( anwser == 2){
                System.out.println("Você selecionou a opção de pesquisa.");
                System.out.print("Digite o nome da cidade que deseja pesquisar: ");
                String anwserCity = input.nextLine();

                for ( int i = 0; i <= cont; i++){
                    if (cityNames[i].equals(anwserCity)){
                        System.out.println(cityNames[i]);
                        System.out.println("Preço R$: "+cityDistance[i]*0.25);
                        float time = (cityDistance[i] / 800) * 60;
                        System.out.println("Tempo da viagem: "+time+" minutos.");
                        if(time > 180){
                            System.out.println(time/180+" escalas.");
                        } else {
                            System.out.println("Voo sem escalas.");
                        }
                    } else {
                        System.out.println("Cidade não encontrada.");
                    }
                }   

            } else if ( anwser == 3 ){
                System.out.println("Você selecinou a opção para encerrar o programa. ");
                loop = false;
            } else {
                System.out.println("Opção inválida, digite números entre 1-2-3.");
                break;
            }

        } while (loop == true);
    }
}
