# 정수 삼각형 - DP

[문제](https://programmers.co.kr/learn/courses/30/lessons/43105)

### Note
- 점화식 찾기: 앞선 결과가 다음 결과에 이용

```java
import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for(int i=triangle.length-2; i>=0; i--){
            for(int j=0; j<triangle[i].length; j++){
                triangle[i][j]+=Math.max(triangle[i+1][j],triangle[i+1][j+1]);
            }
        }
        answer = triangle[0][0];
        return answer;
    }
}
```

