package lista11;

import java.util.Scanner;
import java.io.*;

public class exclusaoClientes {
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
        char confirmacaoDados;

        long posicaoRegistro = 0;

        do {
            do {
                System.out.println("----- Exclusao de Clientes -----");
                System.out.print("Digite o codigo do cliente para exclusao (Digite fim para encerrar): ");
                codClientePK = input.nextLine();

                if (codClientePK.equalsIgnoreCase("FIM")) {
                    break; // Fim do segundo DO
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
            } while (! encontrou);

            if (codClientePK.equalsIgnoreCase("FIM")){ 
                System.out.println("----- Programa Encerrado -----\n");
                break;  //Finalizando o primeiro DO
            }

            //
            clientes.ativo = 'N';
            System.out.println("Nome do aluno................: "+clientes.nomeCliente);
            System.out.println("Codigo do cliente............: "+clientes.codCliente);
            System.out.println("Ano da primeira compra.......: "+clientes.anoPrimeiraCompra);
            System.out.println("Valor da compra:.............: "+clientes.vlrCompra);
            System.out.println("Em dia.....................: "+clientes.emDia);
            System.out.println();

            do{
                System.out.print("\nConfirma a exclusão deste aluno (S/N) ?");
                confirmacaoDados = input.next().charAt(0);

                if (confirmacaoDados == 'S') {
                    try {
                        arquivo = new RandomAccessFile("CLIENTES.DAT", "rw");
                        
                        arquivo.seek(posicaoRegistro);
                        arquivo.writeChar(clientes.ativo);
                        arquivo.close();

                        System.out.println("Cliente excluido com sucesso!\n");
                    } catch (IOException e){
                        System.out.println("Erro na exclusão do cliente - programa será finalizado.");
                        System.exit(0);
                    }
                }
                System.out.println();
            } while (confirmacaoDados != 'S' && confirmacaoDados != 'N');
            input.nextLine();
        } while (clientes.codCliente.equalsIgnoreCase("FIM"));

        input.close();
    }

}
