/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeconcatenate;

/**
 *
 * @author francesco.fortunato
 */
public class ListaConcatenata <T> {
	private NodoConcatenato testa,coda;
	/*
	Esercizio 1
	Implementazione dei costruttori
	Implementazione dei metodi @toString() e @size()
	*/
	public ListaConcatenata() {
		testa = coda = null;
	}
	public ListaConcatenata(T[] n) {
		for(int i = 0; i < n.length; i++) {
			if(i == 0) testa = coda = new NodoConcatenato(n[i],null);
			else {
				NodoConcatenato tempCoda = new NodoConcatenato(n[i], null);
				coda.next = tempCoda;
				coda = tempCoda;
			}
		}
	}
	@Override
	public String toString() {
            if(size() == 0) return "It's empty!";
		NodoConcatenato toPrint = testa;
		String s = "[";
		while(!toPrint.equals(coda)) {
			s+=toPrint.info.toString()+",";
			toPrint = toPrint.next;
		}
		s+=toPrint.info.toString()+"]";
		return s;
	}
	public int size() {
            if(testa == null) return 0;
		int i = 0;
		NodoConcatenato temp = testa;
		while(!temp.equals(coda)) {
			temp = temp.next;
			i++;
		}
		return ++i;
	}
	/*
	Esercizio 2
	Implementazione dei metodi addHead() e addTail()
	Implementazione dei metodi removeHead() e removeTail()
	*/
	public void addHead(T elem) {
            if(size() == 0)
		testa = coda = new NodoConcatenato(elem,null);
            else testa = new NodoConcatenato(elem,testa);
	}
	public void addTail(T elem) {
            NodoConcatenato temp;
            if(size() == 0) {
		temp = new NodoConcatenato(elem, null);
		coda = temp;
                testa = coda;
            } else {
                temp = new NodoConcatenato(elem, null);
		coda.next = temp;
		coda = temp;
            }
	}
	public T removeHead() {
		NodoConcatenato oldHead = testa;
		testa = testa.next;
		return (T)oldHead.info;
	}
	public T removeTail() {
		NodoConcatenato newTail = testa;
		while(!newTail.next.equals(coda)) {
			newTail = newTail.next;
		}
		coda = newTail;
		coda.next=null;
		return (T)newTail.next;
	}
	/*
	Esercizio 3
	Implementazione dei metodi set(int n, T x), get(int n) e remove(int n)
	* e add(int n, T x)
	*/
	public T get(int x) {
		int lunghezza = size();
		NodoConcatenato node = testa;
		for(int i = 0; i < lunghezza; i++) {
			if(i == x) {
				return (T)node.info;
			} else node = node.next;
		}
		return (T)"Non Trovato!";
	}
	public void set(int x, T val) {
		int lunghezza = size();
		NodoConcatenato node = testa;
		for(int i = 0; i < lunghezza; i++) {
			if(i == x) {
				node.info = val;
			} else node = node.next;
		}
	}
	public void add(int x, T val) {
		int lunghezza = size();
		NodoConcatenato toAdd = testa;
                if(x == 0) {
                    addHead(val);
                    return;
                }                
		for(int i = 0; i < lunghezza; i++) {
			if(i == x-1) {
				NodoConcatenato temp = toAdd;
				toAdd = new NodoConcatenato(val ,null);
				toAdd.next = temp.next;
				temp.next = toAdd;
			}
			toAdd = toAdd.next;
		}
	}
        public T remove(int n) {
            int lunghezza = size();
            NodoConcatenato temp;
            if(n == 0) {
                temp = testa;
                removeHead();
                return (T)temp.info;
            }
            if(n == lunghezza-1) {
                temp = coda;
                removeTail();
                return (T)temp.info;
            }
            temp = testa;
            for(int i = 0; i < lunghezza; i++) {
                if(i == n-1) {
                    NodoConcatenato toRemove = temp.next;
                    temp.next=toRemove.next;
                    return (T)toRemove.info;
                } else temp = temp.next;
            }
            return (T)"Non Trovato!";
        }
}
