## 다중 조건 정렬
아래는 학번, 이름, 주소순으로 정렬하는 예제
```java
class Student {
    int num;
    String name;
    String address;
    
    Student(int num, String name, String address) {
        this.num = num;
        this.name = name;
        this.address = address;
    }
}


class StudentCompare implements Comparator<Student> {
    int ret = 0;
    
    @Override
    public int compare(Student s1, Student s2) {
        if(s1.num < s2.num) {
            ret = -1;
        }
        if(s1.num == s2.num) {
            if(s1.name.compareTo(s2.name) == 0) {
                if(s1.address.compareTo(s2.address) < 0) {
                    ret = 1;
                } else if(s1.address.compareTo(s2.address) == 0) {
                    ret = 0;
                } else if(s1.address.compareTo(s2.address) > 0) {
                    ret = -1;
                }
            } else if(s1.name.compareTo(s2.name) < 0) {
                ret = -1;
            } else if(s1.name.compareTo(s2.name) > 0) {
                ret = 1;
            }
        }
        if(s1.num > s2.num) {
            ret = 1;
        }
        return ret;
    }
}
```

## Comparator 람다 활용
- 기본 표현 방식
```java
Collections.sort(books, new Comparator<Book>() {
   @Override
   public int compare(Book o1, Book o2) {
       return o2.getPrice()-o1.getPrice();
  }
});
```

- 람다
```java
Collections.sort(books, (o1, o2) -> o2.getPrice()-o1.getPrice()); 
```

## BFS
```java
void BFS(int start, int[][] graph, int[] path){
    Queue<Integer> queue = new LinkedList();
    queue.add(start);
    path[start]=0;
    while(!queue.isEmpty()){
        int curr = queue.poll();
        for(int i=0; i<graph[curr].length; i++){
            if(graph[curr][i]==1 && path[i]==-1){
                queue.add(i);
                path[i]=path[curr]+1;
            }
        }
    }
}
```

## DFS
```java
//재귀
void DFS(int start, int[][] graph, boolean[] visited){
    visited[start]=true;
    for(int i=0; i<graph[start].length; i++){
        if(graph[start][i]==1 && !visited[i])
            DFS(i,graph,visited);
    }
}

//스택
void DFS(int start, int[][] graph; boolean[] visited){
    Stack<Integer> stack = new Stack();
    stack.push(start);
    visited[start]=true;
    while(!stack.empty()){
        int curr = stack.pop();
        for(int i=0; i<graph[curr].length; i++){
            if(graph[curr][i]==1 && !visited[i]){
                stack.push(i);
                visited[i]=true;
            }
        }
    }
}
```

## DP(Dynamic Programming)
이전 결과가 이후 결과에 사용됨(메모이제이션, 테뷸레이션) + 점화식
- 최적 부분 구조
- 중복되는 부분 문제

#### 메모이제이션(Memoization)
재귀함수로 구현되며 Top-down(하향식)으로 구현하며 필요한 계산만 하게 된다.

#### 테뷸레이션(Tabulation)
반복문으로 구현되며 Bottom-up(상향식)으로 구현되며 모든 계산을 하게 됨.

## Greedy
매 순간 최적의 수를 고려
- 최적 부분 구조(문제의 최종 해결법이 부분 문제에서도 해결법임)
- 탐욕적 선택 속성(앞의 선택이 이후의 선택에 영향을 끼치지 않음)

ex. 화폐 단위가 1/5/10이고 106원이 존재할 때, 가장 적은 수의 화폐를 발행하시오
-> 첫번째로는 10으로 나눔(가장 최적)
-> 두번째로는 5로 ...