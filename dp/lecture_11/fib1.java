import java.util.*;

public class fib1{

    static int fib( int n){

        if( n<=1){
            return n;
        }

        return (fib(n-1) + fib( n-2));

    }

    static int fibDP( int n, int[] arr){

        if( n<=1){
            return n;
        }

        if( arr[n] != 0){
            return arr[n];
        }

        int num = fibDP( n-1, arr) + fibDP( n-2, arr);
        arr[n] = num;

        return num;

    }

    static int fibDP2( int n){

        //can imagine as an 1 D array
        int a = 0;
        int b = 1;
        int c = 0;

        for( int i = 2; i <= n ; i++){
            c = a+b;
            a = b;
            b = c;
        }

        return c;
    }

    public static void main(String[] args){

        System.out.println(fib(6));

        int[] arr = new int[7];
        System.out.println(fibDP(6, arr));

        System.out.println(fibDP2(6));

        //FOR TRAVERSING ARRAY. CANT USE AUTO IN JAVA
        int[] arr3 = {1,2};
        for( int itr : arr3){       
        System.out.println(itr);
        }
    


    }

}