# Permutations

[문제](https://leetcode.com/problems/permutations)

## 문제 설명
주어진 배열에 대해 모든 순열을 찾아라.(배열의 값은 중복이 없다.)

## 아이디어
- 백트래킹을 활용한다.



## 코드
```java
class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        var results :ArrayList<ArrayList<Int>> = arrayListOf()
        var result :ArrayList<Int> = arrayListOf()

        var used = BooleanArray(nums.size)
        
        permutation(nums,used,nums.size,0,results,result)
        print(results)
        return results
    }
    
    fun permutation(nums: IntArray, used : BooleanArray, n: Int, depth: Int, results : ArrayList<ArrayList<Int>>, result : ArrayList<Int>){
        if(depth == n){
            if(result.size != 0){
                results.add(ArrayList(result))
            }
            return
        }
        for(i in 0 .. nums.size-1){
            val num = nums[i]
            if(!used[i]){
                used[i]=true
                result.add(num)
                permutation(nums,used,n,depth+1,results,result)
                result.remove(num)
                used[i]=false
            }else{
                continue
            }
            
        }
        
    }
}
```



