package lecture4;
import java.util.LinkedList;
//import java.utll.*;

public class hm2<k,v> {

	class HMNode{
			k key;
			v value;
			
			HMNode(k key, v value){
				this.key = key;
				this.value = value;
			}		
		}
	
	LinkedList<HMNode>[] buckets;
	int n;
	int N;
	
	hm2(){
		N=4;
		buckets = new LinkedList[N];
		for(int i=0;i<buckets.length; i++){
			buckets[i] = new LinkedList<>();
		}
		n=0;
		}
	
	
		public void put(k key,v value){
			int bi=getBucketIndex(key);
			int di=getDataIndex(bi,key);
			
			
			if(di==-1) {
				 HMNode Node= new HMNode(key,value);
				 buckets[bi].addLast(Node);
					n++;
					}
			else {
				buckets[bi].get(di).value=value;
			
			}
			
		
			
			double lambda = n* 1.0/N;
			
			if(lambda > 2.0){
				
				rehash();
				
			}
			
	}
	
	public boolean containKey(k key){
		int bi = getBucketIndex(key);
		int di = getDataIndex(bi,key);
		if(di == -1){
			return false;
		}else{
			return true;
		}
	}
	
	public v get(k key){
		int bi = getBucketIndex(key);
		int di = getDataIndex(bi,key);
		HMNode n2r = null;;
		if(di == -1){
			return null;
		}else{
			n2r = buckets[bi].get(di);
		}
		return n2r.value;
	}
	
	private int getDataIndex(int bi, k key) {
		
		int counter = 0;
		for(HMNode node: buckets[bi]){
		
			if(node.key.equals(key)){  //for string
			return counter;
		}
		counter++;
		}
		return -1;
	}

	private void rehash() {
		 
		LinkedList<HMNode>[] old= buckets;
		N=2*N;
		System.out.println(N);
		//just like constructor
		
		buckets= new LinkedList[N];
		
		
		for(int i=0 ; i<N ; i++) {
			buckets[i]=new LinkedList<>();
		}
		
		n=0;
		for(int bi=0 ; bi< old.length ; bi++) {
			
			for(int di=0 ; di < old[bi].size() ; di++) {
				
				HMNode node=old[bi].get(di);
				
				put(node.key,node.value);
				
			}
		}
			
	}
	
	private int getBucketIndex(k key) 
	{
		int hc = key.hashCode();
		hc = Math.abs(hc);
		return hc%N;
	}

	public int size() {
		return buckets.length;
	}
	
	public v remove(k key) {
		
		int bi = getBucketIndex(key);
		int di = getDataIndex(bi,key);
		HMNode n2r = null;
		if(di == -1){
			return null;
		}
		else{
			n2r = buckets[bi].remove(di);
			n--;
			
			}
		return n2r.value;
	}
	
	public void display() {
		
		for(int bi=0 ; bi< buckets.length ; bi++) {
				System.out.print(bi + "=" );
				for(int di=0 ; di<buckets[bi].size() ; di++) {
				
					System.out.print("["+di+". "+ buckets[bi].get(di).key +"]");
				}		
				System.out.println();
		}
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		hm2 <String,Integer> map= new hm2<>();
		
		map.put("I",10);
		map.put("C",20);
		map.put("L",30);
		
		System.out.println(map.containKey("I"));
		System.out.println(map.containKey("D"));
		
		System.out.println(map.get("L"));
		System.out.println(map.get("D"));
		
		map.put("H",50);
		map.put("L",70);
		map.put("Q",40);
		map.put("A",250);
		map.put("Y",409);
		
		map.display();
		map.put("F",82);
		
		System.out.println();
		
//		now lambda is 7/4;
		
		
		map.put("v",400);
		map.put("r",23);
		map.put("G",43);
		map.put("h",65);
		
		
		map.display();
		
		
		System.out.println(map.remove("I"));
		System.out.println(map.remove("H"));    //H
		
//		System.out.println(x);
//		
//		map.display();
		
		
		
		
		
		
		
	}

}
