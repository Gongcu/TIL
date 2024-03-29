import Node;

public class Stack {
    Node top;

    int pop(){
        if(top==null)
            return -1;

        Node temp = top;
        top = top.next;

        return temp.key;
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
