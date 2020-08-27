
#include<bits/stdc++.h>

using namespace std;

    int ctr=0;
    void coinChangePerm( vector<int>& arr, int targ, string str ){

        if(targ==0){ 
            cout<<++ctr<<" "<<str<<endl;
            return;
        }

        for(int i=0; i< arr.size(); i++){
            
                coinChangePerm(arr, targ-arr[i], str + to_string(arr[i])+" " );
             }
            
             }

    int ctr1=0;
    
    void coinChangeComb( vector<int>& arr, int targ, string str ,int indx){

    //SUMEET SIR WAY OF BASE CASE
            if(targ==0 || indx == arr.size() -1){
               if(targ==0){
                cout<<++ctr1<<" "<<str<<endl;
            
            }
            return;
            }

        for(int i=indx; i< arr.size(); i++){
            if(targ-arr[i]>=0){
                coinChangeComb(arr, targ-arr[i], str + to_string(arr[i])+" ", i );
             }
             else
                return;
        }

   }

#define vi vector<int> 
#define vb vector<bool> 

//combination
    int coinUnique( vi arr, int targ, int idx, string str){

        if(targ == 0 || idx == arr.size()){
            if(targ == 0)
            {
                cout<<str<<endl;
                return 1;
           }
           return 0;
       }

        int count = 0;
        for( int i = idx  ; i < arr.size() ; i++){
        
        count += coinUnique(arr, targ - arr[i], i+1, str + to_string(arr[i]));
    
        }
    
    return count;

    }

    int coinunique2(vi arr, int targ, string str, vb tru){

        if(targ == 0){
            cout<<str<<endl;
            return 1;
        }

        if( targ < 0){
            return 0;
        }

        int count = 0;
        for( int i = 0  ; i < arr.size() ; i++){
        
        if( !tru[i] )
        { 
            tru[i] = true;
            count += coinunique2(arr, targ - arr[i], str + to_string(arr[i]), tru);
            tru[i] = false;
        }
    }
    
    return count;

    }

       int ctr2 = 0;
    int coinChangeCombBin(vector<int>& arr, int targ, string str, int idx){

            if(targ==0 || idx == arr.size() ){
                if(targ==0){
                cout<<++ctr2<<" "<<str<<endl;
                return 1;
            }
            return 0;
            }

   int count = 0;
   
   if(targ-arr[idx]>=0){
     count+=coinChangeCombBin(arr, targ-arr[idx], str+ to_string(arr[idx])+" ", idx );   
   }      
     count+=coinChangeCombBin(arr, targ, str, idx+1);
        
        return count;

    }

    int ctr3=0;
    int coinChangePermBin(vector<int>& arr, int targ, string str, int idx){

            if(targ==0 || idx == arr.size() ){
                if(targ==0){
                cout<<++ctr3<<" "<<str<<endl;
                return 1;
            }
            return 0;
            }

   int count = 0;
   
   if(targ-arr[idx]>=0){
     count+=coinChangePermBin(arr, targ-arr[idx], str+ to_string(arr[idx])+" ", 0 ); //indx=0
  
   }      
     count+=coinChangePermBin(arr, targ, str, idx+1);
        
        return count;

    }

int ctr4=0;
int cccbs(vector<int>& arr, int targ, string str, int idx){

            if(targ==0 || idx == arr.size() ){
                if(targ==0){
                cout<<++ctr4<<" "<<str<<endl;
                return 1;
            }
            return 0;
            }

   int count = 0;
   
   if(targ-arr[idx]>=0){
     count+=cccbs(arr, targ-arr[idx], str+ to_string(arr[idx])+" ", idx ); //indx=0
  
   }      
     count+=cccbs(arr, targ, str, idx+1);
      

    return count; 
}

int ccpbs(vector<int>& arr, int targ, string str,
                                int indx, vector<bool>& truth){

       if(targ==0 || indx == arr.size()){
               if(targ==0){
                cout<<++ctr1<<" "<<str<<endl;
                return 1; }
            return 0;
            }

        int count=0;
        for(int i=indx; i< arr.size(); i++){
            if(targ-arr[i]>=0 && truth[i] == false){
                truth[i] = true;
                count+=ccpbs(arr, targ-arr[i],
                                    str + to_string(arr[i])+" ", i,truth );
                truth[i] = false;
                }
            }
        return count;

   }



int main(){

    vector<int> arr = {2,3,5,7};
    // coinChangePerm( arr, 10, "" );

    // coinChangeComb( arr, 10, "", 0);


    // cout<<coinUnique(arr, 10, 0, "")<<endl;   //for comb

    // vector<bool> v(arr.size(), false);
    // cout<<coinunique2(arr, 10, "", v)<<endl; // for perm





// // BY BINARY(VOID TYPE)
//     cout<<coinChangeCombBin(arr, 10, "",0);

//     cout<<coinChangePermBin(arr, 10, "",0);


// // BY BINARY(VOID TYPE) , but also not infinite coins
    // cout<<cccbs(arr, 10, "",0);


//coinChangecombBinarySingle == ccpcbs


 vector<bool> truth(4,false);
 cout<<ccpbs(arr, 10, "", 0, truth);


//coinChangePermBinarySingle == ccpbs

    return 0;
}


