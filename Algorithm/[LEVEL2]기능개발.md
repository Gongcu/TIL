# 기능개발

[문제](https://programmers.co.kr/learn/courses/30/lessons/42586)


```java
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        ArrayList<Integer> alist =new ArrayList();
        int[] day = new int[progresses.length];
        int count = 1;
        int feature;
        
        //기능 별 소요일 계산
        for(int i=0; i<progresses.length; i++)
            day[i]=(int)Math.ceil((100.0-progresses[i])/speeds[i]);
        
        //배포 결정
        feature = day[0];
        for(int i=1; i<day.length; i++){
            if(feature<day[i]){
                feature=day[i];
                alist.add(count);
                count=1;
            }
            else{
                count++;
            }
        }
        alist.add(count);
        
        //배열로 변환
        answer = alist.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}
```

## Note
- Math.ceil(VALUE):올림
- List.stream().mapToInt(i->i).toArray(): `Integer list` to `int array`

