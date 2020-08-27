#include<bits/stdc++.h>
using namespace std;

int main(){

vector<vector<int>> arr{{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};

int rmin = 0, rmax = arr.size() - 1, cmin = 0, cmax = arr.size() - 1, ctr = 0;

while( ctr < arr.size() * arr[0].size()){

for ( int i = cmin; i <= cmax ; i++){
        cout<<arr[rmin][i]<<" ";
        ctr++;
}
rmin++;

for( int i = rmin; i <= rmax; i++){
        cout<<arr[i][cmax]<<" ";
        ctr++;
}
cmax--;

for( int i = cmax ; i >= cmin; i--){
        cout<<arr[rmax][i]<<" ";
        ctr++;
}
rmax--;

for( int i = rmax ; i >= rmin; i--){
        cout<<arr[i][cmin]<<" ";
        ctr++;
}
cmin++;

}



    return 0;
}