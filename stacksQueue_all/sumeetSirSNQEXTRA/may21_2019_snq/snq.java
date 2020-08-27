package may21_2019_snq;

import java.util.Stack;

public class snq {
	
	public static void stack_demo(){
		
		Stack<Integer> st= new Stack<Integer>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		
		while(st.size()>0)
		{
			System.out.println(st.peek());
			st.pop();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stack_demo();
	}
}

