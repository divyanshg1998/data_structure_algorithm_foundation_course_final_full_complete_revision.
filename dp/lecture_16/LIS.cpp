#include<bits/stdc++.h>
using namespace std;

int fun(vector<int>& arr){
    
    if( arr.size() == 0)      return 0;

    else
    {
    vector<int> dp( arr.size(), 1);
    dp[0] = 1;
   
     int max_ = 1;
     for( int i = 1; i < arr.size(); i++){
         
         for( int j = i - 1; j >= 0 ; j--){
         
             if( arr[j] < arr[i] && dp[j] + 1 > dp[i] ){
                 dp[i] = dp[j] + 1;
                 max_ =  max(max_, dp[i]);
                     }
         
            }
     }
        
     for( int ele : dp){
         cout<<ele<<" ";
     }cout<<endl;

    return max_;   

    }
}


int LIS_(vector<int> &arr)
{
    vector<int> list;
    list.push_back(arr[0]);

    int len = 1;
    for (int i = 1; i < arr.size(); i++)
    {
        if (arr[i] > list[len - 1])
        {
            list.push_back(arr[i]);
            len++;
            cout<<"1 ";
            
        for( int i = 0 ; i < list.size(); i++){
            cout<<list[i]<<" ";
        }cout<<endl;

        }

        else
        {
            int li = 0;
            int ri = len - 1;
                while (li <= ri)
                {
                int mid = (li + ri) / 2;    
                if (list[mid] < arr[i])
                    li = mid + 1;
                else
                    ri = mid;
            }
            list[ri] = arr[i];
        
        cout<<"2 ";
            
        for( int ele : list){
            cout<<ele<<" ";
        }cout<<endl;

        }

    }
    return len;
}

int main(){

    // vector<int> arr={10,22,9,33,21,50,41,60,80,1};
    vector<int> arr = {10,9,2,5,3,7,101,18};
    // vector<int> arr = { 50, 51, 52, 53, 1, 2, 3, 4, 5, 6};
    
    int a = 1e6;
    cout<<a<<endl;
    
    // cout<<fun(arr)<<endl;

    cout<< LIS_(arr) << endl;

    return 0;
}