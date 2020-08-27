#include<bits/stdc++.h>
using namespace std;

#define vi vector<int>
#define vvi vector<vector<int>>

int mat( vector<int>& arr, int beg, int end){

if( beg + 1 == end){
    return 0;
}

int min_ = INT_MAX;//JAVA LAMBA LIKE SYSO 
                    //Integer.Max_Value;

for( int i = beg + 1; i < end ; i++){

int left = mat( arr, beg, i);
int right = mat( arr, i, end);
int myans = arr[beg] * arr[i] * arr[end];   

int ans = left + myans + right; 
if( ans < min_){
    min_ = ans;
}
}

return min_;
}


int mat2( vector<int>& arr, int beg, int end, vector<vector<int>>& dp){

if( beg + 1 == end){
    return 0;
}

int min_ = INT_MAX;//JAVA LAMBA LIKE SYSO 
                    //Integer.MAX_VALUE;

if( dp[beg][end] != 0){
    return dp[beg][end];
}

for( int i = beg + 1; i < end ; i++){

int left = mat2( arr, beg, i, dp);
int right = mat2( arr, i, end, dp);
int myans = arr[beg] * arr[i] * arr[end];   

int ans = left + myans + right; 
if( ans < min_){
    min_ = ans;
}
}

dp[beg][end] = min_;

return min_;
}

int dp3(vi& arr){

vvi dp2(arr.size(), vi(arr.size(),0));

for( int gap = 2 ; gap < dp2[0].size(); gap++ ){
    for( int i = 0, j = gap; j < dp2[0].size(); i++, j++){

        int min_ = INT_MAX;     //Integer.MAX_VALUE
        for( int cut = i + 1 ; cut <= j - 1; cut++ ){
            int left =  dp2[i][cut];
            int right = dp2[cut][j];

            int multi = arr[i] * arr[cut] * arr[j];

            int ans = left + right + multi;
            if(ans<min_){
                min_ = ans;
            }
        }
    dp2[i][j] = min_;
    }
}

for( vi arr1: dp2){
    for( int ele: arr1){
        cout<<ele<<"\t";
    }
    cout<<endl;
}

return dp2[0][dp2[0].size() - 1]; 
 
}

int dpToString(vi& arr){

vvi dp2(arr.size(), vi(arr.size(),0));

for( int gap = 2 ; gap < dp2[0].size(); gap++ ){
    for( int i = 0, j = gap; j < dp2[0].size(); i++, j++){

        int min_ = INT_MAX;     //Integer.MAX_VALUE
        for( int cut = i + 1 ; cut <= j - 1; cut++ ){
            int left =  dp2[i][cut];
            int right = dp2[cut][j];

            int multi = arr[i] * arr[cut] * arr[j];

            int ans = left + right + multi;
            if(ans<min_){
                min_ = ans;
            }
        }
    dp2[i][j] = min_;
    }
}

vector<vector<string>> dp5(arr.size(), vector<string>(arr.size(), ""));

for( int gap = 0 ; gap < dp5[0].size(); gap++ ){
    for( int i = 0, j = gap; j < dp5[0].size(); i++, j++){

        if( gap == 0 ){
            char ch = ('A' + i);
            dp5[i][j] = to_string(ch); //to_string is only used for int
               
                // to_string
        }            
        if( gap== 1)

        int min_ = INT_MAX;     //Integer.MAX_VALUE
        for( int cut = i + 1 ; cut <= j - 1; cut++ ){
            int left =  dp5[i][cut];
            int right = dp5[cut][j];

            int multi = arr[i] * arr[cut] * arr[j];

            int ans = left + right + multi;
            if(ans<min_){
                min_ = ans;
            }
        }
    dp5[i][j] = min_;
    }
}



return dp5[0][dp5[0].size() - 1]; 
 
}


int main(){

    vector<int> arr ={40, 20, 30, 10, 30};   
    cout<<mat(arr, 0, arr.size()-1)<<endl;

//memo
    vector<vector<int>> dp( arr.size(),vector<int>(arr.size(),0));
    cout<<mat2(arr, 0, arr.size()-1, dp)<<endl;

    cout<<dp3(arr)<<endl;

   //to find the string showing the matrix 
   //cant do it by memorisation
    vector<vector<string>> dp4( arr.size(),vector<string>(arr.size(),""));
   //dp
    
    // cout<<dpToString(arr)<<endl;



    return 0;
}
