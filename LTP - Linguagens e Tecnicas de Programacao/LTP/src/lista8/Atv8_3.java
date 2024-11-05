package lista8;
import java.util.Scanner;

public class Atv8_3 {
    static String [] vetCidade = {"BELO HORIZONTE", "SÃO PAULO", "RIO DE JANEIRO", "SALVADOR", "CURITIBA"};
    public static void main(String[] args) {
        //Declaracao de variaveis
        String [] nomeCliente = new String [100];
        float [] custoCliente = new float [100];
        float totalCustoClientes = 0;
        byte contClientes = 0, diaEntrada, diaSaida;
        String [] tipoQuarto = {"STANDARD","LUXO","SUPER-LUXO"};
        String escolhaDoQuarto,cidadeDaHospedagem;

        Scanner input = new Scanner (System.in);

        System.out.println("Hospedagens.com\nTemos opções nas seguintes cidades:");
        System.out.println("1 - Belo horizonte\n2 - São Paulo\n 3- Rio de Janeiro\n3 - Salvador\n4 - Curitiba");
        System.out.println("Opções de quarto: \n1 - Standard R$120,00 (Diária)\n2 - Luxo R$150,00 (Diária)\n3 - Super-Luxo R$180,00 (Diária)");

        System.out.println("Para finalizar a utilização do programa digite 'parar'.\n");

         //Entrada de dados

        for (int i = 0; i < nomeCliente.length; i++){
            System.out.println("Digite seu nome: ");
            nomeCliente[i] = input.nextLine();

            if (nomeCliente[i].equalsIgnoreCase("parar")){
                System.out.println("Encerrando a inserção de dados.");
                break;
            }

            do {
                System.out.println("Digite a cidade que vocë deseja se hospedar: ");
                cidadeDaHospedagem = input.nextLine();
    
                if (cidadeEhValida(cidadeDaHospedagem) == false) {
                    System.out.println("Cidade indisponivel para hospedagem");
                } else {
                    System.out.println("Cidade disponivel para hospedagem.");
                }
            } while( cidadeEhValida(cidadeDaHospedagem) == false);

            do {
                System.out.println("Digite o dia de entrada na hospedagem: ");
                diaEntrada = input.nextByte();

                System.out.println("Digite o dia de saída da hospedagem: ");
                diaSaida = input.nextByte();

                if (diaSaida < diaEntrada ){
                    System.out.println("O dia de saida deve ser maior que o dia de entrada.");
                }             
            } while (diaSaida < diaEntrada);

            input.nextLine();

            do {
                System.out.println("Digite o tipo do quarto que você deseja: ");
                escolhaDoQuarto = input.nextLine();

                if (!(escolhaDoQuarto.equalsIgnoreCase("STANDARD") || escolhaDoQuarto.equalsIgnoreCase("LUXO") 
                || escolhaDoQuarto.equalsIgnoreCase("SUPER-LUXO"))){
                    System.out.println("Digite uma opção válida de quarto.");
                } else {
                    System.out.println("Valor da conta: "+calcularValorHospedagem(diaEntrada, diaSaida, escolhaDoQuarto));
                    custoCliente[i] = calcularValorHospedagem(diaEntrada, diaSaida, escolhaDoQuarto);
                    totalCustoClientes = totalCustoClientes +  custoCliente[i];
                    System.out.println(totalCustoClientes);
                }

            } while( !(escolhaDoQuarto.equalsIgnoreCase("STANDARD") || escolhaDoQuarto.equalsIgnoreCase("LUXO") 
            || escolhaDoQuarto.equalsIgnoreCase("SUPER-LUXO")));

            contClientes++;
        }

        //Saida de dados
        System.out.println("\nRelatório de contas acima da média");
        System.out.println("Nome do hóspede                    Vlr Conta");
        System.out.println("---------------------------------  ---------");
        for (int i = 0; i < contClientes; i++){
            if (custoCliente[i] > (totalCustoClientes/contClientes)){
                System.out.print(nomeCliente[i]);
                for (int espaco = 0; espaco < (35 - nomeCliente[i].length()); espaco++){
                    System.out.print(" ");
                }
                System.out.print(custoCliente[i]);
            }
        }
    }

    public static boolean cidadeEhValida (String cidadeDaHospedagem){
        boolean achou = false;

        //arumar validacao disso aqui
        for (int i = 0; i < vetCidade.length; i++){
            if (cidadeDaHospedagem.equalsIgnoreCase(vetCidade[i])){
                achou = true;
                break;
            } else {
                achou = false;
            }
        }

        return achou;
    }

    public static float calcularValorHospedagem (byte diaDeEntrada, byte diaDeSaida, String opcaoQuarto){
        float valorConta;
        
        if (opcaoQuarto.equalsIgnoreCase("STANDARD")){
            valorConta = (diaDeSaida - diaDeEntrada) * 120;
            return valorConta;
        } else if (opcaoQuarto.equalsIgnoreCase("LUXO")){
            valorConta = (diaDeSaida - diaDeEntrada) * 150;
            return valorConta;
        } else {
            valorConta = (diaDeSaida - diaDeEntrada) * 180;
            return valorConta;
        }
        
    }
}
