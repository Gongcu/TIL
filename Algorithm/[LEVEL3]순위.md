# 순위

[문제](https://programmers.co.kr/learn/courses/30/lessons/49191#)

## Note
- 그래프 문제임을 파악하기 -> 연쇄적인 결과가 주어짐
- 승자에서 패자로 간선을 잇는 단방향 그래프와 그 반대인 패자에서 승자로 잇는 단방향 그래프를 생성
- 한 권투선수에서 각각의 그래프에서 탐색을 진행해서 각각 방문할 수 있는 노드의 수를 게산
- 위에서 두 값의 합이 n-1이라면 그 선수의 순위를 확정지을 수 있음

## 코드
```java
import java.util.*;
class Solution {
    ArrayList<ArrayList<Integer>> winner = new ArrayList();
    ArrayList<ArrayList<Integer>> looser = new ArrayList();

    public int solution(int n, int[][] results) {
        int answer = 0;
        int[] count = new int[n];
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n;i++){
            winner.add(new ArrayList());
            looser.add(new ArrayList());
            count[i]=0;
        }
        
        for(int i=0; i<results.length; i++){
            winner.get(results[i][0]-1).add(results[i][1]-1);
            looser.get(results[i][1]-1).add(results[i][0]-1);
        }
        
        
        for(int i=0; i<n; i++){
            visitedToFalse(visited);
            dfs(winner,i,visited,count);
            visitedToFalse(visited);
            dfs(looser,i,visited,count);
        }
        
        
        for(int i=0; i<count.length; i++){
            if(count[i]==n-1)
                answer++;
        }
        
        return answer;
    }
    
    void dfs(ArrayList<ArrayList<Integer>> graph,int point,boolean[] visited, int[] count){
        Stack<Integer> stack = new Stack();
        stack.push(point);
        
        while(!stack.empty()){
            int curr=stack.pop();
            for(int i=0; i<graph.get(curr).size(); i++){
                int next = graph.get(curr).get(i);
                if(!visited[next]){
                    visited[next]=true;
                    stack.push(next);
                    count[next]+=1;
                }
            }
        }
    }
    
    void visitedToFalse(boolean[] visited){
        for(int i=0; i<visited.length; i++)
            visited[i]=false;
    }
}
```


