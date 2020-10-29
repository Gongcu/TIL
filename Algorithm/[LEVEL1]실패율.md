# 실패율(2019 카카오 블라인드 채용) - 구현

[문제](https://programmers.co.kr/learn/courses/30/lessons/42889#)


## 코드
```java
import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int failer=0, count =0;
        float[] failer_rate = new float[N];
        float max=-1.0f; int max_index=-1;
        
        //단계별 실패율 계산
        for(int i=1; i<N+1; i++){
            for(int j=0; j<stages.length; j++){
                if(i==stages[j])
                    failer++;
                if(i<=stages[j])
                    count++;
            }
            if(count==0) //해당 단계까지 도달한 유저가 한명도 없을 경우
                failer_rate[i-1]=0.0f;
            else
                failer_rate[i-1] = (float) failer/count;
            failer = 0; count = 0;
        }
        
        //실패율이 최대인 스테이지 부터 내림차순으로 배치
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(failer_rate[j]>max){
                    max = failer_rate[j];
                    max_index = j;
                }
            }
            answer[i]=max_index+1;
            failer_rate[max_index]=-1.0f;
            max=-1.0f; max_index=-1;            
        }
        return answer;
    }
}
```


