# 중복 문자열의 수 쿼리

[문제](https://programmers.co.kr/learn/courses/30/lessons/62284)

## 쿼리 요약: 우유와 요거트 둘다 담은 장바구니를 구하라. 
|ID|	CART_ID|	NAME|	PRICE|
|---|---|---|---
|1630|	83|	Cereal|	3980|
|1631|	83|	Multipurpose Supply|	3900|
|5491|	286|	Yogurt|	2980|
|5504|	286|	Milk|	1880|

```sql
SELECT CART_ID
FROM CART_PRODUCTS
WHERE NAME LIKE 'Milk' OR NAME LIKE 'Yogurt'
GROUP BY CART_ID
HAVING COUNT(DISTINCT(NAME))=2
```

## 쿼리 흐름
1. 먼저 Milk, Yogurt를 담은 CART_ID를 모두 조회, 
2. 그 후 CART_ID로 그룹화하여 `COUNT(DISTINCT(NAME))`이 2이상, 즉 Milk와 Yogurt가 모두 존재하는 카트만 반환
