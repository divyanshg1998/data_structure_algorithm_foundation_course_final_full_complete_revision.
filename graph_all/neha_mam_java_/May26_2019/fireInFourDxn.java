package May26_2019;

import java.util.ArrayList;
import java.util.LinkedList;


public class fireInFourDxn {

	static void FireInFourDxn (in[][] arr){
		
		LinkedList<THelper> queue= new LinkedList<>();
		boolean[] visited= new boolean[graph.size()];
		 
		queue.add(new THelper(src, ""+ src, 0));
		
		while(queue.size()>0){
			
			THelper rem= queue.getFirst();
			queue.removeFirst();
			System.out.println(rem.v+" via "+ rem.psf+"@"+ rem.dsf);
			
			if(visited[rem.v]==true)
				continue;
			
			else
				visited[rem.v]=true;
			
			if(rem.v==des){
				return true;
			}
			
			for(int n=0; n<graph.get(rem.v).size(); n++)
			{
				edge ne=graph.get(rem.v).get(n);
				
				if(visited[ne.n]==false){
					queue.add(new THelper(ne.n,rem.psf+ne.n, rem.dsf+ne.wt));
				}
			}
			
		}
		return false;
		
	}

	public static void main(String[] args) {
		
		int[][] arr={
				{0,1,1,1,1,0},
				{0,1,0,0,1,0},
				{0,0,0,1,0,2},
				{0,1,0,1,0,1},
				{2,0,1,1,0,0}};
		
		
		FireInFourDxn(arr);
		
	}

}
