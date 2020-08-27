// package May24_2019;

public class kstack {

	int[] da;
	int[] pa;
	int fh;
	int cap;
	int[] sha;
	
	kstack(int cap, int k){
		this.cap=cap;
		da=new int[cap];
		pa=new int[cap];
		sha =new int[k];
		fh=0;
		for(int i=0; i<sha.length; i++){
			sha[i]=-1;			
		}	
		
		for(int i=0; i<pa.length-1;i++){
			pa[i]=i+1;			
		}
		
		pa[cap-1]=-1;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		kstack kk=new kstack(10,3);
	
		kk.push(10,0);
		kk.push(20,0);
		kk.push(30,1);
		kk.push(40,2);
		kk.push(50,2);
		kk.push(60,1);
		kk.push(70,1);
		kk.push(80,2);
		kk.push(90,0);
		kk.push(100,0);
		
//		while(!kk.isempty)
//		{
//			System.out.println();
//		}
		
		for(int i=0; i<=2; i++){
		System.out.println(i+":");
		while(kk.isEmpty(i)==false){
			System.out.print(kk.pop(i)+" ");
		}
		System.out.println();
		kk.pop(i);
		}
		
	}

	public boolean isFull(){
		if (fh==-1)
			return true;
		else
			return false;		
	}
	
	public boolean isEmpty(int k){
		
		return sha[k]==-1;
	}
	
	public void push(int val,int k){
		if(isFull()){
			System.out.println("stack overflow");
		}
		else
		{
			int temp=fh;
			fh=pa[fh];
			pa[temp]=sha[k];
			sha[k]=temp;
		
			da[temp]=val;
		
		}
		}
	
	public int pop(int k){
		if(isEmpty(k)){
			System.out.println("stack "+k+" underflow");
			return -1;
		}
			else{
			
				int temp=sha[k];
				sha[k]=pa[temp];
				pa[temp]=fh;
				fh=temp;
				return da[temp];
			}		
	}

	
}
