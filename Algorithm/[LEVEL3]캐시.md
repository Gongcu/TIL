# 2018 KAKAO BLIND RECRUITMENT - 캐시

[문제](https://programmers.co.kr/learn/courses/30/lessons/17680)

## Note
- LRU 메커니즘의 이해

## 코드
```java
import java.util.*;
class Solution {
    LinkedList<String> cache = new LinkedList();
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int count = 0;
        
        //대소문자 구분 없음 -> 대문자화
        for(int i=0; i<cities.length; i++)
            cities[i]=cities[i].toUpperCase();
        
        //캐시 크기에 따른 실행시간 측정
        while(count!=cities.length){
            if(isHit(cities[count])){
                reorder(cities[count],cacheSize);
                answer +=1;
            }else{
                misReorder(cities[count],cacheSize);
                answer +=5;
            }
            count++;
        }
        
        return answer;
    }
    
    void reorder(String hitItem,int cacheSize){
        if(cache.size()>0)
            cache.removeFirstOccurrence(hitItem);
        if(cacheSize>0 && cacheSize>cache.size())
            cache.add(hitItem);
    }
    
    void misReorder(String newItem,int cacheSize){
        if(cache.size()>0 && cache.size()==cacheSize)
            cache.removeFirst();
        if(cacheSize>0 && cacheSize>cache.size())
            cache.add(newItem);
    }
    
    Boolean isHit(String curr){
        return cache.contains(curr);
    }
}
```


