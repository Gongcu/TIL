# 3진법 뒤집기

[문제](https://programmers.co.kr/learn/courses/30/lessons/42884)

### Note
- 복잡하게 생각하지 말기
- 코드 라인 100줄 넘어가면 맞는 솔루션인가 의심
- 해법: 차량이 나가기 전에는 무조건 단속이 되어야 함 -> 나가는 순서대로 정렬

### 코드가 간단한 풀이
```java
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        int camera = 0;
        
        Arrays.sort(routes, (o1, o2)->o1[1]-o2[1]);
        camera = routes[0][1];
        for(int i=1; i<routes.length; i++){
            if(routes[i][0]>camera){
                answer++;
                camera=routes[i][1];
            }
        }
        
        return answer;
    }
}
```

### 직관적인 풀이
```java
import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        int camera;
        int i=0;

        //나가는 순으로 정렬
        Arrays.sort(routes, (o1,o2) -> o1[1]-o2[1]);
        //가장 먼저 나가는 차량 위치에 카메라 설치
        camera = routes[0][1];

        do{
            //현재 카메라에 단속되는 차량 검사
            for(int j=i; j<routes.length; j++){
                i=j;
                if(routes[j][0]<=camera && routes[j][1]>=camera){ //단속되는 경우
                    continue;
                }else{//단속되지 않는 경우
                    //카메라 설치
                    camera = routes[j][1];
                    answer++;
                    break;
                }
            }
            if(i==routes.length-1)
                break;
        }while(i<routes.length);
        return answer;
    }
}
```



