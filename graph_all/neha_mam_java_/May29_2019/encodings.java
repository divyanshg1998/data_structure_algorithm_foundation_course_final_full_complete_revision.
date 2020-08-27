package May29_2019;
import java.util.*;
public class encodings{
   
	public static ArrayList<String> fun(String str){
// 		if(str.length()==1) {
// 			ArrayList<String> al=new ArrayList<>();
// 			int ch=str.charAt(0);
// 			System.out.println(ch);
//             char ch4 = (char) (ch + 64);
            
//             System.out.println(ch4);
// 			//			int ch3=ch+17;
// //			char ch2=Integer.parseInt(ch) +64;
// 			al.add(ch4+"");
// 			return al;
// 		}
    
		if(str.length()==0){
			ArrayList<String> al=new ArrayList<>();
			al.add("");
			return al;

}
		char ch= str.charAt(0);
		String ros=str.substring(1,str.length());
		
		ArrayList<String> rres=fun(ros);
		
		ArrayList<String> mres=new ArrayList<>();
		
		for(int i=0; i<rres.size(); i++) {
//		if(rres.get(i).length()<)
		
			if(rres.get(i).charAt(0)>'i')
			{
                mres.add(ch+rres.get(i));
                System.out.println(mres.add(ch+rres.get(i)));
			}

            else {
				mres.add((ch+rres.get(i).charAt(0))+ rres.get(i).substring(1));
                mres.add(ch+rres.get(i));
                System.out.println(mres.add((ch+rres.get(i).charAt(0))+ rres.get(i).substring(1)));
                System.out.println(mres.add(ch+rres.get(i)));
            }
		}		
	return mres;	
    
}
	public static void main(String[] args) {
    
        
    // convert char to int 
        // char ch='a';
        // int i=(int) (ch - 64); //we apply two brackets here
        // System.out.println(ch);
        // System.out.println(i); 


        // int i=1;
        // char ch3=(char)(i + 64); //we apply two brackets here
        // System.out.println(ch3);
        // System.out.println(i);



        String str= "1123";
		
		ArrayList<String> al= fun(str); 
		
		// System.out.println(al);
	}

}




