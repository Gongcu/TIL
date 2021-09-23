# 여행경로 - DFS

[문제](https://programmers.co.kr/learn/courses/30/lessons/43164#)

## DFS(깊이 우선 탐색)
그래프에서 연결 요소를 깊이 우선으로 탐색하는 알고리즘.
해당 문제에서 키 포인트는 방문하지 않은 정점 별로 DFS를 수행하여 수행된 만큼 카운트 증가.

## 문제 핵심 아이디어
- 방문 과정에서 문자열이 빠른 순서로 방문 -> 정렬
- 티켓 전부를 사용해야 함 -> 티켓이 전부 사용될 경우에만 종료

## 코드
```java
import java.util.*;
class Solution {
    List<String> path = new ArrayList();
    boolean find = false;
    
    public String[] solution(String[][] tickets) {
        boolean[] used = new boolean[tickets.length];
        
        //정렬 시작 도시가 같은 경우 도착 도시 알파벳이 앞서게
        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                if(!o1[0].equals(o2[0]))
                    return o1[0].compareTo(o2[0]);
                else
                    return o1[1].compareTo(o2[1]);
            }
        });
        

        //ICN 찾기
        int i = 0;
        for(; i<tickets.length; i++){
            if(tickets[i][0].equals("ICN"))
                break;
        }
        
        while(!find){
            dfs(i, tickets, used, 0);
                
            if(!find){
                i++;
                Arrays.fill(used,false);
                path.clear();
            }
        }
        
        
        String[] result = new String[path.size()];
        i= 0;
        for(String city : path)
            result[i++] = city;
        
        return result;
    }
    
    void dfs(int start, String[][] tickets, boolean[] used, int n){
        used[start] = true;
        path.add(tickets[start][0]);
        
        if(usedAll(used)){
            path.add(tickets[start][1]);
            find = true;
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(used[i] || !tickets[start][1].equals(tickets[i][0])) 
                continue;
            
            
            dfs(i, tickets, used, n+1);
            
            if(find)
                return;
            
            used[i] = false;
            path.remove(path.size()-1);
            
        }
        
        

    }
    
    boolean usedAll(boolean[] used){
        for(boolean value : used)
            if(!value)
                return false;
        return true;
    }
}
```

