import java.util.*;
class subsequance{
  
    static int length3(String str){
    
        //for count 
        int[][] dp = new int[str.length()][str.length()];
        
        for( int gap = 0; gap < dp[0].length; gap++){
            for(int i = 0 , j = gap + i; j < dp[0].length ; i++, j++){
                if ( gap == 0){
                    dp[i][j] = 1;
                }
    
                else if ( str.charAt(i) == str.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
               
                else {
                    dp [i][j]= Math.max( dp[i+1][j],dp[i][j-1]);
                }
            } 
        }
    
    for( int[] ele: dp){
        for( int ele2: ele){
            System.out.print(ele2 + " ");
        }
        System.out.println();
    }
    
    return dp[0][dp.length - 1];
        
    }
    
        // static int lcss(String str1, String str2){
    
        //     int[][] dp = new int[str1.length()][str2.length()];
    
        //     for( int i = dp.length - 1 ; i>=0 ; i--){
        //         for( int j = dp.length - 1; j>=0; j--){
    
    
        //         }
        //     }
    
    
        // }
    
        static String s ( String str){

            String[][] dp = new String[str.length()][str.length()];

            for( int i = 0; i < dp.length; i++ ){
                for( int j = 0 ; j < dp[0].length; j++){
                    dp[i][j] = "";
                }
            }  

            for( int gap = 0; gap < dp[0].length; gap++ ){
                for( int i = 0, j = gap; j < dp[0].length; i++,j++ ){
                    if( gap == 0){
                        dp[i][j] = str.charAt(i) + "";//error here cant initialise char as string
                    }
                    else if( str.charAt(i) == str.charAt(j)){
                        dp[i][j] = str.charAt(i) + dp[i+1][j-1] + str.charAt(j);
                    }
                    else {
                        if( dp[i+1][j].length() >= dp[i][j-1].length()   ){
                            dp[i][j] = dp[i+1][j];
                        }
                        else{
                            dp[i][j] = dp[i][j-1];
                        }
                    }
                }
            }

            for( String[] str1 : dp){
                for( String str3 : str1){
                    System.out.print(str3+ "\t");
                }
                System.out.println();
            }

            return dp[0][dp[0].length - 1];
        }


    static int count(String str){
    
        //for count 
        int[][] dp = new int[str.length()][str.length()];
        
        for( int gap = 0; gap < dp[0].length; gap++){
            for(int i = 0 , j = gap + i; j < dp[0].length ; i++, j++){
                if ( gap == 0){
                    dp[i][j] = 1;
                }
    
                else if ( str.charAt(i) == str.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
               
                else {
                    dp [i][j]= Math.max( dp[i+1][j],dp[i][j-1]);
                }
            } 
        }
    
    for( int[] ele: dp){
        for( int ele2: ele){
            System.out.print(ele2 + " ");
        }
        System.out.println();
    }
    
    return dp[0][dp.length - 1];
        
    }
    
        
    public static void main(String [] args){


        String str1 = "bababa";
        String str2 = "aaa";
        String str3 = "pcbcap";
      
        // //this func returns the total no of possible palindromic subequance in the string
        System.out.println(length3(str3));
        System.out.println(length3(str1));

        //string
        System.out.println(s(str1));
        System.out.println(s(str3));

        System.out.println(count(str3));
        System.out.println(count(str3));


        // String str4 = "pcbcmp";
        // String str5 = "AcbcmA";
      
        // System.out.println("====================");

        // System.out.println(lcss(str4, str5));





    }

}