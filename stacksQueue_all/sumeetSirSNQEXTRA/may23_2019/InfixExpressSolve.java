// package may23_2019;

import java.util.Stack;
import java.util.*;

public class InfixExpressSolve {
		public static void main(String[] args) {
	
			// double a = Math.random();
			// System.out.println(a);
			//range 0.0 to 1.0
			
			Random rand = new Random();

			int b = rand.nextInt(3);
			System.out.println(b);
			
			int c = rand.nextInt();
			System.out.println(c);//int from 
								 // 2^31 - 1  to  -2^31

		String str = "8+2/3+2^1*(1+3)";
		String str2= "(8+2)/3+2^(1*1+3)";
		// System.out.println(evaluate(str));
		// System.out.println(evaluate(str2));
		
		// System.out.println(InfixToPost(str));
		// System.out.println(InfixToPost(str2));

		
	}
	public static int priority(char ch) {
		int rv = -1;
		switch (ch) {
		case '^':
			rv = 3;
			break;
		case '*':
			;
		case '/':
			rv = 2;
			break;
		case '+':
			rv = 1;
		case '-':
			rv = 1;
			break;

		}
		return rv;

	}

	public static int operate(int v1, int v2, char ch) {
		int rv = -1;
		switch (ch) {
		case '^':
			rv = (int) Math.pow(v1, v2);
			break;
		case '*':
			rv = v1 * v2;
			break;
		case '/':
			rv = v1 / v2;
			break;
		case '+':
			rv = v1 + v2;
			break;
		case '-':
			rv = v1 - v2;
			break;
		}
		return rv;

	}

	public static int evaluate(String str) {
		Stack<Integer> vs = new Stack<>(); //value
		Stack<Character> os = new Stack<>(); //operator

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			// only 4 cases
			//
			if (ch == '(') {
				os.push(ch);
			}

			else if (ch == ')') {
				while (os.peek() != '(') {
					int v2 = vs.pop();
					int v1 = vs.pop();
					char ch2 = os.pop();
					vs.push(operate(v1, v2, ch2));
		
		}
				os.pop();
			}

			else if (ch >= '0' && ch <= '9') {
				vs.push(ch - '0');
			} else {
				while(!os.isEmpty() && os.peek() != '('
						&& priority(ch) <= priority(os.peek())) {

					int v2 = vs.pop();
					int v1 = vs.pop();
					char ch2 = os.pop();
					vs.push(operate(v1, v2, ch2));
				}
				os.push(ch);
			}

		}

		while(!os.isEmpty())
		{
			int v2 = vs.pop();
			int v1 = vs.pop();
			char ch2 = os.pop();
			vs.push(operate(v1, v2, ch2));
		}
		
		return vs.peek();		
	}
	
	public static String InfixToPost(String str){
		String res="";
		Stack<Character> os = new Stack<>();//opertor stack
		String nstr="";
		for(int i=str.length()-1; i>=0; i--)
		{
			nstr=nstr+str.charAt(i);
		}
			
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			// only 4 cases
			//
			if (ch == '(') {
				os.push(ch);
			}

			else if (ch == ')') {
				while (os.peek() != '(') {
					char ch2 = os.pop();
					res+=ch2;					
				}
				os.pop();
			}

			else if (ch >= '0' && ch <= '9') {
					res+=ch;
			} 
			else {
				while(!os.isEmpty() && os.peek() != '(' 
						&& priority(ch) <= priority(os.peek())) {

					char ch2 = os.pop();
					res+=ch2;
				}
				os.push(ch);
			}
		}
		
		while(!os.isEmpty())
		{
			char ch2 = os.pop();
			res+=ch2;
		}
		
		return res;		
	}
}
