import java.util.*;

public class knightsTour{
    static int ctr=0;
    static void nKnights(int[][] arr, int r , int c, int move){
    
        // rective approach inplace of proactive

        
        if(r<0 || c<0 || r>=arr.length || c>=arr[0].length
                            || arr[r][c]!=0){
                                  
                return;
                            }     
        
        //special case
    // normally a base case is made like 
    // if(move==arr.length* arr[0].length+1)
    // bcz all the 25 case included before It
    // but , for reactive , in the base case 
    // we have to take and untake the option

    if(move==arr.length* arr[0].length){

            System.out.println("******"+ ++ctr +"*******");
            for(int i=0 ; i < arr.length; i++){
                for(int j=0; j<arr[0].length; j++){
                    System.out.print(arr[i][j]+"\t ");
                }
                System.out.println()
            ; }
            System.out.println("******"+ ctr +"*******");
            
                return;
        }
        
        arr[r][c]=move;
        nKnights(arr, r-2, c-1, move+1);
        nKnights(arr, r-2, c+1, move+1);

        nKnights(arr, r-1, c-2, move+1);
        nKnights(arr, r+1, c-2, move+1);
        
        nKnights(arr, r-1, c+2, move+1);
        nKnights(arr, r+1, c+2, move+1);

        nKnights(arr, r+2, c-1, move+1);
        nKnights(arr, r+2, c+1, move+1);
        
        //silly 
        //untake the option
        // debug the problem if not working , for such
        arr[r][c]=0;
    }

    public static void main(String[] args){

        // in a chess board of 5*5 a knight is placed at 1,3 
        // now find all the ways by which 5*5 knight can be placed in the chess 
        // board  
         nKnights(new int[5][5], 1, 3, 1);
        
    }

} 