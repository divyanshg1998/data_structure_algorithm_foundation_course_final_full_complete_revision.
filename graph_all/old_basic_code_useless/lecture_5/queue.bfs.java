import java.util.*;

public static queue.bfs{

    static Scanner scn = new Scanner(System.in);
    
    // static int[] graph = new int[10];
    static ArrayList<Edge>[] graph = new ArrayList[7];
    
    static class Edge{

        int nbr; 
        int wt;
    
        Edge(int nbr, int wt){
            this.nbr = nbr;
            this.wt = wt;
        }

        Edge(){

        }
    }

     static void addEdge( int u, int v, int wt){

        Edge e1 = new Edge( v, wt);
        Edge e2 = new Edge( u, wt);

        graph[u].add(e1);
        graph[v].add(e2);        

    }


    static void case1(){

        for(int i=0; i<7 ; i++){
            graph[i] = new ArrayList<Edge>();
        }

        addEdge( 0, 1, 10);
        addEdge( 0, 3, 10);
        addEdge( 1, 2, 10);
        addEdge( 2, 3, 40);
        addEdge( 3, 4, 2);
        addEdge( 4, 5, 2);
        addEdge( 5, 6, 8);
        addEdge( 4, 6, 3);
        
    }

  static void display(){

        for(int i = 0; i < graph.length; i++){
            System.out.print(i + " => " );
            for(int j=0; j < graph[i].size(); j++){
                System.out.print( "(" + graph[i].get(j).nbr + "," + graph[i].get(j).wt + "), ");
            }
            System.out.println();
        }
    }

    class num{
        




    }
    
    static void bfs (LinkedList<Integer> ll){

    ll.addLast()    


    }


    public static void main(String[] args){

    LinkedList<Integer> ll = new LinkedList<>();
    
    bfs(ll);


    }

    static void bfs( LinkedList<Integer> ll){

    while(ll.size() != 0){
        ll.addLast(); 






    }


}