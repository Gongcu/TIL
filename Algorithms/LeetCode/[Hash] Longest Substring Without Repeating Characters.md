# Longest Substring Without Repeating Characters

[문제](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

## 문제 설명
반복되는 문자가 없는 가장 긴 서브스트링을 찾는 문제

## 아이디어
- 투포인터로 구간을 잡는다
- 해당 구간이 중복이 없는 substring인지 확인한다.
    - 중복이 없으면, 오른쪽 포인터를 하나 늘린다.
    - 중복이 있으면, substring의 첫번째 중복값의 다음을 i로 옮기고 계속 진행한다.


## 코드
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //가장 긴 서브스트링, 서브스트링 내 문자는 반복이 없어야함.
        int max = 0;
        
        if(s.length()==1)
            max = 1;
        
        
        for(int i=0, j=1; i<s.length() && j<=s.length();){
            if(j-i<max){
                j++;
                continue;
            }
            String subs = s.substring(i,j);
            int index = duplicated(subs);
            if(index==-1){
                max = j-i;
                j++;
            }else{
                //서브스트링의 중복값의 첫번째값 다음 부터 다시 시작
                i=i+subs.indexOf(subs.charAt(index))+1;
                j=i+1;

            }
        }

        
        return max;
    }
    
    //중복이 없으면 -1, 중복이 있으면 중복값의 첫 인덱스
    int duplicated(String s){
        Map<Character,Integer> map = new HashMap();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int val = map.getOrDefault(ch,0)+1;
            if(val>=2){
                return s.indexOf(ch);
            }
            map.put(ch, val);
        }
        return -1;
    }
}
```



