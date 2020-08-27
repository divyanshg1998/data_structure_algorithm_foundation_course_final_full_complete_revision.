import java.util.*;

public class hashmap{

    public static void main(String[] args){

        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 1000);
        map.put("pakis", 2000);
        map.put("usa", 9);
        map.put("malasia",90);

        System.out.println(map);

        for( String keys : map.keySet()){
            System.out.println(map.get(keys));
        //randomly print karta hain
        }

        System.out.println("------------------");
        if(map.containsKey("usa")){
            System.out.println(map.get("usa"));
        }
        
        System.out.println(map.remove("usa"));
 
      
        System.out.println("------------------");
        if(map.containsValue(1000)){
            System.out.println("there");
        }
 

    }

}