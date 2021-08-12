# Longest Palindromic Substring

[문제](https://leetcode.com/problems/longest-palindromic-substring/)

## 문제 설명
가장 긴 팰린드롬 서브스트링을 찾는 문제

## 아이디어
- 2차원 DP를 이용해 구현한다. (점화식에 2개의 값이 필요할 경우 2차원 DP라 정의)
- i와 j번째 문자가 서로 같고, 길이가 2 이하이거나 한칸 더 짧은 서브스트링([i+1][j-1])이 팰린드롬이라면 [i][j]도 팰린드롬이다.


## 코드
```java
class Solution {
    
    public String longestPalindrome(String s) {
        boolean[][] p = new boolean[s.length()][s.length()];
        
        int left=0,right=0;
        int max = Integer.MIN_VALUE;
        
        if(s.length()<=1)
            return s;
        
        
        for(int j=0; j<s.length(); j++){
            for(int i=0; i<j; i++){
                //i와 j가 같고, 길이가 2이하이거나 한 칸 더 짧은 서브스트링([i+1][j-1])이 팰린드롬이라면 [i][j]는 팰린드롬이다.
                p[i][j] = (s.charAt(i)==s.charAt(j)) && (j-i<=2 || p[i+1][j-1]);
                if(p[i][j] && max < j-i+1){
                    left = i;
                    right = j;
                    max = j-i+1;
                }
            }
        }
        
        return s.substring(left,right+1);
    }
    
    boolean isPalindrom(String s){
        StringBuilder sb = new StringBuilder(s).reverse();
        return s.equals(sb.toString());
    }
}
```



