#include<bits/stdc++.h>
using namespace std;
#define vvi vector<vector<int>>
#define  vi vector<int>
#define vb vector<bool>
#define vvb vector<vector<bool>>


vvb pal2( string str){

        vvb dp( str.length(), vb( str.length(), false));    
       
        for(int gap = 0 ; gap < dp[0].size(); gap++ ){
            for( int i = 0 , j = gap; j < dp[0].size(); j++, i++){
                if( gap == 0){
                    dp[i][j]= true;                     
                     }
                else if ( str[i] == str[j]){
                    if( dp[i+1][j-1]  == true){
                          dp[i][j] = true;
                        }
                else {
                        dp[i][j] = false;                    
                        }
                    }
                 else {
                    dp[i][j] = false;                    
                    }
            }
        }

    return dp;
    }
    
int fun(string str, int beg, int end, vvb dp){

if( beg == end || dp[beg][end])
{
    return 0;
}

int min_ = INT_MAX;
for( int cut = beg; cut < end; cut++ ){
    int left = fun( str, beg, cut, dp);
    int right = fun( str, cut + 1, end, dp);

    int ans = left + right + 1;
    if( ans < min_ ){
        min_ = ans;
    }    
}

return (min_ + 1);

}



int main(){

    string str = "abccbc";
    vvb pal1 = pal2(str);
    // vvb pal( str.length(), vb( str.length(), false)); 

    fun(str, 0, str.length() - 1, pal1);
    //memo
    
    vvi dp(str.length(),vi(str.length(),0));
    // fun2(str, 0, str.length() - 1, );


    return 0;
}