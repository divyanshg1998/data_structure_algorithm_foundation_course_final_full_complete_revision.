// package March23_2019_linkedlist_2;

public class Node {
			int data;
			Node next;

		public Node(int data) {
				data = data;
			}
	

	public void rloop(Node nn) {

	}

	public boolean isCircular(Node n){

		Node s=n;   //slow
		Node f=n; //fast
		while(s != null)
		{
			s=s.next;
			f=f.next.next;
			if(s==f)
				return true;

		}
		
		return false;
}

	void display() {

	}

	public static void main(String[] args)	{
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		n10.next = null;

		boolean res = n1.isCircular(n1);
		System.out.println(res);
		//removeLoop();
		
		//display(n1);
	}
	
	}