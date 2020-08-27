#include<bits/stdc++.h>
using namespace std;

string str1 = "send";
string str2 = "more";
string str3 = "money";

vector<int> mapCharToNumber(26, 0);
vector<bool> numberUsed(10, false);

int stringToNumb( string str){
    int sum=0; 
    for(int i = 0; i < str.length() ; i++){
        sum = sum*10 + mapCharToNumber[str[i] - 'a'];
    }
     return sum;
}

int ctr3=0;
void crypto2(string str, int indx){

if(indx == str.length()){

    int num1 = stringToNumb(str1);
    int num2 = stringToNumb(str2);
    int num3 =  stringToNumb(str3);

    // cout<<++ctr3<<endl<<stringToNumb(str1)<<endl<<
    // stringToNumb(str2)<<endl<<stringToNumb(str3)<<endl<<"----"<<endl;

    if( num1 + num2 == num3 && mapCharToNumber(str3[0] - 'a') ){

    cout<<++ctr3<<endl<<stringToNumb(str1)<<endl<<
    stringToNumb(str2)<<endl<<stringToNumb(str3)<<endl<<"----"<<endl;
}

    return;
}

for(int i=9 ; i >= 0 ; i-- ){

        int indx2 = str[indx];
        
        if(numberUsed[i] == false){
        
        mapCharToNumber[indx2 - 'a'] = i;
        numberUsed[i] = true;    
        crypto2(str, indx+1);
        numberUsed[i] = false;
        mapCharToNumber[indx2 - 'a'] = 0;
        }
}

}



void crypto()
{

vector<int> freqmap(26,0);
string str =str1 + str2 + str3;

cout<<str<<endl;

for(int i = 0; i < str.length(); i++){
    freqmap[str[i] - 'a']++;
}


// for(int i=0; i< freqmap.size() ; i++){
//     cout<< freqmap[i]<<"\t";
// }

string str2="";
for( int i = 0; i < 26; i++){
    if( freqmap[i] != 0 ){
        str2 += ('a' + i);
    }  
}

cout<<str2<<endl;;

crypto2( str2, 0);

}

int main(){

    crypto();
    return 0;
}

