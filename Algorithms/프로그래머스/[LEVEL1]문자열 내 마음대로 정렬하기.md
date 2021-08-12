# 문자열 내 마음대로 정렬하기

[문제](https://programmers.co.kr/learn/courses/30/lessons/12915?language=java)

## 코드
```java
import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        int t;
        String temp;
        String[] answer = new String[strings.length];
        ArrayList<String> list = new ArrayList();
        
        //기존 배열을 n번째 기준 정렬
        for(int i=0; i<strings.length-1; i++){
            for(int j=i+1; j<strings.length; j++){
                if(strings[i].charAt(n)>strings[j].charAt(n)){
                    temp = strings[i];
                    strings[i]=strings[j];
                    strings[j]=temp;
                }
            }
        }
        
        //n번째 기준으로 정렬된 문자열에 대해 n번째 값이 같은 경우 해당 부분에 대해 사전식 정렬
        for(int i=0; i<strings.length; i++){
            //i부터 몇 번째까지 중복인가?
            t=i;
            list.add(strings[i]);
            while(t+1<strings.length){
                if(strings[i].charAt(n)==strings[t+1].charAt(n)){
                    list.add(strings[++t]);
                }
                else
                    break;
            }
            
            if(list.size()==1) //중복이 없는 경우
                answer[i]=list.get(0);
            else{ //중복이 존재할 경우
                Collections.sort(list);
                for(int k=0; k<list.size(); k++)
                    answer[i+k]=list.get(k);
            }
            list.clear();
            i=t; //t까지 정렬되었으므로 i를 j로 갱신
        }
    
        return answer;
    }
}
```



