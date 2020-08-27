package May24_2019;

public class AmyStack {

	private int[] arr;
	private int tos;
	private int cap;

	AmyStack(int val) {
		this.cap = val;
		arr = new int[cap];
		tos = -1;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmyStack ms = new AmyStack(3);
		ms.push(10);
		ms.push(20);
		ms.push(30);
		ms.push(40);
		while (ms.size() > 0) {
			int val = ms.pop();
			System.out.println(val);
		}
		ms.pop();
	}
	
	public void push(int val) {
		if (tos == cap - 1) {
			System.out.println("stack overflow");
			return;
		}
		tos++;
		arr[tos] = val;

	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("stack underflow");
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

}
