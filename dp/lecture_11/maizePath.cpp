#include<bits/stdc++.h>
using namespace std;

vector<int> dir1= {1 , 0, 1};
vector<int> dir2 = {0, 1, 1};

int calls = 0;
int mp( int sr, int sc, int dr, int dc){

if ( sr == dr && sc == dc)
{
    return 1;
    }
    
    int count =0;
    
    for( int i = 0; i < dir1.size(); i++ ){
    int nr = sr + dir1[i];
    int nc = sc + dir2[i];

    if( nr <= dr && nc <= dc )
    {
        //have to apply an isValid here if upward or backward movement
        // here only positive movement
        count+=mp( nr, nc, dr, dc);
    }
    
}
calls++;
return count;
}

int calls1 = 0;
vector<vector<int>> ndir1=
                    {{ 0, 1, 1},
                    { 1, 1, 0}};

int mpDP( int sr, int sc, int dr, int dc, vector<vector<int>>& dp){

if ( sr == dr && sc == dc)
{
    dp[sr][sc] = 1;
    return 1;
    }
    
if( dp[sr][sc] != 0){
    return dp[sr][sc];
}

//reactive
if( dp.size() == dp[0].size() && dp[sc][sr] != 0){
     return dp[sc][sr];    
}

    int count =0;
    
    for( int i = 0; i < ndir1[0].size(); i++ ){
    int nr = sr + ndir1[0][i];
    int nc = sc + ndir1[1][i];

    if( nr <= dr && nc <= dc )
    {
        count+=mpDP( nr, nc, dr, dc, dp);
    }    

}

dp[sr][sc] = count;

//proactive
if( dp.size() == dp[0].size() && dp[sc][sr] == 0){
     dp[sc][sr] = dp[sr][sc];    
}


calls1++;
return count;
}



vector<vector<int>> ndir2=
                    {{0,1},{1,1},{1,0}};



int mpDP_MM( int sr, int sc, int dr, int dc, vector<vector<int>>& dp){

// FOR MULTI-MOVE 
//     we will run another for loop containing the radius for the function and we check
//     if the nrew and ncol is in our given range or not.
//     loop of radius till size of box


if ( sr == dr && sc == dc)
{
    dp[sr][sc] = 1;
    return 1;
    }
    
if( dp[sr][sc] != 0){
    return dp[sr][sc];
}

if( dp.size() == dp[0].size() && dp[sc][sr] != 0){
     return dp[sc][sr];    
}

    int count =0;

    for( int i = 0; i < ndir2.size(); i++ ){
    //extra
    for( int rad = 1; rad <= dp.size() ; rad++){ 
    int nr = sr + ndir2[0][i] * rad;
    int nc = sc + ndir2[1][i] * rad;

    if( nr <= dr && nc <= dc )
    {
        count+=mpDP_MM( nr, nc, dr, dc, dp);
    }    

    else break;
}

}

dp[sr][sc] = count;

if( dp.size() == dp[0].size()){
     dp[sc][sr] = dp[sr][sc];    
}

return count;
}


vector<vector<int>> ndir4=
                    {{0,1},{1,1},{1,0}};

void mpDP_TAB( int sr, int sc, int dr, int dc){

    vector<vector<int>> mp( dr+1, vector<int>( dc+1, 0) );

   for( int i = dr; i>=0; i--){
        for( int j = dc ; j >=0 ; j--){
        
        if(i == dr && j == dc)
            mp[i][j] = 1;

    else{
    
        for( int ii = 0 ; ii < ndir4.size() ; ii++ ){
            for(int rad = 1 ; rad < mp.size() ; rad++){

                int nr = i + ndir4[ii][0] * rad;
                int nc = j + ndir4[ii][1] * rad;

                if( nr <= dr && nc <= dc){
                    mp[i][j] += mp[nr][nc];
                }
            }
        }
                
        }
    }
   
   }
   
for( vector<int>& arr: mp){
    for( int ele: arr){
        cout<<ele<<" ";        
    }
    cout<<endl;
}

}

int main(){
// maizepath by dp , tabulation

cout<<mp(0 ,0 , 2, 2)<<endl; 

int n=2;
vector<vector<int>> v(n+1, vector<int>(n+1,0));
cout<<mpDP(0, 0, 2, 2, v)<< endl;

for( vector<int>& arr: v){
    for( int ele: arr){
        cout<<ele<<" ";        
    }
    cout<< endl;
}


// multi move
// jumps allowed here, so thats it.
cout<<"============="<<endl;
int n1=3;
vector<vector<int>> v3(n1+1, vector<int>(n1+1, 0));
cout<<mpDP_MM(0, 0, n1, n1, v3)<< endl;

for( vector<int>& arr: v3){
    for( int ele: arr){
        cout<<ele<<" ";        
    }
    cout<< endl;
}

//tabulation, best and easiest here

//BEST WAY 
//TABULATION

cout<<"============="<<endl;
int n2=2;
vector<vector<int>> v4(n2+1, vector<int>(n2+1, 0));

mpDP_TAB(0, 0, n2, n2);

    return  0;
}