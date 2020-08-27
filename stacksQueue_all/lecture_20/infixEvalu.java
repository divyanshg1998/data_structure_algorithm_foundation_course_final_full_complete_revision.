import java.util.*;
public class infixEvalu{

    static int priority( char ch){

        if( ch == '+' || ch == '-')     return 0;
        else if( ch == '*' || ch == '/' || ch == '%')    return 1;
        else if ( ch == '^')     return 2;
        
        return -1;   
    }


    static boolean isOperator( char ch ){
    if( ch == '-' || ch == '+'|| ch == '*' || ch == '/' || ch == '%' || ch =='^'){
        return true;
    }
        return false;
    }

    static int operation(int a , int b, char ch){
        if( ch == '+')
            return a + b;
        
        else if ( ch =='-')         
             return a - b;
        
         else if( ch == '/')
            return a / b;
        
        else if (ch == '*')
            return a * b;

        else if (ch == '%')
            return a % b;
       
        else if(ch == '^')
            return (int) Math.pow(a, b);            
        
        else return -1;
    
    }    

    
    
    static int infixExp(String str){

        Stack<Integer> numst = new Stack<>();
        Stack<Character> opst = new Stack<>();
        
        for( int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            int num = ch - '0';       
            if( num >= 0 && num <= 9){
                numst.push(num);
            }

            else if( ch == '('){
                opst.push(ch);
            }

            else if( isOperator(ch)){
            
                while( opst.size() != 0 && priority(ch) < priority(opst.peek()) && opst.peek() != '('){
  
                int b = numst.pop();
                int a = numst.pop();
                char op = opst.pop();
                
                int ans = operation( a, b, op); 
                numst.push(ans);                
                }
                
                opst.push(ch);
            }

            else if( ch == ')'){
                while( numst.size() != 0 && numst.peek() != '('){
                    int b = numst.pop();
                    int a = numst.pop();
                    char op = opst.pop();
                    
                    int ans = operation( a, b, op); 
                    numst.push(ans);             
            
                }
            opst.pop();
            }

        }

        while( opst.size() != 0)
        {

            int b = numst.pop();
            int a = numst.pop();
            char op = opst.pop();
            
            int ans = operation( a, b, op); 
            numst.push(ans);             

        }

    return numst.pop();
    
}

    public static void main(String[] args){

        String str ="8+4*3-9/3^(2-1)";
        System.out.println(infixExp(str));


        
    }
}