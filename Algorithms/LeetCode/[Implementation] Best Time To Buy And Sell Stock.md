# Best Time To Buy And Sell Stock

[문제](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

## 문제 설명
한 주식의 일자 별 가격을 나타내는 배열이 주어진다. 언제 주식을 사고 팔아야 최대의 이익을 남길 수 있는가?

## 아이디어
- 인덱스를 이동시키며 현재 인덱스까지의 최소값을 구한다.
- 오늘 주식 값 - 현재까지 있던 날 중 주식의 최소값의 계산 결과가 최대면 최대값을 교체한다.


## 코드
```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxp = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            if(min > prices[i])
                min = prices[i];
            maxp = Math.max(maxp, prices[i]-min);
        }
        return maxp;
    }
}
```



