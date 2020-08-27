import java.util.*;

public class fireStorm{

    static class Point{
        int x;
        int y;
        int t;
      } 
    
    static void solve(int[][] arr, int time){

        ArrayDeque<Point> q= new ArrayDeque();

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j]==1){
                    Point p1= new Point();
                    p1.x=i;
                    p1.y=j;
                    p1.t=1;
                    q.addLast(p1);                        
                }
            }
        }

            while(q.size()>0){

                Point rem = q.getFirst();
                q.removeFirst();

                if(rem.t == time+2 ){
                    break;
                }

                if(arr[rem.x][rem.y] < 0){
                   continue;     
                }
                arr[rem.x][rem.y] = -rem.t;
                // we make negative to know we have viisited                 
                
                if(rem.x-1>=0 && arr[rem.x-1][rem.y]==0){
                Point np= new Point();
                np.x=rem.x-1;
                np.y=rem.y;
                np.t = rem.t +1;                      
                q.addLast(np);
               }                

                if(rem.y-1>=0 && arr[rem.x][rem.y-1]==0){
                    Point np= new Point();
                    np.x=rem.x;
                    np.y=rem.y-1;
                    np.t = rem.t +1;
                    q.addLast(np);                      
                  }                
    
                 if(rem.x+1<arr.length && arr[rem.x+1][rem.y]==0){
                    Point np= new Point();
                    np.x=rem.x+1;
                    np.y=rem.y;
                    np.t = rem.t +1;                      
                    q.addLast(np);                      
             }                
                if(rem.y+1 < arr[0].length && arr[rem.x][rem.y+1]==0){
                    Point np= new Point();
                    np.x=rem.x;
                    np.y=rem.y+1;
                    np.t = rem.t +1;       
                    q.addLast(np);               
                    }             
        }

} 
    
      public static void main(String[] args){

        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        al.add(20);
        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(30);
        al2.addAll(al);
        for( int ele : al2){
            System.out.println(ele);
        }

int[][] arr={
{1,2,0,2,0,0,0},
{0,2,0,2,0,1,0},
{0,0,0,2,0,0,0},
{2,2,2,2,2,2,0},
{0,2,1,0,0,0,0},
{0,2,0,0,0,0,0},
{0,2,0,0,0,0,0},
};

solve(arr, 2);

for(int i = 0; i < arr.length; i++){
    for(int j = 0; j < arr[0].length; j++){
        System.out.print(arr[i][j]+"\t");
    }
    System.out.println();
    }
}

}