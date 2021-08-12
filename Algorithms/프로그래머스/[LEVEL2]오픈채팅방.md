# 2019 KAKAO BLIND RECRUITMENT - 오픈채팅방

[문제](https://programmers.co.kr/learn/courses/30/lessons/42888)

### Note
- 구현

```java
import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> list = new ArrayList();
        HashMap<String,String> map =new HashMap();
        String[] answer;
        
        //ID별 닉네임 저장
        for(String r : record){
            String[] arr = r.split(" ");
            if(arr[0].equals("Enter"))
                map.put(arr[1],arr[2]);
            else if(arr[0].equals("Change"))
                map.put(arr[1],arr[2]);
        }
        
        //레코드를 탐색하며 ID를 가장 최신 닉네임과 매칭
        for(int i=0; i<record.length; i++) {
            String[] arr = record[i].split(" ");
            if(arr[0].equals("Enter"))
                list.add(map.get(arr[1])+"님이 들어왔습니다.");
            else if(arr[0].equals("Leave"))
                list.add(map.get(arr[1])+"님이 나갔습니다.");
            else
                continue;
        }
        
        //결과
        answer = new String[list.size()];           
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
}
```

