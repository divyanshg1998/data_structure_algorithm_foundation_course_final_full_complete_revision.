// package March23_2019_linkedlist_2;
import java.util.*;

public class linkedList_2 {

	private class Node {
		public int data;
		public Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	private void handleAddSize0(int data) {
		Node nn = new Node();

		nn.data = data;
		nn.next = null;

		head = nn;
		tail = nn;
		size++;
	}

	public void addLast(int data) {

		if (head == null)
			handleAddSize0(data);

		else {
			// steps
			// step1: space allocation
			Node nn = new Node();
			// step2:Put value of var
			nn.data = data;
			nn.next = null;
			// 3.connect from last
			tail.next = nn;
			// 4.summary update
			tail = nn;
			size++;
		}

	}

	// isempty
	public void display() {
		Node nn = new Node();
		nn = head;
		for (int i = 0; i < size; i++) {
			// not by condition of tail bcz last element being left then
			// nn.next != tail
			System.out.print(nn.data + " ");
			nn = nn.next;
		}
		System.out.println();
	}

	public void getSize() {
		System.out.println(size);
	}

	public boolean isEmpty() {

		return size == 0;
		// wrong code
		// must use size makes easy
		// if (head == null && tail == null) {
		// System.out.println("LL is EMPTY");
		// } else
		// System.out.println("LL is NOT EMPTY");
		//
	}

	public void addFirst(int data) {
		if (size == 0)
			handleAddSize0(data);

		Node nn = new Node();
		nn.data = data;
		nn.next = head;
		head = nn;
		size++; // imp
	}

	public int getFirst() {
		if (size == 0)
			return -1;
		else
			return head.data;

	}

	public int getLast() {

		return tail.data;

	}

	private int handleRemoveWhenSize1() {
		int temp = head.data;
		head = tail = null;
		size = 0;
		return temp;
	}

	public int removeFirst() {
		if (size == 0)
			return -1;

		else if (size == 1)
			return handleRemoveWhenSize1();
		// can call
		// handleAddatsize0()
		else {
			head = head.next;
			Node nn = head;
			size--;
			return nn.data;
		}
	}

	public int removeAt(int indx) {
		// like always, 4 cases
		// 1.index out of bound
		// 2.remove first (2cases)
		// 3.remove last (2 cases)
		// 4.normal remove
		if (indx < 0 || indx > size) {
			return -1;
		}

		else if (indx == 0)
			return removeFirst();

		else if (indx == size - 1)
			return removeLast();

		else { // imp
			Node nn = getNodeAt(indx - 1);
			Node nn1 = nn.next;
			nn.next = nn.next.next;
			size--;
			return nn1.data;
		}
	}

	public Node getNodeAt(int indx) {
		// TODO Auto-generated method stub
		Node nn = head;
		for (int i = 1; i <= indx; i++) {
			nn = nn.next;
		}
		return nn;
	}

	public int removeLast() {
		if (size == 0)
			return -1;

		else if (size == 1)
			return handleRemoveWhenSize1();
		// can call

		else {
			Node nn = getNodeAt(size - 2);
			nn.next = null;
			int t = tail.data;
			tail = nn;
			// silly
			size--;
			return t;
		}
	}

	// changes done by me
	public void addAt(int data, int indx) {
		// like always, 4 cases
		// 1.index out of bound
		// 2.add first (2cases)
		// 3.add last (2 cases)
		// 4.normal add
		if (indx < 0 && indx > size)
			return;
		else if (indx == 0)
			addFirst(data);
		else if (indx == size - 1)
			addLast(data);
		else {
			Node nn = new Node();
			nn.data = data;
			Node nn1 = getNodeAt(indx - 1);
			nn.next = nn1.next;
			nn1.next = nn;
			// dont miss
			size++;
		}
	}

	private Node calculateMid(Node sp, Node ep) {
		Node slow = sp;
		Node fast = sp;
		while (fast != ep && fast.next != ep) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public int getMid() {
		Node nn = calculateMid(head, tail);
		return nn.data;
	}
	
	public int kthfromLast(int k){
		Node s=head;
	
		Node f=head;
		
		for(int i=1; i<=k; i++)
		{
			f=f.next;
		}
		
		while(f!=null)
		{
			s=s.next;
			f=f.next;
			}
		
		return s.data;
	}
	
	public void mergeList(linkedList_2 l3 ,
			 linkedList_2 l4)
	{
		Node s1=l3.head;
		Node s2=l4.head;
		
		while(s1 != null && s2 != null){
			if( s1.data<=s2.data ){
				this.addLast(s1.data);
				s1=s1.next;
			}
			else{
				this.addLast(s2.data);
				s2=s2.next;
			}
			}//2 loops
		while(s1 != null ){
				this.addLast(s1.data);
				s1=s1.next;
		}
		while(s2 != null){
				this.addLast(s2.data);
				s2=s2.next;
	}
	}

	private linkedList_2 mergeSort(Node f, Node l){
		
		if(f==l){
			linkedList_2 l7=new linkedList_2();
			l7.addLast(f.data);
			return l7;
			}
		
		Node mid=calculateMid(f,l); 
		
		linkedList_2 l2= new linkedList_2();
		l2 = mergeSort(f, mid);
		
		linkedList_2 l3= new linkedList_2();
		l3 = mergeSort(mid.next, l);
		
		linkedList_2 l4= new linkedList_2();
		l4.mergeList(l2,l3);
		
		return l4;
		}
	
	public linkedList_2 mergeSort()
	{
		return mergeSort(head,tail);
	}
		
	public static void main(String[] args) {
	
		linkedList_2 l1 = new linkedList_2();
		l1.addLast(30);
		l1.addLast(20);
		l1.addLast(10);
		l1.addLast(50);
		l1.addLast(15);
		l1.display();
		System.out.println("<====mid====>");
		System.out.println(l1.getMid()); // without size
		l1.addLast(40);
		l1.display();
		System.out.println("<====mid====>");
		System.out.println(l1.getMid());
		System.out.println("<===2thfromLast===>");
		System.out.println(l1.kthfromLast(2));
		
		// linkedList_2 l2 = new linkedList_2();
		// l2.addLast(3);
		// l2.addLast(7);
		// l2.addLast(7);
		// l2.addLast(9);
		// l2.addLast(9);
		// linkedList_2 l3 = new linkedList_2();
		// l3.addLast(5);
		// l3.addLast(6);
		// l3.addLast(7);
		// l3 .addLast(7);
		// l3.addLast(8);

//		linkedList_2 l4 = new linkedList_2();
//		l2.display();
//		l3.display();
//		System.out.println("<===merge(sorted)====>");
//		linkedList_2 l6=new linkedList_2();
//		l6.mergeList(l2,l3);
//		l6.display();
//		System.out.println("<===mergesort====>");
//		l1.display();
//		linkedList_2 l7=new linkedList_2();
//		l7=l1.mergeSort();
//		l7.display();
	System.out.println("<==no linkedList===>");
//suppose we have only node and no class
	
	
	
	
		
	
	}

}
