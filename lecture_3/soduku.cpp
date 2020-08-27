#include<bits/stdc++.h>
//#include<vector>

using namespace std;

bool isSafeToPlaceNo( vector<vector<int>> &boxes , int r, int c, int num )
{

    for(int i = 0; i < 9 ; i++){
        if(boxes[i][c] == num){
            return false;
        }
    }

    for(int j = 0; j < 9 ; j++){
        if(boxes[r][j] == num){
            return false;
        }
    }

        int ii = (r/3) * 3;
        int jj = (c/3) * 3;

    for(int x = 0 ; x < 3 ; x++){
        for( int y = 0 ; y < 3; y++ ){

            if(boxes[ii + x ][ jj + y] == num){
                return false;
            }
        }
    }

    return true;
}

int ctr=0;
void soduku( vector<vector<int>> &grid, int idx){

if( idx == grid.size() * grid[0].size()){

  cout<<"-------"<<++ctr<<"------"<<endl;
  
    for(int i=0; i < grid.size() ;i++ ){
        for(int j=0 ; j < grid[0].size(); j++){
            cout<<grid[i][j]<<"\t";
        }
        cout<<endl;
    }

    return;

}

int r = idx / 9;
int c =  idx % 9;

// if( grid[r][c] != 0){

//     soduku( grid, idx +1);
// }

//to decrease the height of the the tree
while( grid[r][c] != 0 && !(r == 8 && c == 7))
{
    idx = idx + 1;
    r = idx/9;
    c = idx % 9;
 
 }

if( grid[r][c] == 0){

  for(int i=1 ; i<= 9; i++){
   
    if(isSafeToPlaceNo(grid, r, c , i ))
    {
    
    grid[r][c] = i; //place 

    soduku( grid, idx +1);

    grid[r][c] = 0; // unplace 

    }
}

}

}


void SodukuSubseq(vector<vector<int>>& grid, int box, int num){


if( box == grid.size() * grid[0].size()) {

  
  cout<<"-------"<<++ctr<<"------"<<endl;
    for(int i=0; i < grid.size() ;i++ ){
        for(int j=0 ; j < grid[0].size(); j++){
            cout<<grid[i][j]<<"\t";
        }
        cout<<endl;
    }
  
    return;
}


int r = box / 9;
int c = box % 9;

if( grid[r][c] != 0){
    SodukuSubseq( grid, box + 1, 1 );
}

// while( grid[r][c] != 0){
// {
//     idx = idx + 1;
    //    r = idx/9;     

// }

if( grid[r][c] == 0){

  if(isSafeToPlaceNo(grid, r, c , num ))
    {
    
    grid[r][c] = num;
    SodukuSubseq( grid, box + 1, 1);
    grid[r][c] = 0;

    }
    
if( num + 1 < 10)
    SodukuSubseq( grid, box , num + 1);

//proactive call only
//otherwise many cases
}

}



int ctr4=0;

void SodukuBitMasking2( vector<vector<int>> &grid, int box){

if( box == grid.size() * grid[0].size()){

  cout<<"-------"<<++ctr4<<"------"<<endl;
  
    for(int i=0; i < grid.size() ;i++ ){
        for(int j=0 ; j < grid[0].size(); j++){
            cout<<grid[i][j]<<"\t";
        }
        cout<<endl;
    }
    return;
}


int r = box / 9;
int c = box % 9;

if( grid[r][c] != 0){

    SodukuBitMasking2( grid, idx +1 );
}

// while( grid[r][c] != 0){
// {
    //    r = idx/9;     

// }

if( grid[r][c] == 0){
int bm;
  for(int i=1 ; i<= 9; i++){
     bm = 1 << i ; 
    if( (rarr[r] & bm == 0) & (carr[c] & bm == 0) & (subMat[r/3][c/3] & bm ==0) ){


//we use xor bcz we konw what is there and we can also just have to reverse it 
   
            rarr[r] ^ = bm;
            carr[c] ^ = bm;
            subMat[r/3][c/3] ^ = bm;
       
            grid[r][c] = i;
        //PLACE IT 
            soduku( grid, idx +1);
        // UNPLACE IT    
            grid[r][c] = 0;
            rarr[r] ^ = bm;
            carr[c] ^ = bm;
            subMat[r/3][c/3] ^ = bm;
   
    }
}
}

}

vector<int> rarr ( 9 , 0);
vector<int> carr ( 9 , 0);
vector<vector<int>> subMat ( 3,vector<int>(3,0));

void SodukuBitMasking1(vector<vector<int>>& grid){

int bm;
for(int i = 0; i < grid.size(); i++){
    for(int j = 0; j < grid[0].size() ; j++){
        bm = 1 << grid[i][j];
        if(grid [i][j] != 0){
            rarr[i]|= bm;
            carr[j]|= bm;
            subMat[i/3][j/3] |= bm;
        }
    }
}

SodukuBitMasking2(grid, 0);

}

int main(){

vector<vector<int>> grid= {{3, 0, 6, 5, 0, 8, 4, 0, 0},  
                      {5, 2, 0, 0, 0, 0, 0, 0, 0},  
                      {0, 8, 7, 0, 0, 0, 0, 3, 1},  
                      {0, 0, 3, 0, 1, 0, 0, 8, 0},  
                      {9, 0, 0, 8, 6, 3, 0, 0, 5},  
                      {0, 5, 0, 0, 9, 0, 6, 0, 0},  
                      {1, 3, 0, 0, 0, 0, 2, 5, 0},  
                      {0, 0, 0, 0, 0, 0, 0, 7, 4},  
                      {0, 0, 5, 2, 0, 6, 3, 0, 0}};


soduku( grid, 0);


// // BY BINARY OR SUBSEQUANCE 
// SodukuSubseq( grid, 0, 1);

SodukuBitMasking1(grid);

    return 0;
}

