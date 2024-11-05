package lista10;

import java.util.Scanner;

public class Atv10_2 {
    public static void main(String[] args) {
        String[] nomes = new String[30];
        String login, senha;
        int contador = 0;
        boolean loop = false;

        Scanner input = new Scanner(System.in);

        while (!loop && contador < 30) {
            System.out.print("Digite um nome (ou 'sair' para encerrar): ");
            String nome = input.nextLine();

            if (nome.equalsIgnoreCase("sair")) {
                loop = true;
            } else {
                if (validarNome(nome)) {
                    nomes[contador] = nome;
                    contador++;
                } else {
                    System.out.println("Nome inválido. Tente novamente.");
                }
            }
        }

        for (int i = 0; i < contador; i++) {
            login = gerarLogin(nomes[i]);
            senha = gerarSenha(login);
            System.out.println("Nome: " + nomes[i]);
            System.out.println("Login: " + login);
            System.out.println("Senha: " + senha);
            System.out.println();
        }
    }

    private static boolean validarNome(String nome) {
        if (nome.length() < 15) {
            return false;
        }

        String[] partes = nome.split(" ");
        if (partes.length < 2) {
            return false;
        }

        for (String parte : partes) {
            if (!parte.matches("[a-zA-Z]+")) {
                return false;
            }
        }

        return true;
    }

    private static String gerarLogin(String nome) {
        String login = "";
        String[] partes = nome.split(" ");
        for (String parte : partes) {
            login += parte.substring(0, 1).toUpperCase();
        }
        return login;
    }

    private static String gerarSenha(String login) {
        String senha = "";
        for (char c : login.toCharArray()) {
            senha += (int) c;
        }
        return senha;
    }
}