package lista11;

import java.util.Scanner;
import java.io.*;

public class alteracaoClientes {

    public static class Cliente {
        public char ativo;
        public String nomeCliente, codCliente;
        public int anoPrimeiraCompra;
        public float vlrCompra;
        public boolean emDia;
    }

    public static void main(String[] args) {
        // Declaracao de variaveis

        Cliente clientes = new Cliente();
        Scanner input = new Scanner(System.in);

        RandomAccessFile arquivo;

        String codClientePK;
        boolean encontrou;
        char confirmacaoDados, emdiaAux;
        byte opcao;
        long posicaoRegistro = 0;

        do {
            do {
                System.out.println("----- Alteracao de Clientes -----");
                System.out.print("Digite o código do cliente (Fim para encerrar): ");
                codClientePK = input.nextLine();

                if (codClientePK.equalsIgnoreCase("FIM")) {
                    break;
                }

                encontrou = false;

                try {
                    arquivo = new RandomAccessFile("CLIENTES.DAT", "rw");
                    while (true) {
                        posicaoRegistro = arquivo.getFilePointer();
                        clientes.ativo = arquivo.readChar();
                        clientes.codCliente = arquivo.readUTF();
                        clientes.nomeCliente = arquivo.readUTF();
                        clientes.anoPrimeiraCompra = arquivo.readInt();
                        clientes.vlrCompra = arquivo.readFloat();
                        clientes.emDia = arquivo.readBoolean();

                        if (codClientePK.equals(clientes.codCliente) && (clientes.ativo == 'S')) {
                            encontrou = true;
                            break;
                        }
                    }
                    arquivo.close();

                } catch (EOFException e) {
                    encontrou = false;
                    System.out.println("Este codigo nao foi encontrado no arquivo. \n");
                } catch (IOException e) {
                    System.out.println("Erro na abertura do arquivo - programa será finalizado.");
                    System.exit(0);
                }
            } while ( ! encontrou);

            if (codClientePK.equalsIgnoreCase("FIM")) {
                System.out.println("----- Programa Encerrado -----\n");
                break; // Finalizando o primeiro DO
            }

            clientes.ativo = 'S';
            clientes.codCliente = codClientePK;

            do {
                System.out.println("[ 1 ] Nome do aluno................: " + clientes.nomeCliente);
                System.out.println("[ 2 ] Codigo do cliente............: " + clientes.codCliente);
                System.out.println("[ 3 ] Ano da primeira compra.......: " + clientes.anoPrimeiraCompra);
                System.out.println("[ 4 ] Valor da compra:.............: " + clientes.vlrCompra);
                System.out.println("[ 5 ] Em dia.....................: " + clientes.emDia);

                do {
                    System.out.print("Digite o número do campo que deseja alterar (0 para finalizar): ");
                    opcao = input.nextByte();
                } while (opcao < 0 || opcao > 4);

                switch (opcao) {
                    case 1:
                        input.nextLine();
                        System.out.print("Digite o NOVO NOME do Cliente..........................: ");
                        clientes.nomeCliente = input.nextLine();
                        break;
                    case 2:
                        input.nextLine();
                        System.out.print("Digite o NOVO CODIGO do Cliente........................: ");
                        clientes.codCliente = input.nextLine();
                        break;
                    case 3:
                        input.nextLine();
                        System.out.print("Digite o NOVO ANO da primeira compra...................: ");
                        clientes.anoPrimeiraCompra = input.nextInt();
                        break;
                    case 4:
                        input.nextLine();
                        System.out.print("Digite o NOVO VALOR do produto.........................: ");
                        clientes.vlrCompra = input.nextFloat();
                        break;
                    case 5:
                        System.out.print("Digite se o cliente está em dia (S/N)..................: ");

                        emdiaAux = input.next().charAt(0);

                        if (emdiaAux == 'S'){
                            clientes.emDia = true;
                        } else {
                            clientes.emDia = false;
                        }
                        break;
                }
            } while (opcao != 0);

            do{
                System.out.print("\nConfirma a alteracao dos dados (S/N) ?");
                confirmacaoDados = input.next().charAt(0);

                if (confirmacaoDados == 'S') {
                    try {
                        arquivo = new RandomAccessFile("CLIENTES.DAT", "rw");
                        
                        arquivo.seek(posicaoRegistro);

                        arquivo.writeChar('N');
                        
                        arquivo.seek(arquivo.length());
                        arquivo.writeChar(clientes.ativo);
                        arquivo.writeUTF(clientes.codCliente);
                        arquivo.writeUTF(clientes.nomeCliente);
                        arquivo.writeInt(clientes.anoPrimeiraCompra);
                        arquivo.writeFloat(clientes.vlrCompra);
                        arquivo.writeBoolean(clientes.emDia);                        

                        arquivo.close();

                        System.out.println("Dados alterado com sucesso!\n");
                    } catch (IOException e){
                        System.out.println("Erro na alteracao do cliente - programa será finalizado.");
                        System.exit(0);
                    }
                }
                System.out.println();
            } while (confirmacaoDados != 'S' && confirmacaoDados != 'N');

            input.nextLine();

        } while (!codClientePK.equalsIgnoreCase("FIM"));

        input.close();
    }
}
