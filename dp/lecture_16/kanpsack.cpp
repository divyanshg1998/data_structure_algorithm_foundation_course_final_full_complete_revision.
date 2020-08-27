#include<bits/stdc++.h>
using namespace std;
#define vi vector<int>


void maxSumBounded( vi& wts, vi& price, int bag){

vector<vector<int>> dp ( wts.size() , vector<int> ( bag + 1, 0));

for( int i = 0; i < dp.size(); i++){
    for( int j = 0; j < dp[0].size(); j++){
        
    if( i == 0){
            if ( j >= wts[i]){
                dp[i][j] = price[i];
            }
        }

    else{
        int val = 0;
               int idx = j - wts[i];
                if (  idx >= 0){
                    val = dp[i - 1][idx] + price[i];  
                }
            
            dp[i][j] = max(val, dp[i-1][j]);
        }

    }
}

    for( vector<int>& arr: dp){
        for ( int arr2 : arr){
            cout<<arr2<<" ";
            }
            cout<<endl;
    }


cout<<"Ans:";
}

void maxSumUnbounded(vi& wts,vector<int>& prices, int bag){

vector<int> dp (bag + 1, 0);
dp[0] = 0;

for( int i = 0; i< wts.size(); i++){
    for ( int j = 1; j < dp.size(); j++){
        int idx = j - wts[i];
        int val = 0;
        if( idx  >= 0){
            val = prices[i] + dp[idx];
        }
        dp[j] = max(dp[j], val);
    }

    cout<<prices[i]<<" : ";
    for( int ele : dp){
        cout<<ele<<" ";
    }
    cout<<endl;
}

} 


int main(){


    vector<int> wts=
				{2,5,1,3,4};
    vector<int> price = 
            	{15,14,10,45,30};	
	int bag = 8;		

	maxSumBounded(wts,price,bag);

    //do coinchange first
    // maxSumUnbounded(wts, price, bag);

		
    return 0;
}