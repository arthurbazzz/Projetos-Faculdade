package lista5;
import java.util.Scanner;

public class Atv5_5 {
    public static void main(String[] args) {
        // Declaracao de variaveis

        String[] nomeAlunoAprovado = new String[50];
        int[] notaAlunoAprovado = new int[50];

        String nomeAluno;
        int notaAluno;
        char sexo;
        int contAprovados= 0, contM = 0, contF = 0, somaNotasGeral = 0, somaNotasF = 0, contFReprovados = 0;
        float mediaNotasF;

        Scanner input = new Scanner(System.in);

        // Entrada de dados

        for (int i = 0; i < 50; i++) {
            System.out.print("Digite o nome do " + (i + 1) + "° aluno(a): ");
            nomeAluno = input.nextLine();

            if(nomeAluno.equals("parar")){
                System.out.println("parando o programa");
                break;
            }

            System.out.println("\nPara informar o sexo utilize:\nF - Feminino\nM - Masculino");

            do {
                System.out.print("Digite o seu sexo (F/M): ");
                sexo = Character.toUpperCase(input.next().charAt(0));

                if (sexo != 'F' && sexo != 'M') {
                    System.out.println(
                            "Não foi possivel indentificar o que foi digitado.\nDigite novamente utilizando (F ou M)");
                }
            } while (sexo != 'F' && sexo != 'M');

            System.out.println("\nPara informar a nota do aluno, utilize números inteiros");
            do {
                System.out.print("Digite a nota do " + (i + 1) + "° aluno: ");
                notaAluno = input.nextInt();

                if (notaAluno < 0 || notaAluno > 100) {
                    System.out.println("Digite a nota com um valor entra 0 e 100");
                }

                //Verifica se todos os alunos foram aprovados
                if (notaAluno >= 60) {
                    nomeAlunoAprovado[contAprovados] = nomeAluno;
                    notaAlunoAprovado[contAprovados] = notaAluno;
                    contAprovados++;
                } 
                
                if (notaAluno >= 60 && sexo == 'M'){    
                    contM++;
                } else if (notaAluno < 60 && sexo == 'F'){
                    contFReprovados++;
                }

                if(sexo == 'F'){
                    somaNotasF = notaAluno;
                    contF++;
                }

            } while (notaAluno < 0 || notaAluno > 100);
            System.out.println();
            somaNotasGeral+= notaAluno;
            input.nextLine();
        }

        mediaNotasF = (somaNotasF/contF);

        //Saida de dados
        System.out.println("\nNumero de alunos aprovados: "+contM);
        System.out.println("Numero de alunas reprovadas: "+contFReprovados);
        System.out.println("Média das notas femininas: "+mediaNotasF);
        System.out.println("Media geral da turma: "+somaNotasGeral/50);
        System.out.println("\nAlunos aprovados(as): ");
        System.out.println("Nome                         Nota");
        for (int i = 0; i < (contAprovados);i++){
            System.out.print(nomeAlunoAprovado[i]);
                    for (int c = 0; c < (30 - nomeAlunoAprovado[i].length()); c++){
                        System.out.print(" ");
                    }
            
            System.out.print(notaAlunoAprovado[i]);

            System.out.println();   
        }
    }
}
