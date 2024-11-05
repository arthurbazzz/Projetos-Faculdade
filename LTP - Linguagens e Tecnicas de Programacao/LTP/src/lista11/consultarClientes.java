package lista11;

import java.util.Scanner;
import java.io.*;

public class consultarClientes {
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
        
        do{
            System.out.println("----- Consulta de Clientes ------");
            System.out.println("[1] Consultar apenas 1 Cliente ");
            System.out.println("[2] Lista de todos os Clientes ");
            System.out.println("[0] Sair ");

            do {
                System.out.print("\nDigite a opção desejada: ");
                opcao = input.nextByte();

                if (opcao < 0 || opcao > 2) {
                    System.out.println("opcao invalida, digite novamente. \n");
                }
            } while (opcao < 0 || opcao > 2);

            switch (opcao) {
                case 0:
                    System.out.println("\n----- Programa Encerrado -----\n");
                    break;
                case 1:
                    input.nextLine();
                    System.out.println("Digite a Matricula do Aluno: ");
                    codClientePK = input.nextLine();
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
                                imprimirCabecalho();
                                imprimirCliente(clientes);
                                System.out.println("\nFim do Relatório - ENTER para continuar...\n");
                                input.nextLine();
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
                    break;

                case 2: 
                try {
                    arquivo = new RandomAccessFile("CLIENTES.DAT", "rw");
                    imprimirCabecalho();
                    while (true) {
                        posicaoRegistro = arquivo.getFilePointer();
                        clientes.ativo = arquivo.readChar();
                        clientes.codCliente = arquivo.readUTF();
                        clientes.nomeCliente = arquivo.readUTF();
                        clientes.anoPrimeiraCompra = arquivo.readInt();
                        clientes.vlrCompra = arquivo.readFloat();
                        clientes.emDia = arquivo.readBoolean();
                        if (clientes.ativo == 'S'){
                            imprimirCliente(clientes);
                        }
                    }
                } catch (EOFException e) {
                    encontrou = false;
                    System.out.println("\nFim do Relatório - ENTER para continuar...\n");
                    input.nextLine();
                } catch (IOException e) {
                    System.out.println("Erro na abertura do arquivo - programa será finalizado.");
                    System.exit(0);
                }
                break;
            }
        } while ( opcao != 0);

    }
    
    public static void imprimirCabecalho () {
        System.out.println("-Codigo Cliente- --------- Nome Aluno --------- -Ano Primeira Compra- -Valor Compra-");
    }

    public static void imprimirCliente (Cliente clientes){
            System.out.println(formatarString(clientes.codCliente, 16) + " " +
                               formatarString(clientes.nomeCliente, 30) + " "+
                               formatarString(String.valueOf(clientes.anoPrimeiraCompra), 21) + " "+
                               formatarString(String.valueOf(clientes.vlrCompra), 11) + " " );
    }

    public static String formatarString (String texto, int tamanho) {

        if (texto.length() > tamanho ){
            texto = texto.substring(0, tamanho);
        } else {
            while (texto.length() < tamanho) {
                texto = texto + " ";
            }
        }
        return texto;
    }
}
