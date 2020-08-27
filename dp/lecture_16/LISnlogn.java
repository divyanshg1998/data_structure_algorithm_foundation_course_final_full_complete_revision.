import java.util.*;

public class LISnlogn{

    public static int LISsubhesh(int[] arr){
        //code ratt lo
        int[] minVal = new int[arr.length];
        int ans = 0;
        // int hi = 0;
          for( int val : arr){
            int lo = 0; 
            int hi = ans;
            
            while( lo < hi){
                //kyuki jab equal hoota hai tiu return karte hain
                int mid = (lo + hi) / 2;

                if( minVal[mid] < val){
                    lo = mid + 1;
                }
                else{   // if( arr[mid] == val){
                    //              >
                    hi = mid ;        
                }
                System.out.println(lo + " " + hi + " " + mid + " " + ans  );
            }
            minVal[lo] = val;
            if( lo == ans){
                System.out.println("here");
                ans++;
            }       
            System.out.println(lo + " " + hi + " " + ans + "\t");
            for( int i = 0 ; i < minVal.length && arr[i] != 0 ; i++){
                System.out.print(minVal[i] + " ");
            }
            System.out.println();    
        }
    
        
        return ans;
}
    
    public static int lengthOfLIS(int[] arr) {
        
        if( arr.length == 0) return 0;
        
        else
        {
        ArrayList<Integer> al = new ArrayList<>();

        al.add(arr[0]);

        for( int i = 1; i < arr.length ; i++){
            if( arr[i] > al.get(al.size() - 1)){
                al.add(arr[i]);

                System.out.print("1. ");
                for( int ii = 0 ; ii < al.size(); ii++){
                    System.out.print(al.get(ii) + " ");
                }System.out.println();
           }

           else{

            int l = 0;
            int r = al.size() - 1;
            int mid;

            while( l < r ){
                //not equal to here because, not mid - 1 here 
                //case      int[] arr = {4,10,4,3,8,9};


                mid = (l + r) / 2;       //bracket must 
                
                if( al.get(mid) == arr[i]){
                   break;               // return mid;
                }
   
                else if( al.get(mid) < arr[i])
                    l = mid + 1;
                else if( al.get(mid) > arr[i])
                    r = mid ;

            }
                     
            int mid2 = (l + r)/2;
            
            if( arr[mid2] != arr[i])
                al.set(mid2, arr[i]);

            //ArrayList.set(index, ele);    
            //ArrayList.put(index, ele)

            System.out.print("2. ");
          for( int ii = 0 ; ii < al.size(); ii++){
                System.out.print( al.get(ii) + " " );
            }System.out.println();

        }

        }

        // for( int ele : al){
        //     System.out.print(ele+ " ");
        // }System.out.println();

        return al.size();
    }
    }

    public static void main(String[] args){

        // int[] arr={10,22,9,33,21,50,41,60,80,1};
        // int[] arr = {4,10,4,3,8,9};
        // int[] arr = {8, 10, 12, 14, 16, 11};
        int[] arr = {10,9,2,5,3,7,101,18};
        // System.out.println(lengthOfLIS(arr));
        System.out.println(LISsubhesh(arr));
        
    }   
}