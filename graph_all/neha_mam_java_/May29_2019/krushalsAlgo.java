package May29_2019;

import java.util.ArrayList;
import java.util.PriorityQueue;

import May29_2019.Dij.THelper;
import May29_2019.Dij.edge;

public class krushalsAlgo {

	static class KEdge  implements Comparable<KEdge>{
		int u;
		int v;
		int wt;
		
		KEdge(int u, int v, int wt){
			this.u=u;
			this.v=v;
			this.wt=wt;
			}
		public int compareTo(KEdge o) {
				// TODO Auto-generated method stub
				return this.wt-o.wt;
	}
}

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

	
public static ArrayList<ArrayList<Edge>> krushal(ArrayList<ArrayList<edge>> graph)  	
{
	int[] pa= new int[graph.size()];
	int[] ra= new int[graph.size()];
	for(int i=0; i<graph.size(); i++){
		pa[i]=i;		
		ra[i]=1;
	}
	
	ArrayList<ArrayList<Edge>> mst= new ArrayList<>();

	PriorityQueue<KEdge> pq=new PriorityQueue();
	
	for(int i=0;i<graph.size();i++){
		
		for(int j=0; j<graph.get(i).size(); j++){
			
			KEdge k= new KEdge(i,graph.get(i).get(j).n, graph.get(i).get(j).wt);
			
			if(i<graph.get(i).get(j).n){
				pq.add(k);
			}
		}
	}
	
	while(pq.size!=0){
		KEdge k= pq.remove();
		int u=k.u;
		int v=k.v;
		int us1= finds1(pa,u);
		int vs1=finds1(pa,v);
		
		if(us1!=vs1){
			
			addEdge(mst,u,vv,k.wt);
			merge(parray,rarray,us1,vs1);
		}
		
	}
	return mst;
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

		krushal(graph2);
	}

}
