# 위장

[문제](https://programmers.co.kr/learn/courses/30/lessons/42578)

### Note
- 다른 풀이 참조
- 기본적인 조합 연산은 A X B X C X ...
- 해당 문제에선 옷을 안 입는 것도 선택지 -> (A+1) X (B+1) X (C+1) X ...
- 각 부위별로 전부 옷을 안입은 경우를 제외하기 위해 RESULT - 1
- 구현은 쉬운 문제이지만 아이디어를 얻기가 매우 어려웠음

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


