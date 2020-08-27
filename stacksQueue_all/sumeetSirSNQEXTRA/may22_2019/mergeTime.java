// package may22_2019;

import java.util.Arrays;
import java.util.Stack;

public class mergeTime {

	static class Interval implements Comparable<Interval>
	{
		int start;
		int end;
		
		public Interval (int start, int end){
			this.start=start;
			this.end= end;
			}
		
		public int compareTo(Interval o){
			return this.start-o.start;
		}		
	}
	
	static void overlappingIntervals(int[] starts, int[] ends){
		
		Interval[] intvs= new Interval[starts.length];
		
		for(int i=0; i<starts.length ; i++){
			
			Interval intv =new Interval(starts[i], ends[i]);
			intvs[i]= intv;			
		}
		Arrays.sort(intvs);
		
		Stack<Interval> st= new Stack<>();
		st.push(intvs[0]);
//		System.out.println(intvs[1]);
		
		for(int i=1; i<intvs.length; i++){
			
			if(intvs[i].start < st.peek().end){
				Interval inte=st.peek();
				inte.end=Math.max(intvs[i].end, inte.end);
			}else{
				st.push(intvs[i]);
			}
		}	
		
		while(st.size()>0){
			System.out.println(st.peek().start+"-"+st.peek().end);
			st.pop();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] st={22,17,19,2,6,12,3};
		int[] end={26,20,23,4,9,15,7};

		overlappingIntervals(st, end);
					
	}

}
