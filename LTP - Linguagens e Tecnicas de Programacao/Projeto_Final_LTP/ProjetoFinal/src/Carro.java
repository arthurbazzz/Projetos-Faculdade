import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Carro {

	private char ativo;
	private String codCarro;
	private String marca;
	private String modelo;
	private char fabricacao;
	private String origemMarca;
	private String categoria;
	private float motorizacao;
	private int potencia;
	private float peso;
	private float preco;
	private String mesAnoFab;

	private String vetMarca[] = { "TOYOTA", "HONDA", "VOLKSWAGEN", "CHEVROLET", "FIAT", "HYUNDAI", "BMW",
			"MERCEDES BENS", "RENAULT", "JEEP" };
	private String vetOrigens[] = { "JAPÃO", "JAPÃO", "ALEMANHA", "EUA", "ITÁLIA", "COREIA DO SUL", "ALEMANHA",
			"ALEMANHA", "FRANÇA", "EUA" };
	private String vetCategoria[] = { "HATCH", "SEDA", "SUV", "PICAPE", "ESPORTIVO" };

	private long pesquisarCarro(String carroPesq) {
		// metodo para localizar um registro no arquivo em disco
		long posicaoCursorArquivo = 0;
		try {
			RandomAccessFile arqCarro = new RandomAccessFile("CARRO.DAT", "rw");
			while (true) {
				posicaoCursorArquivo = arqCarro.getFilePointer(); // posicao do inicio do registro no arquivo
				ativo = arqCarro.readChar();
				codCarro = arqCarro.readUTF();
				marca = arqCarro.readUTF();
				modelo = arqCarro.readUTF();
				fabricacao = arqCarro.readChar();
				origemMarca = arqCarro.readUTF();
				categoria = arqCarro.readUTF();
				motorizacao = arqCarro.readFloat();
				potencia = arqCarro.readInt();
				peso = arqCarro.readFloat();
				preco = arqCarro.readFloat();
				mesAnoFab = arqCarro.readUTF();

				if (carroPesq.equals(codCarro) && ativo == 'S') {
					arqCarro.close();
					return posicaoCursorArquivo;
				}
			}
		} catch (EOFException e) {
			return -1; // registro nao foi encontrado
		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo  -  programa sera finalizado");
			System.exit(0);
			return -1;
		}
	}

	private void salvarCarro() {
		// metodo para incluir um novo registro no final do arquivo em disco
		try {
			RandomAccessFile arqCarro = new RandomAccessFile("CARRO.DAT", "rw");
			arqCarro.seek(arqCarro.length()); // posiciona o ponteiro no final do arquivo (EOF)
			arqCarro.writeChar(ativo);
			arqCarro.writeUTF(codCarro);
			arqCarro.writeUTF(marca);
			arqCarro.writeUTF(modelo);
			arqCarro.writeChar(fabricacao);
			arqCarro.writeUTF(origemMarca);
			arqCarro.writeUTF(categoria);
			arqCarro.writeFloat(motorizacao);
			arqCarro.writeInt(potencia);
			arqCarro.writeFloat(peso);
			arqCarro.writeFloat(preco);
			arqCarro.writeUTF(mesAnoFab);
			arqCarro.close();
			System.out.println("Dados gravados com sucesso !\n");
		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo  -  programa sera finalizado");
			System.exit(0);
		}
	}

	private void desativarCarro(long posicao) {
		// metodo para alterar o valor do campo ATIVO para N, tornando assim o registro
		// excluido
		try {
			RandomAccessFile arqCarro = new RandomAccessFile("CARRO.DAT", "rw");
			arqCarro.seek(posicao);
			arqCarro.writeChar('N'); // desativar o registro antigo
			arqCarro.close();
		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo  -  programa sera finalizado");
			System.exit(0);
		}
	}

	private String consistirMarca(String marca) {

		for (int i = 0; i < 10; i++) {
			if (marca.equals(vetMarca[i])) {
				return vetOrigens[i];
			}
		}

		return "ERRO";

	}

	// Validação da data de fabricação
	private boolean consistirMesAnoFab(String dataEhValida) {
		int mes = 0, ano = 0;
		boolean dataValida = true;

		if (dataEhValida.length() != 7 || dataEhValida.charAt(2) != '/') {
			System.out.println("Fabricacao invalida, digite a data com 7 caracteres no formato MM/AAAA.");
			dataValida = false;	
		}

		try {
			mes = Integer.parseInt(dataEhValida.substring(0, 2));
			ano = Integer.parseInt(dataEhValida.substring(3));
		} catch (NumberFormatException e) {
			System.out.println("Data invalida, digite mes e ano numericos");
			dataValida = false;
		}

		if (mes < 1 || mes > 12) {
			System.out.println("Data invalida, digite mes entre 1 e 12");
			dataValida = false;
		}

		if (ano > 2024 || ano < 1980) {
			System.out.println("Data invalida, digite o ano entre 1980 e 2024");
			dataValida = false;
		}

		return dataValida;

	}
	// *********************** INCLUSAO *****************************

	public void incluir() {
		String codCarroChave;
		char confirmacao;
		int index;
		long posicaoRegistro;
		boolean valido, validacaoCategoria;

		do {
			do {
				valido = true;

				Main.leia.nextLine();
				System.out.println("\n ***************  INCLUSAO DE CARROS  ***************** ");
				System.out.print("Digite o codigo do carro( FIM para encerrar): ");
				codCarroChave = Main.leia.nextLine();
				if (codCarroChave.equalsIgnoreCase("FIM")) {
					break;
				}

				if (codCarroChave.length() != 6) {
					System.out.println("O código do carro deve ter 6 caracteres.");
					valido = false;
				} else {
					for (index = 0; index < 6; index++) {
						if (index < 3) {
							if (codCarroChave.charAt(index) < 'A' || codCarroChave.charAt(index) > 'Z') {
								System.out.println("O código do carro deve estar no formato XXX999");
								valido = false;
							}
						} else {
							if (codCarroChave.charAt(index) < '0' || codCarroChave.charAt(index) > '9' && valido) {
								System.out.println("O código do carro deve estar no formato XXX999");
								valido = false;
							}
						}
					}
				}

				if (valido) {
					posicaoRegistro = pesquisarCarro(codCarroChave);

					if (posicaoRegistro >= 0) {
						System.out.println("O código inserido já está incluso.\n");
						valido = false;
					}
				}

			} while (!valido);

			if (codCarroChave.equalsIgnoreCase("FIM")) {
				break;
			}

			ativo = 'S';
			codCarro = codCarroChave;

			do {
				System.out.print("Digite a marca do carro...........................................: ");
				marca = Main.leia.nextLine();
				origemMarca = consistirMarca(marca);

				if (origemMarca.equals("ERRO")) {
					System.out.println("Mensagem de erro, esta marca nao existe no sistema.");
				}
			} while (origemMarca.equals("ERRO"));


			do {
				System.out.print("Digite o modelo...................................................: ");
				modelo = Main.leia.nextLine();

				if (modelo.length() != 6){
					System.out.println("O modelo do carro deve ter 6 caracteres.");
				}
			} while (modelo.length() != 6);

			do {
				System.out.print("Digite a fabricacao do carro......................................: ");
				fabricacao = Character.toUpperCase(Main.leia.next().charAt(0));

				if (fabricacao != 'I' && fabricacao != 'N') {
					System.out.println("Fabricacao inválida, digite I para internacional e N para nacional.");
				}
			} while (fabricacao != 'I' && fabricacao != 'N');


			do {			
				Main.leia.nextLine(); 
				System.out.print("Digite a categoria do carro.......................................: ");
				categoria = Main.leia.nextLine();
				validacaoCategoria = true;

				for (int i = 0; i < vetCategoria.length; i++) {
					if (vetCategoria[i].equalsIgnoreCase(categoria)) {
						validacaoCategoria = true;
						break;
					} else {
						validacaoCategoria = false;
					}
				}
				if (! validacaoCategoria){
					System.out.print("Categoria invalida, digite uma categoria valida.");
				}
			} while ( ! validacaoCategoria);

			do {
				System.out.print("Digite a motorizacao do carro.....................................: ");
				motorizacao = Main.leia.nextFloat();

				if (motorizacao < 1 || motorizacao > 5) {
					System.out.println("Motorização inválida, digite um valor entre 1.0 e 5.0");
				}

			} while (motorizacao < 1 || motorizacao > 5);

			do {
				System.out.print("Digite a potencia do carro........................................: ");
				potencia = Main.leia.nextInt();

				if (potencia < 1) {
					System.out.println("Digite um valor positivo acima de 0");
				}

			} while (potencia < 1);

			do {
				System.out.print("Digite o peso do carro............................................: ");
				peso = Main.leia.nextFloat();

				if (peso < 500) {
					System.out.println("O peso mínimo é de 500Kg");
				}
			} while (peso < 500);

			do {
				System.out.print("Digite o preco do carro...........................................: ");
				preco = Main.leia.nextFloat();
				
				if (preco < 10000) {
					System.out.println("Preço inválido. Digite um valor acima de R$10.000");
				}
			}while (preco < 10000);

			do {
				Main.leia.nextLine();
				System.out.print("Digite o mes e ano de fabricacao (MM/AAAA)........................: ");
				mesAnoFab = Main.leia.nextLine();

				if (! consistirMesAnoFab(mesAnoFab)){
					System.out.println("Digite uma data valida.");
				}
			}while (! consistirMesAnoFab(mesAnoFab));

			do {
				System.out.print("\nConfirma a gravacao dos dados (S/N) ? ");
				confirmacao = Main.leia.next().charAt(0);
				if (confirmacao == 'S') {
					salvarCarro();
				}
			} while (confirmacao != 'S' && confirmacao != 'N');

		} while (!codCarroChave.equals("FIM"));
	}

	// *********************** Exclusao *****************************

	public void excluir() {
		long posicaoRegistro = 0;
		String codCarroChave;
		char confirmacao;

		Main.leia.nextLine();

		do {
			do {
				Main.leia.nextLine();
				System.out.println(" \n***************  EXCLUSAO DE CARRO  ***************** ");
				System.out.print("Digite o codigo do carro que deseja pagar (Digite FIM para encerrar) : ");
				codCarroChave = Main.leia.nextLine();

				if (codCarroChave.equalsIgnoreCase("FIM")) {
					break;
				}
				posicaoRegistro = pesquisarCarro(codCarroChave);

				if (posicaoRegistro == -1) {
					System.out.println("Codigo nao foi encontrado no sistema.");
				}
			} while (posicaoRegistro == -1);

			if (codCarroChave.equalsIgnoreCase("FIM")) {
				System.out.println("Encerrando esta operação.");
				break;
			}

			System.out.println(" [1] Nome do marca......: " + marca);
			System.out.println(" [2] Nome da categoria..: " + categoria);
			System.out.println(" [3] Nome do modelo.....:" + modelo);
			System.out.println(" [4] Valor do veiculo...: " + preco);
			System.out.println();

			do {
				System.out.print("Deseja deletar esse veiculo (S/N): ");
				confirmacao = Main.leia.next().charAt(0);

				if (confirmacao == 'S') {
					desativarCarro(posicaoRegistro);
				}

			} while (confirmacao != 'S' && confirmacao != 'N');

		} while (!codCarroChave.equalsIgnoreCase("FIM"));
	}

	// *********************** Alteracao *****************************

	public void alterar() {
		RandomAccessFile arquivo;

		String codCarroChave;
		char confirmacao;
		byte opcao;
		long posicaoRegistro = 0;
		boolean validacaoCategoria;

		Main.leia.nextLine();
		System.out.println("\n ***************  ALTERACAO DE CARROS ***************** ");
		do {
			do {
				System.out.print("Digite o codigo do carro que deseja alterar (Digite FIM para encerrar) : ");
				codCarroChave = Main.leia.nextLine();

				if (codCarroChave.equalsIgnoreCase("FIM")) {
					break;
				}

				posicaoRegistro = pesquisarCarro(codCarroChave);

				if (posicaoRegistro == -1) {
					System.out.println("Codigo nao foi encontrado no sistema.");
				}
			} while (posicaoRegistro == -1);

			if (codCarroChave.equalsIgnoreCase("FIM")) {
				System.out.println("Encerrando esta operação.");
				break;
			}

			ativo = 'S';
			codCarro = codCarroChave;

			do {
				System.out.println();
				System.out.println("Codigo do carro [" + codCarro + "]");
				System.out.println(" [1] Marca do carro..................: " + marca);
				System.out.println(" [2] Modelo do carro.................: " + modelo);
				System.out.println(" [3] Fabricacao do carro.............: " + fabricacao);
				System.out.println(" [4] Origem do carro.................: " + origemMarca);
				System.out.println(" [5] Categoria do carro..............: " + categoria);
				System.out.println(" [6] Motorizacao do carro............: " + motorizacao);
				System.out.println(" [7] Potencia do carro...............: " + potencia);
				System.out.println(" [8] Peso do carro...................: " + peso);
				System.out.println(" [9] Preço do carro..................: " + preco);
				System.out.println(" [10] Mês e ano da fabricacao........: " + mesAnoFab);

				do {
					System.out.print("\nDigite a opcao que voce deseja (Digite 0 para finalizar): ");
					opcao = Main.leia.nextByte();

					if (opcao < 0 || opcao > 11) {
						System.out.println("Digite um numero entre 0 a 11.");
					}
				} while (opcao < 0 || opcao > 11);

				switch (opcao) {
					case 1:
						Main.leia.nextLine();
						do {
							System.out.print("Digite a nova marca do carro...........................................: ");
							marca = Main.leia.nextLine();
							origemMarca = consistirMarca(marca);

							if (origemMarca.equals("ERRO")) {
								System.out.println("Mensagem de erro, esta marca nao existe no sistema.");
							}
						} while (origemMarca.equals("ERRO"));
						break;

					case 2:
						Main.leia.nextLine();
						do {
							System.out.print("Digite o modelo...................................................: ");
							modelo = Main.leia.nextLine();

							if (modelo.length() != 6){
								System.out.println("O modelo do carro deve ter 6 caracteres.");
							}
						} while (modelo.length() != 6);
						break;

					case 3:
						Main.leia.nextLine();
						do {
							System.out.print("Digite a nova fabricacao do carro......................................: ");
							fabricacao = Character.toUpperCase(Main.leia.next().charAt(0));

							if (fabricacao != 'I' || fabricacao != 'N') {
								System.out.println(
										"Digite uma opcao de fabricao valida\nI - Internacional | N - Nacional");
							}
						} while (fabricacao != 'I' || fabricacao != 'N');
						break;

					case 4:
						Main.leia.nextLine();
						System.out.println("Origem carro é alterada junto com a marca.");
						break;

					case 5:
						Main.leia.nextLine();
						do {
							System.out.print("Digite a categoria do carro.......................................: ");
							categoria = Main.leia.nextLine();
							validacaoCategoria = true;

							for (int i = 0; i < vetCategoria.length; i++) {
								if (vetCategoria[i].equalsIgnoreCase(categoria)) {
									validacaoCategoria = true;
									break;
								} else {
									validacaoCategoria = false;
									System.out.print("Modelo invalido, digite um modelo valido.");
								}
							}
						} while (!validacaoCategoria);
						break;

					case 6:
						Main.leia.nextLine();
						do {			
							System.out.print("Digite a categoria do carro.......................................: ");
							categoria = Main.leia.nextLine();
							validacaoCategoria = true;
			
							for (int i = 0; i < vetCategoria.length; i++) {
								if (vetCategoria[i].equalsIgnoreCase(categoria)) {
									validacaoCategoria = true;
									break;
								} else {
									validacaoCategoria = false;
								}
							}
							if (! validacaoCategoria){
								System.out.print("Categoria invalida, digite uma categoria valida.");
							}
						} while ( ! validacaoCategoria);

					case 7:
						Main.leia.nextLine();
						do {
							System.out.print("Digite a potencia do carro........................................: ");
							potencia = Main.leia.nextInt();

							if (potencia < 1) {
								System.out.println("Digite um valor positivo acima de 0");
							}

						} while (potencia < 1);
						break;

					case 8:
						Main.leia.nextLine();
						do {
							System.out.print("Digite o peso do carro............................................: ");
							peso = Main.leia.nextFloat();

							if (peso < 500) {
								System.out.println("O peso mínimo é de 500Kg");
							}
						} while (peso < 500);
						break;

					case 9:
						Main.leia.nextLine();
						do {
							System.out.print("Digite o preco do carro...........................................: ");
							preco = Main.leia.nextFloat();
							
							if (preco < 10000) {
								System.out.println("Preço inválido. Digite um valor acima de R$10.000");
							}
						}while (preco < 10000);
						break;

					case 10:
						Main.leia.nextLine();
						do {
							System.out.print("Digite o novo mes e ano de fabricacao (MM/AAAA)........................: ");
							mesAnoFab = Main.leia.nextLine();
			
							if (! consistirMesAnoFab(mesAnoFab)){
								System.out.println("Digite uma data valida.");
							}
						}while (! consistirMesAnoFab(mesAnoFab));
						break;
				}
			} while (opcao != 0);
	
				do {
					System.out.print("\nConfirma a gravacao dos dados (S/N) ? ");
					confirmacao = Main.leia.next().charAt(0);
					if (confirmacao == 'S') {
						desativarCarro(posicaoRegistro);
						salvarCarro();
					}
				} while (confirmacao != 'S' && confirmacao != 'N');

				Main.leia.nextLine();

		} while (!codCarroChave.equalsIgnoreCase("FIM"));
	}

	// ******** RELATORIO **********

	public void relatorio() {
		int opcao;

		System.out.println("\n ***************  RELATORIO ***************** ");
		System.out.println(" [1] Listar todos os carros de uma marca informada");
		System.out.println(" [2] Listar todos os carros de um ano de fabricação informado");
		System.out.println(" [3] Listar todos os carros de uma faixa de preço informada");
		System.out.println(" [4] Listar todos os carros");
		System.out.print("Digite um número de 1 a 4 de acordo com a opção desejada: ");
		opcao = Main.leia.nextInt();

		Main.leia.nextLine();

		try (RandomAccessFile arqCarro = new RandomAccessFile("CARRO.DAT", "r")) {
			int marcaPesq = -1;
			String anoPesq = "";
			float precoMin = 0, precoMax = 0;

			if (opcao == 1) {
				System.out.println("Digite de 1 a 10 para selecionar a marca do carro, sendo:");
				for (int i = 0; i < vetMarca.length; i++) {
					System.out.printf("%d- %s%n", i + 1, vetMarca[i]);
				}
				marcaPesq = Main.leia.nextInt();
				Main.leia.nextLine();

				if (marcaPesq < 1 || marcaPesq > vetMarca.length) {
					System.out.println("Marca inválida.");
					return;
				}

			} else if (opcao == 2) {
				System.out.println("Digite o ano de fabricação:");
				anoPesq = Main.leia.nextLine();
			} else if (opcao == 3) {
				System.out.println("Digite o preço mínimo:");
				precoMin = Main.leia.nextFloat();
				System.out.println("Digite o preço máximo:");
				precoMax = Main.leia.nextFloat();
			} else if (opcao != 4) {
				System.out.println("Opção inválida.");
				return;
			}

			while (arqCarro.getFilePointer() < arqCarro.length()) {
				ativo = arqCarro.readChar();
				codCarro = arqCarro.readUTF();
				marca = arqCarro.readUTF();
				modelo = arqCarro.readUTF();
				fabricacao = arqCarro.readChar();
				origemMarca = arqCarro.readUTF();
				categoria = arqCarro.readUTF();
				motorizacao = arqCarro.readFloat();
				potencia = arqCarro.readInt();
				peso = arqCarro.readFloat();
				preco = arqCarro.readFloat();
				mesAnoFab = arqCarro.readUTF();

				if (ativo == 'S') {
					boolean exibir = false;
					if (opcao == 1 && marca.equalsIgnoreCase(vetMarca[marcaPesq - 1])) {
						exibir = true;
					} else if (opcao == 2 && mesAnoFab.endsWith(anoPesq)) {
						exibir = true;
					} else if (opcao == 3 && preco >= precoMin && preco <= precoMax) {
						exibir = true;
					} else if (opcao == 4) {
						exibir = true;
					}

					if (exibir) {
						System.out.printf("%s %s %s %s %c %s %.1f %d %.1f %.2f %s%n",
								codCarro, marca, modelo, origemMarca, fabricacao, categoria, motorizacao,
								potencia, peso, preco, mesAnoFab);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		}
	}
}
