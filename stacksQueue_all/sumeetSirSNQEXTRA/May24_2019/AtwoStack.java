package May24_2019;

public class AtwoStack {

	private int[] arr;
	private int tos1;
	private int tos2;
	private int cap;

		AtwoStack(int val) {
			this.cap = val;
			arr = new int[cap];
			tos1 = -1;
			tos2 = cap;
		}

		public void push1(int val) {
			if (isfull1) {
				System.out.println("stack overflow");
				return;
			}
			tos1++;
			arr[tos1] = val;

		}

		public void push2(int val) {
			if (isfull) {
				System.out.println("stack overflow");
				return ;
			}
			tos2--;
			arr[tos2] = val;
		}
		
		public int pop1() {
			if (isEmpty1()) {
				System.out.println("stack 1 underflow");
				return -1;
			}
			int val = arr[tos];
			arr[tos] = 0;
			tos--;
			return val;
		}

		public int size() {
			return tos + 1;
		}

		public boolean isEmpty() {
			if (size() == 0)
				return true;

			else
				return false;
		}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
