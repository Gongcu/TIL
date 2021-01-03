# 정수 삼각형 - DP

[문제](https://programmers.co.kr/learn/courses/30/lessons/43105)

### Note
- 점화식 찾기: 앞선 결과가 다음 결과에 이용

```java
import java.util.*;
class Solution {
    int[] a ;//= new int[(500+501)/2]; //a[0] is empty
    public int solution(int[][] triangle) {
        a = new int[triangle.length*triangle.length];
        int answer = 0;
        int curr=triangle.length+1;
        int count = 1;
        //init base value
        for(int i=triangle.length-1;i>=0; i--)
            for(int j=0; j<triangle[i].length;j++)
                a[count++]=triangle[i][j];

        
        
        for(int height=triangle.length-1; height>=1; height--){
            for(int j=0; j<triangle[height-1].length; j++){
                a[curr]+=Math.max(a[curr-height-1],a[curr-height]);
                curr++;
            }
        }

        answer = a[curr-1];
        
        return answer;
    }
}
```

