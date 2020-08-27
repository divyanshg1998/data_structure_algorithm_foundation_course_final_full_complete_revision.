import java.util.*;
public class dice{

    public static class edge {
		int nbr;
		int ctr;

		edge(int nbr, int ctr) {
			this.nbr = nbr;
			this.ctr = ctr;
		}
    }
    
    static ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
    public static void addEdge(int v1, int v2){

        graph2.get(v1).add(v2);

    }

    public static void display(){
        
        for(int i=0; i < graph2.size() ; i++){
            System.out.print((i+"->"));
            for( int j=0 ; j < graph2.get(i).size() ; j++){
                System.out.print("["+ graph2.get(i).get(j) + "]");
            }
            System.out.println("." );
        }
    }

    public static void mdr(){

    int[] vis= new int[30];
    LinkedList<edge> q = new LinkedList<>();
    edge r = new edge( 0, 0 );
    q.addLast(r);

        // max and main
        // java int steps=Integer.MAX_VALUE;
        // C++  int steps=INT_MAX;
    
    while(q.size()>0){
        
        edge rem = q.getFirst();
        q.removeFirst();

        if( vis[rem.nbr] != 0 ){
            if( rem.ctr < vis[rem.nbr] || rem.nbr == 0 ){

            }
            else
            continue;
        }
        vis[rem.ctr] = rem.ctr;

        // if(rem.nbr == 29 ){
        //     steps=Math.min(steps, rem.dist);
        // }

        for(int i=0 ; i<graph2.get(rem.nbr).size(); i++ ){
            int num = graph2.get(rem.nbr).get(i);
            edge ne=new edge(num, rem.ctr+1);
            q.addLast(ne);
            continue;
        }
        
        for(int n = rem.nbr+1 ; n <= rem.nbr+6 && n<30; n++){
            edge ne=new edge(n, rem.ctr + 1);
            q.addLast(ne);
        }
    }

    System.out.println(vis[29]);

}
    

    public static void main(String[] args){

 
		for (int v = 0; v < 30; v++) {
			graph2.add(new ArrayList<>());
		}

        addEdge(2, 27);
        addEdge(7, 14 );

        addEdge(23,4);
        addEdge(28,5);

        // System.out.println(graph2.get(3).size());
		display();
        mdr();
        
    }
}