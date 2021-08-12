# 위장

[문제](https://programmers.co.kr/learn/courses/30/lessons/42583)

### Note
- 힌트 참조
- 맨 처음 Queue에 다리 길이만큼 '0'으로 초기화하여 시작
- 위를 생각하지 못하면 타임아웃에 걸리는 문제

```java
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int index = 0;
        int currWeight = 0;
        int passed = truck_weights.length;
        Queue<Integer> queue = new LinkedList();
        
        for(int i=0; i<bridge_length; i++)
            queue.add(0);
        
        while(true){
            int out = queue.poll();
            currWeight -= out;
            
            if(out!=0){
                if(--passed==0)
                    break;
            }
                
            if(index<truck_weights.length && (currWeight+truck_weights[index])<=weight){
                queue.add(truck_weights[index]);
                currWeight += truck_weights[index++];
            }else
                queue.add(0);
            
            answer++;
                
        }
        return answer+1;
    }
}
```


