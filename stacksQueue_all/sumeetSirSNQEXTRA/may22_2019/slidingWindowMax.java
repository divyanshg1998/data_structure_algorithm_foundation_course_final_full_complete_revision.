// package may22_2019;

import java.util.Stack;

public class slidingWindowMax {

	public static void main(String[] args) {
		
		int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
		int[] arr2 = nge(arr);
		for (int val : arr2) {
			System.out.print(val + " ");
		}
		System.out.println();

		int[] arr3 = slidwindow(arr2, 4);
		for (int val : arr3) {
			System.out.print(val + " ");
		}

	}

	// index
	public static int[] nge(int[] arr) {
		Stack<Integer> st = new Stack<Integer>();

		st.push(arr.length - 1);
		int[] res = new int[arr.length];
		res[res.length - 1] = arr.length;

		for (int i = arr.length - 2; i >= 0; i--) {
			while (st.size() != 0  && arr[i] > arr[st.peek()]) {
				st.pop();
			}

			res[i] = st.size() == 0 ? arr.length : st.peek();
			st.push(i);

		}
		return res;
	}

	public static int[] slidwindow(int[] arr, int k) {

		int[] result = new int[arr.length - k + 1];

		int j = 0;

		for (int i = 0; i < arr.length - k + 1; i++) {

			if (j < i)
				j = i;

			while (arr[j] < i + k) {
				j = arr[j];
			}
			result[i] = j;
		}
		return result;
	}
}