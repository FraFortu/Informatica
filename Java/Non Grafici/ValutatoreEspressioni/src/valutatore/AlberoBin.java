/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valutatore;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author francesco.fortunato
 */
public class AlberoBin {
	protected Nodo <Token> radice;
	public AlberoBin() {
		radice = new Nodo(null, null, null);
	}
	public AlberoBin(Nodo left, Token info, Nodo right) {
		radice.left = left;
		radice.info = info;
		radice.right = right;
	}
	public boolean isEmpty() {
		return radice.info == null;
	}
	public Nodo insert(ArrayList<Token> exp, Nodo n){
		boolean addOSott = false;
		int i;
		for(i = 0; i < exp.size() && ! addOSott; i++) {
			if(exp.get(i).isOperator && exp.get(i).operatorOrVariable == '+' || 
					exp.get(i).operatorOrVariable == '-') {
				addOSott = true;
			}
		}
		//System.out.println(exp.get(i - 1));
		if(addOSott) {
			n = new Nodo(exp.get(i - 1), null, null);
			ArrayList<Token> left = new ArrayList();
			for(int pos = 0; pos < i - 1; pos ++) {
				left.add(exp.get(pos));
			}
			n.left = insert(left, n.left);
			ArrayList<Token> right = new ArrayList();
			for(int pos = i; pos < exp.size(); pos ++) {
				right.add(exp.get(pos));
			}
			n.right = insert(right, n.right);
		} else {
			boolean mulODiv = false;
			for(i = 0; i < exp.size() && ! mulODiv; i++) {
				if(exp.get(i).isOperator && exp.get(i).operatorOrVariable == '*'
						|| exp.get(i).operatorOrVariable == '/') {
					mulODiv = true;
				}
			}
			if(mulODiv) {
				n = new Nodo(exp.get(i - 1), null, null);
				ArrayList<Token> left = new ArrayList();
				for(int pos = 0; pos < i - 1; pos ++) {
					left.add(exp.get(pos));
				}
				n.left = insert(left, n.left);
				ArrayList<Token> right = new ArrayList();
				for(int pos = i; pos < exp.size(); pos ++) {
					right.add(exp.get(pos));
				}
				n.right = insert(right, n.right);
			} else {
				n = new Nodo(exp.get(i - 1), null, null);
			}
		}
		return n;
	}
	public double visitaSimmetrica(Nodo n) {
		double result = 0;
		try {
			if(! n.isEmpty()) {
				Token el = (Token) n.info;
				double l = visitaSimmetrica(n.left);
				double r = visitaSimmetrica(n.right);
				if(! el.isOperator) {
					return el.numero;
				} else {
					if(el.operatorOrVariable == '+') {
						result = l + r;
					} else if(el.operatorOrVariable == '-') {
						result = l - r;
					} else if(el.operatorOrVariable == '*') {
						result = l * r;
					} else if(el.operatorOrVariable == '/') {
						result = l / r;
					}
				}				
			}
		} catch(NullPointerException ex) {
		}	
		return result;
	}
	public void toString(Nodo temp) {
		if(temp.left != null) {
			System.out.println(temp.info + " è la radice di sx " + temp.left.info);
			toString(temp.left);
		}
		if(temp.right != null) {
			System.out.println(temp.info + " è la radice di dx " + temp.right.info);
			toString(temp.right);
		}
	}
	private class Nodo <T> {
		protected T info;
		protected Nodo left;
		protected Nodo right;
		public Nodo(T info, Nodo left, Nodo right) {
			this.info = info;
			this.left = left;
			this.right = right;
		}
			public boolean isEmpty() {
			return info == null && left == null && right == null;
		}
	}
}
