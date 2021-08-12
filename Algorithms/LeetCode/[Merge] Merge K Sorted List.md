# Merge K Sorted Lists

[문제](https://leetcode.com/problems/merge-k-sorted-lists/)

## 문제 설명
K개의 정렬된 리스트의 헤드 노드 배열이 주어지고, 이 K의 정렬된 리스트를 정렬된 하나의 리스트로 반환하는 문제

## 아이디어
- 주어진 리스트를 모두 연결한 뒤
- 위로 생성된 하나의 리스트를 분할-병합한다.


## 코드
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = findHead(lists);

        if(head==null)
            return null;

        ListNode temp = head;

        //분할된 리스트 모두 연결
        for(ListNode list : lists){
            if(list==null || list==head){
                continue;
            }
            while(temp!=null && temp.next!=null){
                temp=temp.next;
            }
            if(list==null)
                continue;
            temp.next=list;
            temp=temp.next;
        }
        
        return split(head);
    }
    
    //분할
    ListNode split(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        
        //현재 리스트의 크기 결정
        ListNode temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        
        //크기 절반 지점에서 분할(끊기)
        ListNode prev = null;
        temp =head;
        int count = 0;
        while(size/2!=count){
            prev=temp;
            temp=temp.next;
            count++;
        }
        prev.next = null;
        
        //계속 분할
        ListNode l1 = split(head);
        ListNode l2 = split(temp);
        
        //분할된 리스트를 병합
        return merge(l1,l2);
    }
    
    /**
    * 두 리스트의 헤드를 통해 병합
    */
    ListNode merge(ListNode l1, ListNode l2){
        ListNode temp = null;
        ListNode head = null;
        ListNode i = l1, j=l2;
        while(i!=null && j!=null){
            if(i.val>j.val){
                if(temp==null){
                    temp = j;
                    head=temp;
                }else{
                    temp.next = j;
                    temp=temp.next;
                }
                j=j.next;
            }else{
                if(temp==null){
                    temp = i;
                    head=temp;
                }else{
                    temp.next = i;
                    temp=temp.next;
                }
                i=i.next;
            }
        }
        
        while(i!=null){
            if(temp==null){
                temp = i;
                head=temp;
            }else{
                temp.next = i;
                temp=temp.next;
            }
            i=i.next;
        }
        
        while(j!=null){
            if(temp==null){
                temp = j;
                head=temp;
            }else{
                temp.next = j;
                temp=temp.next;
            }
            j=j.next;
        }
        return head;
    }
    
    ListNode findHead(ListNode[] lists){
        ListNode head = null;
        for(ListNode l : lists){
            if(l!=null){
                return l;
            }
        }
        return null;
    }
}
```



