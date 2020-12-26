# 3진법 뒤집기

[문제](https://programmers.co.kr/learn/courses/30/lessons/42587)

## Tip
- ArrayLSIT를 Queue 처럼 활용: remove(0)
- Map.entry("key","value")를 활용한 리스트


## 코드
```java
import java.util.*;
class Solution {
    ArrayList<Map.Entry<Integer,Integer>> queue = new ArrayList();

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int max;
        //QUEUE <LOCATION, PRIORITY> 
        
        for(int i=0; i<priorities.length; i++)
            queue.add(Map.entry(i,priorities[i]));
        
        max = getMax();
        
        while(!queue.isEmpty()){
            Map.Entry<Integer,Integer> item = queue.get(0);
            

            if(item.getValue()<max){
            //꺼낸 값이 최대가 아닐 경우 맨 뒤로 삽입
                queue.remove(0);
                queue.add(item);
            }else{
            // 최대일 경우 출력, 만약 원햇던 아이템이면 break, 아니면 최대값을 재설정하고 다시 반복
                answer++;
                queue.remove(0);
                
                if(item.getKey()==location)
                    break;
                else
                    max = getMax();
            }
        }
        return answer;
    }
    
    int getMax(){
        int max = queue.get(0).getValue();
        for(int i=1; i<queue.size(); i++)
            if(max<queue.get(i).getValue())
                max = queue.get(i).getValue();
        return max;
    }
}
```



