package may23_2019;

import java.util.Stack;

public class postfixExpreSolve {

	public static void main(String[] args) {
		// TODO Auto-generate
		post123("823/+21^13+*+");
		post123("24/32^-");//value
		postToInfixPrefix("823/+21^13+*+");
		postToInfixPrefix ("24/32^-");
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


	public static void postToInfixPrefix (String str){
		
		Stack<String> is= new Stack<>();//instack
		Stack<String> ps= new Stack<>();//prestack
		int ans;

		for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
			
				// only 2 cases
			 if (ch >= '0' && ch <= '9') {
					is.push(""+ ch);//we cant pass char,
					//convert to string like this
					
					ps.push(""+ch);
			 
			 } 
			 else {
						String v2 = is.pop();//char to string
						String v1 = is.pop();
						String ch2= "("+v1+ch+v2+")";
						is.push(ch2);
						
						String s2= ps.pop();
						String s1= ps.pop();
						String ch3= ch+s1+s2;
						ps.push(ch3);
					}					
				}
		
		System.out.println("postToInfix:"+is.peek());

		System.out.println("postToPrefix:"+ps.peek());
	}

	
	public static void post123(String str){
		//evaluate
		Stack<Integer> posts= new Stack<>();
		int ans;

		for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);

				// only 2 cases
			 if (ch >= '0' && ch <= '9') {
					posts.push(ch - '0');
				} 
			 else {
						
						int v2 = posts.pop();
						int v1 = posts.pop();
						posts.push(operate(v1, v2, ch));
					}
					
				}
		
		System.out.println("poststackexpValue:"+posts.peek());
}
	}
	

