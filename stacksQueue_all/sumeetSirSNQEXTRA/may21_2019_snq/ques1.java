// package may21_2019_snq;

import java.util.Stack;

public class ques1 {

	public static void stack_print(String str) {

		Stack<Integer> st = new Stack<Integer>();
		int val = 1;
		for (int i = 0; i < str.length(); i++) {

			st.push(val);
			val++;

			if (str.charAt(i) == 'i') {

				while (!st.isEmpty()) {
					System.out.println(st.peek());
					st.pop();
				}
				}
			}

		st.push(val);
		val++;
		while (!st.isEmpty()) {
			System.out.println(st.peek());
			st.pop();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stack_print("ddddddi");
		System.out.println();
		// stack_print("ddidddid");
		
	}
}
