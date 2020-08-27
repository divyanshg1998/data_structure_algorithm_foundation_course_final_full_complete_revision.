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

bool bfs(int sr, int dn){
    
    
vector<bool> visited (graph.size(), false);
queue<int> q;

q.push(sr);

while(q.size()>0){

// grm*wp*

int rem = q.front();

q.pop();

if(visited[rem]==true){
    continue;
}
visited[rem]=true;

// print
if(rem==dn){
    return true;
}

for(int n = 0; n < graph[rem].size() ; n++){
Edge e1 = graph[rem][n];
if( visited[e1.nbr] == false ){ 
q.push(e1.nbr);
}

}
}

return false;
}

string gsc(int i, vector<bool>& vis){

string str="";
queue<int> q;
q.push(i);

while(q.size()>0){

    // in order of: grm w a

    int rem=q.front();
    q.pop();

    if(vis[rem] == true){
    continue;
    }
    vis[rem]=true;

    str+=to_string(rem);

    for(int i=0; i<graph[rem].size() ; i++){
        Edge e1 = graph[rem][i];
        if(vis[e1.nbr]==false){
            q.push(e1.nbr);
        }
    }

}

return str;

}


vector<string> gcc(){

vector<string> comps; //component

vector<bool> visited(graph.size(), false);

for(int i=0; i<graph.size(); i++){
    if(visited[i] == false){
        // get selected componentss
        string comp = gsc( i, visited );
        comps.push_back(comp);
    }
}

return comps;
}


    int main()
{
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
    // imp point
    // addEdge(3, 4, 2);  //intersection
    addEdge(4, 5, 3);
    addEdge(5, 6, 3);
    addEdge(6, 4, 8);   
    // extra
    // addEdge(2, 5, 2);
    display();

    // vector<bool> v(7,false);
    // bool a2=pathExist(0,6,v);     //DFS
    // cout<<a2<<endl;

    cout<<bfs(0,6)<<endl; //both the 2 func are same

    // get connected components
    vector<string> v= gcc();

    for(auto itr: v){
        cout<<itr<<endl;
    }

    // for(int i=0; i < v.size(); )


    return 0;
}