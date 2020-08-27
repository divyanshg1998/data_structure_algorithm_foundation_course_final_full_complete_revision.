import java.util.*;

public class nearestleft{
    public static void main(String[] args){

        //find the nearest left element bigger than me or show -1 in O(n)
        int[] arr = { 1, 4, 2, 3, 8, 6, 5, 9, 1};
        // int[] ans = new int[arr.length];
        //no dont necessary need it
        Stack<Integer> st = new Stack<Integer>();

        for( int i = 0; i < arr.length; i++ ){
     
            while( st.size() != 0 && st.peek() <= arr[i]){
                st.pop();
           }

           
    if( st.size() == 0)
           System.out.println( arr[i] + " => -1" );
    else
            System.out.println( arr[i] + " => " + st.peek());
        
            st.push(arr[i]);
        }

// by using the above we are decreasing the extra space being taken as well

//ques formation
//find the next greatest element to each element

System.out.println("next greatest element");
fun(arr);
    }

public static void fun( int[] arr){

    Stack<Integer> st = new Stack<Integer>();

    System.out.println( arr[arr.length - 1] +"=> -1");
    st.push(arr[arr.length - 1]);

    for(int i = arr.length - 2 ; i >= 0; i++){
        while( st.size() != 0 && st.peek() <= arr[i] ){
            //dont use isEmpty() here
            st.pop();
        }

        if( st.size() != 0){
            System.out.println(arr[i] +" => " + st.peek() );
        }
        else{
            System.out.println(arr[i] +" => -1" );
        }
        st.push(arr[i]);
    }
    
        }
}
