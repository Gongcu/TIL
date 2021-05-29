import Node;

public class Stack {
    Node top;

    void pop(){
        if(top==null)
            return;
        top=top.next;
    }

    void push(int value){
        top=new Node(value, top);
    }

    void print(){
        for(Node curr=top; curr!=null;curr=curr.next){
            System.out.print(curr.value+" ");
        }
    }
}
