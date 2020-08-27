#include<bits/stdc++.h>

using namespace std;

class Edge{

    public:

    int nbr;
    int wt;

    Edge(int nbr, int wt){
        this->nbr = nbr;
        this->wt = wt;
    }
    Edge(){

    }
};

vector<vector<Edge> > graph;

void addEdge( int v1, int v2, int wt){

if( v1<0 || v2<0 || v1 >= graph.size() || v2 >= graph.size())
{
    return;
}

graph[v1].push_back(Edge( v2, wt));
graph[v2].push_back(Edge( v1, wt));

// Edge e1 = new Edge( v2, wt);
// Edge e2 = new Edge( v1, wt);

// graph[v1].push_back(e1);
// graph[v2].push_back(e2);
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

        addEdge( 0, 3, 10);
        addEdge( 0, 1, 10);
        addEdge( 1, 2, 10);
        addEdge( 2, 3, 40);
        addEdge( 3, 4, 2);
        addEdge( 4, 5, 2);
        addEdge( 4, 6, 3);
        addEdge( 5, 6, 8);
    
    }


void removeVertex(int u){

for(int i = 0; i < graph[u].size() ; i++ ){    
    int val = graph[u][i] .nbr ;
    
    for(int j=0 ; j < graph[i].size(); j++ ){
        if( graph[val][j].nbr == u){
            graph[val].erase( graph[val].begin() + j);
        }  
    }
}

graph.erase(graph.begin() + u);
}

void removeEdge( int u, int v){

for(int i=0 ; i < graph[u].size(); i++){

if( graph[u][i]. nbr == v ){
graph[u].erase( graph[u].begin() + i);
break;
}
}

for(int i=0 ; i < graph[v].size(); i++){

if( graph[v][i].nbr == u ){
graph[v].erase( graph[v].begin() +i);
break;
}

}

}

void removeVertex3(int u){

//ulti loop because size varying, we do this for size varying
for( int i = graph[u].size() - 1; i >= 0; i--){

    int v = graph[u][i].nbr ;
    removeEdge(u, v);
}


}
int main(){

    solve();
    display();
   
    removeEdge(3,4);
    display();

    removeVertex3(3);
    
    display();

   
   
   
   
    return 0;
}