#include <bits/stdc++.h>
using namespace std;

class Edge
{
    // we only take nbr for edge bcz the other edge is shown by the index of the outer
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

void addEdge( int v1, int v2, int wt){

if( v1<0 || v2<0 || v1 >= graph.size() || v2 >= graph.size())
{
    return;
}

// graph[v1].push_back(new Edge( v2, wt));
// graph[v2].push_back(new Edge( v1, wt));

Edge e1 ( v2, wt);
Edge e2 ( v1, wt);

graph[v1].push_back(e1);
graph[v2].push_back(e2);
}


void display(){

for(int i = 0; i < graph.size() ; i++){
    cout<<i<<"=> ";  
    for( int j=0; j < graph[i].size() ; j++){
        cout<<"("<<graph[i][j].nbr<<","<<graph[i][j].wt<<"),";
            }
            cout<<endl;
            }
 cout<<"=============="<<endl;
}

void solve(){

    for(int i=0; i < 7; i++){//
        vector<Edge> al;
        graph.push_back(al);
    }


        addEdge( 0, 1, 10);
        addEdge( 0, 3, 10);
        addEdge( 1, 2, 10);
        addEdge( 2, 3, 40);
        addEdge( 3, 4, 2);
        addEdge( 4, 5, 2);
        addEdge( 5, 6, 8);
        addEdge( 4, 6, 3);
        
    }

void bfs(int sr)
{

vector<bool> visited ( graph.size() , false);
queue<int> q;
q.push(sr);

while(q.size() > 0){

//grm*wa*

int rem = q.front();

q.pop();

if( visited[rem] == true){
    continue;
}

visited[rem] = true;

// if( rem == dn)
// {
//     return true;
// }

cout << rem <<endl; 

for(int n = 0; n < graph[rem].size() ; n++){
     Edge e1 = graph[rem][n];
     if(visited[e1.nbr] == false){
         q.push(e1.nbr);
     }
}
}
}    


void removeEdge( int u, int v){

for(int i=0 ; i < graph[u].size(); i++){

if( graph[u][i].nbr == v ){
graph[u].erase( graph[u].begin() + i);
break;
}
}

for(int i=0 ; i < graph[v].size(); i++){

if( graph[v][i] . nbr == u ){
graph[v].erase( graph[v].begin() +i);
break;
}
}
}

string gcc2( int src, vector<bool>& tru) {

queue<int> q;
q.push(src);
string str = "" ;

while(q.size() > 0){

// grm*wa*

int rem = q.front();

q.pop();

if( tru[rem] == true){
   continue;
}

tru[rem] = true;

str += to_string(rem);
// cout<<str<<endl;

for ( int n = 0 ; n < graph[rem].size() ; n++){


int num = graph[src][n].nbr;
if( tru[num] == false )
{
    q.push(num);    
}
}

// cout<<"loop 2 "<<str<<endl;

// cout<<"graph[rem].size():"<<graph[rem].size()<<endl;

}

// cout<<"loop 2 end "<< str<<endl;
return str;
}

vector<string> gcc(){

    vector<bool> tru( graph.size(), false);
    vector<string> v1;

    for( int i = 0 ; i < graph.size() ; i++ ){
        if( tru[i] == false){
           string str = gcc2(i,tru); 
        //    cout<<i<<" call return"<<str<<endl;
           v1.push_back(str);                 
        }
    }

    return v1;
    
    }

void isConnected2( int src, vector<bool>& tru)
{

queue<int> q;
q.push(src);

while(q.size() > 0){

    int rem = q.front();
    q.pop();

    if( tru [rem] == true){
        continue;
    }

    tru [rem] = true;

    for( int n = 0; n < graph[rem].size() ; n++){
        int a = graph[rem][n].nbr;
        if( tru[a] == false){
            q.push(a);
        }
    }
    }
   
    
    

}


bool isConnected(){

vector<bool> tru (graph.size(), false);

isConnected2(0 , tru);

for( int i = 1 ; i < graph.size() ; i++ ){
    if( tru[i] == false ){
        return false;
    }
}

return true;

}

bool iscyclic()
{

queue<int> q;
q.push(0);
string str = "";
vector<bool> tru(graph.size(), false);

while(q.size() > 0){

// grm*wa*

int rem = q.front();

q.pop();

if( tru[rem] == true){
   return true;
}

tru[rem] = true;

str += to_string(rem);
// cout<<str<<endl;

for ( int n = 0 ; n < graph[rem].size() ; n++){

int num = graph[rem][n].nbr;
if( tru[num] == false )
{
    q.push(num);    
}
}

}

return false;
}

int main(){

    solve();
    display();
   
    bfs(0);
   
    removeEdge( 3, 4);
    display();   

    vector<string> v = gcc();

    for( auto itr : v){
        cout<<itr<<endl;
    }

    cout<<"isConnected:"<<isConnected()<<endl;
    cout<<"iscyclic:"<<iscyclic()<<endl;
    addEdge( 3, 4, 2);
    cout<<"isConnected:"<<isConnected()<<endl;   
    cout<<"iscyclic:"<<iscyclic()<<endl;

    

















//     vector<sting> v = gcc();

//     for( string str : v){
//         cout<< str<< endl;
//     }

     
   
   
//     return 0;




}