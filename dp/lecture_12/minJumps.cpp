#include<bits/stdc++.h>
using namespace std;
#define vi vector<int>
#define vvi vector<vector<int>>
#define vs vector<string>

vector<int> minJumps(vector<int>& arr){

vector<int> strg(arr.size(),0);

for ( int i = strg.size() - 2; i >= 0; i-- ){
    
    int minval = strg.size();
for( int j = 1 ; j <= arr[i] && i + j < strg.size(); j++){
    minval = min( minval, strg[i + j]);
}
    strg[i] = minval+1; 
}
        // dp array is being used // silly mistake
        // case of zero also handled here

for( int str: strg){
    cout<<str<<" ";
}
cout<<endl;


if( strg[0] < strg.size())    cout<<strg[0]<<endl;
else    cout<<"-1"<<endl;


    return strg;
}

vs minPath(vi& myarr, vi& arr,int idx){

if( idx == myarr.size() - 1){
vs v2  {to_string(idx)};
return v2;
}

vs v ;

    for( int j = idx + 1; j <= idx + myarr[idx]; j++){
        if( arr[j] == arr[idx] - 1){
            vs nv = minPath(myarr, arr, j);
            for( int k = 0; k < nv.size(); k++){
            v.push_back( to_string(idx) + nv[k] );
        }
    }
    }
    
return v;
}

int jump(vector<int>& arr) {
    if(arr.size() == 1)     return 0;
        
    else      return minStepsGreedy( arr, 0);
    }

    
int minStepsGreedy(vector<int>& arr, int idx){

if( arr[idx] == 0)         return 0;

    int maxJumpSize = 0;
    int jump = 0;


for( int i = 1; i <= arr[idx]; i++){
    
    if( arr[idx] + idx >= arr.size() - 1){   
        return 1;
    }    

    else if( idx + i < arr.size() && arr[idx + i] + i > maxJumpSize ){
        maxJumpSize = arr[idx + i] + i;
        jump = i;
    }

}

int val = minStepsGreedy(arr, jump + idx);
if( val == 0 )     return 0;
else    return val+1;

}



int main(){
    
//tabulation
vector<int> arr = {1, 3, 0, 4, 0, 0, 2, 1, 1, 0};

// vector<int> arr = {4, 3, 0, 1, 2, 3, 1, 2, 3};

vector<int> strg = minJumps(arr);

for( int num: strg)
{
    cout<< num<< " ";
}cout<<endl;


//or all possible ways to go from start to the end too
//we store all possible paths in the tabulation
//in each element


//find the minimum steps path 

cout<<"========"<<endl;
vs v = minPath(arr, strg, 0);
for( string str: v){
    cout<<str<<endl;
}
//not by tabulation here

//greedy approach
cout<<"=========="<<endl;
cout<<endl<<jump(arr)<<endl;
   
    return 0;
}