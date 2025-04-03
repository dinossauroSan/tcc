package tcc01;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		int opcao;
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("Leitor de Strings:");
            System.out.println("1 - Ler uma String, imprimir sufixos, imprimir prefixos e verificar palíndromos");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada
			
            switch(opcao) {
            case 1:
            	System.out.println("Digite uma palavra sem espaços");
            	String palavra = scanner.nextLine();
    			LeitorString leitorString = new LeitorString(palavra);
    			System.out.println("Sua palavra é: " + leitorString.getPalavra());
    			System.out.println("Seu prefixo é:");
    			leitorString.imprimirPrefixo();
    			System.out.println("Seu sufixo é:");
    			leitorString.imprimirSufixo();
    		
    			System.out.println("A palavra é um palíndromo?   " + leitorString.verificarPalindromo());
    			break;
            case 2:
            	System.out.println("Saindo...");
            	break;
            default:
            	System.out.println("Opção inválida! Tente novamente.");
            }
		} while (opcao != 2);
		
		scanner.close();
		
		
	}
}
