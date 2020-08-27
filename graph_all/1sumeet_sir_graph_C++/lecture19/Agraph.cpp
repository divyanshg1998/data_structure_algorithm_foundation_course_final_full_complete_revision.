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
        if( tru[nn.nbr] == false ){
    
        bool tru2 = pathExist(nn.nbr,v2,tru);
    
        if(tru2==true){
            return true;
        }
    }    
    }

    return false;
    // if any change in any vaariable in node pre then change in node post itself 
    // similarly, edge pre & edge post
}


void gsc(int i, vector<bool>& vis){

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

    
    for(int i=0; i<graph[rem].size() ; i++){
        Edge e1 = graph[rem][i];
        if(vis[e1.nbr]==false){
            q.push(e1.nbr);
        }
    }

}
}




bool isConnected(){

vector<bool> visited(graph.size(), false);
int ctr=0;

for(int i=0; i<graph.size(); i++){
    if(visited[i] == false){
        // get selected componentss
        gsc( i, visited );
        ctr++;
        if(ctr==2){
            return false;
        }
    }
}

return true;
}


bool gsc2 (int i, vector<bool>& vis){

queue<int> q;
q.push(i);

while(q.size()>0){

    // in order of: grm w a

    int rem=q.front();
    q.pop();

    if(vis[rem] == true){
    return true;
    }
  
    vis[rem]=true;

    
    for(int i=0; i<graph[rem].size() ; i++){
        Edge e1 = graph[rem][i];
        if(vis[e1.nbr]==false){
            q.push(e1.nbr);
        }
    }

}

return false;
}

bool isCyclic(){

vector<bool> visited(graph.size(), false);

for(int i=0; i<graph.size(); i++){
    if(visited[i] == false){
        
        bool val = gsc2 ( i, visited );
        if(val == true){
            return true;l
        }          

    }

}return false;
}


class twoInt{

public:
//very imp to write
int val;
int level;


twoInt(int val,int level){
this->val=val;
this->level=level;
}

};

bool isBipartite2(int ii , vector<int>& vis){
//just int of vector is passed
queue<twoInt> q;
twoInt a(ii,1);

q.push(a);

while(q.size()>0){

    // in order of: grm w a

    twoInt rem= q.front();
    q.pop();

    if(vis[rem.val] != 0){
   
    if( rem.level % 2 != vis[rem.val] %2) {
        // both are not together odd    or    even
        return false;    
        }
    
    else 
        continue;
    }
    vis[rem.val]=rem.level;
   
    for(int i=0; i<graph[rem.val].size() ; i++){
        Edge e1 = graph[rem.val][i];

        if( vis[e1.nbr] == 0 ){
            twoInt a1(e1.nbr ,rem.level+1); 
            q.push(a1);
         } 
    }
}

return true;
}

bool isBipartite1(){

    vector<int> vis(graph.size(), 0);

    for(int i=0; i< graph.size(); i++){
        if(vis[i] == 0){
            bool var=isBipartite2(i, vis);
            if( var == false){
                 
                return false;
            }
        }

    }
return true;
}

int main(){

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
    //edge that is combining
    addEdge(3, 4, 2);
    
    addEdge(4, 5, 3);
    addEdge(5, 6, 3);
    addEdge(6, 4, 8);

    // extra
    // addEdge(2, 5, 2);

    display();

    cout<<isConnected()<<endl;    // means the graph exists in a single piece
    cout<<isCyclic()<<endl;       // is any cycle in the graph 
    cout<<isBipartite1()<<endl;

    return 0;
}