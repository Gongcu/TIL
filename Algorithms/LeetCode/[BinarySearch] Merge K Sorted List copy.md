# Search In Rotated Sorted Array

[문제](https://leetcode.com/problems/search-in-rotated-sorted-array/)

## 문제 설명
정렬된 배열이 특정 값을 기준으로 회전되어있는 상태로 주어진다. 그 배열에서 타겟 값의 위치를 반환하라.

## 아이디어
- 이진탐색을 활용한다.
- 정렬된 배열과 유사하거나, 최적의 값을 찾는 등과 같은 문제에서 이진탐색을 활용한다.


## 코드
```java
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
    
        int pivot = findPivot(nums);
            
        int left = 0;
        int right = nums.length - 1;
    
        while(left<=right){
            int mid = (left+right)/2;
            //left~right 사이의 진짜 중간값의 위치
            int midValueIndex = (mid+pivot)%nums.length;
            
            //값은 실제 중간 값 기준 비교, 이동은 mid 기준 이동

            if(nums[midValueIndex]==target)
                return midValueIndex;
            else if(nums[midValueIndex] > target)
                right = mid-1;
            else
                left = mid+1;
        
        }
        return -1;
    } 
    
    //값이 바뀌기 시작하는 인덱스 찾기 == 최솟값
    int findPivot(int[] nums){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<min){
                min = nums[i];
                minIndex=i;
            }
        }
        return minIndex;
    }
}
```



