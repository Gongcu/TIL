# 3진법 뒤집기

[문제](https://programmers.co.kr/learn/courses/30/lessons/68935)


## 코드
```java
import java.util.*;
import java.lang.Math;
class Solution {
    public int solution(int n) {
        int answer = 0;
        String a="";
        int num=0;
        int i=0; //3진법 자릿수
        for(;;){
            if((n/(int)Math.pow(3,i++))>0)
                continue;
            else{
                i--;
                break;
            }
        }
        
        //3진법 변환, 높은 자릿수의 수부터 계산
        for(int j=i-1; j>=0; j--){
            for(int k=2; k>=0; k--){
                if(num==n){
                    a+=0;
                    break;
                }else if((num+(int)Math.pow(3,j)*k) <= n){
                    num+=(int)Math.pow(3,j)*k;
                    a+=k;
                    break; 
                }
            }
        }
        
        //10진법으로 표현
        for(int k=0; k<a.length(); k++)
            answer+=(int)Math.pow(3,k)*(a.charAt(k)-'0');
        
        return answer;
    }
}
```


