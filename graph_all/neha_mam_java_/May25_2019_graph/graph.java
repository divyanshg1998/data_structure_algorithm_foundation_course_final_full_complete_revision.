
import java.util.*;

 class graph {
	// samsung ques
	// rat loo, subtle mistake , almost always
	static class edge {
		int n;
		int wt;

		edge(int n, int wt) {
			this.n = n;
			this.wt = wt;
		}
	}
	
	static class THelper{
		int v;
		String psf;
		int dsf;
		
		THelper(int v,String psf, int dsf){
			
		this.v=v;
		this.psf=psf;
		this.dsf=dsf;		
		}
		}

	static boolean bsf (ArrayList<ArrayList<edge>> graph, int src, int des){
		
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
	static class FHelper{
		int i;
		int j;
		int t;
		
		public FHelper(int i, int j, int t)
		{
			this.i=i;
			this.j=j;
			this.t=t;
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

		display(graph2);
		System.out.println(hasPath(graph2, 0, 6, new boolean[7]));
		System.out.println("all Path Exclusive");
		allPathExclusive(graph2, 0, 6, new boolean[7], "");
		System.out.println("all Path Inclusive");
		allPathInclusive(graph2, 0, 6, new boolean[7], "0", 0, 41);
		System.out.println("Smallest:" + spd + ":" + sp);
		System.out.println("Largest:" + lpd + ":" + lp);
		System.out.println("Factor:"+"41");
		System.out.println("ceil:" + ceilnum +	":"+ceilString);
		System.out.println("floor" + floornum+":"+ floornum);
		System.out.println("print kth larges  t:");
		System.out.println(bsf(graph2,0,6));
		
		int[][] arr={
				{-2,-2,0,-2,-2,-2},
				{-2,-1,-1,-2,-1,-1},
				{-2,-2,-1,-2,-2,-2},
				{-2,-2,-2,-2,-1,-1},
				{-2,-1,-1,0,-2,-2}};
		
		
		FireInFourDxn(arr);
		ArrayList<String> Ans=new ArrayList<>();
		Ans=getConnenctedComponentS(graph2);
		for(String val: Ans){
			System.out.println(val);
		}
		
		}
	
	static boolean isNeed(int[][] arr, int i, int j){
		if(i<0 || i>arr.length-1 || j<0 || j>arr[0].length-1){
			return false;
		}
		
		if(arr[i][j]==-1)
			return false;
		
		if(arr[i][j]>=0)
					return false;
		return true;
		
		
	}
	
	static String getConnenctedComponent(ArrayList<ArrayList<edge>> graph, boolean[] 
			visited, int src){
		
		LinkedList<Integer> queue=new LinkedList<>();
		queue.add(src);
		
		String comp="";
		
		while(queue.size()>0){
			
			int rem=queue.removeFirst();
			
			if(visited[rem] == true)
				continue;
			
			else 
				visited[rem]= true;
			
			comp += rem;
			
			for(int n=0; n< graph.get(n).size(); n++){
				
				edge ne=graph.get(rem).get(n);
				if(visited[ne.n] == false){
					
					queue.add(ne.n);
				}
				
			}
		}
		
		return comp;
		
	}
	
	static ArrayList<String> getConnenctedComponentS(ArrayList<ArrayList<edge>> graph){

		ArrayList<String> comps=new ArrayList<>();
		boolean[] visited=new boolean[graph.size()];
		
		for(int i=0; i<graph.size(); i++){
			
			if(visited[i]==false){
				
				String comp=getConnenctedComponent(graph,visited, i);
				comps.add(comp);
			}
			
		}
		return comps;		
	}
	
	
	static void FireInFourDxn(int[][] arr){

		LinkedList<FHelper> queue= new LinkedList<>();
		
		for(int i=0; i<arr.length; i++){
			for (int j=0; j<arr[0].length; j++){
				if(arr[i][j]==0)
				queue.add(new FHelper(i,j,0));
			}
		}
		while(queue.size()>0  ){
		
			FHelper element= queue.removeFirst();
			
			int ii=element.i;
			int j=element.j;
			int t=element.t;
			
			
			if(arr[ii][j]>0){
				continue;
			}
			else
			{
				arr[ii][j]=t;
			}

			System.out.println(ii+":"+j+" :AT TIME:" +t);

			if(isNeed(arr,ii-1,j))
				queue.add(new FHelper(ii-1,j,t+1));
			if(isNeed(arr, ii,j+1))
				queue.add(new FHelper(ii,j+1,t+1));
			if(isNeed(arr, ii+1,j))
				queue.add(new FHelper(ii+1,j,t+1));
			if(isNeed(arr, ii,j-1))
				queue.add(new FHelper(ii,j-1,t+1));
		}
		
		}	
		
	static void addEdge(ArrayList<ArrayList<edge>> graph2, int v1, int v2, int wt) {
		graph2.get(v1).add(new edge(v2, wt));

		graph2.get(v2).add(new edge(v1, wt));

	}

	static void display(ArrayList<ArrayList<edge>> graph2) {
		for (int i = 0; i < graph2.size(); i++) {
			System.out.println(i + "->" + " ");

			for (int n = 0; n < graph2.get(i).size(); n++) {
				System.out.print("{" + graph2.get(i).get(n).n + "@" + graph2.get(i).get(n).wt + "} ");
			}
			System.out.println();
		}
	}

	static boolean hasPath(ArrayList<ArrayList<edge>> graph2, int src, int des, boolean[] visited) {
		//imp samsung
		if (src == des) {
			return true;
		}//node pre

		visited[src] = true;
		//node pre
		for (int i = 0; i < graph2.get(src).size(); i++) {

			int nn = graph2.get(src).get(i).n;
			if (visited[nn] == false)
				if (hasPath(graph2, nn, des, visited) == true)
					return true;
		}
		//node post
		return false;

	}

	static void allPathExclusive(ArrayList<ArrayList<edge>> graph2, int src, int dsn, boolean[] visited, String str) {

		//rat loo
		if (src == dsn) {
			System.out.println(str + dsn);
			return;
		}//n pre

		visited[src] = true;//n pre

		for (int i = 0; i < graph2.get(src).size(); i++) {

			int nn = graph2.get(src).get(i).n;
			//e pre
			if (visited[nn] == false) {
				allPathExclusive(graph2, nn, dsn, visited, str + src);
			}
		}
		visited[src] = false;//n post
	}

	static int spd = Integer.MAX_VALUE;//smallest path dist
	static String sp = "";

	static int lpd = Integer.MIN_VALUE;
	static String lp = "";

	static String ceilString = "";
	static int ceilnum = Integer.MAX_VALUE;

	static String floorString = "";
	static int floornum = Integer.MIN_VALUE;

	
	
	static void allPathInclusive(ArrayList<ArrayList<edge>> graph2, int src, int dsn, boolean[] visited, String str,
			int dsf, int factor) {

		if (src == dsn) {
			System.out.println(dsf+":"+str + dsn);
			//conditions
			
			if (dsf < spd) {
				sp = str;
				spd=dsf;
			}

			if (lpd < dsf) {
				lp = str;
				lpd=dsf;
			}

			if (ceilnum > dsf && factor < dsf) {
				ceilnum = dsf;
				ceilString = str;
			}

			if (floornum < dsf && dsf < factor) {
				floornum = dsf;
				floorString = str;
			}

		return;
		}

		for (int i = 0; i < graph2.get(src).size(); i++) {

			int nn = graph2.get(src).get(i).n;
			int wt=graph2.get(src).get(i).wt;
			if (visited[nn] == false) {
				visited[src] = true;
				allPathInclusive(graph2, nn, dsn, visited, str + nn, dsf + wt, factor);
				visited[src] = false;
			}
		}
	}

}





