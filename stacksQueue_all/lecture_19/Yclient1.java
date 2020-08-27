import java.util.*;

public class Yclient1{
    public static void main(String[] args){

        //this is of mystack itself only
        
        //ctrl + alt + n , giving wrong output when using class variables here

        Mystack ms = new Mystack();
        for ( int i = 0; i <= 11; i++){
            ms.push(i+1);
        }

        for( int j = 0 ; j < 1 ; j++){
            ms.pop();
        }
        
        ms.print();       

        for( int j = 0 ; j <= 1; j++){
            ms.push(j);
        }
        
        ms.print();       

    }
}