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
public class AlberoBin <T> {
	private T info;
	private AlberoBin <T> left;
	private AlberoBin <T> right;
	public AlberoBin() {
		this(null, null, null);
	}
	public AlberoBin(T info, AlberoBin left, AlberoBin right) {
		this.info = info;
		this.left = left;
		this.right = right;
	}
	public T getInfo() {
		return (T)info;
	}
	public AlberoBin getLeft() {
		return left;
	}
	public AlberoBin getRight() {
		return right;
	}
	public boolean isEmpty() {
		return (right == null && left == null && info == null);
	}
}
