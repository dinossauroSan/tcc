package tcc02;
import java.util.HashMap; //Extensão do Map
import java.util.Map; //Interface java que armazena pares chave-valor, onde cada chave é única e mapeia para um valor específico
//Map<chave, valor>
import java.util.Set;

public class AutomatoFinito {
	private Map<String, Map<Character, String>> transicoes; //Exemplo: Map<q0, a -> q1> 
	private String estadoAtual; // Um Map composto por outro map. Map<Estado, Map<letra, Estado>>
	private Set<String> estadosFinais;
	
	//As transições definem o automato, podendo criar qualquer AFD através do método adicionartransicao
	
	public AutomatoFinito(Set<String> estadosFinais) {
		try {
			transicoes = new HashMap<>();
			this.estadosFinais = estadosFinais;
			estadoAtual = "q0";
		} catch (Exception e) {
			System.out.println("Erro: Algo deu errado, tente novamente");
		}
		
		
		
		
	}
	
	public void adicionarTransicao(String estadoOrigem, char simbolo, String estadoDestino) {
		try {
			transicoes.putIfAbsent(estadoOrigem, new HashMap<>()); 
		
		//Verifica se o estado de origem já existe no mapa de transições e se ele não existir
		//ele cria um novo, se existir, não faz nada
		
			transicoes.get(estadoOrigem).put(simbolo, estadoDestino); //Obtém o hashmap correspondente ao estadoOrigem
		} catch (Exception e) {
			System.out.println("Erro: Algo deu errado, tente novamente");
		}
	}
	
	public boolean validarPalavra(String palavra) {
		
		estadoAtual = "q0";
		
		for (char simbolo : palavra.toCharArray()) { //: Transforma o for em um For-each 
		//toCharArray transforma a palavra em um array de caracteres, exemplo: "abc" em ['a', 'b', 'c']
			if (!transicoes.containsKey(estadoAtual) || !transicoes.get(estadoAtual).containsKey(simbolo))
				return false;
			//!transicoes.containsKey(estadoAtual) Verifica se o estado atual existe, se ele não existir, retorna false (está invertido)
			//!transicoes.get(estadoAtual).containsKey(simbolo) Verifica se há uma transição válida para o símbolo, se não houver, retorna false, ou seja, inválido
			
			estadoAtual = transicoes.get(estadoAtual).get(simbolo);
			//Obtém o próximo estado
		}
		return estadosFinais.contains(estadoAtual); //Verifica se terminou no estado final
	}
	
	public void setEstadosFinais(Set<String> estadosFinais) {
		try {
			this.estadosFinais = estadosFinais;
		} catch (Exception e) {
			System.out.println("Erro: Algo deu errado, tente novamente");
		}
	}
	
	
}
