# 등굣길 - DP

[문제](https://programmers.co.kr/learn/courses/30/lessons/42898)

### Note
- 점화식 찾기: 앞선 결과가 다음 결과에 이용

```java
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] path = new int[n][m];
        path[0][0] = 1;
        
        //물웅덩이 설정
        for(int i=0; i<puddles.length && puddles[0].length!=0; i++){
            path[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        
        //가능한 왼쪽 경로의 수와 가능한 위쪽 경로의 합
        for(int y=0; y<path.length; y++){
            for(int x=0; x<path[y].length; x++){
                if((x==0 && y==0))
                    continue;
                
                if(path[y][x]==-1){
                    path[y][x]=0;
                    continue;
                }

                if(y-1<0)
                    path[y][x] = path[y][x-1] % 1000000007;
                else if(x-1<0)
                    path[y][x] = path[y-1][x] % 1000000007;
                else
                    path[y][x] = (path[y-1][x]+path[y][x-1])% 1000000007;
                
            }
        }
        
        return path[n-1][m-1];
    }
}
```

