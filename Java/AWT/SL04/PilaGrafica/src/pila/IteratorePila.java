package pila;

public class IteratorePila implements Iterator {
	private PilaIterabile pila;
	private Nodo scorri;
	public IteratorePila(PilaIterabile pila) {
		this.pila = pila;
		goFirst();
	}
	@Override
	public Object current() {
		return scorri.info;
	}

	@Override
	public boolean inside() {
		return scorri.next != null;
	}

	@Override
	public void goFirst() {
		scorri = (Nodo) pila.top();
	}

	@Override
	public void goNext() {
		if(inside())
			scorri = scorri.next;
	}
	
}
