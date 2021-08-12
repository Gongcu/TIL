# 베스트앨범

[문제](https://programmers.co.kr/learn/courses/30/lessons/42579)

### Note
- 해시맵
- 맵 리스트: ArrayList<ArrayList<Map.Entry<Integer,Integer>>>
- Entry 생성: new AbstractMap.SimpleEntry<Integer,Integer>(key,value);
- 풀이2: Class를 이용한 풀이(implements Comparable)

### 해시맵만을 이용한 풀이
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

### Class를 이용한 풀이
```java
import java.util.*;
class Solution {
    public class Music implements Comparable<Music>{
        private int id;
        private String genre;
        private int play;
        
        public Music(int id, String genre, int play){
            this.id = id;
            this.genre = genre;
            this.play = play;
        }
        
        @Override
        public int compareTo(Music o){
            if(this.play == o.play) return o.id-this.id;
            return this.play - o.play;
        }
        String getGenre(){return genre;}
        int getId(){return id;}
        int getPlay(){return play;}
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        ArrayList<Music> musics = new ArrayList();
        
        
        for(int i=0; i<genres.length; i++){
            musics.add(new Music(i,genres[i],plays[i]));
        }
        Collections.sort(musics);
        
        
        for(int i=0; i<musics.size(); i++){
            System.out.println(musics.get(i).getId());
        }
        
        HashMap<String, Integer> gRank = new HashMap();
         
        ArrayList<String> gRankOrder = new ArrayList();
        ArrayList<Integer> gpRankOrder = new ArrayList();
        
        ArrayList<Integer> result = new ArrayList();  
        
        //장르별 재생수
        for(int i=0; i<genres.length; i++){
            gRank.put(genres[i],gRank.getOrDefault(genres[i],0)+plays[i]);
        }
        
        //장르 내림차순 정렬
        for(String key : gRank.keySet()){
            int value = gRank.get(key);
            int i;
            for(i=0; i<gRankOrder.size(); i++){
                if(value>=gpRankOrder.get(i))
                    break;
            }
            gRankOrder.add(i,key);
            gpRankOrder.add(i,value);
        }
        
        
        //장르별 TOP 2
        for(String key : gRankOrder){
            int count = 2;
            for(int i=musics.size()-1; i>=0; i--){
                if(count==0)
                    break;
                if(musics.get(i).getGenre().equals(key)){
                    count--;
                    result.add(musics.get(i).getId());
                }
            }
        }
        
        answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i]=result.get(i);
        }
        
        return answer;
    }
}
```