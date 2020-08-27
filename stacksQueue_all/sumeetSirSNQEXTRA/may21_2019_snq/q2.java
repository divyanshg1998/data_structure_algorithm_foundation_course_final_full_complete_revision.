// package may21_2019_snq;
import java.util.*;

public class q2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//nge
		int[] arr2={10,8,9,6,3,5};
		int[] arr=func(arr2);
		for(int val:arr)
		{
			System.out.println(val);
		}
	}

	public static int[] func(int[] arr)
	{
		Stack<Integer> st= new Stack<Integer>();
		
		st.push(arr[arr.length-1]);
		int[] res=new int[arr.length];
		res[res.length-1]=-1;
	
		char flag='y';
	for(int i=arr.length-2; i>=0; i--){
			while(!st.isEmpty() && arr[i]>st.peek())
			{
				st.pop();
				flag='y';
			}
		
	  	
		res[i]= st.size()>0 ? st.peek() : -1 ;
		if(flag=='y'){
			st.push(arr[i]);
			flag='n';
		}
		
		}	
	return res;
}	
}		
