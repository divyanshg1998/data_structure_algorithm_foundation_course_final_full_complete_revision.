import java.util.*;

public class huffmanEncoder{

    public static class  Node {
        String data;
        int freq = 0;
        Node left = null;
        Node right = null;

        Node( String data, int freq, Node left, Node right){
            this.data = data;
            this.freq = freq;
            this.left = left; 
            this.right = right;
        }
    }
    
    public static void huffmanTree(String str){

        int[] freq = new int[26];

        for( int i = 0 ; i < str.length(); i++)
        {
            freq[(str.charAt(i) - 'a')]++;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for( int i = 0 ; i < freq.length(); i++){
            if( freq[i] > 0 ){
                Node node = new Node("" + (char)('a'+ i), freq[i], null, null);
                pq.add(node);
            }

        while( pq.size() != 1){
            Node one = pq.remove();
            Node two = pq.remove();

            Node node = new Node(one.data + two.data, one.frq + two.freq, one, two);
            pq.add(node);
        }


        }

    } 
    
    
       public static void main(String[] args){

        String str = "abcjdhadsajadsa";
        

    }

    
}