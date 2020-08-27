#include <bits/stdc++.h>
using namespace std;

class Edge
{
    // we only take nbr for edge bcz the other edge is shown by the index of the outer\
    // vector
public:
    int nbr;
    int wt;
    Edge(int nbr, int wt)
    {
        this->nbr = nbr;
        this->wt = wt;
    }
};

vector<vector<Edge>> graph;
void addEdge(int v1, int v2, int wt)
{
    Edge e1(v1, wt);
    graph[v2].push_back(e1);

    Edge e2(v2, wt);
    graph[v1].push_back(e2);
}

void display(){

    for(int i=0; i< graph.size(); i++){
        cout<<i<<".";
        for(int j=0; j<graph[i].size();j++){
            cout<<"[" << graph[i][j].nbr <<"->"<< graph[i][j].wt << "]";
        }cout<<"."<<endl;
    }
}

bool pathExist(int v1, int v2, vector<bool>& tru)
{
    if(v1==v2){
        return true;
    }
    
    tru[v1]=true;
    
    for(int nb=0; nb < graph[v1].size(); nb++ ){
        Edge nn = graph[v1][nb];
       // cout<<nn.nbr;
        if( tru[nn.nbr] ==false ){
    
        bool tru2= pathExist(nn.nbr,v2,tru);
    
        if(tru2==true){
            return true;
        }
    }
    
    }

    return false;
    // if any change in any vaariable in node pre then change in node post itself 
    // similarly, edge pre & edge post
}


void printAllPath(int v1, int v2, vector<bool>& tru, string& psf, int wt)
{
    if(v1==v2){
        cout<<psf<<v2<<"@"<<wt<<endl;
        return;
      }
    
    tru[v1]=true;//node pre
    
    for(int nb=0; nb < graph[v1].size(); nb++ ){
        Edge nn = graph[v1][nb];
        if( tru[nn.nbr] == false ){
        //edge pre
        psf+=to_string(v1);   
        printAllPath(nn.nbr, v2, tru, psf, wt+nn.wt);
        psf.erase(psf.length()-1,1);
        //edge post
        }
}
    tru[v1]=false;//node post
}


string sp;  //SMALL PATH
int spd=INT_MAX;
string lp;
int lpd=INT_MIN;

string cp;  //cEAL PATH
int cpd=INT_MAX;
string fp;
int fpd=INT_MIN; 


void printAllPath2(int v1, int v2, vector<bool>& tru, string& psf, int wt, int factor)
{
    // silly mistake
    // if copy a func then have to change the name of the call of the func

    if(v1 == v2){

        // psf=psf+to_string(v2);
        // cout<<psf<<"@"<<wt<<endl;
   
        if(wt<spd){
            sp=psf;
            spd=wt;
        }
   
        if(wt>lpd){
            lp=psf;
            lpd=wt;
        }

        if(wt < factor && wt > fpd){
            fp=psf;
            fpd=wt;
           }

        if(wt>factor && wt<cpd){
            cp=psf;
            cpd=wt;
        }

      return;
      }
    
    tru[v1]=true;
    
    for(int nb=0; nb < graph[v1].size(); nb++ ){
        Edge nn = graph[v1][nb];
        if( tru[nn.nbr] == false ){
        
        psf += to_string(v1);   
        printAllPath2(nn.nbr, v2, tru, psf, wt+nn.wt, factor);
        psf.erase(psf.length()-1,1);
        
        }
    }
    tru[v1]=false; 
}

void hpc(int sr, vector<bool>& visited, int original, string& str, int count){

    if(count==graph.size()-1){
        str+=to_string(sr);
        cout<<str;
        for(int i=0; i<graph[sr].size() ; i++){
            Edge nn = graph[sr][i]; 
            if(nn.nbr==original){
                cout<<"*"<<endl;
                str.erase(str.length()-1, 1);
                return;
            }
        }

    cout<<"."<<endl;
    str.erase(str.length()-1,1);
    return;

    }

    visited[sr]=true;

    for(int n=0; n<graph[sr].size() ; n++){
        Edge nn= graph[sr][n];
        if(visited[nn.nbr]==false){
            str+=to_string(sr);
            hpc(nn.nbr, visited, original, str, count+1 );
            str.erase(str.length()-1, 1);
        }
    }    

    visited[sr]=false;// not visited[sr] == false
}

vector<vector<int>> a;


    int main()
{

    a.push_back( vector<int>());

// c++ mai string ka s lowercase
//  bool bhi chota
// compared to better languge java
// S 
// boolean


    graph.push_back( vector<Edge>());
    graph.push_back( vector<Edge>());
    graph.push_back( vector<Edge>());
    graph.push_back( vector<Edge>());
    graph.push_back( vector<Edge>());
    graph.push_back( vector<Edge>());
    graph.push_back( vector<Edge>());

    addEdge(0, 1, 10);
    addEdge(1, 2, 10);
    addEdge(0, 3, 40);
    addEdge(3, 2, 10);
    addEdge(3, 4, 2);
    addEdge(4, 5, 3);
    addEdge(5, 6, 3);
    addEdge(6, 4, 8);

    // extra
    addEdge(2, 5, 2);

    display();

    vector<bool> v(7,false);
    bool a2 = pathExist(0,6,v);
    cout<<a2<<endl;
    
    vector<bool> visited(7,false);
    string str="";
    printAllPath(0,6,visited,str,0);

    // printAllPath2(0,6,visited,str,0,42);
    // cout<<"smallest:"<<sp<<"@"<<spd<<endl;
    // cout<<"largest:"<<lp<<"@"<<lpd<<endl;
    // cout<<"ceil:"<<cp<<"@"<<cpd<<endl;
    // cout<<"floor:"<<fp<<"@"<<fpd<<endl;
    
    cout<<"hamiltonian:"<<endl;
    // hamiltonian path and cycle

    hpc(0, visited, 0,str, 0); 
    
    
    return 0;
}