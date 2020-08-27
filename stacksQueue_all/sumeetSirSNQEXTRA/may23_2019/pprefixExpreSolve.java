package may23_2019;

import java.util.Stack;

public class pprefixExpreSolve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		pre123("++8/23*^21+13");
		pre123("-/24^32");//value
		
		preToInfixPrefix("++8/23*^21+13");
		//same as pre123 for infix and prefix,just as string
		preToInfixPrefix ("-/24^32");
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

	
	public static void pre123(String str){
		//evaluate
		Stack<Integer> pres = new Stack<>();//prestack
		int ans;

		for (int i = str.length() - 1; i >= 0; i--) {
			char ch = str.charAt(i);

			// only 2 cases
			if (ch >= '0' && ch <= '9') {
				pres.push(ch - '0');// as a string input
			} else {
				// swap v1 and v2
				int v1 = pres.pop(); // typecast
				int v2 = pres.pop();
				pres.push(operate(v1, v2, ch));
			}
		}
		
		System.out.println("prestackexpValue:"+pres.peek());
}

	public static void preToInfixPrefix (String str){
		
		Stack<String> is= new Stack<>();//instack
		Stack<String> ps= new Stack<>();//poststack
		int ans;

		for (int i = str.length()-1; i >=0 ; i--) {
				char ch = str.charAt(i);
			
				// only 2 cases
			 if (ch >= '0' && ch <= '9') {
					is.push(""+ ch);//we cant pass char,
					//convert to string like this
					
					ps.push(""+ch);
			 
			 } 
			 else {
						//v1 v2 swap
				 		String v1 = is.pop();//char to string
						String v2 = is.pop();
						String ch2= "("+v1+ch+v2+")";
						//becomes string
						is.push(ch2);
						
						String s1= ps.pop();
						String s2= ps.pop();
						String ch3= s1+s2+ch;
						ps.push(ch3);
					}					
				}
		
		System.out.println("preToInfix:"+is.peek());

		System.out.println("preToPostfix:"+ps.peek());
	}

}
