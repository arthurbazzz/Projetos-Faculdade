package lista7;
import java.util.Scanner;

public class Atv7_2 {
    public static void main(String[] args) {    
        //Declaracao de variaveis
        String [] nomeCidade = new String[20];
        float [] distanciaCidade = new float [20];
        int cont = 0;
        Scanner input = new Scanner (System.in);

        boolean loop = true, resposta = true;

        //Entrada de dados
        System.out.println("Gerenciamento de Voos");
        System.out.println("\nInstruções:\n1- O programa ira iniciar no modo de inserção das cidades, por favor não deixe em branco o nome das cidades.");
        System.out.println("Para encerrar a inserção digite 'parar'.\n2- Após a inserção das cidades será necessário informar a distância da cidade em relação a Belo Horizonte.");

        System.out.println("\nInicializando a inserção das cidades.");

        //Entrada de dados
            do{
                do{
                    System.out.print("Digite o nome da cidade: ");
                    nomeCidade[cont] = input.nextLine();

                    if (nomeCidade[cont].equals("parar")){
                        loop = false;
                    }

                    if (nomeCidade[cont].isEmpty()){
                        System.out.println("Voce nao pode deixar o nome da cidade vazio.");
                    }

                } while (nomeCidade[cont].isEmpty());

                do{
                    if (loop == true){
                        System.out.print("Distância em KM: ");
                        distanciaCidade[cont] = input.nextFloat();
    
                        if (distanciaCidade[cont] < 500){
                            System.out.println("Digite um valor maior ou igual a 500.");
                        }
                    } else {
                        System.out.println("Encerrando o programa");

                    }
                 } while (distanciaCidade[cont] < 500 && loop == true);
                 
                cont++;
                input.nextLine();
            } while( cont < 20 || loop == true);
            
        //Busca das cidades
            do {
                System.out.print("Digite o nome da cidade que você deseja pesquisar: ");
                String resp = input.nextLine();

                for (int i = 0 ; i < cont; i++){
                    if(nomeCidade[i].equals(resp)){
                        System.out.println("Achou");
                    } else{
                        System.out.println("Cidade não foi encontrada.");
                    }
                }

                System.out.println("Deseja pesquisar mais uma cidade? (Sim/Nao)");
                resp = input.nextLine();

                if(resp.equals("Nao")){
                    resposta = false;
                }
            } while(resposta == true);

    }
}
