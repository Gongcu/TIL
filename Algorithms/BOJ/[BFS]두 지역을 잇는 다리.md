# 두 지역을 잇는 다리

[문제](https://www.acmicpc.net/problem/17352)

### Note
- 그래프 탐색 문제

```java
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//1~N까지 N개의 섬 존재
//섬들을 잇는 N-2개의 다리가 주어짐
//두 섬 사이에 다리를 하나 두어 어떤 섬이든 왕복이 가능하게 해라

// 첫 줄에 섬의 개수
// 다음 N-2번 줄에는 간선

public class P17352 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            boolean[] visited = new boolean[N + 1];
            List<List<Integer>> graph = new ArrayList();
            for (int i = 0; i < N + 1; i++)
                graph.add(new ArrayList());


            for (int i = 0; i < N - 2; i++) {
                String[] x = br.readLine().split(" ");
                int node1 = Integer.parseInt(x[0]);
                int node2 = Integer.parseInt(x[1]);

                graph.get(node1).add(node2);
                graph.get(node2).add(node1);
            }

            List<Integer> list1 = bfs(graph, visited, 1);
            List<Integer> list2;
            for (int i = 1; i < N + 1; i++) {
                if (!visited[i]) {
                    list2 = bfs(graph, visited, i);
                    System.out.println(list1.get(0) + " " + list2.get(0));
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> bfs(List<List<Integer>> graph, boolean[] visited, int start) {
        List<Integer> list = new ArrayList<>();

        Queue<Integer> queue = new LinkedList();

        queue.offer(start);
        visited[start] = true;
        list.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    list.add(next);
                }
            }
        }
        return list;
    }

}
```