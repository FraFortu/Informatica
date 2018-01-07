package calcolatrice;
import java.util.ArrayList;
public class Valutatore{
	
	private static ArrayList<Token> exp;
	
	
	public static double risultato(String exp) { 
		/*exp è l'espressione che inserisco e che voglio calcolare
		mentre this.exp è l'arraylist della classe valutatore
		*/
		Valutatore.exp = valuta(exp);
		AlberoBin expTree = new AlberoBin();
		expTree.insert(Valutatore.exp);
		return expTree.visitaSimmetrica(expTree.radice);
	}
	
	public static ArrayList<Token> valuta(String espressione){
		exp = new ArrayList();
		translateExpression(espressione);
		return exp;
	}
	private static void translateExpression(String s){
        String temp = new String();
        int j;
        s += ' ';
        for(int i=0;i<s.length();i++){
            if(isOperator(s.charAt(i)) || isParenthesis(s.charAt(i)))
                exp.add(new Token(s.charAt(i)));
			/*else{
				if(s.charAt(i) == 'x' | s.charAt(i) == 'y')
					exp.add(new Token(s.charAt(i)));*/
                                else{
					if(s.charAt(i) != ' '){
						for(j=i;s.charAt(j)!=' ' && j < s.length() && !isOperator(s.charAt(j)) && !isParenthesis(s.charAt(j));j++){
							temp += s.charAt(j);
						}
						if(temp.equals(""))
							break;
						exp.add(new Token(Double.parseDouble(temp)));
						i = j-1;
						temp = "";
					}
				}
			//}
        }
	}
	protected static boolean isOperator(char o){
		return o == '+' || o == '-' || o == '*' || o == '/' || o == '^';
	}
        protected static boolean isParenthesis(char o){
		return o == '(' || o == ')';
	}
}