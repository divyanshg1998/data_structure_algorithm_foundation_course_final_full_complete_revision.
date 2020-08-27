import java.util.*;

public class solution{

    static int coin(int[] arr, int targ, int idx, String str){

        if(targ == 0){
            System.out.println(str);
            return 1;
        }

        if( targ < 0){
            return 0;
        }

        int count = 0;
        for( int i = idx  ; i < arr.length ; i++){
        
        count += coin(arr, targ - arr[i], i, str + arr[i]);
    
    }
    
    return count;

    }

    static int coinp(int[] arr, int targ,  String str){

        if(targ == 0){
            System.out.println(str);
            return 1;
        }

        if( targ < 0){
            return 0;
        }

        int count = 0;
        for( int i = 0  ; i < arr.length ; i++){
        
            count += coinp(arr, targ - arr[i], str + arr[i]);
        
        }
    
        return count;
    }
    

    static int coinUnique(int[] arr, int targ, int idx, String str){

        if(targ == 0){
            System.out.println(str);
            return 1;
        }

        if( targ < 0){
            return 0;
        }

        int count = 0;
        for( int i = idx  ; i < arr.length ; i++){
        
        count += coinUnique(arr, targ - arr[i], i+1, str + arr[i]);
    
    }
    
    return count;

    }

    static int coinunique2(int[] arr, int targ, String str, boolean[] tru){

        if(targ == 0){
            System.out.println(str);
            return 1;
        }

        if( targ < 0){
            return 0;
        }

        int count = 0;
        for( int i = 0  ; i < arr.length ; i++){
        
        if( !tru[i] )
        { 
            tru[i] = true;
            count += coinunique2(arr, targ - arr[i], str + arr[i], tru);
            tru[i] = false;
        }
    }
    
    return count;

    }

    static int b( int[] arr, int targ, int indx , String str){

     if( indx == arr.length || targ <= 0 ){
         if( targ == 0 ){
            System.out.println(str);
            return 1;
         }   
         return 0;
     }   
     int count = 0 ;

     count+=b( arr, targ - arr[indx], indx , str + arr[indx]);
     
     count+=b( arr, targ , indx + 1, str );

     return count;
    }

    static int b2( int[] arr, int targ, int indx , String str, boolean[] tru) {

        if( indx == arr.length || targ <= 0 ){
            if( targ == 0 ){
               System.out.println(str);
               return 1;
            }   
            return 0;
        }   
        int count = 0 ;
   

        if( tru[indx] == false){
        tru[indx] = true;
        count+=b2( arr, targ - arr[indx], 0, str + arr[indx], tru);
        tru[indx] = false;
        }


        count+=b2( arr, targ , indx + 1 , str, tru );
   

        return count;
       }


    static int b3( int[] arr, int targ, int indx , String str){

        if( indx == arr.length || targ <= 0 ){
            if( targ == 0 ){
               System.out.println(str);
               return 1;
            }   
            return 0;
        }   
        int count = 0 ;
   
        count+=b3( arr, targ - arr[indx], indx + 1, str + arr[indx]);
        
        count+=b3( arr, targ, indx + 1, str );
   
        return count;
       }
   

    static int b4( int[] arr, int targ, int indx , String str, boolean[] tru) {

        if( indx == arr.length || targ <= 0 ){
            if( targ == 0 ){
               System.out.println(str);
               return 1;
            }   
            return 0;
        }   

        int count = 0 ;
   

        if( tru[indx] == false){
        
        tru[indx] = true;
        count += b4( arr, targ - arr[indx], 0, str + arr[indx], tru);
        tru[indx] = false;
        }
        
        count += b4( arr, targ , indx + 1, str, tru );
   
        return count;
       }



       public static void main(String[] args){

        int[] arr = {2, 3, 5, 7};
        
        System.out.println(coin(arr, 10, 0, ""));   // combination
        
        System.out.println( coinp(arr, 10, ""));    //perm
        
        System.out.println(coinUnique(arr, 10, 0, ""));   

        System.out.println(coinunique2(arr, 10, "", new boolean[4])); //perm
        
        
        System.out.println(b(arr, 10, 0,""));

        System.out.println(b2(arr, 10, 0,"", new boolean[4]));

        System.out.println(b3(arr, 10, 0,""));

        System.out.println(b4(arr, 10, 0, "", new boolean[4]));

                         
        

        }



}