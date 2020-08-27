#include<iostream>

using namespace std;
void getss(string ques, string ans){

    if(ques.length() == 0){
        cout<<ans<<endl;
        return;
    }

    char ch = ques[0];

    getss(ques.substr(1),ans+ch); //1
    getss(ques.substr(1),ans); //0 
}

int ctr = 0; 
void getss2(string ques, string ans){

    if(ques.length() == 0){
        cout<<ans<<endl;
        ctr++;return;
    }


    char ch = ques[0];
    getss2(ques.substr(1),ans+ch);
    int val = int(ch);
    getss2(ques.substr(1),ans + to_string(val) );
    getss2(ques.substr(1),ans); 

}

int main(){

    //void type , binary way
    // getss("abc","");
    getss2("abc","");
    cout<<"ANSWERS"<<ctr;

    return 0;
}

