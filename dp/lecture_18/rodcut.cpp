#include<bits/stdc++.h>
using namespace std;
#define vi vector<int>

int maxvalue(vi& rod, int st, int end){

if( st == end){
    return rod[0];
}


// if( st > end)   return 0;

int max_ = INT_MIN;
for ( int i = st  ; i < end; i++){

int left  = maxvalue( rod, st, i);
int right = maxvalue( rod, i + 1, end);

int ans = left + right;

    max_= max( max_, ans);

}

max_ = max( max_, rod[end - st + 1]);

return max_;
}

int maxvalue(vi& rod, int st, int end){

if( st == end){
    return rod[0];
}


// if( st > end)   return 0;

int max_ = INT_MIN;
for ( int i = st  ; i < end; i++){

int left  = maxvalue( rod, st, i);
int right = maxvalue( rod, i + 1, end);

int ans = left + right;

    max_= max( max_, ans);

}

max_ = max( max_, rod[end - st + 1]);

return max_;
}

int rodcut2(vi& rod, int l){

if( l == 1) return rod[0];
if( l == 0) return 0;

int max_ = INT_MIN;         //Integer.MIN_VALUE;
for ( int i = 1; i <= l ; i++){
    int val = rod[i] + rodcut2(rod, l-i);
    if(val > max_){
        max_ = val;
    }
}
return max_;

}

int rodcutDP(vi& rod, int sum){


}

int main (){

vi rod{ 1, 5, 8, 9, 17, 17, 20};

cout<<maxvalue(rod, 0, rod.size() - 1)<<endl;
cout<<rodcut2(rod, 7);
// cout<<rodf(rod, 0, rod.size() - 1)<<endl;

cout<<rodcutDP(rod, 7);

return 0;
}
