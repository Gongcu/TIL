# 완주하지 못한 선수

[문제] (https://programmers.co.kr/learn/courses/30/lessons/42576)


### 효율성이 떨어지는 풀이 - 연결리스트
```java
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        LinkedList<String> pList = new LinkedList();
        for(int i=0; i<participant.length; i++)
            pList.add(participant[i]);
        
        for(int i=0; i<completion.length; i++){
            int index = pList.indexOf(completion[i]);
            if(index==-1)
                return pList.get(index);
            else
                pList.remove(index);
        }
        return pList.get(0);
    }
}
```

### 효율성이 좋은 풀이 - 해시 맵
```java
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        //참가자를 hashMap에 추가, 결과는 <참가자명, 같은 이름의 미 완주자 수>
        for(int i=0 ;i<participant.length; i++)
            map.put(participant[i], map.getOrDefault(participant[i],0)+1);
            
        //hashMap의 참가자를 완주자 키로 찾고, 미 완주자 수를 1 감소
        for(int i=0 ;i<completion.length; i++)
            map.put(completion[i], map.get(completion[i])-1);
        
        //value가 1이상 : 미 완주자
        for(int i=0 ;i<participant.length; i++)
            if(map.get(participant[i])>0)
                return participant[i];
        
        //cannot reach below return statement
        return null;
    }
}
```

## 핵심 - HashMap 
<key,value>로 이루어진 자료구조. 핵심은 key 값을 통해 O(1)의 시간복잡도를 가진다.
또한, key값은 중복되지 않는다. 예를들어 <1, 100>이 해시맵에 존재하고, <1,50>을 put하면 기존 값은 사라진다.

#### 주요 메서드
 - .put(key, value) : <key,value> 저장
 - .get(key): key에 해당하는 value 반환.
 - .getOrDefault(key, defaultValue): key에 해당하는 value를 얻는다. 만약 해당 키가 없다면 defaultValue를 반환한다.
 
