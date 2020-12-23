# 더 맵게

[문제](https://programmers.co.kr/learn/courses/30/lessons/42626)


```java
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue();
        
        for(int i=0; i<scoville.length; i++)
            pQueue.add(scoville[i]);
            
        while(pQueue.size()>=2){
            if(pQueue.peek()>=K)
                break;
            else{
                int min = pQueue.poll();
                int nextMin = pQueue.poll();
                pQueue.add(min + nextMin*2);
                answer++;
            }
        }
        
        if(answer==scoville.length-1 && pQueue.peek() < K){
            answer = -1;
        }
        
        return answer;
    }
}
```

## Note
`PriorityQueue`: 우선순위 기반의 FIFO. 삽입은 맨 끝, 삭제는 우선순위 기반

- int형 priorityQueue 선언 (우선순위가 낮은 숫자 순)

  `PriorityQueue<Integer>` priorityQueue = new PriorityQueue<>();

- int형 priorityQueue 선언 (우선순위가 높은 숫자 순)

  `PriorityQueue<Integer>` priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

