# 가장 큰 수

[문제](https://programmers.co.kr/learn/courses/30/lessons/42746)

## Note
- 문자열 활용 문제 -> 다양한 테스트 케이스 고려

## 코드
```java
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for(int i=0; i<arr.length; i++)
            arr[i]=String.valueOf(numbers[i]);
        
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });
        if(arr[0].equals("0"))
            return "0";
        
        for(int i=0; i<arr.length; i++)
            answer +=arr[i];
        return answer;
    }
    
}
```

## 순열을 이용한 풀이 - 시간 초과
```java
import java.util.*;
class Solution {
    ArrayList<String> list =new ArrayList();
    public String solution(int[] numbers) {
        String answer = "";
        perm(numbers,0,numbers.length, numbers.length);
        Collections.sort(list);
        answer=list.get(list.size()-1);
        return answer;
    }
    
    void perm(int[] num, int depth, int n, int k){
        //depth:교환 깊이, n:배열 크기, k:몇개를 뽑아 순열을 만들지
        if(depth==k){
            print(num,k);
            //list.add(num);
            return;
        }
        for(int i=depth; i<n; i++){
            swap(num,i,depth);
            perm(num,depth+1,n,k);
            swap(num,i,depth);
        }
    }
    void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    void print(int[] arr, int k) {
        String value="";
        for (int i = 0; i < k; i++) { 
            value+=arr[i];
        }
        list.add(value);
    }
}
```



