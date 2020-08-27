#include<bits/stdc++.h>

using namespace std;

int ctr1=0;
int nQueensComb(int qno, int bno, int tnq , int tnb, string str ){
    if( qno == tnq){
        cout<<++ctr1<<str<<endl;
        return 1;
    }

    int count=0;

    for(int i = bno; i <= tnb ; i++ ){
        count+= nQueensComb(qno+1, i+1, tnq, tnb, str + "q" + 
                        to_string(qno)+"b"+to_string(i)+" " );
    }


return count;
}


int ctr2=0;
int nQueensPerm(int qno, int tnq , int tnb, string str
                             , vector<bool>& truth){
    if( qno == tnq){
        cout<<++ctr2<<" "<<str<<endl;
        return 1;
    }

    int count=0;

    for(int i = 0; i < tnb ; i++){
        if(truth[i] == false){
        truth[i]=true;
        count += nQueensPerm(qno+1, tnq, tnb, str + "q" + 
                        to_string(qno)+"b"+to_string(i)+" ", truth );
        truth[i]=false;
    }
    }

return count;
}



int ctr=0;
int nanqc(int qno, int bno, int tnq , int tnb, string str ){
    if( qno == tnq){
        cout<<++ctr<<str<<endl;
        return 1;
    }

    int count=0;

    for(int i = bno; i <= tnb ; i++ ){
        int r = i/4;
        int c = i%4;

        count+= nanqc(qno+1, i+1, tnq, tnb, str + "q" + 
                        to_string(qno)+" "+"r"+to_string(r)+"c"+to_string(c)+" " );
    }


return count;
}


bool isSafeToPlace(vector<vector<bool>>& tru, int r, int c){

int xdir[4] = {0, -1, -1, -1};
int ydir[4] = {-1, -1, 0, 1};

for(int rad = 1; rad < max(tru.size(), tru[0].size()); rad++ ){

    for( int d = 0; d <= 3; d++){
        int nr = r + xdir[d] * rad;
        int nc = c + ydir[d] * rad;     

        if( nr>=0 && nr<tru.size() && nc >=0 && nc < tru[0].size() && 
                                            tru[nr][nc] == true    )
            return false;                                           
    }
 }
       return true;   
}

int NQueensCutComb( int bno, int qno, string str, vector<vector<bool>>& tru ){
    if( qno == 0 || bno == tru.size() * tru[0].size() ){
        if(qno==0){
        cout<<++ctr<<str<<endl;
        return 1;
    }
    return 0;
}
    int count=0;

    for(int i = bno; i < tru.size() * tru[0].size() ; i++ ){
        int r = i/4;
        int c = i%4;

            if(isSafeToPlace(tru, r, c)){
            tru[r][c] = true;
            count+= NQueensCutComb( i+1, qno-1, str + "q" + 
                        to_string(qno)+" "+"r"+to_string(r)+"c"+to_string(c)+" " , tru);
            tru[r][c] = false;            
    }
}

return count;
}


int nqccb( int bno, int qno, string str, vector<vector<bool>>& tru ){

     if( qno == 0 || bno == tru.size() * tru[0].size() ){
        if(qno==0){
        cout<<++ctr<<str<<endl;
        return 1;
    }
    return 0;
    }

        int r = bno/4;
        int c = bno%4;
        int count=0;
  
  if(isSafeToPlace(tru, r, c)){
                tru[r][c] = true;    
       count+=nqccb(bno+1 , qno-1, str+  "q" + 
                    to_string(qno)+" "+"r"+to_string(r)+"c"+to_string(c)+" " , tru);
                tru[r][c] = false;            
    }

       count+=nqccb(bno+1 , qno, str , tru);      

return count;
}



int main(){

// cout<<nQueensComb( 0, 1, 2, 4, "" );
// vector<bool> truth( 4, false);
// cout<<nQueensPerm( 0, 2, 4, "", truth );


// cout<<nanqc( 0, 1, 4, 16, "");// NandNQueensComb == nanqc



vector<vector<bool>> tru(4, vector<bool>(4,false)); 
ctr=0;

// cout<<NQueensCutComb( 1, 4, "", tru);

vector<vector<bool>> tru1(4, vector<bool>(4,false)); 
ctr=0;


// cout<<nqccb( 0, 4, "", tru1);// NQueensCutCombBinary== nqccb



//case of typecasting
    string str = "";
    int i=4;
    str += ('a' + i);
    cout<<str<<endl;

    int arr[97] ={0};
    arr['a' - 1] = 1;
    cout<<arr['a' - 1];

return 0;

}