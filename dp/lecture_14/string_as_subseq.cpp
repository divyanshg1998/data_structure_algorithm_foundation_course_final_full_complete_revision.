#include<bits/stdc++.h>
using namespace std;

int find(string str1, string str2){

    if( str2 == ""){
        return 1;
    }

    if(str1 == ""){
        return 0;
    }

    if( str1[0] == str2[0]){
       return  find( str1.substr(1), str2.substr(1))
                + find(str1.substr(1), str2);
        
    }
    else 
    return find(str1.substr(1), str2);

}

int findDP(string str1, string str2){

vector<vector<int>> dp ( str1.length() + 1,( vector<int>( str2.length() + 1 , 0)));

for( int i = dp.size() -1; i>=0 ; i-- ){
    for(int j = dp[0].size() - 1; j >= 0; j-- ){
        if( i == dp.size() - 1 && j == dp[0].size() - 1){
            dp[i][j] = 1;
        }

        else if( i == dp.size() - 1){
            dp[i][j] = 0;
        }

        else if( j == dp[0].size() - 1){
            dp[i][j] = 1;
        }

        else{
            if( str1[i] == str2[j]){
                dp[i][j] = dp[i+1][j] + dp[i+1][j+1]; 
            }
 
            else{
                dp[i][j] = dp[i+1][j];
            }

        }

    }

}

return dp[0][0];
}

int main(){

    string str1 = "ageeksforgeeks";
    string str2 = "gks";

    cout<<find(str1, str2)<<endl;

    cout<<findDP(str1, str2)<<endl;



    return 0;
}