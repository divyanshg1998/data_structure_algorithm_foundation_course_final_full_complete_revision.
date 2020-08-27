#include<bits/stdc++.h>
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

    for(int i=0 ; i< graph.size() ; i++){
        cout<<i<<".";
        for(int j=0 ; j<graph[i].size();j++){
            cout<<"[" << graph[i][j].nbr <<"->"<< graph[i][j].wt << "]";
        }cout<<"."<<endl;
        }        
}

class dPair{

    public :
    int v;
    int c;
    string psf;

    dPair(int v, int c, string str){
        this->v=v;
        this->c=c;
        this->psf=str;
      }
    // dPair(){

    // }

bool operator>(const dPair& other) const
{
    return this->c > other.c;
}
};

void djiktras(int s){

priority_queue<dPair,vector<dPair>,greater<dPair>> pq;
vector<bool> visited(graph.size(),false);
vector<vector<dPair>> g;

dPair pair( s ,0 , to_string(s));
pq.push(pair);

while(pq.size()>0){

    dPair rem = pq.top();
    pq.pop();

    if(visited[rem.v] == true){ 
    continue;
    }
    visited[rem.v] = true;


    cout<<rem.v<<"@"<<rem.c<<"->"<<rem.psf<<endl;

    for(int i=0; i < graph[rem.v].size(); i++){
        Edge e1 = graph[rem.v][i];
        if( visited[e1.nbr] == false){
        dPair ndp( e1.nbr , rem.c + e1.wt, rem.psf + to_string(e1.nbr));
        pq.push(ndp);
        }
    }
    }

}

class pPair{

public:
int v;
int av;
int cost;

pPair(int v, int av, int cost){
    this->v=v;
    this->av = av;
    this-> cost = cost; 
}

bool operator>(const pPair &other ) const
{
return this->cost > other.cost;
}

};

void addEdge2( vector<vector<Edge>>& g, int v1, int v2, int wt)
{

    Edge e1(v1, wt);
    g[v2].push_back(e1);

    Edge e2(v2, wt);
    g[v1].push_back(e2);
}


void display2(vector<vector<Edge>>& g){

    for(int i=0 ; i< g.size() ; i++){
        cout<<i<<".";
        for(int j=0 ; j<g[i].size();j++){
            cout<<"[" << g[i][j].nbr <<"->"<< g[i][j].wt << "]";
        }cout<<"."<<endl;
        }        
}

void prims(int s){

vector<vector<Edge>> g(graph.size(), vector<Edge>());
vector<bool> vis(graph.size(), false);

priority_queue<pPair, vector<pPair>, greater<pPair>> pq;
pPair p(0,-1,0);
pq.push(p);

while(pq.size()>0){

    pPair rem = pq.top();
    pq.pop();

    if(vis[rem.v] == true){
        continue;
    }
    vis[rem.v]= true;

    if(rem.av != -1){
        addEdge2(g, rem.v, rem.av, rem.cost);
    }

    for( int nb = 0 ; nb < graph[rem.v].size() ; nb++){
        Edge e1 = graph[rem.v][nb];
        if(vis[e1.nbr] == false){
        pPair np( e1.nbr, rem.v , e1.wt);
        pq.push(np);            
        }
    }
}

display2(g);
//note 
// we cant print the graph for djiktra's as we dont have the acquiring vertex
// and the total weight only , whereas in prims we have av and instantaneous cost as well
}



int main(){
    
    graph.push_back( vector<Edge>());
    graph.push_back( vector<Edge>());
    graph.push_back( vector<Edge>());
    graph.push_back( vector<Edge>());
    graph.push_back( vector<Edge>());
    graph.push_back( vector<Edge>());
    graph.push_back( vector<Edge>());

    addEdge(0, 1, 20);
    addEdge(1, 2, 10);
    addEdge(0, 3, 40);
    addEdge(3, 2, 20);
    //edgre that is combining
    addEdge(3, 4, 2);
    
    addEdge(4, 5, 3);
    addEdge(5, 6, 3);
    addEdge(6, 4, 8);

    // extra
    // addEdge(2, 5, 2);

    display();
    cout<<"diktra's:"<<endl;
    djiktras(0);

    cout<<"prims's"<<endl;
    prims(0);
    

    

    return 0;
}
