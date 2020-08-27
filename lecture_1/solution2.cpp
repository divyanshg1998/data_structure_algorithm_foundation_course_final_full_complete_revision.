#include<bits/stdc++.h>
using namespace std;


#define vi vector<int> 
#define vb vector<bool>
#define vvb vector<vector<bool>>
#define vvi vector<vector<int>>

int nqueenperm(int box, int q, int qp, string str, vb& tru){

 if( qp == q){
    cout<<str<<endl; 
    return 1;
 }

int n = 0;
for( int i = 0 ; i < box; i++) {

    if( !tru[i] ){
    tru[i] = true;
    n += nqueenperm(box, q, qp + 1,  str + " b" + to_string(i) + " q" + to_string(qp), tru);
    tru[i] = false;
}

}

return n;
}


int nqueencomb(int box, int q, int qp, int bno, string str){

 if( qp == q || bno == box){
   
       if( qp == q){
    cout<<str<<endl; 
     return 1;
   }

 return 0;
 }

int n = 0;

for( int i = bno; i < box; i++) {

    n += nqueencomb(box, q, qp + 1, i + 1, str + " b" + to_string(i) + " q" + to_string(qp));
}

return n;
}

vvi dir = {{0,-1},{-1,-1},{-1,0},{-1,+1}};

bool isSafe(vvb& tru, int r, int c ){

for ( int i = 0 ; i < dir.size(); i++){
    for( int rad = 1; rad < tru.size(); rad ++){
            int nr = r + dir[i][0] * rad;
            int nc = c + dir[i][1] * rad;
        
        if( nr >= 0 && nc >= 0 && nr < tru.size() && nc < tru.size()
          && tru[nr][nc] == true){
              return false;
        }        
    }    
}
return true;

}

int count1 = 0 ;
void nqueencomb2(int box, int q, int qp, int bno, string str, vvb& boxes){

 if( qp == q || bno == box){
      if( qp == q){
        cout<<str<<endl;        
          count1++;
           }
  return;
}

int n = 0;

for( int i = bno; i < box; i++) {
    int r = i / q;
    int c = i % q;

    if( isSafe(boxes, r, c) ) {
    boxes[r][c] = true;   
     nqueencomb2(box, q, qp + 1, i + 1, str +  " q" + to_string(qp) +" r" + to_string(r) + "c" + 
                                 to_string(c) , boxes);
    boxes[r][c] = false;
}
}
}

int main(){

    vb v(5, false);

    cout<<nqueenperm( 3, 2, 0, "", v)<<endl;

    // cout<<nqueencomb( 3, 2, 0, 0, "")<<endl;

    vi v3(5, 0);
    
    // cout<<nqueencomb(16, 4, 0, 0, "");
    
    vvb v4(4, vb(4, false));
    nqueencomb2( 16, 4, 0, 0, "", v4); 
    cout<<count1;
    
    
    

    
    return 0;

}
