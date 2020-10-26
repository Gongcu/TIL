# 두 개 뽑아서 더하기

[문제](https://programmers.co.kr/learn/courses/30/lessons/64061)


```java
import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        ArrayList<Character> slist = new ArrayList(); //스킬 트리 캐릭터
        ArrayList<Character> list = new ArrayList();  //스킬트리 별
        ArrayList<Character> alist = new ArrayList(); //정답 확인

        for(int i=0; i<skill.length(); i++)
            slist.add(skill.charAt(i));
        for(int k=0; k<skill_trees.length; k++){
            //k번째 스킬 트리 리스트 생성
            for(int i=0; i<skill_trees[k].length(); i++){
                list.add(skill_trees[k].charAt(i));
            }
            //리스트의 아이템이 스킬트리에 존재할 경우 추가
            for(int j=0; j<list.size(); j++){
                if(slist.contains(list.get(j))) 
                    alist.add(list.get(j));
            }
            
            //스킬트리 순서가 맞지 않을 경우 정답 수 감소
            for(int i=0; i<alist.size(); i++){
                if(alist.get(i)!=slist.get(i)){
                    answer--;
                    break;
                }
            }
            list.clear(); alist.clear();
        }
        return answer;
    }
}
```

## 핵심 - ArrayList 활용

