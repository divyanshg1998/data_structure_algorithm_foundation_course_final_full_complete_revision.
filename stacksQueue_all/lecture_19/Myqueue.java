import java.util.*;

public class Myqueue
{
     int[] arr;
     int start = 0;
     int end = 0;
     int size = 0;
     
     Myqueue(int size){
        this.arr = new int[this.size];
     }

     Myqueue(){
        this.arr = new int[10];
     }

    //note we do not use static in the functions of the class
    
     public boolean isEmpty(){
        //static
        return (this.size == 0);
     }

     public int front(){
        if( isEmpty()){
            System.err.println("StackIsFull");
            return -1;
        }

        return this.arr[this.start];
     }

     public void push(int data){
    // static
        if( this.size == arr.length){
            System.err.println("QueueIsFull");
            return;
        }

        this.arr[this.end] = data;
        this.end = (this.end+1) % this.arr.length;       
        this.size++;     
     
    }

    public int pop(){
        // static
        if( isEmpty()){
            System.err.println("StackIsEmpty");
            return -1;
        }

        int rv = arr[this.start];
        this.start = (this.start + 1) % arr.length;        
        return rv;            

    }

    public static void main(String [] args){


    }
}