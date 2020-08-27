import java.util.*;
public class picnic{

    public static int possible( int n){
        if ( n == 2) return 2;
        if ( n == 1) return 1;

        return ( possible(n-1) + (possible(n-2)*(n-1)) );
    //GET AWAY THIS THE THING HERE

    }

    public static int possible1(int n){

    int strg[] = new int[n+1];
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
    strg[1] = 1;
    strg[2] = 2;

    for( int i = 3 ; i <= n; i++){
        strg[i] = strg[i-1] + strg[i-2] * (i-1);
    } 

    return strg[n];

    }

    public static int posiible2( int n){

        int a = 1;
        int b = 2;

        for ( int i = 3 ; i <= n; i++ ){
            c = a + b;
            b = c;
            a = b;
        }


    }
    public static void main( String[] args){

        //memorization
        System.out.println(possible(5));

        //tabulation
        System.out.println(possible1(5));

        //tabulation better
        System.out.println(possible2  (5));
}
}