import java.util.*;

public class nDynamicStack extends Mystack{
    //A->B

    nDynamicStack(){
        super();        
    }

    nDynamicStack(int size){
        super(size);
        }

    @Override
    public void push(int data){

        if( this.idx == this.st.length - 1)  {
            //change the variables of parent class
            int[] temp = new int[this.st.length * 2];
            for( int i = 0; i < this.st.length; i++){
                temp[i] = this.st[i];
            }
            this.st = temp;
        }
        
        super.push(data);
    }

}