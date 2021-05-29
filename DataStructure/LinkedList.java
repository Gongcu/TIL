public class LinkedList{
    Node head;
    Node tail;

    void add(int value){
        head = new Node(value, head);
    }
    void addLast(int value){
        tail.next = new Node(value,null);
        tail= tail.next;
    }

    boolean delete(int value){
        Node curr=head;
        Node prev=head;
        boolean exist =false;
        for(;curr!=null;curr=curr.next){
            if(curr.value == value){
                exist = true;
                break;
            }
            prev = curr;
        }
        if(curr==head)
            head = head.next;

        if(exist){
            prev.next = curr.next;
        }
        return exist;
    }

    void iterate(){
        for(Node curr=head; curr!=null; curr=curr.next){
            System.out.print(curr.value+" ");
        }
    }
}

