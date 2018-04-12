/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vicinanza;

/**
 *
 * @author PS03
 */
public class Lista <PuntoMappa> implements Crossable {
	/*
	classe Lista di PuntoMappa con testa e coda (NodoConc) come proprietà
	testa e coda sono accessibili solo all'interno del package (protected) per uso all'interno della classe Mappa
	*/
	protected NodoConc<PuntoMappa> testa,coda;
	public Lista() {
		testa = coda = null;
	}
	//il metodo add aggiunge un elemento alla lista
	public void add(PuntoMappa elem) {
		if(size() == 0) {
			testa = coda = new NodoConc(elem,null);
		} else {
			NodoConc toAdd = new NodoConc(elem, null);
			coda.next = toAdd;
			coda = toAdd;
		}
	}
	//size calcola quanti elementi sono presenti
	public int size() {
		if(testa == null) return 0;
		NodoConc temp = testa;
		int counter = 0;
		while(!temp.equals(coda)) {
			counter++;
			temp = temp.next;
		}
		return ++counter;
	}
	//toString è un metodo inutile in questo caso ma comunque stampa gli elementi della lista
	@Override
	public String toString() {
		int length = size();
		String toPrint = "[+\n";
		NodoConc temp = testa;
		for(int i = 0; i < length; i++) {
			toPrint += temp.info.toString() + "\n";
		}
		toPrint += coda.info.toString() +"\n";
		return toPrint;
	}
        @Override
        public Iteratore newIterator() {
            return new IteratoreClass(this);
        }
} 
