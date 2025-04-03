package tcc04;

import java.util.HashSet; //Extensão do Set, mais rápido e sem ordem garantida
import java.util.Scanner;
import java.util.Set; //Interface que representa um conjunto
import java.util.ArrayList; //Implementação de List, armazena os elementos em um array dinâmico
import java.util.List;  //Interface que representa uma sequência ordenada de elementos

public class Conjuntos {
    private HashSet<Integer> A;
    private HashSet<Integer> B;
    private static final int maxCardinalidade = 10;

    public Conjuntos() {
        A = new HashSet<>();
        B = new HashSet<>();
    }

    public void adicionarElementosA() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite a quantidade de elementos do conjunto A (máximo 10): "); //Quantidade de elementos
        int cardinalidadeA = scanner.nextInt();
        while (cardinalidadeA > maxCardinalidade || cardinalidadeA < 0) {
            System.out.println("Quantidade inválida! Digite um número entre 0 e 10:"); //Enquanto a cardinalidade A for maior que a cardinalidade maxima ou for menor que zero, repete
            cardinalidadeA = scanner.nextInt();
        }
        System.out.println("Digite os elementos do conjunto A:"); //Elementos
        for (int i = 0; i < cardinalidadeA; i++) {
            A.add(scanner.nextInt());
        }
        
    }

    public void adicionarElementosB() {
        Scanner scanner = new Scanner(System.in); //Quantidade de elementos
        System.out.println("Digite a quantidade de elementos do conjunto B (máximo 10): ");
        int cardinalidadeB = scanner.nextInt();
        while (cardinalidadeB > maxCardinalidade || cardinalidadeB < 0) {
            System.out.println("Quantidade inválida! Digite um número entre 0 e 10:"); 
            cardinalidadeB = scanner.nextInt(); 
        }
        System.out.println("Digite os elementos do conjunto B:"); //Elementos
        for (int i = 0; i < cardinalidadeB; i++) {
            B.add(scanner.nextInt());
        }
    }

    public void apresentarConjuntoA() {
        System.out.println("Conjunto A: " + A);
        System.out.println("Cardinalidade de A: " + A.size());
    }
    
    public void apresentarConjuntoB() {
        System.out.println("Conjunto B: " + B);
        System.out.println("Cardinalidade de B: " + B.size());
    }
    
    public void apresentarUniao() { //Apresenta todos os elementos de  A e B, sem repetir
        Set<Integer> uniao = new HashSet<>(A); //Variável do tipo Set<Integer>, representa o conjunto A, nomeada uniao
        uniao.addAll(B); //Método utilizado para adicionar todos os elementos de um conjunto a outro, sem repetir
        System.out.println("União de A e B (A ∪ B): " + uniao);
        System.out.println("Cardinalidade da união: " + uniao.size());
    }
    
    public void apresentarIntersecao() { //Apresenta apenas os elementos que estão em ambos conjuntos
        Set<Integer> intersecao = new HashSet<>(A);
        intersecao.retainAll(B); //Remove os elementos do conjunto intersecao que nao estão em B
        System.out.println("Interseção de A e B (A ∩ B):: " + intersecao);
        System.out.println("Cardinalidade da Interseção: " + intersecao.size());
    }
    
    public void apresentarDiferenca() { //Apresenta todos os elementos que estão em A, mas não em B
        Set<Integer> diferenca = new HashSet<>(A);
        diferenca.removeAll(B); //Mantém no conjunto apenas os elementos que também estão em B
        System.out.println("Diferença (A - B): " + diferenca);
        System.out.println("Cardinalidade da diferença: " + diferenca.size());
    }

    public void apresentarProdutoCartesiano() { //Conjunto de todos os pares ordenados possíveis, onde o primeiro elemento vem de A e o segundo vem de B
        Set<String> produtoCartesiano = new HashSet<>();

        for (Integer a : A) { // Percorre cada elemento do conjunto A (for-each
            for (Integer b : B) { // Para cada elemento de A, percorre todos os elementos de B
                produtoCartesiano.add("(" + a + ", " + b + ")"); // Adiciona o par ordenado (a, b)
            }
        }
        System.out.println("Produto Cartesiano (A × B): " + produtoCartesiano);
        System.out.println("Cardinalidade do Produto Cartesiano: " + produtoCartesiano.size());
    }
    
    public void apresentarConjuntoDasPartesA() { //Conjunto que contém todos os subconjuntos possíveis de A, incluindo o conjunto vazio, o próprio conjunto e os subconjuntos intermediários
        Set<Set<Integer>> conjuntoDasPartesA = new HashSet<>();
        List<Integer> listaElementos = new ArrayList<>(A); // Converte para lista para facilitar
        int tamanho = listaElementos.size();
        
        // Gerar todas as combinações possíveis
        for (int i = 0; i < (1 << tamanho); i++) { // 2^n subconjuntos
            Set<Integer> subconjunto = new HashSet<>();
            for (int j = 0; j < tamanho; j++) {
                if ((i & (1 << j)) != 0) { // Verifica se o bit está "ligado" (1)
                    subconjunto.add(listaElementos.get(j));
                }
            }
            conjuntoDasPartesA.add(subconjunto);
        }
        
        // Exibir o conjunto das partes e sua cardinalidade
        System.out.println("Conjunto das Partes de A: " + conjuntoDasPartesA);
        System.out.println("Cardinalidade do Conjunto das Partes: " + conjuntoDasPartesA.size());
    }
    
    public void apresentarConjuntoDasPartesB() { //Conjunto que contém todos os subconjuntos possíveis de A
        Set<Set<Integer>> conjuntoDasPartesB = new HashSet<>();
        List<Integer> listaElementos = new ArrayList<>(B); // Converte para um arrayDinamico, um array que aumenta de tamanho automaticamente quando novos elementos sao adicionados
        int tamanho = listaElementos.size(); //Retorna o número de elementos que estao ocupando posições
        
        // Gerar todas as combinações possíveis
        for (int i = 0; i < (1 << tamanho); i++) { // 2^n subconjuntos, onde n é a quantidade de elementos do conjunto
            Set<Integer> subconjunto = new HashSet<>(); //i vai de 0 até 2^n - 1, percorrendo todas as combinações possíveis de elementos.
//Exemplo: Se tamanho = 3, então i vai de 0 a 7 (2³ = 8 subconjuntos)
            
            for (int j = 0; j < tamanho; j++) { //Percorre cada elemento do conjunto B
                if ((i & (1 << j)) != 0) { // Verifica se o bit está "ligado" (1)
                	//Operação bit a bit para determinar quais elementos devem ser adicionados ao subconjunto, desloca o bit 1 de J, ou seja, se j = 0 -> 0001 em vez de 0000
                    subconjunto.add(listaElementos.get(j));
                }
            }
            conjuntoDasPartesB.add(subconjunto);
        }
        
        // Exibir o conjunto das partes e sua cardinalidade
        System.out.println("Conjunto das Partes de B: " + conjuntoDasPartesB);
        System.out.println("Cardinalidade do Conjunto das Partes: " + conjuntoDasPartesB.size());
    }
    
    
    
    
}
