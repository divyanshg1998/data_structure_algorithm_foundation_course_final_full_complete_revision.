import java.util.*;

public class Hashmap <K,V>{

    class Node{
        K key;
        V value;

        Node( K key, V value){             
            this.key = key;
            this.value = value;
        }
    }
 
    LinkedList<Node>[] buckets = new LinkedList[10];

    Hashmap() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

//READ ALL THE FUNCTION FROM THE BOTTOM
//BOTTOM TO UP
   


public void put(K key, V val ){
    int idx = myHashCode(key);
    LinkedList<Node> ll = buckets[idx];

    Node nn = findKeyInLL(ll, key);

    if( nn != null){
        nn.key = key;
    }
    
    else{

        Node n = new Node(key, val);
        ll.addFirst(n);

        double lambda = ll.size() * 1.0 /buckets.length ;//imp
    
        if(lambda >= 1){
            // rehash();
        }
        
    }

}

public Node get(K key ){
    int idx = myHashCode(key);
    LinkedList<Node> ll = buckets[idx];

    Node n = findKeyInLL(ll, key);
    return n;

}

// public Node foundInBucket( LinkedList ,Integer key){


// }


public boolean containsKey(K key){ 
    int idx = myHashCode(key);
    LinkedList<Node> ll = buckets[idx];
    int size = buckets[idx].size();

    while( size-- > 0){
        Node n = ll.getFirst();
        if( n.key == key){
           return true;
        }   
        ll.addLast(ll.removeFirst());
    }

    return false;
}

public ArrayList<K> keySet(){
    //it returns an arrayList containing the keys in itself
    ArrayList<K> ar = new ArrayList<>();
    
    for(int i = 0; i < buckets.length; i++){
        int size = buckets[i].size();

        while( size-- > 0){
            Node n = buckets[i].getFirst();
            ar.add(n.key);
            buckets[i].addLast(buckets[i].removeFirst());
        }
    }

    return ar;

}

public Node findKeyInLL( LinkedList<Node> bucket, K key){

    Node rn = null;
    int size = bucket.size();
    
    while( size-- > 0){

        Node n = bucket.getFirst();
        if( n.key == key){
            //keep n at the top itself , so can get it
            return n;
        }
        bucket.addLast(bucket.removeFirst());
    }
    return rn;
}

public int myHashCode( K key){
    int code = key.hashCode();
    return Math.abs(code) % buckets.length;//Math.abs 
}

public static void main(String[] args){

   
}

}
