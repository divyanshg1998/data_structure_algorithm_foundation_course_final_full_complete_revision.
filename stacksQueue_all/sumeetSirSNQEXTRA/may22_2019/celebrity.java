package may22_2019;

public class celebrity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr=
				{{0,0,1,1,1,1},
				{1,0,1,1,1,1},
				{1,0,0,1,1,0},
				{0,0,0,0,1,0},
				{0,0,0,0,0,0},
				{1,0,1,1,1,0}};
		System.out.println(celebrit(arr));		
		}
	
	public static int celebrit(int[][] arr){
		int l=0, r=5;
		
		while(l<=r){
			if(arr[l][r]==1){
				l++;
			}
			
			else if(arr[l][r]==0){
				r--;				
			}
		}
		
		for(int i=0; i<arr.length;i++){
			if(i != l){
				//converse
				if(arr[l][i]==1 || arr[i][l]==0 )
			//l knows no one   or  l is known by everyone
					return -1;
			}			
		}
		return l;
	}	
	}


