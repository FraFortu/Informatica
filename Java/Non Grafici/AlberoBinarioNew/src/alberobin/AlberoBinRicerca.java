/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alberobin;

/**
 *
 * @author francesco.fortunato
 */
public class AlberoBinRicerca <T extends Comparable<T>> extends AlberoBinNodo<T> {
	public AlberoBinRicerca() {
            super();
	}
        public AlberoBinRicerca(Nodo left, T info, Nodo right) {
            super(left, info, right);
        }
        private void insert(T info, Nodo b) {
			try {
				if (! b.isEmpty()) {
					if (info.compareTo((T) b.info) < 0) {
						insert(info, b.left);
					} else {
						insert(info, b.right);
					}
				} else {
					b = new Nodo(info, null, null);
				}
			} catch(NullPointerException ex) {
				b = new Nodo(info, null, null);
			}
        }
		public void insert(T info) {
			insert(info,this.rad);
		}
}
