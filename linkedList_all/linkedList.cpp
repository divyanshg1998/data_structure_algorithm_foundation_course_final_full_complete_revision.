#include <bits/stdc++.h>
using namespace std;

class linkedList
{
public:
    class Node
    {
    public:
        int data = 0;
        Node *next = nullptr;

        Node(int data)
        {
            this->data = data;
        }

        //default constructor does not exists itself here
        Node()
        {
        }
    };

private:
    Node* head = nullptr;
    Node* tail = nullptr;
    int size = 0;

public:

    ~linkedList(){
    Node* temp = head;

    while( head != nullptr){
        head = head->next;//heap mai hai objects
        delete temp;        
        temp = head;
    }       

    }

    void addFirst(int data)
    {
        Node *node = new Node(data);
        // Node *node ;
        // we can also write Node *node;  ,itself here, because,
        // we dont want this pointer to have an object to point to in heap

        if (head == nullptr && tail == nullptr)     //size == 0
        {
            head = node;
            tail = node;
            
        }
        else{
            node->next = head;
            head = node;
            }
            size++;        
    }

    void addLast( int data){
        Node* node = new Node(data);  
        // Node *node ; 
        if (head == nullptr && tail == nullptr)     //size == 0
         {   head = node;
             tail = node;
         }

        else {
            tail->next = node;
            node->next = nullptr;
            tail = node;
         }
         size++;                   
    }

    int size1(){
        return size;//cant have same name of func and var
    }

    bool isEmpty(){
        return (size == 0);
    }

    Node* getNodeAt( int idx){
        if(head == nullptr)     return nullptr;     //size == 0
        if( idx >= size && idx < 0)    return nullptr;

        Node* node = head;
        for( int i = 1; i <= idx; i++){
            node = node->next;
        }

        return node;
    }
    
    int removeFirst(){

        Node* rv = new Node();
        rv = head;

        if (size == 0)  return -1;

        if( size == 1){
            head = nullptr;
            tail = nullptr;
            size--;
        }
        else{
           head = rv->next;
           size--;     
            }

        int data1 = rv->data;
        delete rv;  //

        return data1;
        // return (size == 0) ? data1 : -1;
    }
    
    int removeLast(){

        Node* rv = new Node();
        rv = tail;

        if( head == nullptr)    return -1;

        if( head == rv ){    //size == 1
            head = nullptr;
            tail = nullptr;
            size--;
        }
        else{
            Node* prev = getNodeAt(size - 2);
            tail = prev;             
            size--;     
            }

        int data1 = rv->data;
        delete rv;

        return data1;

    }

    void display(){
        Node* node = head;
        
        while( node != nullptr){
            cout<<node->data<<" ";
            node = node->next;
        }
        cout<<endl;
    }
};


// int fun2( string str){


//     stack<int> st;
//     int maxlen = 0;
//     for(int i = 0 ; i < str.length(); i++ ){
//         if( str[i] == '(')
//         {
//             st.push(i);
//         }
//         else{
//             if( str[st.top()] == '(')
//             {
//                 st.pop();
//                 maxlen = max( maxlen, i - st.top());
//             }

//             else
//             st.push(i);
//         }  
//     }
    
//     cout<<"maxLength"<<maxlen;
//     return maxlen;
// }

int main()
{
    // //if linkedlist made at heap
    // linkedList* ll = new linkedList();
    // ll->addFirst(10);        //arrow is used to point to the things at heap, here ll made at heap
                                //and this pointer too


    //linked list at stack
   
   
   
    linkedList ll;
    ll.addFirst(10);        //. is used here, it is for stack
    ll.addFirst(20);
    ll.addFirst(30);
    ll.addLast(40);
    ll.addLast(50);
    ll.display();
      
    // Node* node = new Node();
    // ll.getNodeAt(2);
    // cout<<node->data<<endl;

    cout<<ll.removeFirst()<<endl;
    cout<<ll.removeFirst()<<endl;
    cout<<ll.removeFirst()<<endl;
    cout<<ll.removeFirst()<<endl;
    cout<<ll.removeFirst()<<endl;
    cout<<ll.removeFirst()<<endl;
    ll.display();



    // ll.addLast(40);
    // ll.addLast(50);
    // ll.addLast(40);


    // Node ll = new Node();

    




    // fun2("()()");
    return 0;
}
