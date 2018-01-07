package valutatore;
import java.util.ArrayList;
public class Valutatore{
	public static void main(String[] args) {
		ArrayList<Token> e = Valutatore.valuta("8*3-14");
		/*for(int i=0;i<e.size();i++)
			System.out.println(e.get(i).toString());*/
		AlberoBin b = new AlberoBin();
		b.radice = b.insert(e, b.radice);
		//b.toString(b.radice);
		System.out.println(b.visitaSimmetrica(b.radice));
	}
	private static ArrayList<Token> exp;
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
            if(s.charAt(i) == '+' | s.charAt(i) == '-' | s.charAt(i) == '*' | s.charAt(i) == '/')
                exp.add(new Token(s.charAt(i)));
			else{
				if(s.charAt(i) == 'x' | s.charAt(i) == 'y')
					exp.add(new Token(s.charAt(i)));
				else{
					if(s.charAt(i) != ' '){
						for(j=i;s.charAt(j)!=' ' && j < s.length() && !isOperator(s.charAt(j));j++){
							if(s.charAt(j) == 'x' || s.charAt(j) == 'y' || ((int)s.charAt(j) >= 65 && (int)s.charAt(j) <= 90) || ((int)s.charAt(j) >= 97 && (int)s.charAt(j) <= 122))
								break;
							temp += s.charAt(j);
						}
						if(temp.equals(""))
							break;
						exp.add(new Token(Integer.parseInt(temp)));
						i = j-1;
						temp = "";
					}
				}
			}
        }
	}
	private static boolean isOperator(char o){
		return o == '+' | o == '-' | o == '*' | o == '/';
	}
}