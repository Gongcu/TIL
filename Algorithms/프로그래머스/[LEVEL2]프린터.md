# 프린터

[문제](https://programmers.co.kr/learn/courses/30/lessons/42587)

## Tip
- 복잡한 풀이법
    - ArrayList를 Queue 처럼 활용: remove(0)
    - Map.entry("key","value")를 활용한 리스트
- 간단한 풀이법
    - 모든 인쇄물의 위치를 추적하지 않고 목표 인쇄물만 추적

## 복잡한 풀이
```java
import java.util.*;
class Solution {
    ArrayList<Map.Entry<Integer,Integer>> queue = new ArrayList();

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int max;
        
        for(int i=0; i<priorities.length; i++)
            queue.add(Map.entry(i,priorities[i]));
        
        max = getMax();
        
        while(!queue.isEmpty()){
            Map.Entry<Integer,Integer> item = queue.get(0);
            

            if(item.getValue()<max){
            //꺼낸 값이 최대가 아닐 경우 맨 뒤로 삽입
                queue.remove(0);
                queue.add(item);
            }else{
            // 최대일 경우 출력, 만약 원햇던 아이템이면 break, 아니면 최대값을 재설정하고 다시 반복
                answer++;
                queue.remove(0);
                
                if(item.getKey()==location)
                    break;
                else
                    max = getMax();
            }
        }
        return answer;
    }
    
    int getMax(){
        int max = queue.get(0).getValue();
        for(int i=1; i<queue.size(); i++)
            if(max<queue.get(i).getValue())
                max = queue.get(i).getValue();
        return max;
    }
}
```

## 간단한 풀이
```java
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int print=0;
        LinkedList<Integer> list = new LinkedList();
        
        for(int i=0; i<priorities.length; i++)
            list.add(priorities[i]);
        
        while(true){
            if(max(list,print)){
                if(print==location){
                    answer=print;
                    break;
                }
                print++;
            }else{
                int item = list.get(print);
                list.removeFirst();
                list.add(item);
                
                if(location!=print)
                    location--;
                else
                    location=list.size()-1;
            }
        }
        
        //i번 인덱스는 i+1번 째
        return answer+1;
    }
    
    //현재 인쇄물이 이후 인쇄물보다 우선순위가 높음
    boolean max(LinkedList<Integer> list, int maxValueIndex){
        if(maxValueIndex>=list.size())
            return true;
        int max = list.get(maxValueIndex);
        for(int i=maxValueIndex+1; i<list.size(); i++){
            if(list.get(i)>max){
                return false;
            }
        }
        return true;
    }
}
```



