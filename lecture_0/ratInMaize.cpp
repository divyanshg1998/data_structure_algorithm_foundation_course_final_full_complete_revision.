#include<iostream>

using namespace std;
// CAN KEEP A CTR TOO


int rinm( int sr, int sc, int dr, int dc, string str){

if(sr == dr && sc == dc ){
    cout<<str<<endl;
    return 1;
}

int count=0;

if(sr+1 <=  dr){
    count += rinm(sr+1, sc, dr, dc, str + "H"); 
}

if(sc+1 <=  dc){
    count += rinm(sr, sc+1, dr, dc, str+ "V" ); 
}

if(sr+1 <=  dr && sc+1 <=  dc){
    count += rinm(sr+1, sc+1, dr, dc, str+"D"); 
}

return count;

}


int rinm2( int sr, int sc, int dr, int dc, string str){

if(sr == dr && sc == dc ){
    cout<<str<<endl;
    return 1;
}

int count=0;

if(sr+1 <=  dr){
    count += rinm(sr+1, sc, dr, dc, str + "H"); 
}

if(sc+1 <=  dc){
    count += rinm(sr, sc+1, dr, dc, str+ "V" ); 
}

if(sr+1 <=  dr && sc+1 <=  dc){
    count += rinm(sr+1, sc+1, dr, dc, str+"D"); 
}

return count;
}


int main(){

// refer floodfill
    //ratInMaize or mazepath problem
    
    cout<<rinm(0,0,2,2,"");

    // cout<<rinm2(0,0,5,5,"");

    return 0;
}