#include<bits/stdc++.h>

using namespace std;

//memorization , not the best approach
int boardpath1( int now, int targ, vector<int>& dp){
    
    if( now == targ){
        return 1;
    }

    if( dp[now] != 0){
        return dp[now];
    }

    int count = 0; 
    for( int i = 1; i <= 6 ; i++){
        if(now + i <= targ){
            count += boardpath1( now + i, targ, dp);
        }
    }

   dp[now] = count;

    return count;   
}

//tabulation, better  
int boardpath2( int start, int end){

vector<int> arr( end+1, 0);
arr[end] = 1;


for( int i = end - 1 ; i >= 0; i--){
    for( int dice = 1; dice <= 6; dice++)
{
    if( i + dice <= end)
{
    arr[i] += arr[i + dice];
}

else break;

}
}
    for( auto itr : arr){
        cout<<itr<<" ";
    }cout<<endl;

return arr[0];
}

int main(){

    vector<int> arr (11, 0);

    cout<<boardpath1(0,10,arr)<<endl;

    for( auto itr : arr){
        cout<<itr<<" ";
    }cout<<endl;


    //not for arr
    //   for( int ele : arr){
    //       cout<<ele<<" ";
    //   } 
    //   cout<<endl;
   
    cout<<"======================"<<endl;
    cout<<boardpath2(0,10)<<endl;

    return 0;
}