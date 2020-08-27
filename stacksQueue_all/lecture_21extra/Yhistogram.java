import java.util.*;

public class Yhistogram{

    public static void main(String[] args){

        int[] arr ={2, 1, 5, 6, 2, 3};
        histogram(arr);   
        
     }

      public static int histogram(int[] arr) 
        {
        Stack<Integer> st = new Stack<>();
        int maxArea= 0;     //TEST CASE BECAUSE IF NO INPUT AT ALL, THEN ANS = 0  
        st.push(-1);
        //peek for java and top for c++

        for( int i = 0; i < arr.length; i++){
            
            while( st.peek() != -1 && arr[st.peek()] > arr[i] ){
                int idx = st.pop();
                int left = st.peek();
                int right = i;

                int width = right - left - 1 ;
                int area = width * arr[idx];
                System.out.println("Area " + idx + " =" + area);
                    maxArea = Math.max( maxArea, area); 
            }
            st.push(i);

        }

        while( st.peek() != -1){

            int idx = st.pop();
            int area = (arr.length - st.peek() - 1) * arr[idx];
             System.out.println("Area " + idx+ " =" + area);
   
            maxArea = Math.max( maxArea, area);
        }
        System.out.println("MaxArea = " + maxArea);
    }
    return maxArea;
}


}