# 두 개 뽑아서 더하기

[문제](https://programmers.co.kr/learn/courses/30/lessons/64061)


```java
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                list.add(numbers[i]+numbers[j]);
            }
        }
        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            if(!answerList.contains(list.get(i)))
                answerList.add(list.get(i));
        }
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i]=answerList.get(i);
        }
        return answer;
    }
}
```

## 핵심 - ArrayList 활용
 - .contains(x) : x가 리스트에 존재하는지 확인
