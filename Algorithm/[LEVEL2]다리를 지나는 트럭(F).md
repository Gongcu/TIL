# 위장

[문제](https://programmers.co.kr/learn/courses/30/lessons/42583)

### Note
- 힌트 참조
- 맨 처음 Queue에 다리 길이만큼 '0'으로 초기화하여 시작
- 위를 생각하지 못하면 타임아웃에 걸리는 문제

```java
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map =new HashMap();
        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            answer*=(entry.getValue()+1);
        }

        return answer-1;
    }
}
```


