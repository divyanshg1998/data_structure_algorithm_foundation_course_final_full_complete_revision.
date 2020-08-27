#include<bits/stdc++.h>

using namespace std;

void multiply(vector<vector<long long>>& a,vector<vector<long long>>& b){

long long a0 = a[0][0] * b[0][0] + a[0][1] * b[1][0];
long long a1 = a[0][0] * b[0][1] + a[0][1] * b[1][1];
long long a2 = a[1][0] * b[0][0] + a[1][1] * b[1][0];
long long a3 = a[1][0] * b[0][1] + a[1][1] * b[1][1];

a[0][0] = a0;
a[0][1] = a1;
a[1][0] = a2;
a[1][1] = a3;

}

void power(vector<vector<long long>>& a,vector<vector<long long>>& I, int n){

if( n==1 ){
return;
}

power(a,I,n/2);
multiply(a,a);

//use brackets for binay and ternury operator too

if( (n&1) == 1){  
multiply(a,I);
}

// int i = 1;
// (n&1) ? multiply(a,I) : i++ ; 
// can use ternury only when have both conditions

}

int main(){

    vector<vector<long long>> a {{1,1},{1,0}};
    vector<vector<long long>> I {{1,1},{1,0}};
 
    int n = 5;  
    
    // handle case 0 must
    if ( n == 0 ){    
    cout<<1;
    }

    else{
    power(a,I,n);
    cout<<a[0][1];    
    }

    return 0;
}