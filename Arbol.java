package imp;

import api.BinaryTree;
import api.Dictionary;
import api.Set;

public class Arbol {
	
	public boolean verificar (BinaryTree a, Dictionary d) {
		
		Set claves = d.getKeys();
		
		Set aux = copiarSet(claves);
		while(!aux.isEmpty()) {
			
			int nodo = aux.choose();
			aux.remove(nodo);
			
			int nivelDiccionario = d.get(nodo);
			int nivelReal = nivel(a, nodo, 0);
			
			if (nivelReal != nivelDiccionario) {
				return false;
				
			}
		}
		return true;
	}
	
	private int nivel(BinaryTree a, int x, int nivelActual) {
		if (a ==null) {
			return -1;
		}
		
		if (a.getRoot() == x) {
			return nivelActual;
		}
		int izquierda = nivel(a.getLeft(), x, nivelActual +1);
		
		if (izquierda !=1) {
			return izquierda;
		}
		return nivel(a.getRight(), x, nivelActual+1);
		
		
	}
	
	public Set copiarSet(Set conjunto) {
		Set copia = new Conjunto();
		Set aux = new Conjunto();
		
		while (!conjunto.isEmpty()) {
			int x = aux.choose();
			conjunto.remove(x);
			
			copia.add(x);
			aux.add(x);
			
		}
		
		while (!aux.isEmpty()) {
			
			int x = aux.choose();
			aux.remove(x);
			
			conjunto.add(x);
		}
		
		return copia;
		
	}

}
