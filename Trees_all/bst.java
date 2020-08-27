import java.util.*;

public class bst{

    static class Node{

        int data = 0;
        Node left = null;
        Node right = null;

        Node( int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
        Node( int data){
            this.data = data;
        }
        Node(){

        }

    }
   
    public static int idx1 = 0;
    public static void display( Node root){
        if( root == null)   return;

        //this line is needed
        //as we add left data, if it is null, then we do not add any thing

         String ans = "";
         ans += root.left != null ? root.left.data : ".";
         ans += "<=" + root.data + "=>" ;

         ans += root.right != null ? root.right.data : ".";
         

        //incorrect cant assign int to string
        //  String ans1 =  2;
        //  System.out.println(ans1);
        //correct
        // String ans2 = "" + 2;  


         System.out.println(ans);

        display(root.left);
        display(root.right);
    }

    public static Node createBST(int[] arr, int si, int ei){

    int mid = si + ei >> 1;//divide by 2

    Node node = new Node(arr[mid]); 
  
    
    node.left = createBST( arr, );





    }

    public static void main(String[] args){

        int[] arr = { 2, 6, 10, 25, 38, 39, 40, 52, 68, 72};

        Node nn = createBST(arr);
        display(nn);
        
    }

}