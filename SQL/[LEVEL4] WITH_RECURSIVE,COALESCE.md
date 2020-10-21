# 중복 문자열의 수 쿼리

[문제](https://programmers.co.kr/learn/courses/30/lessons/59413)

## 쿼리 요약: 0시부터 23시까지 시간대별 입양 기록

```sql
WITH RECURSIVE
            TEMPHOUR AS -- TEMPHOUR이란 VIEW를 만들고
              ( SELECT 0 AS HOUR - TEMPHOUR에 '0' 행을 생성 컬럼명은 HOUR
                UNION ALL -- 아래 쿼리문은 반복 수행됨
                SELECT HOUR + 1 
                FROM TEMPHOUR
                WHERE HOUR < 23 ) -- HOUR<23까지 반복 수행
SELECT T1.HOUR, COALESCE(T2.COUNT,0)
FROM TEMPHOUR T1
LEFT JOIN
(SELECT HOUR(DATETIME) AS HOUR, COUNT(HOUR(DATETIME)) AS COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR(DATETIME)
ORDER BY HOUR) T2
ON T1.HOUR = T2.HOUR
```

## 핵심
- WITH RECURSIVE: 아래의 경우 초기 SQL문으로 HOUR이란 컬럼이 생성되며 값 0의 행이 하나 생성된다. 이 후 UNION ALL로 반복하며 아래 반복할 SQL문을 정의한다.
이때, 위에서 선언한 `뷰명`과 `HOUR`를 이용하면 된다.
```sql
with recursive 뷰명 as(
    초기 SQL [EX) SELECT 0 AS HOUR]
    union all
    반복할 SQL(+반복을 멈출 where절 포함)[EX) SELECT HOUR+1 FROM 뷰명 WHERE HOUR<23]
)select * from 뷰명;
```
- COALESCE(필드명, 0): 해당 필드가 NULL인 경우 0으로 처리한다.
- LEFT OUTER JOIN: 왼쪽 테이블과 오른쪽 테이블을 조인하는데, 왼쪽은 모두 존재. 오른쪽은 왼쪽의 조인 조건에 맞은 행이 없는 경우 NULL 처리한다.


