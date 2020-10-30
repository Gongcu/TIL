# 네트워크 - DFS

[문제](https://programmers.co.kr/learn/courses/30/lessons/43162)

## DFS(깊이 우선 탐색)
그래프에서 연결 요소를 깊이 우선으로 탐색하는 알고리즘.
해당 문제에서 키 포인트는 방문하지 않은 정점 별로 DFS를 수행하여 수행된 만큼 카운트 증가.

## 코드
```java
import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        boolean[] visited = new boolean[n];
        
        //방문되지 않은 점들에 대해서 dfs 수행한 뒤 answer 증가
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(computers, i, visited);
                answer++;
            }
        }
        
        return answer;
    }
    private void dfs(int[][] computers, int point, boolean[] visited){
        Stack<Integer> stack = new Stack();
        stack.push(point);
        while(!stack.empty()){
            int v = stack.pop();
            for(int i=0; i<computers.length; i++){
                if(computers[v][i]==1 && !visited[i]){
                    visited[i]=true;
                    stack.push(i);
                }
            }
        }
    }

}
```


