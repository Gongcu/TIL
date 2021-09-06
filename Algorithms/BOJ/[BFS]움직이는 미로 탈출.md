# 움직이는 미로 탈출
[문제](https://www.acmicpc.net/problem/16954)

### 문제 설명
8x8 움직이는 미로 탈출
.: 이동가능 , #: 벽
벽(#)은 1초마다 아래 행으로 이동
캐릭터는 1초마다 고정 혹은 인접한 칸으로 이동(가로,세로,대각,제자리) 가능
벽과 캐릭터 중 캐릭터가 먼저 이동하고 그다음 벽이 이동하게 됨
벽이 캐릭터가 있는 칸으로 이동하면 캐릭터 이동 불가 -> 0
        
현재 위치 위에 벽이 있다면 무조건 이동
가려는 곳 위에 벽이 있다면 이동 불가 -> 하나도 갈 곳 없으면 0
        

### Note
- BFS로 이동 가능한 모든 경로 추가(범위 체크 및 다음 위치에 벽 있는지 체크)
- Queue에서 뽑아 현재 벽 위에 있을 경우 다음 경우로 이동, 없을 경우 해당 위치에서 다시 모든 경우 추가
- 시간이 8초가 넘어가거나 벽이 전부 없어질 경우 1 리턴

```java
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P16954 {
    static int[] dx = {1,1,1,0,0,0,-1,-1,-1};
    static int[] dy = {1,0,-1,1,0,-1,1,0,-1};

    public static void main(String[] args){
        final char[][] graph = buildGraph();
        int[] start = new int[]{7,0,0};//(Y,X,time)
        int result = bfs(start,graph);
        System.out.println(result+"");

    }

    public static int bfs(int[] start, final char[][] graph){
        Queue<int[]> queue = new LinkedList(); //
        queue.offer(start);
        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            if(outOfRange(curr))
                continue;

            int currY = curr[0];
            int currX = curr[1];
            int time = curr[2];

            char[][] currGraph = updateGraph(time, graph.clone());

            if(onTheWall(currGraph, curr))
                continue;
            
            if(time>=8 || graphIsEmpty(currGraph))
                return 1;
            

            for(int i=0; i<9; i++){
                int nextX = currX+dx[i];
                int nextY = currY+dy[i];
                
                //다음으로 이동 가능한 경우 추가
                if(!outOfRange(new int[]{nextY,nextX}) && !onTheWall(currGraph,new int[]{nextY,nextX,time}))
                    queue.offer(new int[]{currY+dy[i],currX+dx[i],time+1});
            }
     
        }

        return 0;
    }

    public static boolean outOfRange(int[] curr){
        return curr[0] >= 8 || curr[0]< 0 || curr[1] >= 8 || curr[1]< 0;
    }

    public static boolean onTheWall(char[][] graph,int[] curr){
        int currY = curr[0];
        int currX = curr[1];
        int time = curr[2];

        if(graph[currY][currX]=='#'){
            return true;
        }
        return false;
    }

    public static boolean graphIsEmpty(char[][] graph){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(graph[i][j]=='#')
                    return false;
            }
        }
        return true;
    }

    public static char[][] updateGraph(int time, char[][] graph){
        char[][] g = new char[8][8];
        for(int i=0; i<8; i++){
            for(int j=0; j<8;j++){
                g[i][j]='.';
            }
        }

        for(int i=0; i<8; i++){
            for(int j=0; j<8;j++){
                if(i-time >=0 && graph[i-time][j]=='#')
                    g[i][j]='#';
            }
        }

        return g;
    }

    public static char[][] moveWall(char[][] graph){
        char[][] g = new char[8][8];
        for(int i=0; i<8; i++){
            for(int j=0; j<8;j++){
                if(i+1<8 && graph[i][j]=='#')
                    g[i+1][j]='#';
                else
                    g[i][j]='.';
            }
        }
        return g;
    }
    
    public static char[][] buildGraph(){
        char[][] path = new char[8][8];
        //DFS 혹은 BT해서 패스 확인하면 될듯
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            for(int i=0; i<8; i++){
                String str = br.readLine();
                for(int j=0; j<8; j++)
                    path[i][j] = str.charAt(j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }
}

```