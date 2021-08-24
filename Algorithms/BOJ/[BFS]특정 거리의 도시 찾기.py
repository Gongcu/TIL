import sys
from collections import deque

N,M,K,START= map(int,sys.stdin.readline().split())

graph = []

for i in range(0,N+1):
    graph.append([])

for i in range(0,M):
    source,dest= map(int,sys.stdin.readline().split())
    graph[source].append(dest)


path = [-1 for i in range(0,N+1)]
queue = deque()
queue.append(START)
path[START] = 0

while len(queue)!=0:
    curr = queue.popleft()
    for next in graph[curr]:
        if path[next]!=-1:
            continue
        path[next]=path[curr]+1
        queue.append(next)

result = []
for i,dist in enumerate(path):
    if dist==K:
        result.append(i)

if len(result) == 0 :
    print(-1)
else:
    result.sort()
    for i in result:
        print(i)
