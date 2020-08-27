#include<bits/stdc++.h>

using namespace std;

class MinStack {
public:
      
            stack<long long> st;
            long long minsf = INT_MAX;

    MinStack() {
        
    }
    
    void push(int x) {

        //for very first push case
        if(st.size() == 0){
            minsf = x;
            st.push(x);
            return;
        }
        
        long long val = x;
        
        long long val2 =  val - minsf + val;
        
        if( val < minsf){
            st.push( val2 );
            minsf = val;
        }
            else{
             st.push(x);
        }
    }
    
    void pop() {
       
        if( st.top() < minsf){
            minsf =  minsf - st.top() + minsf;//which is prev( 2*value - minsf)// pre_min = 2*new_min - top
            st.pop();
        }
        else{
           st.pop();
        }
       
       //FOR CASES IF stack empty
         if( st.size() == 0){
            minsf = LONG_MAX;    
        }
        
    }
    
    int top() {
        if( st.top() < minsf){
            return minsf ;//which is prev( 2*value - minsf)
        }
        else{
            return st.top();
        }        
    }
    
    int getMin() {
        return minsf;        
    }
};


int main(){

//we have got all the outputs in int in each function
//but we have made the stack of long long as well as all the 
// variables inside the stack

//this is extremely useful for the cases where there is the condition
// of infinity and - infinity


    MinStack st ;
    st.push(-1);
    st.push(1);
    st.push(0);
    st.push(-5);
    st.push(-2);
    st.push(-8);
    st.push(-1);
    
    cout<<st.top()<<endl;
    st.pop();
    cout<<st.top()<<endl;
    st.pop();
    cout<<st.top()<<endl;
    st.pop();
    cout<<"MIN"<<st.getMin()<<endl;
    cout<<st.top()<<endl;
    st.pop();
    cout<<st.top()<<endl;
    st.pop();
    cout<<st.top()<<endl;
    st.pop();
    cout<<"MIN"<<st.getMin()<<endl;
    cout<<st.top()<<endl;
    st.pop();
    cout<<st.top()<<endl;
    st.pop();
    
    return 0;
}

            