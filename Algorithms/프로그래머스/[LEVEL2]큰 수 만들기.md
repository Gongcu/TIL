# 큰 수 만들기 - 그리디

[문제](https://programmers.co.kr/learn/courses/30/lessons/42883)


## 일반적인 풀이
```java
import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int max = -1;
        int max_index=0;
        //결과물의 자릿수(count) = nums.size()-k;
        //아래를 자릿수 만큼 반복
        //좌측에서 제일 높은 값을 뽑고 0~max_index는 다음 최대값 탐색에서 제외(우측에서 여분의 자릿수는 건들이지 않음) 
        //ex) 127..3453, 7뽑으면 ...3453만 남김
        int count = number.length()-k;
        for(int i=count;i>0;i--){
            //최대값 추출
            for(int j=max_index; j<=number.length()-i; j++){
                if(max<number.charAt(j)-'0'){
                    max=number.charAt(j)-'0';
                    max_index = j;
                }
                if(max == 9) break;
            }
            answer+=max;
            max = 0; max_index++; //다음 반복
        }               
        return answer;
    }
}
```

## 스택을 이용한 풀이
```java
import java.util.Stack;
class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
```

