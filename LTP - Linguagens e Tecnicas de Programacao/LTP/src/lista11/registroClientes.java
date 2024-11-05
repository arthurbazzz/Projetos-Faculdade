package lista11;

import java.io.*;
import java.util.Scanner;

public class registroClientes {
    public static class Cliente {
        public char ativo;
        public String nomeCliente, codCliente;
        public int anoPrimeiraCompra;
        public float vlrCompra;
        public boolean emDia;
    }
    public static void main(String[] args) {
        //Declaracao de variaveis
        Cliente clientes = new Cliente();
        Scanner input = new Scanner (System.in);

        RandomAccessFile arquivo;

        String codClientePK;
        boolean encontrou;
        char emdiaAux, confirmacaoDados;
        do{
            do{
                System.out.println("----- Inclusao de Clientes -----");
                System.out.print("Digite o codigo do cliente (Para finalizar digite FIM): ");
                codClientePK = input.nextLine();

                if (codClientePK.equalsIgnoreCase("FIM")){
                    break;  //Fim do segundo DO
                }

                encontrou = false;
                
                try{
                    arquivo = new RandomAccessFile("CLIENTES.DAT", "rw");
                 while (true) {
                    clientes.ativo = arquivo.readChar();
                    clientes.codCliente = arquivo.readUTF();
                    clientes.nomeCliente = arquivo.readUTF();
                    clientes.anoPrimeiraCompra = arquivo.readInt();
                    clientes.vlrCompra = arquivo.readFloat();
                    clientes.emDia = arquivo.readBoolean();

                    if (codClientePK.equals(clientes.codCliente) && (clientes.ativo == 'S')){
                        System.out.println("Cliente já cadastrado, digite outro código para o cliente.\n");
                        encontrou = true;
                        break;
                    }
                }

                arquivo.close();

                }catch(EOFException e){
                    encontrou = false;
                } catch(IOException e){
                    System.out.println("Erro na abertura do arquivo - programa será finalizado.");
                    System.exit(0);
                }
            } while( encontrou );

            if (codClientePK.equalsIgnoreCase("FIM")){ 
                System.out.println("----- Programa Encerrado -----\n");
                break;  //Finalizando o primeiro DO
            }

            //Entrada de dados
            clientes.ativo = 'S';
            clientes.codCliente = codClientePK;

            do{
                System.out.print("Digite o nome do cliente.........................: ");
                clientes.nomeCliente = input.nextLine();

                if (clientes.nomeCliente.length() < 10){
                    System.out.print("O nome do cliente deve ter no minimo 10 caracteres.");
                }

            } while (clientes.nomeCliente.length() < 10);

            do{
                System.out.print("Digite o ano da primeira compra..................: ");
                clientes.anoPrimeiraCompra = input.nextInt();

                if (clientes.anoPrimeiraCompra < 2013){
                    System.out.println("Digite um ano igual ou maior a 2013. \n");
                }

            } while (clientes.anoPrimeiraCompra < 2013);

            System.out.print("Digite o valor do produto........................: ");
            clientes.vlrCompra = input.nextFloat();

            System.out.print("Cliente está em dia (S/N)? ");
            emdiaAux = input.next().charAt(0);

            if (emdiaAux == 'S'){
                clientes.emDia = true;
            } else {
                clientes.emDia = false;
            }

            do{
                System.out.print("\nConfirma a gravação de dados (S/N) ? ");
                confirmacaoDados = input.next().charAt(0);

                if (confirmacaoDados == 'S'){
                    try{
                        arquivo = new RandomAccessFile("CLIENTES.DAT", "rw");
                        arquivo.seek(arquivo.length());

                        arquivo.writeChar(clientes.ativo);
                        arquivo.writeUTF(clientes.codCliente);
                        arquivo.writeUTF(clientes.nomeCliente);
                        arquivo.writeInt(clientes.anoPrimeiraCompra);
                        arquivo.writeFloat(clientes.vlrCompra);
                        arquivo.writeBoolean(clientes.emDia);
                        
                        arquivo.close();

                        System.out.println("Dados gravados com suecesso !\n");

                    } catch (IOException e){
                        System.out.println("Erro na gravacao do registro - programa sera finalizado.");
                        System.exit(0);
                    }
                }
            } while(confirmacaoDados != 'S' && confirmacaoDados != 'N');

            input.nextLine();

        } while( ! clientes.codCliente.equalsIgnoreCase("FIM"));

        input.close();
    }


}
