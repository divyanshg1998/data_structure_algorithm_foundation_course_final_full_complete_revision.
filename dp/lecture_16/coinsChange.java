import java.util.*;

public class coinsChange{
    public static void main(String[] args){

        int[] arr ={ 2, 3, 5, 7};
        coinsChangeDP(arr , 10);
        
    }
    public static void coinsChangeDP( int[] arr, int targ){

        int[] dp = new int[targ + 1];
        
        dp[0] = 1;
        for ( int i = 0; i < arr.length ; i++){
            for( int d = 1; d < dp.length; d++ ){
                int indx = d - arr[i];
            if( indx >= 0){
                dp[d] = dp[d] + dp[indx];
            }
        }

            System.out.print(arr[i]+" : " );
            
            for( int ele : dp){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
        
    }

}
