import java.util.*;

public class floodFill{

    public static boolean isValid( int[][] arr, int sr, int sc){

        if(sr<0 || sr > arr.length - 1 || sc < 0 || sc > arr.length -1 || 
                        arr[sr][sc] == 1 || arr[sr][sc] == 2)
                        {
                        return false;
                }
                return true;
    }

    static int ctr = 0;
    public static void floodFill( int[][] arr, int sr, int sc, String str){

        if(sr == arr.length-1 && sc == arr.length-1){
        System.out.println((++ctr) + str);
        return;    
        }

        arr[sr][sc] = 2;
        if(isValid(arr, sr-1, sc)){
           floodFill(arr, sr-1, sc, str + "T"); 
        }

        if(isValid(arr, sr, sc-1)){
            floodFill(arr, sr, sc-1, str + "L");
        }

        if(isValid(arr, sr+1, sc)){
            floodFill(arr, sr+1, sc, str + "D");            
        }

        if(isValid(arr, sr, sc+1)){
            floodFill(arr, sr, sc+1, str + "R");
        }
        arr[sr][sc] = 0;

}

static int[][] dir ={ {1,0}, {0,1}, {1,1}};
static String[] name = { "D", "R", "Di" }; 

static int ctr1=0;
static void floodFillVeryEasyMethod(int[][] v, int sr, int sc, String str){

    if(sr == v.length-1 && sc == v[0].length - 1){
        System.out.println((++ctr1)+" "+str);
        return;
    }

    v[sr][sc] = 2;
    
    for( int i = 0 ; i < dir.length ; i++){
        
        int nr = sr + dir[i][0] * 1;
        int nc = sc + dir[i][1] * 1;

        if(isValid(v ,nr, nc)){
                floodFillVeryEasyMethod(v, nr, nc, str + name[i]);
        }
    }
    
    v[sr][sc] = 0;

}

static int ctr2 = 0;
static int floodFillFindHeight(int[][] v, int sr, int sc, String str){

    if(sr == v.length-1 && sc == v[0].length - 1){
        System.out.println((++ctr2)+" "+str);
        return 0;
    }

    v[sr][sc] = 2;
    int MaxHeight = 0;
    for( int i = 0 ; i < dir.length ; i++){
        
        int nr = sr + dir[i][0] * 1;
        int nc = sc + dir[i][1] * 1;

        if(isValid(v ,nr, nc)){
                MaxHeight=Math.max(MaxHeight,floodFillFindHeight(v, nr, nc, str + name[i]));
        }
    }
    
    v[sr][sc] = 0;
    return MaxHeight + 1;
}


static int[][] dir1 ={ {1,0}, {0,1}, {1,1}};
static String[] name1 = { "D", "R", "Di" }; 

static int ctr3=0;
static void floodFillVeryEasyMethod2(int[][] v, int sr, int sc, String str){

    if(sr == v.length-1 && sc == v[0].length - 1){
        System.out.println((++ctr3)+" "+str);
        return;
    }

    v[sr][sc] = 2;
    
    for(int rad = 1; rad < v.length ; rad++)
    for( int i = 1 ; i < dir1.length ; i++){
        
        int nr = sr + dir1[i][0] * rad;
        int nc = sc + dir1[i][1] * rad;

        if(isValid(v ,nr, nc)){
                floodFillVeryEasyMethod2(v, nr, nc, str + name1[i]);
        }
    }
    
    v[sr][sc] = 0;
}




public static void main(String [] args){

String str="";
int[][] v2 = new int[3][3];

floodFillVeryEasyMethod(v2, 0, 0, str);
// floodFillVeryEasyMethod + TO FIND THE HEIGHT OF THE TREE FORMED
// OR TO FIND THE LENGTH OF THE LARGEST STRING WITHOUT USING GLOBAL VARIABLES
// TREE MOST IMP IN CODING

System.out.println("max height string / max tree length:"+floodFillFindHeight( v2, 0, 0, str));


int[][] v =
{
{0, 1, 0, 0, 0, 0, 0, 1},
{0, 1, 0, 1, 1, 1, 0, 1},
{0, 1, 0, 1, 0, 0, 0, 1},
{0, 0, 0, 0, 0, 1, 1, 1},
{0, 1, 0, 1, 0, 0, 0, 0},
{0, 1, 0, 1, 1, 1, 1, 0}, 
{0, 1, 0, 1, 1, 1, 1, 0},
{0, 1, 0, 0, 0, 0, 0, 0}};

//print paths
floodFillVeryEasyMethod2(v, 0, 0, str);

// for(int i=0; i<v.length; i++){
// for (int j=0; j< v[0].length; j++){
//     System.out.print(v[i][j]+" ");
// }
// System.out.println();
// }

System.out.println(ctr);

}

}
