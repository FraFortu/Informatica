package calcolatrice;
public class Token{
	double numero;
	char operatorOrParenthesis;
	boolean isOperator;
        boolean isParenthesis;
	public Token(char o){
		this.operatorOrParenthesis = o;
		isOperator = (o == '+' || o == '-' || o == '*' || o == '/' || o == '^');
                isParenthesis = (o == '(' || o == ')');
	}
	public Token(double numero){
		this.numero = numero;
                isOperator = isParenthesis = false;
	}
	public String toString() {
		if(numero == 0 && operatorOrParenthesis != 0) {
			return ""+operatorOrParenthesis;
		} else if(numero != 0 && operatorOrParenthesis == 0) {
			return ""+numero;
		} else return null;
	}
}