/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatrice;
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
	public void insert(ArrayList<Token> exp) {
		radice = insert(exp, radice);
	}
        
        /*
        il metodo insert funziona con una sola coppia di parentesi! Punto da migliorare 07/01/2018
        */
	private Nodo insert(ArrayList<Token> exp, Nodo n){
		boolean addOSott = false;
		int i;
                int closeParenthesisPos = -1;
                int openParenthesisPos = exp.size();
                for(int j = exp.size() - 1; j >= 0;) {
                    if(exp.get(j).isParenthesis && exp.get(j).operatorOrParenthesis == ')' ) {
                        closeParenthesisPos = j;
                        break;
                    }
                    j--;
                }
                for(int j = 0; j < exp.size();) {
                    if(exp.get(j).isParenthesis && exp.get(j).operatorOrParenthesis == '(' ) {
                        openParenthesisPos = j;
                        break;
                    }
                    j++;
                }
                if(openParenthesisPos == 0 && closeParenthesisPos == exp.size() - 1) {
                    ArrayList<Token> parenthesisPart = new ArrayList();
                            for(int pos = openParenthesisPos + 1; pos < closeParenthesisPos; pos ++) {
					parenthesisPart.add(exp.get(pos));
                            }
                            exp = parenthesisPart;
                            openParenthesisPos = exp.size();
                            closeParenthesisPos = -1;
                }
		for(i = exp.size() - 1; i >= 0 && ! addOSott; ) {
			if(exp.get(i).isOperator && exp.get(i).operatorOrParenthesis == '+' || 
					exp.get(i).operatorOrParenthesis == '-') {
				addOSott = true;
				break;
			}
			i--;
		}
		//System.out.println(exp.get(i - 1));
		if(addOSott && (closeParenthesisPos < i || openParenthesisPos > i)) {
			n = new Nodo(exp.get(i), null, null);
			ArrayList<Token> left = new ArrayList();
			for(int pos = 0; pos < i; pos ++) {
				left.add(exp.get(pos));
			}
			n.left = insert(left, n.left);
			ArrayList<Token> right = new ArrayList();
			for(int pos = i + 1; pos < exp.size(); pos ++) {
				right.add(exp.get(pos));
			}
			n.right = insert(right, n.right);
		} else {
			boolean mulODiv = false;
			for(i = exp.size() - 1; i >= 0 && ! mulODiv;) {
				if(exp.get(i).isOperator && exp.get(i).operatorOrParenthesis == '*'
						|| exp.get(i).operatorOrParenthesis == '/' || exp.get(i).operatorOrParenthesis == '^') {
					mulODiv = true;
					break;
				}
				i--;
			}
			if(mulODiv && (closeParenthesisPos < i || openParenthesisPos > i)) {
				n = new Nodo(exp.get(i), null, null);
				ArrayList<Token> left = new ArrayList();
				for(int pos = 0; pos < i; pos ++) {
					left.add(exp.get(pos));
				}
				n.left = insert(left, n.left);
				ArrayList<Token> right = new ArrayList();
				for(int pos = i + 1; pos < exp.size(); pos ++) {
					right.add(exp.get(pos));
				}
				n.right = insert(right, n.right);
			} else if(closeParenthesisPos < i || openParenthesisPos > i) {
				n = new Nodo(exp.get(i + 1), null, null);
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
					switch (el.operatorOrParenthesis) {
						case '+':
							result = l + r;
							break;
						case '-':
							result = l - r;
							break;
						case '*':
							result = l * r;
							break;
						case '/':
							result = l / r;
							break;
                                                case '^':
                                                        result = 1.0;
                                                        for(int i = 0; i < r; i++) {  
                                                            result *= l;
                                                        }
                                                        break;
						default:
							break;
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
