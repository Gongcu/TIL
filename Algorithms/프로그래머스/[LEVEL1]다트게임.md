# 다트게임(2018 카카오 블라인드 채용) - 구현

[문제](https://programmers.co.kr/learn/courses/30/lessons/17682)


## 코드
```java
import java.util.*;
import java.lang.Math;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int count =0;
        char[] resultChar = new char[dartResult.length()];
        int[] splitIndex = new int[3];
        String[] splitStr = new String[3];
        for(int i=0; i<dartResult.length() && count<3; i++){
            if(Character.isDigit(dartResult.charAt(i))){//10의 경우 고려
                splitIndex[count]=i;
                count++;
                if(i<dartResult.length()-1 && dartResult.charAt(i+1)=='0')//10의 경우 고려하여 건너뛰기
                    i++;
            }
        }
        splitStr[0]=dartResult.substring(splitIndex[0],splitIndex[1]);
        splitStr[1]=dartResult.substring(splitIndex[1],splitIndex[2]);
        splitStr[2]=dartResult.substring(splitIndex[2]);
        
        for(int i=0; i<3; i++){
            System.out.println(splitStr[i]);
        }
        
        for(int i=0; i<splitStr.length; i++){
            if(splitStr[i].charAt(1)=='0'){//점수가 10점(두자리인 경우)
                int point = Integer.parseInt(splitStr[i].substring(0,2));
                int bonus = getBonus(splitStr[i].charAt(2));
                point = (int) Math.pow(point, bonus);
                if(splitStr[i].length()==4){
                    if(splitStr[i].charAt(3) == '*')
                        point *=2;
                    else if(splitStr[i].charAt(3) == '#')//아차상(#)
                        point = -point;
                }
                
                if(i!=2){
                    if(splitStr[i+1].length()==3)
                        if(splitStr[i+1].charAt(2)=='*')
                            point*=2;
                    else if(splitStr[i+1].length()==4)
                        if(splitStr[i+1].charAt(3)=='*')
                            point*=2;
                }
                answer +=point;
            }else{
                int point = splitStr[i].charAt(0)-'0';
                int bonus = getBonus(splitStr[i].charAt(1));
                point = (int) Math.pow(point, bonus);
                if(splitStr[i].length()==3){
                    if(splitStr[i].charAt(2) == '*')
                        point *=2;
                    else if(splitStr[i].charAt(2) == '#')//아차상(#)
                        point = -point;
                }
                
                if(i!=2){
                    if(splitStr[i+1].length()==3)
                        if(splitStr[i+1].charAt(2)=='*')
                            point*=2;
                    else if(splitStr[i+1].length()==4)
                        if(splitStr[i+1].charAt(3)=='*')
                            point*=2;
                }
                answer +=point;
            }
        }
        return answer;
    }
    
    private int getBonus(char a){
        if(a=='S')
            return 1;
        else if(a=='D')
            return 2;
        else 
            return 3;
    }
}
```


