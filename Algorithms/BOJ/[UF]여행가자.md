# 여행가자
[문제](https://www.acmicpc.net/problem/1976)

### 문제 설명
- N개의 도시가 있고 여행 계획에 포함된 도시 M개가 주어진다.
- 이 때, 도시별 연결 그래프가 주어질 떄 해당 여행 계획이 가능한 지 확인해라
- 여행 계획 과정에서 다른 도시를 방문해도 되고, 여러번 방문하는 것도 가능하다.


### Note
- Union-Find로 접근하여 여행 계획에 포함된 도시들의 root가 모두 같을 경우 가능
- 여러번 방문 가능하다는 점도 Union-Find의 특징이다.


```java
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            parent = new int[n+1];
            for(int i=1; i<n+1; i++){
                parent[i]=i;
            }

            List<List<Integer>> graph = new ArrayList();
            for(int i=0; i<n+1; i++) graph.add(new ArrayList());

            for(int i=0; i<n; i++){
                String[] inputs = br.readLine().split(" ");
                for(int j=0; j<inputs.length; j++){
                    if(inputs[j].equals("1")){
                        graph.get(i+1).add(j+1);
                        union(i+1,j+1);
                    }
                    
                }
            }

            String[] pathstr = br.readLine().split(" ");
            List<Integer> path = new ArrayList();
            for(String item : pathstr){
                path.add(Integer.valueOf(item));
            }
    
            String result = "YES";
            int root = find(path.get(0));
            for(int i = 1; i<path.size(); i++){
                if(root!=find(path.get(i)))
                    result ="NO";
            }
            System.out.println(result);
    }


    static int find(int x){
        if(parent[x]==x)
            return x;
    
        int p = find(parent[x]);
        parent[x]=p;
        return p;
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x!=y)
            parent[y]=x;
    }
}
```
