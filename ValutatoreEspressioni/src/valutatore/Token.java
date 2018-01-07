package valutatore;
public class Token{
	int numero;
	char operatorOrVariable;
	boolean isOperator;
	public Token(char o){
		this.operatorOrVariable = o;
		isOperator = o == '+' | o == '-' | o == '*' | o == '/';
	}
	public Token(int numero){
		this.numero = numero;
	}
	public String toString() {
		if(numero == 0 && operatorOrVariable != 0) {
			return ""+operatorOrVariable;
		} else if(numero != 0 && operatorOrVariable == 0) {
			return ""+numero;
		} else return null;
	}
}