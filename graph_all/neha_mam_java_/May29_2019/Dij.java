package May29_2019;
import java.util.*;

public class Dij {
	static class edge {
		int n;
		int wt;

		edge(int n, int wt) {
			this.n = n;
			this.wt = wt;
			}
	}
	
	static void addEdge(ArrayList<ArrayList<edge>> graph2, int v1, int v2, int wt) {
		graph2.get(v1).add(new edge(v2, wt));

		graph2.get(v2).add(new edge(v1, wt));

	}
	
	static class THelper implements Comparable<THelper>{
		int v;
		String psf;
		int dsf;
		
		THelper(int v,String psf, int dsf){
			
		this.v=v;
		this.psf=psf;
		this.dsf=dsf;		
		}

		@Override
		public int compareTo(THelper o) {
			// TODO Auto-generated method stub
			return this.dsf-o.dsf;
		}
		}

	
	static void djiktra (ArrayList<ArrayList<edge>> graph, int src){
		
		PriorityQueue<THelper> queue= new PriorityQueue<>();
		boolean[] visited= new boolean[graph.size()];
		 
		queue.add(new THelper(src, ""+ src, 0));
		
		while(queue.size()>0){
			
			THelper rem= queue.remove();
//			System.out.println(rem.v+" via "+ rem.psf+"@"+ rem.dsf);
			
			if(visited[rem.v]==true)
				continue;
			
			else
			{	
				System.out.println(rem.v+" via "+ rem.psf+"@"+ rem.dsf);
				visited[rem.v]=true;
			
			
			for(int n=0; n<graph.get(rem.v).size(); n++)
			{
				edge ne=graph.get(rem.v).get(n);
				
				if(visited[ne.n]==false){
					queue.add(new THelper(ne.n,rem.psf+ne.n, rem.dsf+ne.wt));
				}
			}			
		}			
	}
		
		
	}	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<edge>> graph2 = new ArrayList<>();

		for (int v = 0; v < 7; v++) {
			graph2.add(new ArrayList<>());
		}

		addEdge(graph2, 0, 1, 10);
		addEdge(graph2, 0, 3, 40);
		addEdge(graph2, 1, 2, 10);
		addEdge(graph2, 2, 3, 10);
		addEdge(graph2, 4, 3, 2);
		addEdge(graph2, 4, 5, 3);
		addEdge(graph2, 4, 6, 8);
		addEdge(graph2, 6, 5, 3);
//		addEdge(graph2, 2, 5, 5);

		djiktra(graph2,0);
		prims(graph2);
		

	}

}
