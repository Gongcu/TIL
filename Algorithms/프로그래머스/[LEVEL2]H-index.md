# H-index

[문제](https://programmers.co.kr/learn/courses/30/lessons/42747)

### Note
- 문제 난이도를 파악하고 쉬운 문제로 보이면 너무 어렵게 생각하지 말 것


```java
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int h=0;true;h++){
            int count = 0;

            for(int i=0; i<citations.length; i++){
                if(citations[i]>=h) 
                    count++;
            }
            //h번 이상 인용된 것만 확인, h번 이하는 자동으로 확인됨
            if(count>=h)
                answer=h;
            else
                break;
            
        }
        
        return answer;
    }
}
```

```java
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        int mid = citations.length/2;
        int h = (citations[0]+citations[citations.length-1])/2;
        int left = 0, right=0;
        for(;;){
            //논몬 인용 수 확인
            for(int i=0; i<citations.length; i++){
                if(citations[i]>=h){
                    right++;
                }else{
                    left++;
                }
            }
            if(left<=h && right>=h){
                //h인덱스일 경우
                answer = h;
                break;
            }else{
                //아닐 경우
                h--;
                left =right=0;
            }
        }
        return answer;
    }
}
```


