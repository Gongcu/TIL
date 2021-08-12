# Combination Sum

[문제](https://leetcode.com/problems/combination-sum/)

## 문제 설명
고유한 값 배열과 타겟 값을 던져주고, 배열의 값을 추출하여 합한 결과가 타겟인 조합 반환(같은 값 추출 가능)

## 아이디어
- 백트래킹을 활용한다.



## 코드
```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList();
        ArrayList<Integer> result= new ArrayList();
        combination(candidates,target,results,result);

        return results;
    }
    
    void combination(int[] candidates, int target, List<List<Integer>> results, List<Integer> result){
        if(target < 0){
            return;
        }
        
        //타겟 값을 만족하는 경우
        if(target==0){
            //중복된 값 추가를 방지하기 위해 조합을 정렬하고 포함 여부 확인
            Collections.sort(result);
            if(!results.contains(result))
                results.add(new ArrayList(result));

            return;
        }

        for(int i = 0; i< candidates.length ;i++){
            result.add(candidates[i]);
            combination(candidates,target-candidates[i],results,result);
            result.remove(Integer.valueOf(candidates[i]));
        }
        
    }
}
```



