package lista2;

import javax.swing.JOptionPane;

public class eleicao {

	public static void main(String[] args) {
		//Variaveis
		String[] opcoes = {"Candidato 1", "Candidato 2", "Candidato 3", "Voto Nulo"};
		byte voto;
		int voto1 = 0, voto2=0, voto3=0, votoNulo=0, votosTotal;
		int resp;
		boolean rodando = true;
		
		// Entrada de dados e Logica
		while (rodando != false) {
			voto = (byte) JOptionPane.showOptionDialog(null, "Escolha um candidato","Votação",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,opcoes, opcoes[0]);
			
			switch(voto) {
			case 0 : JOptionPane.showMessageDialog(null, "Voto computado para Candidato 1", "Voto - Candidato 1", JOptionPane.DEFAULT_OPTION);
					 voto1 = (voto1+1);
					 System.out.println("Votos candidato 1: "+voto1);
				break;
			case 1 : JOptionPane.showMessageDialog(null, "Voto computado para Candidato 2", "Voto - Candidato 2", JOptionPane.DEFAULT_OPTION);
			 		 voto2 = (voto2+1);
					 System.out.println("Votos candidato 2: "+voto2);
			    break;
			case 2 : JOptionPane.showMessageDialog(null, "Voto computado para Candidato 3", "Voto - Candidato 3", JOptionPane.DEFAULT_OPTION);
					 voto3 = (voto3+1);
					 System.out.println("Votos candidato 3: "+voto3);
		    	break;
			case 3 : JOptionPane.showMessageDialog(null, "Voto Anulado", "Voto - Anulado", JOptionPane.DEFAULT_OPTION);
					 votoNulo = (votoNulo+1);
					 System.out.println("Votos nulos: "+votoNulo);
				break;
			default : JOptionPane.showMessageDialog(null, "Voto cancelado");
		    	break;
			}
			
			resp = JOptionPane.showOptionDialog(null, "Vai ser feito mais votos?", "Novos votos", JOptionPane.YES_NO_OPTION, 0, null, null, 0);
			
			if (resp == 1) {
				rodando = false;
			} else {
				rodando = true;
			}
			
		}
			votosTotal = voto1+voto2+voto3+votoNulo;
		
		//Saida de dados
		JOptionPane.showMessageDialog(null, "Resultado da Eleição\n\nCandidato 1: "+voto1+"\nCandidato 2: "+voto2+"\nCandidato 3: "+voto3+"\nVotos Nulos: "+votoNulo
				+"\n\nTotal de votos: "+votosTotal);
		
		if (votoNulo >= voto1 && votoNulo >= voto2 && votoNulo >= voto3){
			JOptionPane.showMessageDialog(null, "Votação Anulada!\nPela quantidade de votos nulos ser maior ou igual\ndo que votos os para os candidatos selecionados");
		} else if (voto1 == voto2 && voto1 == voto3) {
			JOptionPane.showMessageDialog(null, "Empate entre os candidatos!\nSera necessario uma nova votacao");
		} else if (voto1 > voto2 && voto1> voto3) {
			JOptionPane.showMessageDialog(null, "Candidato 1 ganhou a eleicao!");
		} else if (voto2 > voto1 && voto2> voto3) {
			JOptionPane.showMessageDialog(null, "Candidato 2 ganhou a eleicao!");
		} else if (voto3 > voto1 && voto3> voto2) {
			JOptionPane.showMessageDialog(null, "Candidato 3 ganhou a eleicao!");
		} else if (voto1 == voto2 && voto1 > voto3) {
			JOptionPane.showMessageDialog(null, "Candidato 1 e Candidato 2 estão empatados.\nSera necessario realizar o segundo turno!");
		} else if (voto1 == voto3 && voto1 > voto2) {
			JOptionPane.showMessageDialog(null, "Candidato 1 e Candidato 3 estão empatados.\nSera necessario realizar o segundo turno!");
		} else if (voto2 == voto3 && voto2 > voto1) {
			JOptionPane.showMessageDialog(null, "Candidato 2 e Candidato 3 estão empatados.\nSera necessario realizar o segundo turno!");
		} 

		
	}

}
