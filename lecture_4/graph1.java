import java.util.*;
public class graph1{

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
 
 
        // graph[u].add(new Edge( v, wt));
        // graph[v].add(new Edge( u, wt));
        
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

    static boolean hasPath( int src, int des, boolean[] visit){

        if( src == des){
            return true;
             }

        visit[src] = true;
        
        boolean res = false;

        for(int i = 0 ; i < graph[src].size() ; i++)
        {
            int v = graph[src].get(i).nbr;
            if(visit[v] == false)
            res =  res || hasPath( v, des, visit);
        }

        return res;
    }

    static void allPath( int src, int des, boolean[] visit, String str){

        if(src == des){
            System.out.println(str+ des);
            return;
        }

        //node pre
        visit[src] = true;
        
        for( int i=0; i< graph[src].size(); i++){
            int v = graph[src].get(i).nbr;
            if( ! visit[v] )
            {
                allPath(v, des, visit, str + src);
            }

        }
        visit[src] = false;

    }

    static void treeOfGraph(int src, String str, boolean[] visited){

        System.out.println(src + " => " + str);
      
        visited[src] = true;

        for( int i = 0; i < graph[src].size(); i++){

            int v = graph[src].get(i).nbr;
            if(!visited[v]){

                treeOfGraph( v, str + v, visited);
            }
        }

        visited[src] = false;
    }


    static void treeOfGraphPost(int src, String str, boolean[] visited){

        visited[src] = true;

        for( int i = 0; i < graph[src].size(); i++){

            int v = graph[src].get(i).nbr;
            if(!visited[v]){

                treeOfGraphPost( v, str + v, visited);
            }
        }

        visited[src] = false;
        System.out.println(src + " => " + str);
    }
    
    static class value{
        int wt = 0;
        String psf = "" ;

        value(int wt, String psf){
            this.wt = wt;
            this.psf = psf;
          }
          value(){}
    }

    static PriorityQueue<value> pq = new PriorityQueue<value>(5, new valueComparator());

           static class valueComparator implements Comparator<value>{ 

            // Overriding compare()method of Comparator  
            // for descending order of cgpa 
            public int compare(value s1, value s2) { 
            if (s1.wt < s2.wt) 
            return 1; 
            else if (s1.wt > s2.wt) 
            return -1; 
                    return 0; 
            } 
            } 

    
    static int heavy = Integer.MIN_VALUE;
    static int light = Integer.MAX_VALUE;
    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;
    static int value = 30;

    //c++
    //  int m = INT_MAX;

    static void allpathWeight( int src, int des, boolean[] visit, String str, int wt){

        if(src == des){
            
            System.out.println(str + " @" + wt);
            if(wt > heavy){
                heavy = wt;
            } 
            if(wt < light){
                light = wt;
            } 
            if( wt < value && wt > floor ){
                floor = wt;
                
                }

            if( wt > value  &&  wt < ceil ){
                ceil = wt;
            } 
    
            //kth largest
            value v1 = new value(wt, str);    
            pq.add(v1);

            return;
        }

        //node pre
        visit[src] = true;
        
        for( int i=0; i< graph[src].size(); i++){
            int v = graph[src].get(i).nbr;
            int mwt = graph[src].get(i).wt;

            if( ! visit[v] )
            {
                allpathWeight(v, des, visit, str + v, wt + mwt);
            }

        }
        visit[src] = false;

    }

    static void hamiltonian( int src, int origSrc, int count, boolean[] visit, String str){

    if(count == visit.length){
            System.out.print(str + src);
        
            for( Edge E: graph[src]){
                if( E.nbr == origSrc){
                    System.out.print("*");
                    break;
                }
            }
            System.out.println();            
            return ;
    }
    
        //node pre
        visit[src] = true;
        
        for( Edge e : graph[src]){
            int v = e.nbr;
            if( ! visit[v] )
            {
                hamiltonian(v, origSrc, count+1 , visit, str + src);
            }
        }

        visit[src] = false;
    }

    
    
    public static void main(String[] args){
        
        case1();
        display();

        // case2();

        System.out.println(hasPath(0, 6 , new boolean[7]));
        allPath(0, 6 , new boolean[7],"");


        System.out.println("PRE-ORDER:");
        treeOfGraph(0,"0", new boolean[7]);

        
        System.out.println("POST-ORDER");           
        treeOfGraphPost(0, "0", new boolean[7] );

        allpathWeight(0, 6 , new boolean[7], "0", 0);

        System.out.println("heaviest & lightest & kth largest path:"+ heavy +"\t" + light);      
        System.out.println("seal & floor:"+ ceil +"\t" + floor);      
        
        System.out.println("=====hamiltonian cycle=============");
        hamiltonian( 0, 0 ,1, new boolean[7], "");
        
        addEdge( 2, 5, 10);
        
        System.out.println("=====hamiltonian cycle=============");
        hamiltonian( 0, 0 ,1, new boolean[7], "");
        
        // hamiltonianCycle( 0, 1, new boolean[7], "");
        
        //kth largest where k = 3 (for all possible path)
        System.out.println("============");
        int k=3;
        for( int i = 0; i < k  ; i++ ){
            value v2 = pq.remove();
            System.out.println(v2.wt + "@" + v2.psf);
          }
        
        


       



        //java c++
        // int i = Math.max(1,2);
        // System.out.println(i);      
        
        //c++     int i = max(1,2);
    


        
    }

}