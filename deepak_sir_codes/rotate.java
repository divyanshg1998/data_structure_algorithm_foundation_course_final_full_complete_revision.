import java.util.*;
class rotate{
    public static void main(String[] args){
     
        // ques , given an array , find the max sum possible if
        //  we rotate the array towards left each time,
        // if sum = sum(i * arr[i])

        int[] arr = {3, 2, 8, 1};

        System.out.println(val( arr));

    }
    static int val ( int[] arr){

        int sum = 0 ;
        int rmo = 0;
       for ( int i = 0; i < arr.length; i++ ){
            sum += arr[i];
            rmo += arr[i] * i;  //row minus1
        }

        int mymax = rmo;

        System.out.println(mymax);

        for( int i = 0; i <= arr.length - 2; i++){
            int rpo = rmo - sum + 4 * arr[i];   //row plus 1             
               rmo = rpo;
            System.out.println(rpo);
            mymax = Math.max (mymax, rpo);
        }

        return mymax;
        }
}