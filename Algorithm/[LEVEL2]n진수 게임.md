# 2018 KAKAO BLIND RECRUITMENT - [3차] n진수 게임

[문제](https://programmers.co.kr/learn/courses/30/lessons/17687)

## Note
- 진법 변환
- 구현
- 바로 코딩하지 말고 문제를 어떻게 해결할 지 시간을 들여 생각

## 코드
```java
import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String num = "";
        int curr = 0;
        int i = p-1;
        
        while(num.length()/m < t){
            num +=convert(n,curr);
            curr++;
        }
        
        //m번씩 건너뛰며 t길이를 만족할 때 까지 추출
        while(answer.length()!=t){
            answer += num.charAt(i);
            i+=m; 
        }
        
        System.out.println(num);
        return answer;
    }
    
    String convert(int n, int num){
        String result = "";
        while(num>=n){
            if(num%n > 9)
                result += (char)(55+num%n)+"";
            else
                result+=num%n;
            num /= n;
        }
        //16진수의 10 같은 경우 아래 return에서 뒤집으면 01되기 때문에 필터링
        //또한, 10~15는 A,B,C,D,E로 교체
        if(n>10 && num >9){
            //65부터 A ,B, C, ...
            result+=(char)(55+num)+""; 
        }else{
            result+=num+"";
        }
            
        return new StringBuilder(result).reverse().toString();
    }
}
```


