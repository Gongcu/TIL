# Letter Combinations of a Phone Number

[문제](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

## 문제 설명
휴대폰 키패드에서 주어진 숫자 2개에 대해 입력 가능한 문자의 모든 조합

## 아이디어
- 재귀를 활용하여 문제를 해결한다.


## 코드
```java
class Solution {
    fun letterCombinations(digits: String): List<String> {
        val results = arrayListOf<String>();
        val map : Map<Char,String> = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )
        
        combination(digits, map, digits.length, 0, results, "")
        return results;
    }
    
    
    fun combination(digits:String, map:Map<Char,String>,n:Int, depth:Int, results : ArrayList<String>, result : String){
        if(n==depth){
            if(!result.isBlank())
                results.add(result)
            return;
        }
        var ch : Char= digits[depth]
        var value = map[ch]!!;

        //문자(ex. abc)를 순회하며 조합
        for(i in 0 .. value.length-1){
            combination(digits,map,n,depth+1,results, result + value[i])
        }
    }
}
```



