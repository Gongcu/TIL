# 짝지어 제거하기

[문제](https://programmers.co.kr/learn/courses/30/lessons/12973)


```java
import java.util.*;
class Solution
{
    public int solution(String s)
    {
        if(s.length()%2==1)
            return 0;
        
        if(s.length()==0)
            return 1;
        
        int answer = 1;
        
        Stack<Character> stack = new Stack();
        stack.push(s.charAt(0));
        
        for(int i=1; i<s.length(); i++){
            if(!stack.empty() && stack.peek() == s.charAt(i)){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        
        if(stack.size()!=0)
            answer = 0;
        return answer;
    }
}
```
