package imp;

import api.Set;

public class Conjunto implements Set {
	
	private int [] vec;
	private int i;
	
	public Conjunto() {
		
		vec = new int[20];
		i = 0;
	}

	
	public void add(int a) {
		
		if(!pertenece(a)) {
			
			vec[i] = a;
			i++;
		}
		
	}

	public void remove (int a) {
		for (int j = 0; j < i; j++) {
			if (vec [j] == a) {
				vec[j] = vec[i -1];
				i--;
				
				return;
			}
		}
	}

	public int choose() {
		return vec[i-1];
	}

	
	public boolean isEmpty() {
		
		return i == 0;
	}
	
	public boolean pertenece (int a) {
		for (int j = 0; j < i; j++) {
			
			if (vec[j] == a) {
				return true;
			}
		}
		
		return false;
	}
	

}
