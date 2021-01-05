# 단어변환 - BFS

[문제](https://programmers.co.kr/learn/courses/30/lessons/43163)

### BFS(너비 우선 탐색)
그래프에서 연결 요소를 너비 우선으로 탐색하는 알고리즘.

### Note
- 그래프화
- BFS로 최단거리 구하여 반환(타겟 지점에 도착할 경우 해당 거리 반환)

## 코드
```java
import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int targetPoint=-1;
        int[][] graph = new int[words.length+1][words.length+1];
        String[] points = new String[words.length+1];
        
        
        for(int i=0; i<words.length; i++){
            if(words[i].equals(target)){
                targetPoint=i+1;
                break;
            }
        }
        
        if(targetPoint==-1)
            return 0;
            
        
        points[0] = begin;
        for(int i=0; i<words.length; i++)
            points[i+1]=words[i];
        
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                if(i!=j && changable(points[i],points[j]))
                    graph[i][j]=1;
            }
        }
        
        answer = bfs(graph,0,targetPoint);
        
        return answer;
    }
    
    int bfs(int[][] graph, int from, int to){
        Queue<Integer> queue = new LinkedList();
        
        //출발점에서 각 지점 별 거리 트래킹 변수
        int[] dist = new int[graph.length]; 
        for(int i=0; i<dist.length; i++) dist[i]=-1;
        
        //출발점에서 출발점까지의 거리는 0
        dist[from] = 0;
        queue.add(from);
        
        while(queue.size()!=0){
            int curr = queue.poll();
            for(int i=0; i<graph[curr].length; i++){
                int next = i;
                //다음으로 이동가능하며 방문하지 않은 점일 경우
                if(graph[curr][next]==1 && dist[next]==-1){
                    dist[next]=dist[curr]+1;
                    if(next==to) return dist[next];
                    queue.add(next);
                }
            }
        }
        
        //도착 불가능한 경우
        return 0;
    }
    
    boolean changable(String begin, String target){
        int count = 0;
        for(int i=0; i<begin.length(); i++){
            if(begin.charAt(i) != target.charAt(i))
                count++;
        }
        if(count>=2)
            return false;
        else
            return true;
    }
}
```




