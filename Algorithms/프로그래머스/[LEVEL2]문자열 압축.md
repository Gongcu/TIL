# 2020 KAKAO BLIDE RECRUITMENT - 문자열 압축

[문제](https://programmers.co.kr/learn/courses/30/lessons/60057#)

## Note
- 문자열 활용 문제 -> 다양한 테스트 케이스 고려

## 코드
```java
import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int count = 1;
        ArrayList<String> list = new ArrayList();
        ArrayList<Integer> lengths = new ArrayList();
        
        for(int i=0; i<=s.length(); i++){
            String curr = s.substring(0,i+1);
            list.add("");
            for(int j=i+1;j<s.length();j+=(i+1)){
                //다음 비교가 불가능한 경우(마지막 문자열) -> 메인문자열+=((숫자)+비교문자열)
                if(j+i+1>s.length()){
                    if(count>1)
                        list.set(i,list.get(i)+count);
                    list.set(i,list.get(i)+curr);
                    curr=s.substring(j,s.length());
                    count = 1;
                    break;
                }
                //다음 비교가 가능한 경우
                else{
                    //다음 문자열과 같음 -> count 증가
                    if(curr.equals(s.substring(j,j+i+1))) 
                        count++;
                    //다음 문자열과 다름 -> 메인문자열+=(숫자+비교문자열)
                    else{ 
                        if(count>1)
                            list.set(i,list.get(i)+count);
                        list.set(i,list.get(i)+curr);
                        count=1;
                        curr=s.substring(j,j+i+1);
                    }
                }
            }
            
            //마지막 남은 문자열 추가
            switch(count){
                case 1:
                    //count가 없을 경우 메인문자열+=남은문자열
                    list.set(i,list.get(i)+curr);
                    break;
                default:
                    //count가 없을 경우 메인문자열+=(카운트+남은문자열)
                    list.set(i,list.get(i)+count+curr);
                    break;
            }
            lengths.add(list.get(i).length());
            count = 1;
        }

        answer = Collections.min(lengths);
        
        return answer;
    }
}
```



