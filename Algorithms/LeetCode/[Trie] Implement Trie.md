# Implement Trie

[문제](https://leetcode.com/problems/implement-trie-prefix-tree/)

## 문제 설명
트라이를 구현하라.

## 아이디어
- 트라이의 노드는 String(word)와 Map<Character,Node>(children)으로 구성된다.


## 코드
```java
class Trie {
    class Node{
        String word = null;
        Map<Character,Node> children = new HashMap();
        Node(){}
    }

    Node root;

    public Trie() {
        root = new Node();
    }
    
    //각 문자에 대해 현재 노드의 children에 대해 문자에 해당하는 노드를 찾아 다음으로 이동
    //(없었다면 새 노드 추가)
    public void insert(String word) {
        Node curr= root;

        for(char ch : word.toCharArray()){
            if(curr.children.get(ch)==null)
                curr.children.put(ch,new Node());
                
            curr = curr.children.get(ch);
        }

        curr.word = word;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            Node node = curr.children.get(ch);
            if(node == null)
                return false;
            else
                curr = node;
        }
        return curr.word!=null;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        boolean result = true;
        for(char ch : prefix.toCharArray()){
            Node node = curr.children.get(ch);
            if(node == null)
                return false;
            else
                curr = node;
        }
        return true;
    }
    
}
```



