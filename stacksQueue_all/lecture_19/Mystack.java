import java.util.*;

public class Mystack{

    protected int[] st;          //stack
    protected int idx = -1;      //protected so can be acessed by the inherited class too   
    
    Mystack(){
        this.st = new int[10];
    }

    Mystack( int size){
        this.st = new int[size];
    }

    //note we do not use static in the functions of the class

    public void printIdx(){
        System.out.println(this.idx);
    }

   public void print(){
    System.out.print("[");

    for( int i = this.idx; i > 0; i--){
        System.out.print(this.st[i] + ",");
        }
    System.out.println(this.st[0] + "]");
    } 

    public int size(){
        return this.idx+1;
    }

    public boolean isEmpty(){
        return (this.idx == -1);
    }

    public int top(){
        if( this.idx == -1){
            System.err.println("StackIsEmpty");
            return -1;
        }

        return this.st[this.idx];
    }

    public void push(int data){

        if( this.idx == st.length){
           System.err.println("StackIsFull");         
        }

        this.idx++;
        this.st[this.idx] = data; 
    }    

    public int pop(){

        if( this.idx == -1){
            System.err.println("StackIsEmpty");
            return -1;
        }

        int rv = this.st[idx];
        this.st[idx] = 0;
        this.idx--;
        return rv;
    }

    public static void main(String[] args){}
}