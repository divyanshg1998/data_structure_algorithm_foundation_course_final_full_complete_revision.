import java.util.*;

public class pq2
{		
		private ArrayList<Integer> al = new ArrayList<>();
		private Comparator<Integer> comptr;	
		
		public pq2(){
			this.comptr = null;
		}
		 
		public pq2(Comparator<Integer> comptr){
			this.comptr = comptr;
		}
		
		private void swap(int i, int j) {
		
			Integer ith = al.get(i);
			Integer jth = al.get(j);
			
			al.set(i, jth);
			al.set(j, ith);
		}
		
		private boolean ishp(int i, int j) //is higher priority
		{		
			Comparable<Integer> ith = (Comparable<Integer>) al.get(i);
			
			Integer jth=  al.get(j);
			
			if(comptr==null)
				
			return ith.compareTo(jth)<0;
			//default arrangement in ascending order in java
			
			{
				return comptr.compare(al.get(i), al.get(j)) > 0;
			}
		}
		
		private void downheapify(int i)   
		{
			int li = 2 * i + 1;
			int ri = 2 * i + 2;
			
			int hpi =i;//high prio ind
			
					if( li < al.size() && 
							ishp(li,hpi) == true)
					{//if hpi has higher priority over li i.e it is bigger than li
						
						hpi=li;
					}
				
					if( ri<al.size() && ishp(ri,hpi)== true) {
						
						hpi=ri;
					}
		
					if(hpi != i) {
				swap(hpi,i);	
				downheapify(hpi);//hpi here not i	
					}		
		}
	
		public pq2(Integer[] arr){
			this.comptr=null;
			
			for(int i=0; i<arr.length ; i++) {
				al.add(arr[i]);
			}
			
			
			for(int i=arr.length-1; i>=0; i++) {
				downheapify(i);		
			}
			
			
		}
		
		
		public pq2(boolean var){
//			this.type=var; //this needed here
		}
		
		private void upheapify(int i)   
		{
			int pi = (i -1)/2;
					
			int hpi = i;//high prio ind

			//we are comparing three times here
			// to find the min
					if(pi>=0 && ishp(hpi,pi))
					{
						hpi=pi;
					}
				
					if(hpi != i) {
				swap(hpi,i);	
				upheapify(hpi);	
					}		
		}

		
		public void add1(T val) {
			
			al.add(val);
			upheapify(al.size()-1);
		}
		
		public void remove1() {
			
			swap(0,al.size()-1);
			al.remove(al.size()-1);
			downheapify(0);
			
		}
		
		public Integer peek1() {
			
			return al.get(0);
		}
		
		public int size() {
			
			return al.size();
		}

	 static class student implements Comparable<student>{
			 String str;
			 Integer li;
			 Integer val;
			 
			 student(String str , Integer li, Integer val){
				 this.str=str;
				 this.li=li;
				 this.val=val;
			 }
			 
			@Override
			public int compareTo(student o) {
				// TODO Auto-generated method stub
				return this.val - o.val;
			}
			
			public void display() {
				
				System.out.println("["+str+","+li+","+val+"]");
				
			}
		 }
	 
	 static class valComparator implements Comparator<student>
	 {
		public int compare(student s1, student s2) { 
			
		return s1.val-s2.val;	
			
		}
	 }

		
		static class valLIComparator implements Comparator<student>
		 {
			public int compare(student s1, student s2) { 
				
				if(s1.val!= s2.val) {
					return s1.val-s2.val;	
				}
				
				else  {
					return s1.li-s2.li;
				}	
			}		 
	 }
		 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//sorted according to string
		
		pq2<student> p = new pq2<>( new valComparator() ) ;
		
//		pq2<student> p = new pq2<>( Collections.reverseOrder(new valComparator()) ) ;
		
		p.add1(new student("A" , 8 , 5 ));
		p.add1(new student("C" , 7 , 8));
		p.add1(new student("B" , 10 , 6 ));
		p.add1(new student("E" , 8 , 4 ));
		p.add1(new student("F" , 10 , 4 ));
		
		while(p.size()>0)
		{
			student val=p.peek1();			
			val.display();
			p.remove1();			
		}
		System.out.println("");

		PriorityQueue<student> p1 = new PriorityQueue<>( new valComparator()) ;
													// Collections.reverseOrder()
		
//		pq2<student> p = new pq2<>( Collections.reverseOrder(new valComparator()) ) ;
		
		p1.add(new student("A" , 8 , 5 ));
		p1.add(new student("C" , 7 , 8));
		p1.add(new student("B" , 10 , 6 ));
		p1.add(new student("E" , 8 , 4 ));
		p1.add(new student("F" , 10 , 4 ));
		
		while(p1.size()>0)
		{
			student val=p1.peek();			
			val.display();
			p1.remove();			
		}
		System.out.println("");
		
		System.out.println();
//		pq2<student> p2 = new pq2<>( new valLIComparator() ) ;
		
		pq2<student> p2 = new pq2<>( Collections.reverseOrder(new valComparator()) ) ;
									// Collections.reverseOrder()
		p2.add1(new student("A" , 8 , 5 ));
		p2.add1(new student("C" , 7 , 8));
		p2.add1(new student("B" , 10 , 6 ));
		p2.add1(new student("E" , 8 , 4 ));
		p2.add1(new student("F" , 10 , 4 ));
		
		
		while(p2.size()>0)
		{
			student val=p2.peek1();			
			val.display();
			p2.remove1();				
		}
		
		
		Integer [] arr= {10,30,50,40};
		pq2<Integer> p3 = new pq2<>(arr) ;

		while(p3.size()>0) {
			inInteger val = p3.peek1();
			p3.remove1();
			
			System.out.println(val);
			
		}
	
	}
}

