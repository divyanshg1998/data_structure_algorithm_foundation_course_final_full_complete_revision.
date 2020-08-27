// package March16_2019_LinkedList;

public class LinkedList_3 {
//
	private class Node {
		public int data;
		public Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// not needed in java,constructor or destructor
	// public LinkedList()
	// {
	// head=tail=null;
	// size=0;
	// }

	public void handleAddSize0(int data) {
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

	public int handleRemoveWhenSize1() {
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
			Node nn = head;
			head = head.next;
			size--;
			return nn.data;
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
 
	//idx is from 0 to idx

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

	public void reverseDataIterative() {
		Node nn1 = head;
		Node nn2 = tail;// assignment of adress
		
		int fi = 0;
		int li = size - 1;

		for (; fi < li; nn1 = nn1.next, nn2 = getNodeAt(li)) {
			// cant compare adress
			int temp = nn1.data;
			nn1.data = nn2.data;
			nn2.data = temp;
			
			fi++;
			li--;// for condition required
		}
	}

	public void reversePointerIterative() {
		Node prev = null;
		Node curr = head;
		Node after = head.next;

		while (curr != null) {
			curr.next = prev;
			prev = curr;
			curr = after;
			if (after != null)
				// special case last elemnet being left
				after = after.next;

		}

		Node nn = head;
		head = tail;
		tail = nn;

	}

	public void displayReverseRec() {
		displayRev(head);
	}

	public void displayRev(Node nn) {
		if (nn == tail) {
			System.out.print(nn.data + " ");
			return;
		}
		displayRev(nn.next);
		System.out.print(nn.data + " ");
	}


	private void reversePointerR(Node nn) { // private
		if (nn == tail)
			return;

		reversePointerR(nn.next);
		nn.next.next = nn;

	}

	public void reversePointerRec() {

		reversePointerR(head);

		head.next = null;
		Node temp = head;
		head = tail;
		tail = temp;
	}

	Node rdrLeft; // made with other var like tail,head and size

	 public void ReverseDataR(Node right, int floor) {

	if (right == null)
	 return;
	
	 ReverseDataR(right.next, floor + 1);
	
	 if (floor >= size / 2) {
	 int temp = rdrLeft.data;
	 rdrLeft.data = right.data;
	 right.data = temp;
	 
	 rdrLeft = rdrLeft.next;
	 }
	
	 }
	
	 public void ReverseDataRec() {
	 Node rdrLeft = head;
	 ReverseDataR(head, 0);
	 }

	Node tempLeft; // made with other var like tail,head and size

	private boolean isPalin(Node right) {
		if (right == null) {
			return true;
		}
		
		boolean rr = isPalin(right.next);
		boolean mr = rr == true && 
		tempLeft.data == right.data;
		tempLeft = tempLeft.next;
		return mr;

	}

	public boolean isPalin() {
		tempLeft = head;
		return isPalin(head);

	}

	public void fold(Node right, int floor) {
		// make proper diag to understand
		if (right == null)
			return;

		fold(right.next, floor + 1);

		if (floor > size / 2) {
			Node initNext = tempLeft.next;
			right.next = tempLeft.next;
			tempLeft.next = right;
			tempLeft = initNext;
		} else if (floor == size / 2) {
			tail = right;
			right.next = null;
		}
	}

	public void fold() {
		tempLeft = head;
		fold(head, 0);
	}

	public void unfold(Node t1) {
		Node t2 = t1.next;
		if (t1.next == null || t1.next.next == null) {
			head = t1;
			tail = t2 == null ? t1 : t1.next;
			return;
		}
		unfold(t1.next.next);
		t1.next = head;
		head = t1;
		tail.next = t2;
		tail = t2;
		tail.next = null;
	}

	public void unfold() {
		tempLeft = head;
		unfold(head);
	}

	public void removeDuplicates() {
		LinkedList_3 = new LinkedList_3();

		while (size > 0) {
			int temp = removeFirst();
			// by this pointer on l1 linked list
			if (nl.size == 0 || nl.tail.data != temp) {
				nl.addLast(temp);
			}
		}
		head = nl.head; // this pointer
		tail = nl.head; //
		size = nl.size; //
	}

	public void oddEven() {

	}
	
	public static void main(String[] args) {

		// TODO Auto-generated method stub

		// start seeing from top most func
		LinkedList_3 l1 = new LinkedList_3();
		l1.addLast(10);
		l1.addLast(20);
		l1.addLast(30);
		l1.addLast(50);
		l1.addLast(40);
		l1.display();
		System.out.println("<==========>");
		l1.addFirst(40);
		l1.addFirst(50);
		l1.display();
		System.out.println("<==========>");
		l1.addAt(100, 3);
		l1.display();
		System.out.println("<==========>");
		l1.removeFirst();
		l1.removeFirst();
		l1.display();
		System.out.println("<==========>");
		l1.removeLast();
		l1.display();
		System.out.println("<==========>");
		l1.addLast(200);
		l1.display();
		System.out.println("<==========>");
		l1.getSize();
		l1.removeAt(2);
		l1.display();
		l1.addLast(300);

		System.out.println("<==========>");
		l1.display();
		l1.getFirst();
		System.out.println("<===reverseDataIterative=>");
		l1.reverseDataIterative();
		l1.display();
		System.out.println("<==reversePointerIterative=>");
		l1.reversePointerIterative();
		l1.display();
		System.out.println("<===displayReverseRec=======>");
		// actual value as it is
		l1.displayReverseRec();
		// just for display
		System.out.println();
		System.out.println("<====reversePointerRec======>");
		l1.reversePointerRec();
		l1.display();

		System.out.println("<====reverseDataRec======>");
		 l1.ReverseDataRec();
		System.out.println("<====isPalin======>");
		System.out.println(l1.isPalin());
		System.out.println("<====Fold======>");
		l1.fold();
		l1.addLast(-1);
		l1.display();
		// System.out.println("<====unFold======>");
		// l1.addFirst(20);
		// System.out.println("<====unFold======>");
		// l1.unfold();
		// l1.addFirst(-9);
		// l1.addLast(-7);
		// l1.display();
		l1.addFirst(300);
		l1.addLast(-1);
		System.out.println("<====remDup(forSorted)======>");
		l1.display();
		l1.removeDuplicates();
		l1.display();
		l1.oddEven();
		l1.display();
	}

}
