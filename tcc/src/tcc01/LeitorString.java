package tcc01;


public class LeitorString {
	//Atributos
	private String[] sufixo; //Tamanho do array = tamanho da palavra + 1
	private String[] prefixo; //Tamanho do array = tamanho da palavra + 1
	private String palavra; 
	
	//Construtores
	public LeitorString(String palavra) {
			this.setPalavra(palavra);

	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		try {
			this.palavra = palavra.replace(" ", ""); //Substitui espaços por vazio
			int tamanhoDoArray = palavra.length() + 1;
			sufixo = new String[tamanhoDoArray];
			prefixo = new String[tamanhoDoArray];
			for (int i = 0, j = palavra.length(); i < sufixo.length; i++, j--) { //For para percorrer os 2 vetores, enquanto i for menor que o tamanho do vetor, continua o código
				if(i == 0) {             //Exemplo: palavra = palavra, j começa com 7 e não faz nada pois o i é 0, evitando, assim, que o j represente uma posição inválida do array, depois o i = 1 e j = 6,
					sufixo[i] = "λ";
					prefixo[i] = "λ";
				}
				else {
					prefixo[i] = palavra.substring(0, i) ; // palavra.substring(início, fim)
					sufixo[i] = palavra.substring(j);
				}
			}
				
		}
		
		catch (Exception e){ //Captura exceções em gerais que não sejam da classe Error (exemplo: OutOfMemoryError)
			System.out.println("Erro: Algo deu errado, tente novamente");
			
		}
	}

	public String[] getPrefixo() {
		return prefixo;
	}


	public String[] getSufixo() {
		return sufixo;
	}

	
	
	public void imprimirSufixo() {
		for (int i = 0; i < sufixo.length; i++) {
			System.out.println(sufixo[i]);
		}
		
	}
	public void imprimirPrefixo() {
		for (int i = 0; i < prefixo.length; i++) {
			System.out.println(prefixo[i]);
		}
	}
	
	public boolean verificarPalindromo() { 
		String reverso = new StringBuilder(palavra).reverse().toString(); //Converte a variável tipo StringBuilder para uma string de novo
		return palavra.toLowerCase().equals(reverso.toLowerCase()); //Verifica se a palavra é igual ao reverso da palavra
	}
}


//Utilizar RunTimeException para capturar erros de acesso a elemento de array além dos limites

