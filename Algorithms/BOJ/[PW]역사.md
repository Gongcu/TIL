# 키 순서
[문제](https://www.acmicpc.net/problem/1613)

### 문제 설명
- N개의 사건이 존재하고 임의의 두 사건의 순서가 K개 주어진다.
- 이 때 임의로 두 사건을 뽑았을 때 어떤 사건이 먼저 발생했는지 출력하라.


### Note
- 이런 한 그룹 내에서 두 요소 간 대소 관계 혹은 순서 관계를 제시하는 경우 그래프 문제로 표현 가능
- 프로그래머스 '순위', BOJ '키 순서' 문제와 동일함
- 

```python
import sys

n,k = map(int,sys.stdin.readline().split())

## 그래프 초기화
INF = int(1e9)
graph = [[INF] * (n+1) for _ in range(n+1)]

## 사건 전후 관계 입력
for _ in range(k):
    start,end = map(int,sys.stdin.readline().split())
    graph[start][end]= 1

for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            graph[i][j] = min(graph[i][k]+graph[k][j], graph[i][j])

s = int(sys.stdin.readline())
result = []
for i in range(s):
    start, end = map(int,sys.stdin.readline().split())
    if graph[start][end] != INF:
        result.append(-1)
    elif graph[end][start] != INF:
        result.append(1)
    else:
        result.append(0)

for i in result:
    print(i)
```