# Course Schedule

[문제](https://leetcode.com/problems/course-schedule/)

## 문제 설명
파라미터로 총 강의 수와 선후추체계 정보가 담긴 배열이 주어진다. (prerequisites[i] = [ai, bi] ai를 수강하고 싶다면 bi를 먼저 수강해야 함.)

## 아이디어
- 방향 그래프로 풀이한다.
- prerequisites[i] = [ai, bi]는 bi -> ai를 나타낸다.
- DFS를 통해 사이클이 있는지 확인한다.


## 코드
``` java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0 || prerequisites.length==1)
            return true;

        Set<Integer> visited = new HashSet();
        Set<Integer> traced = new HashSet();
        
        List<List<Integer>> graph = new ArrayList();
        
        for(int i=0; i<numCourses; i++) graph.add(new ArrayList());
        for(int[] p : prerequisites)
            graph.get(p[0]).add(p[1]);
        
        
        
        for(int i=0; i<numCourses; i++)
            if(!dfs(graph,i,traced,visited))
                return false;
        
        return true;
    }
    
    //visited는 결과를 도출하는데는 필요하지 않지만 가지치기를 통해 시간복잡도를 줄임
    boolean dfs(List<List<Integer>> graph, int start, Set<Integer> traced, Set<Integer> visited){
        //기존에 방문한 노드 재방문 시 False
        if(traced.contains(Integer.valueOf(start)))
            return false;
        
        //기존에 방문해서 문제 없던 그래프는 True처리
        if(visited.contains(Integer.valueOf(start)))
            return true;
        
        
        traced.add(start);
        
        for(int i=0; i<graph.get(start).size(); i++){
            int next =graph.get(start).get(i);
            if(!dfs(graph, next, traced, visited))
                return false;
        }
    
        traced.remove(start);

        //문제 없는 그래프임을 확인
        visited.add(start);

        return true;
    }
}
```



