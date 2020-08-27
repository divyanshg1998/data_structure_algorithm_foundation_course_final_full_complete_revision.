#include<iostream>
#include<string>
using namespace std;

string keypad[]={".:;","abc","def","ghi","jkl","mno","pqrs","tuv","wx","yz","@#$","*%"};
int ctr=0;

int keypadcomb(string qu, string ans){
if(qu.length()==0){
    cout<<ans<<endl;
    return 1;
}
int ch = qu[0] - '0';
string words = keypad[ch];
int count=0; 

for( int i=0 ; i< words.length(); i++){

    count+=keypadcomb( qu.substr(1), ans+words[i] );
}

if(qu.length() >= 2){

int indx = (qu[0]-'0')*10 + (qu[1]-'0'); 

if(indx >= 10 && indx <12){

 words = keypad[indx];

for( int i=0 ; i< words.length(); i++){

    count+=keypadcomb( qu.substr(2), ans+words[i] );
}

} 

}
return count;
}


int main(){

    cout<<"possible patterns:"<<keypadcomb("845","")<<endl;

    return 0;
}