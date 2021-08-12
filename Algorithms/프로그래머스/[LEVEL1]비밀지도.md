# 2018 KAKAO BLIND RECRUITMENT - 비밀지도

[문제](https://programmers.co.kr/learn/courses/30/lessons/17681)

## Note
- Integer.toBinaryString


## 코드
```java
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] x= new int[n][n];
        int[][] y= new int[n][n];
        for(int i=0; i<n; i++){
            answer[i] = "";
            String intToBinary1 = Integer.toBinaryString(arr1[i]);
            String intToBinary2 = Integer.toBinaryString(arr2[i]);
            intToBinary1=padding(intToBinary1, n);
            intToBinary2=padding(intToBinary2, n);
            for(int j=0; j<intToBinary1.length(); j++){
                x[i][j]=intToBinary1.charAt(j)-'0';
                y[i][j]=intToBinary2.charAt(j)-'0';
            }
        }
        
        for(int i=0; i<x.length; i++){
            for(int j=0; j<x[i].length; j++){
                if(x[i][j]==0 && y[i][j]==0)
                    answer[i]+=" ";
                else
                    answer[i]+="#";
            }
        }
        return answer;
    }
    
    String padding(String str,int size){
        while(str.length()!=size)
            str="0"+str;
        return str;
    }
}
```



