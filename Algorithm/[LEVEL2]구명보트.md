# 두 개 뽑아서 더하기

[문제](https://programmers.co.kr/learn/courses/30/lessons/42885)

### Note
- 투포인터의 활용

```java
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int i=0,j=people.length-1;
        Arrays.sort(people);
        
        while(i<=j){
            if(people[i]+people[j]<=limit){
                answer++;
                i++; j--;
            }else{
                answer++;
                j--;
            }
        }
        
        return answer;
    }
}
```
