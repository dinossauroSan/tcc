package tcc04;

public class Conjuntos {
	private int[] A;
	private int[] B;
	
	//Construtores da classe
	public Conjuntos(int cardinalidadeA, int cardinalidadeB) {
		
	}
	public Conjuntos() {
		
	}
	
	
	
	
	
	
	//Imprimir conjunto A
	public void imprimirConjuntoA() {
		
	}
	
	//Imprimir conjunto B
	public void imprimirConjuntoB() {
		
	}
	
	
	
	
	
	
	//Gets e Sets
	public int[] getB() {
		return B;
	}


	public void setB(int cardinalidade) {
		if (cardinalidade <= 10) {
			B = b;
		}
		else
			System.out.println("A cardinalidade deve ser menor ou igual a 10");
	}


	public int[] getA() {
		return A;
	}


	public void setA(int[] a) {
		A = a;
	}
}
