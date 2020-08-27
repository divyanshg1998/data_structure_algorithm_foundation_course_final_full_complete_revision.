import java.util.*;

public class YYMaxMatrixRect{
public static void main(String[] args){
//max rectangle in matrix

String[][] mat =
{{"1","0","1","0","0"},
  {"1","0","1","1","1"},
  {"1","1","1","1","1"},
  {"1","0","0","1","0"}
};

System.out.println(solve(mat));
}

public static int solve(String[][] mat){

    if(mat.length == 0)    return 0;

int[] arr = new int[mat[0].length];

// an error, cant use arr3[0].length, because nothing there
// int [][] arr3 ={};
// int[] arr2 = new int[arr3[0].length];

int maxArea = 0;
for( int i = 0 ; i < mat.length; i++){
    for( int j = 0 ; j < mat[0].length;j++)
    {

        if( Objects.equals(mat[i][j],"0") ){
            //for string comparison , as == only compares the place where string are stored
            
            //mat[i][j].equals("0");    //does nogt compares null, hence above
            arr[j] = 0;
        }

        else{
            arr[j] += 1;
        }
    
    }

    for( int ele: arr){
        System.out.print(ele+" ");
    }
    System.out.println();
    maxArea = Math.max(histogram(arr), maxArea);

}

return maxArea;
}


public static int histogram(int[] arr) 
{
Stack<Integer> st = new Stack<>();
int maxArea= 0;
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

return maxArea;


}


}