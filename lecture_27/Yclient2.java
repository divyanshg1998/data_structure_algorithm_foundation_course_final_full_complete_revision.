import java.util.*;
public class Yclient2{
    public static void main(String[] args){

        Hashmap2<String, Integer> map = new Hashmap2();
        map.put("India", 1000);
        map.put("pakis", 2000);
        map.put("usa", 9);
        map.put("India",90);

        System.out.println(map);

        System.out.println("------------------");
        
        for( String keys : map.keySet()){
            System.out.println(map.get(keys));
        //randomly print karta hain
        }

        System.out.println("------------------");
        if(map.containsKey("usa")){
            System.out.println(map.get("usa"));
        }
        System.out.println("------------------");
        
        System.out.println(map.remove("usa"));
 
        for( String keys : map.keySet()){
            System.out.println(map.get(keys));
        //randomly print karta hain
        }
      
        System.out.println("------------------");
        // if(map.containsValue(1000)){
        //     System.out.println("there");
        // }
        
 
    }
}