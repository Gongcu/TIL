public class List {
    public static void main(String[] args){
        KList list = new KList();
        list.add(1); list.add(2); list.add(3); list.add(4); list.add(5);
        list.print();
        
        list.remove(0);
        list.print();

        list.remove(3);
        list.print();

        list.remove(1);
        list.print();

        list.add(5);
        list.print();
        
    }

    public static class Node{
        int key;
        Node next;
        Node(int key, Node next){
            this.key = key;
            this.next = next;
        }
    }

    public static class KList{
        Node head = null;
        Node tail = null;

        void add(int key){
            Node newNode = new Node(key, null);
            if(head == null)
                head = tail = newNode;
            else{
                tail.next = newNode;
                tail = newNode;
            }
        }

        void remove(int key){
            Node curr = head;
            Node prev = null;

            if(head==null)
                return;
            
            if(head.key == key){
                head = head.next;
                return;
            }


            while(curr!=null){
                if(curr.key == key){
                    prev.next = curr.next;
                }
                prev = curr;
                curr = curr.next;
            }
        }

        void print(){
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.key+" ");
                temp=temp.next;
            }
            System.out.println();
        }
    }
}
