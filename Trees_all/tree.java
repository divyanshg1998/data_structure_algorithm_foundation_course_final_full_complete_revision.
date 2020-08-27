import java.util.*;

public class tree{

    static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        Node(){
        }

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node( int data){
            this.data = data;
             }
    }

         static int idx = 0;
      
        public static Node createTree( int[] arr){
            if(  idx == arr.length || arr[idx] == -1 ){
                idx++;
                return null;
            }

            Node node = new Node(arr[idx]);
            idx++;

            node.left = createTree(arr);
            node.right = createTree(arr);

            return node;
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

        public static int size( Node root){

            if( root == null)   return 0;

            return size( root.left) + size(root.right) + 1;

        }

            public static int height( Node root){

                return root == null ? -1 : Math.max( height(root.left), height(root.right)) + 1;

            }

        public static int maxDia( Node n){

            if( n == null){
                return 0;
            }
            
            int d1 = maxDia(n.left);
            int d2 = maxDia(n.right);


            int mydia = height(n.left) + height(n.right) + 2;

            return Math.max( mydia, Math.max( d1, d2));

        }

        public static int[] maxDia2( Node n){

            if( n == null){
                
                return new int[] {-1, 0};
            }
            
            int[] d1 = maxDia2(n.left);
            int d2 = maxDia2(n.right);


            int mydia = height(n.left) + height(n.right) + 2;

            return Math.max( mydia, Math.max( d1, d2));

        }

        public static void main(String[] args){

            int[] arr ={10,20,40,60,-1,-1,70,-1,-1,50,80,-1,
                -1,-1,30,90,-1,110,150,-1,-1,-1,100,120,-1,-1,-1};;
            // int[] arr = {10, 20, 40, 60, -1, -1, 70, -1, -1, 50, 8, 0, 
            //             -1, -1, -1, 30, 90, -1, 110, 150, -1, -1, -1, 100, 1, 20, -1, -1, -1};

                Node nn = createTree(arr);
                display(nn);
                System.out.println("Size:" + size(nn));     
                System.out.println("Height:" + height(nn)); // basis of edges
                System.out.println("============");
                System.out.println("maxDia:" + maxDia(nn)); // basis of edges

                

                
                
                
                // System.imaxDia(nn);


            }
    
}