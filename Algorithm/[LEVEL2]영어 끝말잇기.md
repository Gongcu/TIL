# 영어 끝말 잇기

[문제](https://programmers.co.kr/learn/courses/30/lessons/12981)


```java
import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer={0,0};
        ArrayList<String> list = new ArrayList();
        
        //중복 있는 경우 탈락
        for(int i=0; i<words.length; i++){
            if(list.contains(words[i])){
                answer[0]= i%n +1;//who
                answer[1]= i/n + 1;//tern
                return answer;
            }else{
                list.add(words[i]);
            }
        }
        
        char next_start;
        char prev_end=words[0].charAt(words[0].length()-1);
        for(int i=1; i<words.length; i++){
            next_start = words[i].charAt(0);
            if(prev_end!=next_start){
                answer[0]= i%n +1;//who
                answer[1]= i/n + 1;//tern
                return answer;
            }else{
                prev_end=words[i].charAt(words[i].length()-1);
            }
        }

        return answer;
    }
}
```

## 핵심 - ArrayList 활용

