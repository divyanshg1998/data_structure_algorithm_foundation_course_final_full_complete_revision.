#include<bits/stdc++.h>
using namespace std;


bool balancedBrackets1(string str){

stack<int> st;

for( int i = 0; i < str.length() ; i++){

if( str[i] == '<' || str[i] =='(' || str[i] == '{' || str[i] == '['){
    st.push(i);
}

else{
    

    if( (str[i] =='>' || str[i] == '}' || str[i] == ']' || str[i] == ')') && st.size() == 0)    return false;  

    //case str = '>'    // str = ')' 
        
    if( str[i] == '>' && str[st.top()] != '<')      return false;

    if( str[i] == '}' && str[st.top()] != '{')      return false;

    if( str[i] == ']' && str[st.top()] != '[')      return false;

    if( str[i] == ')' && str[st.top()] != '(')      return false;

    st.pop();
}
}

return st.size() == 0 ;

}

int main(){

    string str = "()[]{}";
    cout<<balancedBrackets1(str);

    return 0;
}