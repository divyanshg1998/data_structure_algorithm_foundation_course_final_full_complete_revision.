#include<bits/stdc++.h>
using namespace std;
#define vi vector<int>

int rodcut2(vi& rod, int l){

if( l == 1) { /*&cout<<"base case 1"<<endl;*/return rod[0];};
if( l == 0) { /*cout<<"base case 1"<<endl;*/return 0;}

int max_ = INT_MIN;         //Integer.MIN_VALUE;
for ( int i = 1; i <= l ; i++){
    int val = rod[i-1] + rodcut2(rod, l-i );
    
    max_ = max(val, max_);
}

// cout<<max_;
return max_;
}


int rodcutDP(vi& rod, int l){

vi dp ( rod.size() + 1, 0);

dp[0] = 0;
dp[1] = rod[0];

cout<<dp[0]<<" "<<dp[1]<<" ";

for( int i = 2 ; i < dp.size() ; i++){
// int max_ = -9;  //Integer.MIN_VALUE;
for( int j = 1; j <= i; j++){
    int sum = rod[j-1] + dp[i-j];
    dp[i] = max(sum , dp[i]);  //Math.Max
}
cout<<dp[i]<<" ";
}
cout<<endl;
return dp[dp.size() - 1];

}


int main (){

vi rod{ 1, 5, 8, 9, 10, 17, 17, 20};

// cout<<rodf(rod, 0, rod.size() - 1)<<endl;

cout<<rodcut2(rod, 8);
// cout<<rodcutDP(rod, 8)<<endl;



return 0;
}
