# 2018 KAKAO BLIND RECRUITMENT - [1차] 뉴스 클러스터링

[문제](https://programmers.co.kr/learn/courses/30/lessons/17677)

### Note
- Map의 활용


### 풀이
```java
import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        Map<String,Integer> map1 = new HashMap();
        Map<String,Integer> map2 = new HashMap();
        Map<String,Integer> sumMap = new HashMap();

        int common = 0;
        int sum = 0;
        int map1Length = 0, map2Length=0;
        
        for(int i=0; i<str1.length()-1; i++){
            String curr = str1.substring(i,i+2).toLowerCase();
            if(!isAlphabet(curr))
                continue;
            map1.put(curr,map1.getOrDefault(curr,0)+1);
            map1Length++;
        }
        for(int i=0; i<str2.length()-1; i++){
            String curr = str2.substring(i,i+2).toLowerCase();
            if(!isAlphabet(curr))
                continue;
            map2.put(curr,map2.getOrDefault(curr,0)+1);
            map2Length++;
        }

        //코드 이해를 쉽게 하기 위해 for문 분리
        
        //get common
        if(map1Length>map2Length) 
            for(Map.Entry<String,Integer> entry: map1.entrySet())
                common+=Math.min(entry.getValue(),map2.getOrDefault(entry.getKey(),0));
            
        else
            for(Map.Entry<String,Integer> entry: map2.entrySet())
                common+=Math.min(entry.getValue(),map1.getOrDefault(entry.getKey(),0));
        
        //get sum
        for(Map.Entry<String,Integer> entry: map1.entrySet())
            sumMap.put(entry.getKey(), entry.getValue());
        for(Map.Entry<String,Integer> entry: map2.entrySet())
            sumMap.put(entry.getKey(), Math.max(sumMap.getOrDefault(entry.getKey(),0),entry.getValue()));
        
        for(Map.Entry<String,Integer> entry:sumMap.entrySet()){
            sum +=entry.getValue();
        }
        
        if(sum==0)
            return 65536;
        
        
        return (int)(((double)common/sum)*65536);
    }
    
    boolean isAlphabet(String str){
        if((str.charAt(0)>=65 && str.charAt(0)<=90 || str.charAt(0)>=97 &&str.charAt(0) <=122) &&
            (str.charAt(1)>=65 && str.charAt(1)<=90 || str.charAt(1)>=97 &&str.charAt(1) <=122))
            return true;
        else
            return false;
    }
}
```

