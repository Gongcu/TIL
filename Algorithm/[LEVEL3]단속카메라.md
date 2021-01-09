# 3진법 뒤집기

[문제](https://programmers.co.kr/learn/courses/30/lessons/68935)

### Note
- 복잡하게 생각하지 말기
- 코드 라인 100줄 넘어가면 맞는 솔루션인가 의심
- 해법: 차량이 나가기 전에는 무조건 단속이 되어야 함 -> 나가는 순서대로 정렬

### 코드
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



