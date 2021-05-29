import LinkedList;
import Stack;
import HashMap;

public class test {
    public static void main(String[] args){
        //stackTest();
        //queueTest();
        HashTableTest();
    }

    void listTest(){
        LinkedList list = new LinkedList();
        for(int i=0; i<5; i++)
            list.add(i);
        list.iterate();

        list.delete(3);
        list.iterate();

        list.delete(4);
        list.iterate();
    }

    static void stackTest(){
        Stack stack = new Stack();
        for(int i=0; i<5; i++)
            stack.push(i);
        stack.print();

        
        for(int i=0; i<5; i++){
            System.out.println();
            stack.pop();
            stack.print();
        }
        stack.push(5);
        stack.print();
        System.out.println();
    }

    static void queueTest(){
        Queue queue = new Queue();
        for(int i=0; i<5; i++)
            queue.add(i);
        queue.print();

        
        for(int i=0; i<5; i++){
            System.out.println();
            queue.remove();
            queue.print();
        }
        queue.add(5);
        queue.add(5);
        queue.print();
    }

    static void HashTableTest(){
        HashMap table = new HashMap(100);
        table.put("1","gong");
        table.put("2","kong");
        table.put("3","qong");
        table.put("4","cong");
        table.put("5","oong");

        System.out.println(table.get("5"));
        System.out.println(table.get("4"));
        System.out.println(table.get("3"));
        System.out.println(table.get("2"));
        System.out.println(table.get("1"));

        table.remove("1");

        System.out.println(table.get("1"));

    }
}
