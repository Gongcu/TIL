# Reverse Linked List 2

[문제](https://leetcode.com/problems/reverse-linked-list-ii/)

## 문제 설명
리스트의 헤드가 주어지고, left/right 값이 주어진다. 이 사이의 노드를 뒤집어라.

## 아이디어
- 새 노드를 만들고, 새 노드의 next를 헤드로 설정한다.
- prev,curr은 각각 left의 전, left 노드로 이동시킨다.
- 뒤집기를 right-left 만큼 반복한다.
- 최종적으로 새 노드의 next를 반환한다.


## 코드
```java
import java.util.*;
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode root=new ListNode(),prev=null,curr=null;
        prev=root;
        root.next = head;
        
        for(int i=0; i<left-1; i++)
            prev=prev.next;
        curr=prev.next;
        

        int i = 0;
        int count = right-left;
        
        while(i<count){
            ListNode temp = prev.next;
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = temp;
            
            i++;
        }
        return root.next;
    }
}
```



