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

bool bfs(int sr, int dn){

vector<bool> visited (graph.size(), false);
queue<int> q;

q.push(sr);

while(q.size()>0){

int rem= q.front();

q.pop();

if(visited[rem]==false){
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

    // in order of: grmwa

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

int main(){

    vector<int> v1{9,5,2,3,6,1};
    vector<int> v2{4,3,0,7,8,4};

    int n=10;

    for(int i=0; i<n ;i++){
        // i<n
        // bcz n=tot no. of elements
        graph.push_back( vector<Edge> ());
    }

    for(int i=0; i<v1.size() ;i++){
        addEdge(v1[i], v2[i],1);
    }

    vector<bool> visited (n,false);

    display();

    vector<string> nations = gcc();

    int sum=0;
    for(int i=0; i < nations.size()-1; i++ ){
        for(int j=i+1; j < nations.size();j++){
            // observe the loop starting and end
            // -1 par end , top loop
            sum+= nations[i].size() * nations[j].size();
          }
    }

    cout<<"ANS:"<<sum<<endl;

    return 0;
}