import java.util.*;

public class Yclient{
    public static void main(String[] args){

        Mystack ms = new Mystack();
        for ( int i = 0; i < 10; i++){
            ms.push(i+1);
        }

        ms.print();       

    }
}