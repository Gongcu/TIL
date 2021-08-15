# Product Of Array Except Self

[문제](https://leetcode.com/problems/product-of-array-except-self/)

## 문제 설명
자기 자신을 제외한 배열의 곱을 O(n)의 시간복잡도와 나누기 연산 사용 없이 구현하라.

## 아이디어
- 자기 자신을 제외하고 왼쪽과 오른쪽으로 나누어 곱한다.


## 코드
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] p =new int[nums.length];

        //왼쪽을 곱한다.
        int val = 1; 
        for(int i=0; i<nums.length; i++){
            p[i]=val;
            val*=nums[i];
        }
        
        //오른쪽을 곱한다.
        val = 1;
        for(int i=nums.length-1; i>=0; i--){
            p[i]=p[i]*val;
            val*=nums[i];
        }
        
        
        return p;
    }
}
```



