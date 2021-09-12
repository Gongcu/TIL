# 2차원 배열의 합
[문제](https://www.acmicpc.net/problem/2167)

### 문제 설명
- 2차원 배열이 주어질 때, 특정 2차원 구간의 모든 원소의 합을 구하라.


### Note
- 단순히 브루트 포스를 사용하면 시간 초과가 발생한다.
- 2차원 배열을 사용하는 DP를 이용하여 점화식을 찾아 해결한다.


```python
import sys

R,C= map(int,sys.stdin.readline().split())

graph = [[0]*(C+1) for _ in range(R+1)]
dp = [[0]*(C+1) for _ in range(R+1)]

for i in range(1, R+1):
    arr = list(map(int,sys.stdin.readline().split()))
    for j in range(1, C+1):
        graph[i][j] = arr[j-1]

for i in range(1, R+1):
    for j in range(1, C+1):
        graph[i][j] = graph[i][j]+graph[i-1][j]+graph[i][j-1]-graph[i-1][j-1]


num= int(sys.stdin.readline())

for _ in range(num):
    x,y,p,q = map(int,sys.stdin.readline().split())
    print(graph[p][q] - graph[p][y-1] - graph[x-1][q] + graph[x - 1][y - 1])
```

