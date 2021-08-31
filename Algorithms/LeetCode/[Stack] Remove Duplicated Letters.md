# Remove Duplicated Letters

[문제](https://leetcode.com/problems/remove-duplicate-letters/)

## 문제 설명
중복문자를 제외하고 사전식으로 나열하라

## 아이디어
- 스택을 이용하여 해결한다.
- 각 문자 별 개수를 관리하는 배열과 문자가 현재 문자열에 존재하는지 확인하는 배열로 관리한다.
- 새로운 문자를 삽입할 때, stack의 pop을 추출하여 해당 문자가 넉넉히 존재할 경우 제외하는걸 반복하고, 이후에 새 문자를 추가한다.

## 코드
```java
import java.util.*;
class Solution {
    
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack();
        int[] counter = new int[26];
        boolean[] isExist = new boolean[26];
        
        for(char ch : s.toCharArray()){
            counter[ch-'a']++;
        }
        
        for(char ch : s.toCharArray()){
            counter[ch-'a']--;
            
            if(isExist[ch-'a'])
                continue;
            
            while(!stack.empty() && stack.peek() > ch && counter[stack.peek()-'a']>0){
                int poped = stack.pop();
                isExist[poped -'a']=false;
            }
            
            stack.push(ch);
            isExist[ch-'a']=true;    
        }
        
        StringBuilder sb = new StringBuilder();
        for(char ch : stack){
            sb.append(ch);
        }
        return sb.toString();
    }
    
}
```



