# 더 맵게

[문제](https://programmers.co.kr/learn/courses/30/lessons/42626)


```java
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int i=0; i<scoville.length; i++) pq.add(scoville[i]);
        
        
        while(pq.size()>1 && pq.peek()<K){
            int food = pq.poll()+(pq.poll()*2);
            pq.add(food);
            answer++;
        }
        
        if(pq.peek()<K) answer=-1;
        
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

