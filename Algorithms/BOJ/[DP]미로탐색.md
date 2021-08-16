# 미로탐색

## 아이디어
- DP를 활용하여 문제를 해결한다.
- DFS, BFS로 풀이 가능

```java
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] nbym = br.readLine().split(" ");
            int n = Integer.parseInt(nbym[0]);
            int m = Integer.parseInt(nbym[1]);
            
            int[][] graph = new int[n][m];
            for(int i=0; i<n; i++){
                String row = br.readLine();
                for(int j=0; j<row.length(); j++)
                    graph[i][j]=row.charAt(j)-'0';
            }

            int result = bfs(graph,n,m);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int bfs(int[][] graph, int n, int m){
        Queue<Integer[]> queue = new LinkedList();
        int[][] path = new int[n][m];
        path[0][0]=1;

        queue.offer(new Integer[]{0,0});

        while(!queue.isEmpty()){
            Integer[] point = queue.poll();
            int y = point[0];
            int x = point[1];

            if(y+1<n && graph[y+1][x]==1 && path[y+1][x]==0){
                path[y+1][x]=path[y][x]+1;
                queue.offer(new Integer[]{y+1,x});
            }

            if(y-1>=0 && graph[y-1][x]==1 && path[y-1][x]==0){
                path[y-1][x]=path[y][x]+1;
                queue.offer(new Integer[]{y-1,x});
            }
            
            if(x+1<m && graph[y][x+1]==1 && path[y][x+1]==0){
                path[y][x+1]=path[y][x]+1;
                queue.offer(new Integer[]{y,x+1});
            }
                
            if(x-1>=0 && graph[y][x-1]==1 && path[y][x-1]==0){
                path[y][x-1]=path[y][x]+1;   
                queue.offer(new Integer[]{y,x-1});
            }
        }

        return path[n-1][m-1];
    }
}
```
