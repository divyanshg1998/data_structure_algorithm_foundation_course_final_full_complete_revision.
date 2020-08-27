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

vector<vector<Edge>> graph2;
//graph2 is a direted graph

void addEdge(int v1, int v2, int wt)
{

    Edge e2(v2, wt);
    graph2[v1].push_back(e2);
    //graph2 is a direted graph

}

void display(){

    for(int i=0 ; i< graph2.size() ; i++){
        cout<<i<<".";
        for(int j=0 ; j<graph2[i].size();j++){
            cout<<"[" << graph2[i][j].nbr <<"->"<< graph2[i][j].wt << "]";
        }cout<<"."<<endl;
        }        
}

void topological2( int s, vector<bool>& vis, stack<int>& st){

   
for(int n=0; n < graph2[s].size(); n++){
    Edge e1= graph2[s][n];
    if(vis[e1.nbr] == false){
    topological2( e1.nbr, vis, st);
    }   
}
vis[s]=true;
st.push(s);

}

void topological1(){

vector<bool> vis(graph2.size(),false);
stack<int> st;
for(int i=0; i<vis.size(); i++){
    if(vis[i] == false)
    {
        topological2( i, vis, st);
    }
}

while(st.size()>0)
{
int rem = st.top();
st.pop();

cout<<rem<<endl;
}

}
void topological1Again(){

vector<bool> vis1(graph2.size(),false);
stack<int> st1;

for(int i=graph2.size()- 1; i>=0; i--){
    if(vis1[i] == false)
    {
        topological2( i, vis1, st1);
    }
}

while(st1.size()>0)
{
int rem = st1.top();
st1.pop();

cout<<rem<<endl;
}

}

int main(){

    graph2.push_back(vector<Edge>());
    graph2.push_back(vector<Edge>());
    graph2.push_back(vector<Edge>());
    graph2.push_back(vector<Edge>());
    graph2.push_back(vector<Edge>());
    graph2.push_back(vector<Edge>());
    graph2.push_back(vector<Edge>());

    addEdge(0, 1, 1);
    addEdge(1, 2, 1);
    addEdge(0, 4, 1);
    addEdge(2, 3, 1);
    addEdge(4, 3, 1);
    addEdge(5, 4, 1);
    addEdge(5, 6, 1);
    addEdge(6, 3, 1);
    
    display();

    topological1();
    cout<<"<=========>"<<endl;
    topological1Again();


    return 0;
}
