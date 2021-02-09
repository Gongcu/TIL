# 베스트앨범

[문제](https://programmers.co.kr/learn/courses/30/lessons/42579)

### Note
- 해시맵
- 맵 리스트: ArrayList<ArrayList<Map.Entry<Integer,Integer>>>
- Entry 생성: new AbstractMap.SimpleEntry<Integer,Integer>(key,value);

```java
import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        ArrayList<Integer> result = new ArrayList();
        
        //장르별 총 재생 횟수
        HashMap<String,Integer> genreCount = new HashMap();
        
        //장르별 오름차순 정렬 ex) classic, pop, k-pop, ...
        LinkedList<String> orderedGenre;
        
        //장르별 노래 저장 자료구조
        ArrayList<ArrayList<Map.Entry<Integer,Integer>>> list = new ArrayList();
        
        
        //장르 오름차순 정렬
        for(int i=0; i<genres.length; i++)
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i],0)+plays[i]);
        orderedGenre = sorting(genreCount);
        
        //장르 별로 내부의 노래 정렬 후 두 곡 추출
        for(int i=0; i<orderedGenre.size(); i++){
            list.add(new ArrayList());
            
            //현재 장르에 해당하는 곡만 추가
            for(int j=0; j<genres.length; j++){
                if(genres[j].equals(orderedGenre.get(i)))
                    list.get(i).add(new AbstractMap.SimpleEntry<Integer,Integer>(j,plays[j]));
            }
            
            //현재 장르 내 노래 정렬
            Collections.sort(list.get(i),(o1,o2)->o2.getValue()-o1.getValue());
            
            //현재 장르 내 상위 두 곡 추출
            for(int j=0; j<list.get(i).size(); j++){
                if(j==2)
                    break;
                result.add(list.get(i).get(j).getKey());
            }
        }
        
        answer = new int[result.size()];
        for(int i=0; i<result.size(); i++)
            answer[i]=result.get(i);
        return answer;
    }
    
    LinkedList<String> sorting(HashMap<String,Integer> map){
        List<Map.Entry<String,Integer>> list = new LinkedList(map.entrySet());
        Collections.sort(list, (o1,o2)->o2.getValue()-o1.getValue());
        LinkedList<String> result = new LinkedList();
        for(Map.Entry<String,Integer> entry: list)
            result.add(entry.getKey());
        return result;
    }
}
```

