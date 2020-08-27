#include<bits/stdc++.h>

using namespace std; 


int fun( vector<vector<int>>& v, int r, int c ){

if( r == v.size() - 1 && c == v[0].size() - 1 ){
    return v[r][c];
}

//just 2 calls therefore no dir arr

int count = 1e+8;

if( c+1 <= v[0].size() -1){
    count = min(count , fun( v, r , c+1 )); 
}

if( r+1 <= v.size() - 1){
   count = min(count , fun( v, r+1 , c )); 
} 

if( c+1 <= v[0].size() && r+1 <= v.size() - 1 ){
    count = min(count , fun( v, r+1 , c+1 )); 
}


return  count + v[r][c];

}


int funMemorization( vector<vector<int>>& v, int r, int c ){

if( r == v.size() - 1 && c == v[0].size() - 1 ){
    return v[r][c];
}

vector<vector<int>> dp ( v.size(), vector<int> (v[0].size(),0) ); 

if ( dp[r][c] != 0){
    return dp[r][c]; 
}

// if( dp.size() == dp[0].size() && dp[c][r] != 0){
//      return dp[c][r];    
// }

//just 2 calls therefore no dir arr

int count = 1e+8;

if( c+1 <= v[0].size() -1){
    count = min(count , fun( v, r , c+1 )); 
}

if( r+1 <= v.size() - 1){
   count = min(count , fun( v, r+1 , c )); 
} 

if( c+1 <= v[0].size() && r+1 <= v.size() - 1 ){
    count = min(count , fun( v, r+1 , c+1 )); 
}

dp[r][c] = count;

return  count + v[r][c];

}


vector<vector<int>> ndir3 = {{0,1},{1,1},{1,0}};

int funTabulation(vector<vector<int>>& v){
vector<vector<int>> dp(v.size() , vector<int>( 0, v[0].size()));

for( int i = v.size() -1 ; i >= 0; i--){
    for( int j = v[0].size() - 1; j >= 0; j--){
        if( i == v.size() - 1 && j == v[0].size() - 1){
            dp[i][j] = v[i][j];
        }

        else{
            int val = INT_MAX;  // JAVA    val = Integer.MAX_VALUE;  BADDA NAAM
         
         for( int ii = 0; ii < ndir3.size(); ii++ ){
            int nr = i + ndir3[ii][0];
            int nc = j + ndir3[ii][1];

            if ( nr <= v.size() && nc <= v[0].size()){
                val = min( v[nr][nc], val); // java Math.min()   BADDA NAAM
            }
            
            }

            dp[i][j] = v[i][j] + val;           

         }
        }

    }
    
return dp [0][0];
}


int main(){

vector<vector<int>> v ={ 
        { 2, 3, 0, 4},
        { 0, 6, 5, 2},
        { 8, 0, 3, 7}};
//3 movements allowed here

//find minimum value path for the above

//recursion function
// that is memorisation
cout<<fun(v, 0, 0)<<endl;

// cout<<funMemorization(v, 0, 0)<<endl;

// cout<<funTabulation(v)<<endl;

//tabulation
    

    
    return 0;
    }

