#include<bits/stdc++.h>
using namespace std;

// STACK POP, does not return value always so
//  for value use, stack.peek() or stack.top()

#define vi vector<int> 

vi solve(vi& arr){
stack<int> st;

for (int i = 0; i < arr.size(); i++) {
            if (arr[i] > 0)
                st.push(arr[i]);

            else {
                while (st.size() != 0 && st.top() > 0 && st.top() < -arr[i]) {
                    st.pop();
                }

                if (st.size() != 0 && st.top() == -arr[i])
                    st.pop();

                else if (st.size() == 0 || st.top() < 0)
                    st.push(arr[i]);
            }
        }


vector<int> arr2(st.size(), 0) ;

 for( int i = arr2.size() - 1; i>=0 ; i--){
    int idx=st.top();
    st.pop();
    arr2[i] = arr[idx] ; 
     
 }       

return arr2;

}

int main(){

//cases
//{-2,-1, 1, 2}
// {-8,8}

vi arr {5, 10, -5};
vi arr2 = solve(arr);

for( int ele: arr2){
    cout<<ele<<",";
}

    return 0; 
}