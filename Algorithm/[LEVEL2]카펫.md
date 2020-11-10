# 카펫 - 구현

[문제](https://programmers.co.kr/learn/courses/30/lessons/42842)


## 코드
```java
import java.lang.Math;
import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //공식1: 갈색 수 = 2*노란색 높이 + 2* 노란색 너비 + 4
        //공식2: 노란색 높이*노란색 너비 = 노란색 수
        //-> 갈색 수 = 2*노란색 수/노란색너비 + 2* 노란색 너비 + 4
        //-> 2*노란색 너비^+ (4-갈색수)*노란색 너비 + 2* 노란색 수 = 0
        //int result = 2*Math.pow(x,2) + (4-brown)*x+2*yellow;
        //위로 노란색 너비, 높이가 구해짐. -> 갈색은 노란색 너비+2 * 노란색 높이*2
        int yellow_width=-1, yellow_height=-1;
        for(int x=0; x<2000000; x++)
            if((2*Math.pow(x,2) + (4-brown)*x+2*yellow)==0){
                if(yellow_height==-1) {
                    yellow_height=x;
                    continue;
                }
                if(yellow_width==-1){
                    yellow_width=x;
                    break;
                } 
            }
        if(yellow_width==-1) yellow_width=yellow_height;
        answer[0]=yellow_width+2;
        answer[1]=yellow_height+2;
                        
        return answer;
    }
}
```


