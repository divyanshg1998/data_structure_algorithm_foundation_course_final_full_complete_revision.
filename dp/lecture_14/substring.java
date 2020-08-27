
class substring{

    static int length1(String str, int i, int j){

        //we have faith that this func will return the max length substring from the indexes given 

        if( i == j){
            return 1;
        }

        if ( i+1 == j){
            if ( str.charAt(i) == str.charAt(j)){
               return 2; 
            }
            else if ( str.charAt(i) != str.charAt(j)){
                return 1;
            }             
        }

        if( str.charAt(i) == str.charAt(j)){
           
            //check if substring
            int lengthSubset =  (j-1) - (i+1)  + 1; 
            
            if( length1(str, i+1, j-1) == lengthSubset){
                        return (lengthSubset + 2);    
            }

            else 
            return Math.max(length1(str,i+1,j),length1(str, i, j-1));
        }

        else{
        
            return (Math.max( length1( str, i+1, j) , length1( str, i, j-1)));
        }                

        // return 0;
    }


    
    static int length(String str){

        int[][] dp = new int[str.length()][str.length()];    
        
        for(int gap = 0 ; gap < dp[0].length; gap++ ){
            for( int i = 0 , j = gap; j < dp[0].length; j++, i++){
                if( gap == 0){
                    dp[i][j] = 1;                        
                }
                else if ( str.charAt(i) == str.charAt(j)){
                    int len = (j-1) - (i+1) + 1;//BRACKETS VERY IMP HERE
                    if( dp[i+1][j-1]  == len){
                          dp[i][j] = dp[i+1][j-1] + 2;
                    }
                   else {
                        dp[i][j] = Math.max( dp[i+1][j], dp[i][j-1]);                    
                        }
                    }
                 else {
                    dp[i][j] = Math.max( dp[i+1][j], dp[i][j-1]);                    
                    }
            }
        }

        for( int arr1[]: dp){
            for( int arr2: arr1){
                System.out.print(arr2 + " ");
            }System.out.println();
        }

        return dp[0][dp[0].length - 1];
}


static String length5(String str){

    String[][] dp = new String[str.length()][str.length()];    
    
    for( int i = 0 ; i < dp.length; i++){
        for( int j = 0; j < dp[0].length; j++ ){
            dp[i][j] = "";
        }
    }
    

    for(int gap = 0 ; gap < dp[0].length; gap++ ){
        for( int i = 0 , j = gap; j < dp[0].length; j++, i++){
            if( gap == 0){
                dp[i][j] = "" + str.charAt(i); //char cant be
                                                //  converted to string 
                                                //  have to give "" to make it string                     
                
                                            }
            
            else if ( str.charAt(i) == str.charAt(j)){
                String str3 = dp[i+1][j-1];
                int len = (j-1) - (i+1) + 1;//BRACKETS VERY IMP HERE
                if( str3.length()  == len){
                      dp[i][j] = str.charAt(i) + dp[i+1][j-1] + str.charAt(i);
                }
            
                else {
                    String str1 = dp[i+1][j];
                    String str2 = dp[i][j-1];
                    if(str1.length() > str2.length()){
                        dp[i][j] = dp[i+1][j];
                    }
                    else {
                         dp[i][j] = dp[i][j-1];                    
                    }
                }
            }

             else {

                String str1 = dp[i+1][j];
                String str2 = dp[i][j-1];
                if(str1.length() > str2.length()){
                
                //test case     afasfsdf     ans: a (the first letter) 
                    dp[i][j] = dp[i+1][j];
                }
                else {
                     dp[i][j] = dp[i][j - 1];                    
                }

            }
        }
    }

    for( String[] arr1: dp){
        for( String arr2: arr1){
            System.out.print(arr2 + "\t ");
        }System.out.println();
    }

    return dp[0][dp[0].length - 1];
}


    public static int countSubSt( String str){


        boolean[][] dp = new boolean[str.length()][str.length()];    
        int count = 0;        
        for(int gap = 0 ; gap < dp[0].length; gap++ ){
            for( int i = 0 , j = gap; j < dp[0].length; j++, i++){
                if( gap == 0){
                    dp[i][j]= true;                     
                    count++;
                      }
                else if ( str.charAt(i) == str.charAt(j)){
                    if( dp[i+1][j-1]  == true){
                          dp[i][j] = true;
                          count++;
                        }
                   else {
                        dp[i][j] = false;                    
                        }
                    }
                 else {
                    dp[i][j] = false;                    
                    }
            }
        }

    return count;
    }


    public static void main( String[] args){
   
        String str1 = "bababa";
        String str2 = "aaa";
        String str3 = "pcbcmp";

        //longSubstringLength
        //memorization
        System.out.println(length1(str1, 0, str1.length() -1 ));
        System.out.println(length1(str3, 0, str3.length() -1 ));

        System.out.println("====================");
        //dp    
        System.out.println(length(str1));
        System.out.println(length(str3));

        //print the longest palindromic SUBSTRING itself  
        //most most imp question
        System.out.println("====================");
        
        System.out.println(length5(str1));
        System.out.println(length5(str3));
        
        //count the no. of palindromic substring
        System.out.println(countSubSt(str2));
        System.out.println(countSubSt(str3));








    }


} 
