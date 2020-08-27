import java.util.*;
public class Alru_cache{

    public static class lru{
        LinkedList<Integer> ll = new LinkedList<>();
        HashMap<Integer,Character> map = new HashMap<>();
        int defaultSize = 4;

        void set(int key, char val){
            if( map.containsKey(key)){
                map.put(key, val);
                Integer b = 2;
                Integer a = new Integer(key);
                ll.remove(a);//ll.remove() //removes from an index,ll.remove(2) //removes 2nd index element
                                           // but if we want to remove a particular object ,then pass 
                                           //that object in it                                        
                ll.addFirst(key);           
            }
            else{
 
                if( ll.size() == defaultSize){
                int val2 = ll.removeLast();
               map.remove(val2);
                }
                
                map.put(key, val);       
                ll.addFirst(key);
            }

        }

        char get(int key){

            if( !map.containsKey(key)){
                return '$';
            }

            else{
                Integer a = new Integer(key);
                ll.remove(a);
                ll.addFirst(key);
                return map.get(key);
            }
        }

        void print(){
            for( int val2 : map.keySet()){
                System.out.print(map.get(val2)+ " ");
            }
            System.out.println();
        }
        
    }
    public static void main(String[] args){

        lru ll = new lru();
        ll.set(2, 'a');
        ll.set(3, 'b');
        ll.set(4, 'd');
        System.out.println(ll.get(2));
        ll.print();
        ll.set(3,'f');
        ll.print();
        System.out.println(ll.get(3));
        ll.print();
        ll.set(5,'g');
        ll.set(6,'m');
        ll.print();

    }


}