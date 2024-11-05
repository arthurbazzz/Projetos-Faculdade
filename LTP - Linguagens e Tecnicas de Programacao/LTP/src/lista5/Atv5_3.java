package lista5;

import java.util.Scanner;

public class Atv5_3 {
    public static void main(String[] args) {
        //Declaracao de variaveis
        String [] codMatriculaCalculo = new String[220];
        String [] codMatriculaLtp = new String[150];
        String [] codMatriculaDuasMaterias = new String[150];

        int cont = 0, contCalculo = 0, contLtp = 0;

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < codMatriculaCalculo.length; i++){
            System.out.print("["+(i+1)+"]"+" Codigo de matricula na materia de Calculo: ");
            codMatriculaCalculo [i]= input.nextLine();

            if (codMatriculaCalculo[i].equals("999")){
                codMatriculaCalculo[i] = "0";
                System.out.println("\nEncerrando entrada de dados na materia de Calculo");
                break;
            }
            contCalculo++;
        }

        System.out.println();

        for (int i = 0; i < codMatriculaLtp.length; i++){
            System.out.print("["+(i+1)+"]"+" Codigo de matricula na matéria de LTP: ");
            codMatriculaLtp[i]= input.nextLine();

            if (codMatriculaLtp[i].equals("999")){
                codMatriculaLtp[i] = null;
                System.out.println("\nEncerrando entrada de dados na materia de LTP");

                break;
            }
            
            
            for (int j = 0; j < contCalculo; j++){
              if (codMatriculaCalculo[j].equals(codMatriculaLtp[i])){
                
                //codMatriculaDuasMaterias[j] = codMatriculaCalculo[j];
                //System.out.println(codMatriculaDuasMaterias[i]);
                
                cont++;
                }
            }

            contLtp++;
        }

        //Saida de dados
        System.out.println("\nQuantidade de Alunos Matriculados: "+(contCalculo+contLtp));
        System.out.println("Quantidade de Alunos Matriculados Calculo: "+contCalculo);
        System.out.println("Quantidade de Alunos Matriculados Calculo: "+contCalculo);
        System.out.println("Quantidade de alunos matriculados nas duas materias: "+cont);

        System.out.println("\nMatricula dos alunos matriculados nas duas materias: ");
    }
}
