# 가장 먼 노드 - BFS

[문제](https://programmers.co.kr/learn/courses/30/lessons/49189)

### Note
- BFS를 이용한 노드 별 거리 탐색
- 해당 문제의 경우 `인접행렬`로 풀이한 결과 메모리 초과가 발생 -> 희소그래프의 경우 `인접리스트`활용


### 풀이
```java
import java.util.*;
class Solution {
    ArrayList<ArrayList<Integer>> g = new ArrayList();
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max=0;
        int[] dist=new int[n];
        
        for(int i=0; i<n; i++){
            dist[i]=-1;
            g.add(new ArrayList());
        } 
        
        
        //관리 편의상 모든 점의 번호 -1 
        for(int i=0; i<edge.length; i++){
            int point1 = edge[i][0]-1;
            int point2 = edge[i][1]-1;
            
            g.get(point1).add(point2);
            g.get(point2).add(point1);
        }
        
        bfs(dist);
        
        for(int i=0; i<dist.length; i++){
            if(max<dist[i])
                max=dist[i];
        }
        
        for(int i=0; i<dist.length; i++)
            if(max==dist[i])
                answer++;
        
        return answer;
    }
    
    void bfs(int[] dist){
        Queue<Integer> q = new LinkedList();
        q.add(0);
        
        dist[0] = 0;
        
        while(q.size()!=0){
            int curr = q.poll();
            for(int i=0; i<g.get(curr).size(); i++){
                int next = g.get(curr).get(i);
                if(dist[next]==-1){
                    dist[next] = dist[curr]+1;
                    q.add(next);
                }
            }
        }
    }
}
```

