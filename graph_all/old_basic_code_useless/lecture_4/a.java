import java.util.*;
public class a{

    static ArrayList<String> fun(String q, String a){

        if( q.equals("")){
            ArrayList<String> al = new ArrayList<>();
            al.add("");
            return al;
        }

        char ch = q.charAt(0);

        ArrayList<String> al2 = new ArrayList<>();
        ArrayList<String> al = new ArrayList<>();
        al = fun( q.substring(1) , a );
       
        for( String str : al){
            al2.add(str);
            al2.add( ch + str  );
       }

       return al2;
    }

    public static void ss2( String q, String a){
        if( q.length() == 0){
            System.out.println(a);
            return;
        }

        char ch = q.charAt(0);
        ss2( q.substring(1), a + ch);
        ss2(  q.substring(1), a);            
    }


    public static void main(String[] args){

        ArrayList<String> al = new ArrayList<>();
        al = fun("abc","");

        for( String str : al){
            System.out.println(str);
        }
        // ss2( "abc" ,"");
    }
}