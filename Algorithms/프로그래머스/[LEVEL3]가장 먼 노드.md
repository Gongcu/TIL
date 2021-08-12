# 가장 먼 노드 - BFS

[문제](https://programmers.co.kr/learn/courses/30/lessons/49189)

### Note
- BFS를 이용한 노드 별 거리 탐색
- 해당 문제의 경우 `인접행렬`로 풀이한 결과 메모리 초과가 발생 -> 희소그래프의 경우 `인접리스트`활용
- 그래프화 풀이, 비그래프화 풀이

### 그래프화 풀이
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

### 비그래프화
```java
import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] dist = new int [n];
        for(int i=0; i<dist.length; i++) dist[i]=-1;
        bfs(0,edge,dist);
        
        Arrays.sort(dist);
        for(int i=0; i<dist.length; i++){
            if(dist[dist.length-1]==dist[i])
                answer++;
        }
        
        return answer;
    }
    
    void bfs(int start, int[][] graph, int[] dist){
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        dist[start]=0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int i=0; i<graph.length; i++){
                //아래 조건문은 주어진 edge가 단방향 형태로 주어져있기 때문에 양방향으로 고려하기 위함
                if(graph[i][0]-1 == curr && dist[graph[i][1]-1]==-1){
                    int next = graph[i][1]-1;
                    queue.add(next);
                    dist[next]=dist[curr]+1;
                }else if(graph[i][1]-1==curr && dist[graph[i][0]-1]==-1){
                    int next = graph[i][0]-1;
                    queue.add(next);
                    dist[next]=dist[curr]+1;
                }
            }
        }
    }
}
```