package imp;

import api.Set;
import api.Graph;

public class Grafo implements Graph {
	
	private int [][] matriz;
	private Set nodos;
	private int max;
	
	public Grafo () {
		
		max = 100;
		matriz = new int[max][max];
		nodos = new Conjunto();
		
		
	}
	
	public void addNode(int node) {
		nodos.add(node);
		
	}

	
	public void removeNode(int node) {
		nodos.remove(node);
		
		for(int i = 0; i< max; i++) {
			
			matriz[node][i] = 0;
			matriz[i][node] = 0;
			
		}
	}

	public Set getNodes() {
		
		return nodos;
	}


	public void addEdge(int from, int to, int weight) {
		
		matriz [from][to] = weight;
		
	}

	public void removeEdge(int from, int to) {
		matriz[from][to] = 0;
	}

	public boolean edgeExists(int from, int to) {
		
		return matriz [from][to] != 0;
	}

	public int weight(int from, int to) {
		return matriz[from][to];
	}
	
	
	public boolean iguales (Graph g, Graph g2) {
		
		Set nodos = g.getNodes();
		Set aux = copiarSet(nodos);
		
		while (!aux.isEmpty()) {
			
			int x = aux.choose();
			aux.remove(x);
			
			if(!pertenece(g2.getNodes(), x)) {
				return false;
			}
		}
		
		Set segAux = copiarSet(nodos);
		
		while (!segAux.isEmpty()) {
			
			int elemento = segAux.choose();
			segAux.remove(elemento);
			
			Set terAux = copiarSet(nodos);
			
			while(!terAux.isEmpty()) {
				int segElemento = terAux.choose();
				terAux.remove(segElemento);
				
				if (g.edgeExists(elemento, segElemento) != g2.edgeExists(elemento, segElemento)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean pertenece(Set c, int x) {
		
		Set aux = copiarSet(c);
		while(!aux.isEmpty()) {
			
			int elemento = aux.choose();
			aux.remove(elemento); 
			
			if( elemento == x) {
				return true;
			}
		}
		
		return false;
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
