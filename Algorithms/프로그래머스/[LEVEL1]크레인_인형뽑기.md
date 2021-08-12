# 카카오 겨울 인턴십 2019 - 크레인 인형뽑기

[문제](https://programmers.co.kr/learn/courses/30/lessons/64061)


```java
import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack();
        for(int k=0; k<moves.length; k++){
             for(int i=0; i<board.length; i++){
                 if(board[i][moves[k]-1]>0){//현재 크레인 칸에 인형 존재 -> 스택에 추가
                     if(!stack.empty() && stack.peek()==board[i][moves[k]-1]){
                         stack.pop(); answer+=2;
                     }else{
                         stack.push(board[i][moves[k]-1]);
                     }
                     board[i][moves[k]-1]=0;
                     break;
                 }else{
                     continue; //없으니 크레인 한칸 더 내림
                 }
            }
        }
        return answer;
    }
}
```

## 핵심
- Stack: 스택의 개념 및 활용
