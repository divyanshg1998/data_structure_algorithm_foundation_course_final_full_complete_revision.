#include<bits/stdc++.h>
using namespace std;

int fun1( int n, int k){

if(k == 1){
    return 1;
}

if( n < k ){
    return 0;
}

if( n == k){
    return 1;
}

return fun1(n-1, k-1) + fun1(n-1, k) * k;

}

int fun1DP(int n, int k){

vector<vector<int>> dp( k + 1, vector<int>( n+1, 0) );

for ( int k = 1 ; k < dp.size(); k++){
    for( int n = 1 ; n < dp[0].size(); n++){
        if ( k == 1){
            dp[k][n] = 1;
        }
        else if ( k > n){
            dp[k][n] = 0;

        }
        else if ( k == n){
            dp [k][n] = 1;
        }
        else {
            dp[k][n] = dp[k][n-1] * k + dp[k-1][n-1] ;
        }
    
    cout<<dp[k][n]<<" ";
    }
    cout<<endl;
}
return dp[k][n];


}

int main(){

    cout<<fun1(5,2)<<endl;

    cout<<fun1DP(5,2)<<endl; 


    return 0;

}