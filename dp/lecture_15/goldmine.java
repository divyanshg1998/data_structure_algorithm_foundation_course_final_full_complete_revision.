import java.util.*;
class goldmine{
    public static void main(String[] args){

        // int[][] arr = {{2,1,3,3},
        //                {2,3,1,4},
        //                {2,0,6,4}};
        
        int[][] dp = new int[arr.length][arr[0].length];


        for ( int[] ele : arr){
            for( int ele2 : ele){
                System.out.print(ele2+" ");
            }
            System.out.println();
            }
        

            System.out.println("=================");
        
            //can 
        for( int j = arr[0].length - 1; j >= 0; j--){
            for( int i = 0; i < arr.length ; i ++){
                if( j == arr[0].length - 1 ){
                    dp[i][j] = arr[i][j];
                }
        
                else if( i == 0){
                    dp[i][j] = arr[i][j] + Math.max( dp[i][j+1], dp[i+1][j+1]);
                }

                else if( i == arr.length - 1){
                    dp[i][j] = arr[i][j] + Math.max( dp[i][j+1], dp[i-1][j+1]); 
                }

                else {
                    dp[i][j] = arr[i][j] + 
                                Math.max(dp[i+1][j+1], 
                                Math.max(dp[i][j+1], dp[i-1][j+1]));
                            }                
                        }
                    }

        // can follow the approach 


        //CANT PRINT 2D AS
        // for ( int ele : arr){
        //     System.out.print(ele+" ");
        // }

        for ( int[] ele : dp){
            for( int ele2 : ele){
                System.out.print(ele2+" ");
            }
            System.out.println();
            }
        
// extra ques
// print the gold mine paths
 
goldMine(local);


        }               
    }


    public static void pgmp2(int[][] global, String str, int r, int c){

        if( c == global[0].length){
            System.out.println(str);
            return; 
        }

        //compare all three for even three calls too

        int max= Integer.MIN_VALUE;
   
        for(int i = r-1 ; i <= r+1 && i < global.length; i++){
            // dont forget second condition
            if(global[i][c] > max){
                max=global[i][c];
            }
        } 
    
        for(int i = r-1 ; i <= r+1 && i < global.length; i++){
            // dont forget second condition
            if(global[i][c] == max){
                pgmp2( global, str + global[i][c]+" ", i, c+1);
            }
        }        
}

public static void printGoldMinePath(int[][] global, String str ,int c){

        int max= Integer.MIN_VALUE;
    for(int i=0 ; i < global.length ; i++){
        if( global[i][c] > max){
            max=global[i][c];
        }
    } 

    for(int i=0 ; i < global.length ; i++){
        if(global[i][c] == max){
            pgmp2(global, global[i][c]+" ", i, c+1);
        }
    } 
}