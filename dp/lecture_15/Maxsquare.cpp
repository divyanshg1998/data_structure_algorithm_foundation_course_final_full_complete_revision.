#include<bits/stdc++.h>
using namespace std;

int main(){

// vector<vector<int>> arr =
//                      {{0, 1, 1, 0, 1},  
//                     {1, 1, 0, 1, 0},  
//                     {0, 1, 1, 1, 0},  
//                     {1, 1, 1, 1, 0},  
//                     {1, 1, 1, 1, 1},  
//                     {0, 0, 0, 0, 0}};


vector<vector<int>> arr =
                  {{0, 1, 1, 0, 1},  
                    {1, 1, 0, 1, 0},  
                    {0, 1, 1, 1, 0},  
                    {1, 1, 1, 1, 0},  
                    {1, 1, 1, 1, 1},  
                    {0, 0, 0, 0, 0}};

// by dp

vector<vector<int>> dp ( arr.size(), vector<int> ( arr[0].size(), 0));

for( int i = arr.size() - 1 ;  i >= 0; i--){
    for( int j = arr[0].size() - 1; j >=0 ; j--){

        if( j == arr[0].size() - 1 || i == arr.size() - 1 ){
            dp[i][j] = arr[i][j];
        }

        else if ( arr[i][j] == 1){
            dp[i][j] = min(dp[i][j+1], min(dp[i+1][j+1],dp[i+1][j])) + 1; 
        }
    // dont replace dp with arr
    }
}  

int mymax = INT_MIN;    // JAVA: Integer.MIN_VALUE
                        //min   Math.min();
                        //java lamba like syso

for( int i = 0; i < dp.size(); i++ ){
    for( int j = 0 ; j < dp[0].size(); j++){
        mymax = max( mymax, dp[i][j]); 
        cout<<dp[i][j]<<" ";
   }
   cout<<endl;
}

cout<<"ANSWER:"<<mymax;
    return 0;
}