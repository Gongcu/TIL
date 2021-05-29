import Node;

public class Queue {
    Node front;
    Node rear;

    void add(int value){
        Node node = new Node(value,null);
        if(rear==null)
            front=rear=node;
        else
            rear.next = node;
            rear = node;
    }

    //1개 남은 경우 유의(rear가 삭제할 노드를 참조할 수 있기에 명시적으로 null 처리)
    void remove(){
        if(front==null)
            return;
        if(front.next==null)
            rear= front = null;
        else
            front = front.next;
    }

    void print(){
        for(Node curr=front;curr!=null ;curr=curr.next){
            System.out.print(curr.value+" ");
        }
    }
}
