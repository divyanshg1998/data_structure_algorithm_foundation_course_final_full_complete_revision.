#include<bits/stdc++.h>
using namespace std;
#define vi vector<int>
#define vvi vector<vector<int>>

int fun(vi& bal, int l, int h){
    //low ,high
if ( l == h ){
    return ( (l == 0) ? 1 : bal[l-1] ) * bal[l] * ( ( h == bal.size() - 1) ? 1 : bal[h + 1]); 
}
if( l > h)   return 0;


int max_ = INT_MIN;
for ( int i = l; i <= h ; i++ ){

    int c1 = fun( bal, l, i-1);
    int c2 = fun( bal, i+1, h);

    int mysum = ( (l == 0) ? 1 : bal[l-1] ) * bal[i] * ( ( h == bal.size() - 1) ? 1 : bal[h + 1]); 
    int sum = c1 + c2 + mysum;
    max_ = max( max_ , sum);
}

return max_;
}



int fun2(vi& bal, int l, int h, vvi& dp){
    //low ,high
if ( l == h ){
    return ( (l == 0) ? 1 : bal[l-1] ) * bal[l] * ( ( h == bal.size() - 1) ? 1 : bal[h + 1]); 
}
if( l > h)   return 0;

if( dp[l][h] != 0){
    return dp[l][h];
}

int max_ = INT_MIN;
for ( int i = l; i <= h ; i++ ){

    int c1 = fun2( bal, l, i-1, dp);
    int c2 = fun2( bal, i+1, h, dp);

    int mysum = ( (l == 0) ? 1 : bal[l-1] ) * bal[i] * ( ( h == bal.size() - 1) ? 1 : bal[h + 1]); 
    int sum = c1 + c2 + mysum;
    max_ = max( max_ , sum);
}

dp[l][h] = max_;

return max_;
}


int main(){

vi bal {2, 4, 5, 8, 9, 2, 1, 6};
// vi bal {1, 2, 3, 4, 5};
cout<<fun( bal, 0, bal.size() - 1 )<<endl;

//memo
vvi dp( bal.size(), vi( bal.size(), 0));
cout<<fun2( bal, 0, bal.size() - 1, dp )<<endl;

//just above can do by tabulation as well

//can apply memoisation above

    return 0;
}