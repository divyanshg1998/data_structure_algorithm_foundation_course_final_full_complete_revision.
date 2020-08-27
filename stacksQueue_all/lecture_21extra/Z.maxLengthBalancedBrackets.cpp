#include<bits/stdc++.h>

using namespace std;

int fun2( string str){

    stack<int> st;
    int maxlen = 0;

    for(int i = 0 ; i < str.length(); i++ ){
        if( str[i] == '(')
        {
            st.push(i);
        }

        else{
            if( st.size()!=0 && str[st.top()] == '(')
            {
                //always check that the size is not empty
                //when use st.top()
                //ELSE NO OUTPUT BUT THE EXCEPTION IS STACK EMPTY ERROR
                //THAT IS st.top() called when the stack is actually empty

                st.pop();

                maxlen = max( maxlen, i - ( st.size() == 0  ? -1 : st.top() ) );
                //cant use isEmpthy() for stack
                //bcz does not work in c++
            }

            else
            st.push(i);
        }  
    }

    // cout<<"maxLength"<<maxlen;
    return maxlen;
}

int main(){

    // string str = ")()())";

    string str = "()";

    cout<<"maxLength"<<fun2(str);

    return 0;
}
