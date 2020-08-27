#include<iostream>

using namespace std;

int ctr=0;
void perm(string ques, string ans){

if(ques.length() == 0)
{
    cout<<ans<<endl;
    ctr++;
    return;
}


for(int i=0; i < ques.length(); i++ ){
    
    char ch = ques[i];
    string str = ques.substr(0,i) + ques.substr(i+1);
      
    perm( str , ans+ch);

}

}


void perm2(string ques, string ans){

//memory mapping
//bit - masking

if(ques.length() == 0)
{
    cout<<ans<<endl;
    ctr++;
    return;
}

// int arr[26] ={0};    OTHER OPTION

//BIT MASKING
int arr = 0;

for(int i=0; i < ques.length(); i++ ){
    
    int bm = 1 << ( ques[i] - 'a');
    
    if( (arr & bm) == 0){       //ALWAYS APPLY BRACKETS FOR BIT OPERATION HERE
               
    arr = (arr | bm) ;
    char ch = ques[i];
    string str = ques.substr(0,i) + ques.substr(i+1);
      
    perm2( str , ans+ch);
    arr = (arr & (~bm));

    }

}
}


void perm3(string ques, string ans){

//memory mapping

if(ques.length() == 0)
{
    cout<<ans<<endl;
    ctr++;
    return;
}

int arr[26] = {0};

for(int i=0; i < ques.length(); i++ ){

    if(arr[ques[i] - 'a'] == 0){
        
    arr[ques[i] - 'a'] = 1;
    char ch = ques[i];
    string str = ques.substr(0,i) + ques.substr(i+1);
      
    perm2( str , ans+ch);
    arr[ques[i] - 'a'] = 0;

    }

}

}


int main(){

    // perm("abc","");
    // cout<<ctr<<endl;
    
    // ctr=0;
    // perm("abcdef","");
    // cout<<ctr<<endl;


    
    // BIT MASKING
    // ctr=0;
    // perm2("aba","");    //will use bit masking or normal memory mapping 
    // cout<<ctr<<endl;


    // MEMORY MAPPING
    // ctr=0;
    // perm3("aba","");   //will use bit masking or normal memory mapping 
    // cout<<ctr;

    
    return 0;
}


