import java.util.LinkedList;

public class HashMap {
    LinkedList<Node>[] table;
    int size = 0;
    HashMap(int size){
        table = new LinkedList[100];
        this.size= size;
    }

    Long hashing(String key){
        Long hashCode = 0L;
        for(char x : key.toCharArray())
            hashCode+=x;
        return hashCode;
    }
    
    int getIndex(Long hashCode){
        return (int)(size%hashCode);
    }

    Node search(String key){
        Long hashCode = hashing(key);
        int index = getIndex(hashCode);
        LinkedList<Node> bucket = table[index];
        if(bucket!=null)
            for(Node n : bucket)
                if(n.key == key)
                    return n;
        return null;
    }

    void put(String key, String value){
        Node node = search(key);
        if(node!=null)
            node.value = value;
        else{
            Long hashCode = hashing(key);
            int index = getIndex(hashCode);
            LinkedList<Node> bucket = table[index];
            if(bucket==null)
                table[index] = new LinkedList();
            table[index].add(new Node(key,value));
        }
    }

    String get(String key){
        Node n = search(key);
        if(n==null)
            return "";
        else
            return n.value;
    }

    void remove(String key){
        Long hashCode = hashing(key);
        int index = getIndex(hashCode);
        LinkedList<Node> bucket = table[index];
        if(bucket!=null)
            for(Node n : bucket)
                if(n.key == key){
                    bucket.remove(n);
                    return;
                }
    }



    class Node{
        String key;
        String value;

        Node(String key, String value){
            this.key=key;
            this.value = value;
        }
    }
}
