import java.util.*;
public class priorityQue{
    public static class priorityQueue {

        //default priority queue mai arraylist nahi hooti
        //array hoota hain , or add ho hoo kar banti hain har baar
        //isliye actual complexity nlogn hoti hain, prioQueu bnne mai
        ArrayList<Integer> arr = new ArrayList<>();
        boolean isMax = true;
        
        priorityQueue(boolean isMax) {
            this.isMax = isMax;
        }
        
        priorityQueue(int[] arr1, boolean isMax) {
            this.isMax = isMax;
            for (int i = 0; i < arr1.length; i++) {
                arr.add(arr1[i]) ;
            }
        
            for( int i = arr1.length - 1; i >= 0; i--){
                downheapify(i);
            }
        }

       public void add(int val){
        arr.add(val);
        upheapify(arr.size() - 1);
       } 

       public int top(){
           return arr.get(0); 
       }

       public int remove(){
        //top element

        swap(0, arr.size() - 1);

        int remove_ele = arr.get(arr.size() - 1);
        arr.remove( arr.size() - 1);
        downheapify(0);
         
        return remove_ele;
       }

       public void update(int prevVal , int newVal){

        int idx = -1;
        for( int i = 0; i < arr.size() ; i++){
            if( arr.get(i) == prevVal){
                idx = i;
            }
        } 

        if( idx == -1 )
            return;

        arr.set( idx, newVal);
        upheapify(idx);
        downheapify(idx);
       }
       
       public int size() {
           return arr.size();
       }

       public int compareTo(int val1, int val2){
        if( isMax){
            return val1 - val2;
        }
        else 
            return val2 - val1;
       }

       public void upheapify( int ci){

        int pi = (ci - 1)/2; // ci -1 >> 1;
        if ( pi > 0 && compareTo(arr.get(ci),arr.get(pi)) > 0 ){
            swap( ci, pi);
            upheapify(pi);
        }
       }

       public void downheapify( int idx){

        int maxidx = idx;
        int lci = 2 * idx + 1;
        int rci = 2 * idx + 2;
        
        if( lci < arr.size() && compareTo(arr.get(maxidx),arr.get(lci)) < 0 ){
            maxidx = lci;
        }

        if( rci < arr.size() && compareTo(arr.get(maxidx),arr.get(rci)) < 0 ){
            maxidx = rci;
        } 

        if( maxidx != idx){
            swap(idx, maxidx);
            downheapify(maxidx);
        }

       }

       public void swap ( int x, int y){

        Integer val1 = arr.get(x);
        Integer val2 = arr.get(y);
        // we are taking INTEGER here, it can be int as well as null too
        
        arr.set(x, val2);
        arr.set(y, val1);

       }
    }        
        
        
            public static void main( String[] args){
     
        int[] arr = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13 };
        priorityQueue pq = new priorityQueue(arr, false);

        while (pq.size() != 0) {
            System.out.print(pq.remove() + " ");
        }
        System.out.println();

        priorityQueue pq2 = new priorityQueue(arr, true);
        
        while (pq2.size() != 0) {
            System.out.print(pq2.remove() + " ");
        }

    }
    
}
    
