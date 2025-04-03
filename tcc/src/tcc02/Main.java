package tcc02;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		int opcao;
		int opcao2;
		int opcaoTCC2;
		int opcaoTCC3;
		Scanner scanner = new Scanner(System.in);
		try {
			do {
				System.out.println("Validador de Palavras:");
				System.out.println("1 - Criar um novo automato e inserir transições");
				System.out.println("2 - Implementar autômato do exercício 2-TCC");
				System.out.println("3 - Implementar autômato do exercício 3-TCC");
				System.out.println("4 - Sair");
				System.out.print("Escolha uma opção: ");
				opcao = scanner.nextInt();
				scanner.nextLine(); // Limpar o buffer de entrada
			
				switch(opcao) {
				case 1:
            	
					//Definindo os estados finais
					System.out.println("Quantos estados finais vão ter?");
					int qtdeEstadosFinais = scanner.nextInt();
					scanner.nextLine(); // Consumir a quebra de linha
					Set<String> estadosFinais = new HashSet<>();
					for (int i = 1; i <= qtdeEstadosFinais; i++) { //Enquanto i for menor ou igual a quantidade de estados finais, repita
						System.out.println("Insira o estado Final");
						String estadoFinal = scanner.nextLine();
						estadosFinais.add(estadoFinal);
					}
            	
            	
					//Criando o automato e definindo transições
					AutomatoFinito automato = new AutomatoFinito(estadosFinais);
					do { //While para inserir transições
						System.out.println("Inserir transições ou validar palavras:");
						System.out.println("1 - Inserir uma transição "
								+ "\nTransições iguais serão ignoradas (exemplo: q0 a -> q1 e q0 a -> q0");
						System.out.println("2 - Validar palavra");
						System.out.println("3 - Sair");
						System.out.print("Escolha uma opção: ");
						opcao2 = scanner.nextInt();
						scanner.nextLine();
						switch(opcao2) {
						case 1: //Inserir uma transição
							System.out.println("Escreva o estado de Origem:");
							String estadoOrigem = scanner.nextLine();
							//scanner.nextLine(); // Consumir a quebra de linha
							System.out.println("Escreva o símbolo:");
							char simbolo = scanner.next().charAt(0); //Pegando o primeiro charactere
							scanner.nextLine();
							System.out.println("Escreva o estado de Destino:");
							String estadoDestino = scanner.nextLine();
							automato.adicionarTransicao(estadoOrigem, simbolo, estadoDestino);
							System.out.println(estadoOrigem + ' ' + simbolo + " -> " + estadoDestino );
                    	
                    	
							break;
						case 2: //Validar palavras
							System.out.println("Insira uma palavra composta apenas por a e b");
							scanner.nextLine(); // Consumir a quebra de linha
							String palavra = scanner.nextLine();
							if (automato.validarPalavra(palavra) == true)
								System.out.println("Palavra aceita");
							else
								System.out.println("Palavra rejeitada");
							break;
						case 3: //Sair
							System.out.println("Saindo...");
							break;
						default:
							System.out.println("Opção inválida");
						}
                    
                    	
            		
					} while (opcao2 != 2);
            	
            	
					break;
                
        
				case 2: //Automato exercício 2 TCC
					Set<String> estadosFinaisTCC2 = new HashSet<>();
					estadosFinaisTCC2.add("qf");
            	
					//Inserindo Transições de estados
					AutomatoFinito automatoTCC2 = new AutomatoFinito(estadosFinaisTCC2);
					automatoTCC2.adicionarTransicao("q0", 'a', "q1");
					automatoTCC2.adicionarTransicao("q0", 'b', "q2");
					automatoTCC2.adicionarTransicao("q1", 'a', "qf");
					automatoTCC2.adicionarTransicao("q1", 'b', "q2");
					automatoTCC2.adicionarTransicao("q2", 'a', "q1");
					automatoTCC2.adicionarTransicao("q2", 'b', "qf");
					automatoTCC2.adicionarTransicao("qf", 'a', "qf");
					automatoTCC2.adicionarTransicao("qf", 'b', "qf");
            	
					//Validando Palavras
					do {
						System.out.println("Validar Palavras:");
						System.out.println("1 - Validar uma Palavra");
						System.out.println("2 - Sair");
						System.out.print("Escolha uma opção: ");
						opcaoTCC2 = scanner.nextInt();
                    
						switch(opcaoTCC2) {
						case 1:
							System.out.println("Insira uma palavra composta apenas por a e b");
							scanner.nextLine(); // Consumir a quebra de linha
							String palavra = scanner.nextLine();
							if (automatoTCC2.validarPalavra(palavra) == true)
								System.out.println("Palavra aceita");
							else
								System.out.println("Palavra rejeitada");
							break;
						case 2:
							System.out.println("Saindo...");
							break;
						default:
							System.out.println("Opção inválida");
						}
                    
					} while (opcaoTCC2 != 2);
            	
					break;	
				case 3: //Automato exercício 3 TCC
					//Definindo EstadosFinais
					Set<String> estadosFinaisTCC3 = new HashSet<>(); //HashSet é mais rápido, mas não mantém a ordem de inserção
					estadosFinaisTCC3.add("s4");
					estadosFinaisTCC3.add("s6");
					
					//Inserindo transições de estados
					AutomatoFinito automatoTCC3 = new AutomatoFinito(estadosFinaisTCC3);
					automatoTCC3.adicionarTransicao("q0", 'b', "q0");
					automatoTCC3.adicionarTransicao("q0", 'a', "s3");
					automatoTCC3.adicionarTransicao("s3", 'a', "s6");
					automatoTCC3.adicionarTransicao("s3", 'b', "q0");
					automatoTCC3.adicionarTransicao("s6", 'a', "s6");
					automatoTCC3.adicionarTransicao("s6", 'b', "s4");
					automatoTCC3.adicionarTransicao("s4", 'a', "s6");
					automatoTCC3.adicionarTransicao("s4", 'b', "s4");
					
					//Validando palavras
					do {
						System.out.println("Validar Palavras:");
						System.out.println("1 - Validar uma Palavra");
						System.out.println("2 - Sair");
						System.out.print("Escolha uma opção: ");
						opcaoTCC3 = scanner.nextInt();
                    
						switch(opcaoTCC3) {
						case 1:
							System.out.println("Insira uma palavra composta apenas por a e b");
							scanner.nextLine(); // Consumir a quebra de linha 
							String palavra = scanner.nextLine();
							if (automatoTCC3.validarPalavra(palavra) == true)
								System.out.println("Palavra aceita");
							else
								System.out.println("Palavra rejeitada");
							break;
						case 2:
							System.out.println("Saindo...");
						default:
							System.out.println("Opção inválida");
						}
                    
					} while (opcaoTCC3 != 2);
					break;
				case 4: //Sair
					System.out.println("Saindo...");
					break;
            	
				default:
					System.out.println("Opção inválida! Tente novamente.");
				} 
			}while (opcao != 4);
        
		
			scanner.close();
		} catch (Exception e) {
			System.out.println("Erro: Algo deu errado, tente novamente");
		}
		}
}
