package March24_2019_GT;

import java.util.*;

public class gtree {

	private static class Node {
		public int data;
		public ArrayList<Node> children;
		//pointer

		Node (int data){
		this.data=data;
		this.children=new ArrayList<>();
	}
	}
	
public static Node construct(ArrayList<Integer> dList)
{
	Node root=null;
	ArrayList<Node> nList=new ArrayList<>();
	
	for(int i=0; i<dList.size(); i++)
	{
		
		if( dList.get(i) == -1 )
			nList.remove(nList.size()-1);
		
		else{
		Node nn= new Node(dList.get(i));
		
		if(nList.size() == 0)
		{		
			root=nn;	
		}
		
		else{
		Node lastn= nList.get(nList.size()-1);
		lastn.children.add(nn);
		}
		
		nList.add(nn);  //stack of nList  //theory
}
	}
	return root;
}

	public static void display(Node node) {
	
	String s=node.data+"->";
	for (int i=0; i<node.children.size(); i++)
	{
		s=s+" "+node.children.get(i).data;
	}
	System.out.println(s+".");
	
	for (int i=0; i<node.children.size(); i++)
	{
		display(node.children.get(i));
	}	
}

public static int size(Node nn) {
	//based on faith expectation 
	//f(10)=f(20)+x-
	//we have faith that all elements 20 30 40 
	//size would be returned and have to add only 10
//	if(nn.children==null)
//			return 1;
//	
	int ctr=0;
	for(int i=0;i<nn.children.size();i++)
	{
	 ctr=ctr+size(nn.children.get(i));
			
	}
	return ++ctr;
}

public static int myMax(Node nn) {
	int max=Integer.MIN_VALUE;//lowest value
	
	for(int i=0;i<nn.children.size();i++)
	{
		max=Math.max(max, myMax(nn.children.get(i)));
	}
	
	return Math.max(max, nn.data);
}

public static int height(Node nn) {
	int ht=0;
	
	for(int i=0;i<nn.children.size();i++)
	{
		ht=Math.max(ht, height(nn.children.get(i)));
	}
	
	return ht+1;
}

public static boolean find(Node nn,int dtf) {
	if(nn.data==dtf)
		return true;
			
	//small euler of recursion 
	//dives up
	for(int i=0;i<nn.children.size();i++)
	{
		boolean truth=find(nn.children.get(i),dtf);
		if(truth==true)
			return true;
	
	}
	
	return false;
}

public static ArrayList<Integer> n2rpath(Node root,int dtf)
//datatofind
 {
	if(dtf==root.data)
	{
		ArrayList<Integer> rList=new ArrayList<>();
		rList.add(dtf);
		return rList;
		}
	
	for(int i=0; i< root.children.size(); i++)
	{
		ArrayList<Integer> n2cpath=new ArrayList<>();
		n2cpath=n2rpath(root.children.get(i),dtf);
		if(n2cpath!=null)
			{
			n2cpath.add(root.data);
			return n2cpath;
			}
	}
	return null;
}
	
	public static int lca(Node root, int d1, int d2){
		ArrayList<Integer> al1=n2rpath( root, d1);
		
		ArrayList<Integer> al2=n2rpath(root, d2);
		
		int i=al1.size()-1;
		int j=al2.size()-1;
		
		while(al1.get(i)==al2.get(j))
				{
					i--;
					j--;
				}
		return 	al1.get(i+1);

	}

	public static int dist(Node root, int d1, int d2){
		ArrayList<Integer> al1 = n2rpath( root, d1);
		
		ArrayList<Integer> al2 = n2rpath( root, d2);
		
		int i=al1.size()-1;
		int j=al2.size()-1;
			while(al1.get(i)==al2.get(j))
				{
					i--;
					j--;
				}
		
			return (i+1)+(j+1)+1;
	}

	public static void mirror(Node nn) {
	
		//INBUILT FUNC Collections.reverse(nn.children);
		for(int i=0;i<nn.children.size();i++)
		{
			mirror(nn.children.get(i));
		}
		
		int left=0;
		int right=nn.children.size()-1;
		
		while(left<right){
			
		int temp=nn.children.get(left).data;
		nn.children.get(left).data=nn.children.get(right).data;
		nn.children.get(right).data=temp;
		
		left++;
		right--;
		
		}
			
	}

	public static void removeLeaf(Node nn){
		
		for(int i=0;i<nn.children.size();i++)
		{
			removeLeaf(nn.children.get(i));
		}
		
		for(int j=0; j<nn.children.size(); j++){
			
			if(nn.children.get(j).children.size() ==0)
				nn.children.remove(j);
		}
		
	}
	
	
	public static void main(String[] args) {

	ArrayList<Integer> dList= new ArrayList<Integer>(Arrays.asList
		(10,20,50,-1,60,-1,-1,30,70,-1,80,
				110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1));
		
		Node root= construct(dList);	//head
		display(root);
		
		System.out.println("SIZE:"+size(root));
		System.out.println("myMAX:"+myMax(root));
		System.out.println("height:"+height(root));
		System.out.println("Find:"+find(root,1000));
		System.out.println("nodeToRootPath:"+n2rpath(root,110));
		System.out.println("leastCommonAncester110_60:"+lca(root,110,60));
		System.out.println("Dist_110_60:"+lca(root,110,60));
		System.out.println("<-------mirror--------->");
		mirror(root);
		display(root);	
		System.out.println("<-----removeleaf------>");
		removeLeaf(root);
		display(root);
	}
		
	}


